package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jose Pariona
 * @version 1.0
 */
@Entity
@Table(name = "COMPROBANTE_PAGO")
@NamedQueries({
	@NamedQuery(name = "ComprobantePago.findForSendToBizlinkByFechaEmision", query = "SELECT new com.olva.eser.entity.ComprobantePago(c.id, c.idTipoComprobante.id, c.serieComprobante, c.nroComprobante, c.fechaEmision) FROM ComprobantePago c where c.idEmisorComp = ?1 and c.estadoFacE not in (931, 932, 1069) and c.serieComprobante like 'F%' and c.fechaEmision > ?2 order by c.id"),
    @NamedQuery(name = "ComprobantePago.findByIdEmisorCompTipoSerieNumeroComprobante", query = "SELECT new com.olva.eser.entity.ComprobantePago(c.id, c.estResCom.id) FROM ComprobantePago c WHERE c.idEmisorComp = :idEmisorComp AND c.idTipoComprobante = :idTipoComprobante AND c.serieComprobante = :serieComprobante and c.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "ComprobantePago.findForGenerateXmlByFechaEmision", query = "SELECT new com.olva.eser.entity.ComprobantePago(c.id, c.serieComprobante, c.nroComprobante, c.fechaEmision, c.igv, c.valorIgv, c.valorVenta, c.precioVenta, c.motivoNota, c.flgDivEmi, c.glosaDivEmi, c.fechaVencimiento, c.idFormaPago.id, tc.id, tc.valor2, c.estado.id, c.idMoneda.id, ta.valor, tn.valor, td.valor, d.numeroDocumento, p.concatNombre) FROM ComprobantePago c INNER JOIN c.idTipoComprobante tc INNER JOIN c.idTipoAfectacionIgv ta LEFT JOIN c.idTipoNota tn INNER JOIN c.idDocCliente d INNER JOIN d.idTipDocumento td INNER JOIN d.idPersona p WHERE c.idEmisorComp = ?1 and c.fechaEmision > ?2 AND c.estadoFacE.id = ?3 order by c.id")
})

public class ComprobantePago implements Serializable {

	private static final long serialVersionUID = -2110474483883811580L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPROBANTE_PAGO")
    @SequenceGenerator(name = "SEQ_COMPROBANTE_PAGO", sequenceName = "SEQ_COMPROBANTE_PAGO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    @Getter @Setter private Long id;
	@Column(name = "CREATE_USER")
	@Getter @Setter private BigDecimal createUser;
	@JoinColumn(name = "ID_TIPO_COMPROBANTE", referencedColumnName = "ID")
	@ManyToOne
	@Getter @Setter private Parametros idTipoComprobante;
    @Column(name = "SERIE_COMPROBANTE")
    @Getter @Setter private String serieComprobante;
    @Column(name = "NRO_COMPROBANTE")
    @Getter @Setter private Integer nroComprobante;
    @Basic(optional = false)
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.DATE)
    @Getter @Setter private Date fechaEmision;
    @Column(name = "MODIFY_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date modifyDatetime;
    @Column(name = "FLG_FACTURA_ELECTRONICA")
    @Getter @Setter private Character flgFacturaElectronica = '0';
    @Column(name = "VALOR_VENTA")
    @Getter @Setter private BigDecimal valorVenta;
    @Column(name = "VALOR_IGV")
    @Getter @Setter private BigDecimal valorIgv;
    @Column(name = "PRECIO_VENTA")
    @Getter @Setter private BigDecimal precioVenta;
    @Column(name = "IGV")
    @Getter @Setter private BigDecimal igv;
    @Column(name = "BASE_IMPONIBLE")
    @Getter @Setter private BigDecimal baseImponible;
    @Column(name = "COLLECT")
    @Getter @Setter private Character collect;
    @Column(name = "OBSERVACION")    
    @Getter @Setter private String observacion;
    @Column(name = "ID_OFICINA")    
    @Getter @Setter private BigDecimal idOficina;
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createDatetime;
    @Column(name = "CREATE_TIME") 
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createTime;
    @Column(name = "PC")
    @Getter @Setter private String pc;
    @Column(name = "EFECTIVO")    
    @Getter @Setter private BigDecimal efectivo;
    @Column(name = "ID_PERS_JUR_AREA")
    @Getter @Setter private BigDecimal idPersJurArea;
    @Column(name = "FEC_EJEC_JOB")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fecEjecJob;
    @Column(name = "FLG_DIV_EMI")
    @Getter @Setter private Character flgDivEmi = '0';
    @Column(name = "GLOSA_DIV_EMI")
    @Getter @Setter private String glosaDivEmi;
    @Column(name = "MOTIVO_NOTA")
    @Getter @Setter private String motivoNota;
    @Column(name = "DIGEST_VALUE")
    @Getter @Setter private String digestValue;
    @Column(name = "MAIL_SENT")
    @Getter @Setter private Character mailSent;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    @Getter @Setter private Date fechaVencimiento;
    @Column(name = "FLG_INTGR_WIN_TO_CORP")
    @Getter @Setter private Character flgIntgrWinToCorp = '0';
    

    @JoinColumn(name = "ID_FORMA_PAGO", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros idFormaPago;
    @JoinColumn(name = "ID_MONEDA", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros idMoneda;
    @JoinColumn(name = "ESTADO_ERROR_FAC_E", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros estadoErrorFacE;
    @JoinColumn(name = "ESTADO_FAC_E", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros estadoFacE;
    @JoinColumn(name = "ESTADO", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros estado;
    @JoinColumn(name = "EST_RES_COM", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros estResCom;
    @JoinColumn(name = "ID_TIPO_AFECTACION_IGV", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros idTipoAfectacionIgv;
    @JoinColumn(name = "ID_TIPO_NOTA", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros idTipoNota;
    @JoinColumn(name = "ID_EMISOR_COMP", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    @Getter @Setter private Persona idEmisorComp;
    @JoinColumn(name = "ID_DOC_CLIENTE", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private DocumentoIdentidad idDocCliente;

    @Getter @Setter @Transient private byte[] facturaElectronicaSend;
    @Getter @Setter @Transient private Long facturaElectronicaId;
    @Getter @Setter @Transient private String facturaElectronicaSendName;
    @Getter @Setter @Transient private BigDecimal operacionGravada;
    @Getter @Setter @Transient private BigDecimal operacionExonerada;
    @Getter @Setter @Transient private BigDecimal operacionInafecta;
    @Getter @Setter @Transient private String valor2TipoComprobanteRef;
    @Getter @Setter @Transient private String serieComprobanteRef;
    @Getter @Setter @Transient private Integer numeroComprobanteRef;

    public ComprobantePago() {
	}

	public ComprobantePago(Long id) {
		this.id = id;
	}

	public ComprobantePago(Long id, Integer idEstResCom) {
		this.id = id;
		this.estResCom = new Parametros(idEstResCom); 
	}

	public ComprobantePago(Long id, Integer idTipoComprobante, String serieComprobante, Integer nroComprobante, Date fechaEmision) {
		super();
		this.id = id;
		this.idTipoComprobante = new Parametros(idTipoComprobante);
		this.serieComprobante = serieComprobante;
		this.nroComprobante = nroComprobante;
		this.fechaEmision = fechaEmision;
	}
	
    public ComprobantePago(Long id, String valor2TipoComprobante, String serieComprobante, Integer nroComprobante) {
        this.id = id;
        this.idTipoComprobante = new Parametros();
        this.idTipoComprobante.setValor2(valor2TipoComprobante);
        this.serieComprobante = serieComprobante;
        this.nroComprobante = nroComprobante;
    }
    

	public ComprobantePago(Long id, String serieComprobante, Integer nroComprobante, Date fechaEmision, String observacion, String valorTipoComprobante) {
        this.id = id;
        this.serieComprobante = serieComprobante;
        this.nroComprobante = nroComprobante;
        this.fechaEmision = fechaEmision;
        this.idTipoComprobante = new Parametros();
        this.idTipoComprobante.setValor2(valorTipoComprobante);
        this.observacion = observacion;
    }

	public ComprobantePago(Long id, String serieComprobante, Integer nroComprobante, Character flgDivEmi, String motivoNota, Integer idTipoComprobante, Integer idPersona) {
        this.id = id;
        this.serieComprobante = serieComprobante;
        this.nroComprobante = nroComprobante;
        this.idTipoComprobante = new Parametros(idTipoComprobante);
        this.flgDivEmi = flgDivEmi;        
        this.motivoNota = motivoNota;
        this.idDocCliente = new DocumentoIdentidad();
        this.idDocCliente.setIdPersona(new Persona(idPersona));
    }


	public ComprobantePago(Long id, String serieComprobante, Integer nroComprobante, Date fechaEmision,
            BigDecimal precioVenta, BigDecimal valorIgv, BigDecimal operacionGravada, BigDecimal operacionExonerada,
            BigDecimal operacionInafecta, String valorEstResCom, String valor2TipoComprobante, String valorTipoMoneda,
            String valorTipoDocumentoCliente, String numeroDocumentoCliente) {
        this.id = id;
        this.serieComprobante = serieComprobante;
        this.nroComprobante = nroComprobante;
        this.fechaEmision = fechaEmision;
        this.precioVenta = precioVenta.setScale(2, RoundingMode.HALF_UP);
        this.valorIgv = valorIgv.setScale(2, RoundingMode.HALF_UP);
        this.operacionGravada = operacionGravada.setScale(2, RoundingMode.HALF_UP);
        this.operacionExonerada = operacionExonerada.setScale(2, RoundingMode.HALF_UP);
        this.operacionInafecta = operacionInafecta.setScale(2, RoundingMode.HALF_UP);
        this.estResCom = new Parametros(null, valorEstResCom);
        this.idTipoComprobante = new Parametros();
        this.idTipoComprobante.setValor2(valor2TipoComprobante);
        this.idMoneda = new Parametros(null, valorTipoMoneda);
        this.fechaEmision = fechaEmision;
        this.idDocCliente = new DocumentoIdentidad();
        this.idDocCliente.setIdTipDocumento(new Parametros(null, valorTipoDocumentoCliente));
        this.idDocCliente.setNumeroDocumento(numeroDocumentoCliente);
    }

	public ComprobantePago(Long id, String serieComprobante, Integer nroComprobante, Date fechaEmision,
			BigDecimal igv, BigDecimal valorIgv, BigDecimal valorVenta, BigDecimal precioVenta, String motivoNota, 
			Character flgDivEmi, String glosaDivEmi, Date fechaVencimiento, Integer idFormaPago, Integer idTipoComprobante, 
			String valor2TipoComprobante, Integer idEstado, Integer idMoneda, String valorTipoAfectacionIgv, String valorTipoMotivo, 
			String valorTipoDocumentoCliente, String numeroDocumentoCliente, String concatNombre) {
		this.id = id;
		this.serieComprobante = serieComprobante;
		this.nroComprobante = nroComprobante;
		this.fechaEmision = fechaEmision;
		this.igv = igv;
		this.valorIgv = valorIgv;
		this.valorVenta = valorVenta;
		this.precioVenta = precioVenta;
		this.motivoNota = motivoNota;
		this.flgDivEmi = flgDivEmi == null ? '0' : flgDivEmi;
		this.glosaDivEmi = glosaDivEmi;
		this.fechaVencimiento = fechaVencimiento;
		if (idFormaPago != null) {
			this.idFormaPago = new Parametros(idFormaPago);
		}
		this.idTipoComprobante = new Parametros(idTipoComprobante);
		this.idTipoComprobante.setValor2(valor2TipoComprobante);
		this.estado = new Parametros(idEstado);
		this.idMoneda = new Parametros(idMoneda);
		this.idTipoAfectacionIgv = new Parametros();
		this.idTipoAfectacionIgv.setValor(valorTipoAfectacionIgv);
		this.idTipoNota = new Parametros();
		this.idTipoNota.setValor(valorTipoMotivo);
		this.idDocCliente = new DocumentoIdentidad();
		this.idDocCliente.setIdTipDocumento(new Parametros(null, valorTipoDocumentoCliente));
		this.idDocCliente.setNumeroDocumento(numeroDocumentoCliente);
		this.idDocCliente.setIdPersona(new Persona(null, concatNombre));
	}

	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ComprobantePago)) {
            return false;
        }
        ComprobantePago other = (ComprobantePago) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.olva.job.entity.ComprobantePago[ id=" + id + " ]";
    }
}