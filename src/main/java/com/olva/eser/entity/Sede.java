package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SEDE")
@NamedQueries({
	 @NamedQuery(name = "Sede.findById", query = "SELECT s FROM Sede s WHERE s.idSede = :idSede"),
    @NamedQuery(name = "Sede.findAllOrderByNombre", query = "SELECT s FROM Sede s WHERE s.estado = '1' ORDER BY s.nombre")
})
public class Sede implements Serializable{



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEDE")
    @SequenceGenerator(name = "SEQ_SEDE", sequenceName = "SEQ_SEDE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SEDE")
    @Getter @Setter private BigDecimal idSede;
    
    @Size(max = 100)
    @Column(name = "NOMBRE")
    @Getter @Setter private String nombre;
    
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    @Getter @Setter private Persona idPersona;
    
    @Size(max = 1)
    @Column(name = "FRANQUISIA")
    @Getter @Setter private Long franquisia;
    
    @Column(name = "ESTADO")
    @Getter @Setter private Character estado;
    
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createDatetime;
    
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Usuario createUser;
    
    @Column(name = "MODIFY_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date modifyDatetime;
    
    @JoinColumn(name = "MODIFY_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Usuario modifyUser;
    
    @Basic(optional = false)
    @Column(name = "FAC_REDONDEO_PESO")
    @Getter @Setter private BigDecimal facRedondeoPeso;
    
    @Column(name = "CODIGO")
    @Getter @Setter private String codigo;
    
    @Basic(optional = false)
    @Column(name = "PORC_SEGURO")
    @Getter @Setter private BigDecimal porcSeguro;
    
    @Column(name = "MONTO_SEGURO")
    @Getter @Setter private BigDecimal montoSeguro;
    
    @Column(name = "CANT_CARGO_BASE")
    @Getter @Setter private BigDecimal cantCargoBase;
    
    @JoinColumn(name = "ID_SEDE_PADRE", referencedColumnName = "ID_SEDE")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Sede idSedePadre;
    
    @Column(name = "SECUENCIA_ACTIVA_ORDEN_EMI")
    @Getter @Setter private String secuenciaActivaOrdenEmi;
    
    @JoinColumn(name = "ID_SEDE_RECOJO", referencedColumnName = "ID_SEDE")
    @ManyToOne
    @Getter @Setter private Sede idSedeRecojo;
    
    @JoinColumn(name = "CTA_CTE_BANCO", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros ctaCteBanco;
    
    @Size(max = 20)
    @Column(name = "NUMERO_CTA_CTE_BANCO")
    @Getter @Setter private String numeroCtaCteBanco;
    
    @JoinColumn(name = "MONEDA_CTA_CTE_BANCO", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros monedaCtaCteBanco;
    
    @Size(max = 100)
    @Column(name = "TITULAR_CTA_CTE_BANCO")
    @Getter @Setter private String titularCtaCteBanco;
    
    @Column(name = "RPTE_PRE_ABONO_EMISION")
    @Getter @Setter private String rptePreAbonoEmision;
    
    @Column(name = "RPTE_PRE_ABONO_CORRELATIVO")
    @Getter @Setter private String rptePreAbonoCorrelativo;
    
    @Column(name = "ESTADO_CUENTA_EMISION")
    @Getter @Setter private String estadoCuentaEmision;
    
    @Column(name = "ESTADO_CUENTA_CORRELATIVO")
    @Getter @Setter private BigInteger estadoCuentaCorrelativo;
    
    @Column(name = "VOUCHER_EMISION")
    @Getter @Setter private String voucherEmision;
    
    @Column(name = "VOUCHER_CORRELATIVO")
    @Getter @Setter private BigInteger voucherCorrelativo;
    
    @Column(name = "NRO_PROCESO_EECC_CORRELATIVO")
    @Getter @Setter private BigInteger nroProcesoEECCCorrelativo;
    
    @Column(name = "CIIU")
    @Getter @Setter private BigDecimal ciiu;
    
    @Column(name = "AGENTE_RETENCION")
    @Getter @Setter private Character agenteRetencion;
    
    @Size(max = 100)
    @Column(name = "NUMERO_RETENCION")
    @Getter @Setter private String numeroRetencion;
    
    @Column(name = "SERIE_MANIF_ASIG")
    @Getter @Setter private String serieManifAsig;
    @Column(name = "NUMERO_MANIF_ASIG")
    @Getter @Setter private BigInteger numeroManifAsig;
    @Column(name = "AUTORIZACION_FE")
    @Getter @Setter private String autorizacionFe;
    
    @JoinColumn(name = "TIPO_AFECTACION", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter private Parametros tipoAfectacion;
    @JoinColumn(name = "ID_PERS_JUR_AREA", referencedColumnName = "ID")
    @Getter @Setter private BigDecimal idPersJurArea;
    @Column(name = "EST_CTA_SERIE_AUTOMATICO")
    @Getter @Setter private String estCtaSerieAutomatico;
    @Column(name = "EST_CTA_CORRELATIVO_AUTOMATICO")
    @Getter @Setter private BigInteger estCtaCorrelativoAutomatico;    
    @Column(name = "HORA_INICIAL_MIN")
    @Getter @Setter private Integer horaInicialMin;
    @Column(name = "HORA_INICIAL_MAX")
    @Getter @Setter private Integer horaInicialMax;
    @Column(name = "HORA_FINAL_MIN")
    @Getter @Setter private Integer horaFinalMin;
    @Column(name = "HORA_FINAL_MAX")
    @Getter @Setter private Integer horaFinalMax;
    @Column(name = "HORA_INICIAL_SAB_MIN")
    @Getter @Setter private Integer horaInicialSabMin;
    @Column(name = "HORA_INICIAL_SAB_MAX")
    @Getter @Setter private Integer horaInicialSabMax;
    @Column(name = "HORA_FINAL_SAB_MIN")
    @Getter @Setter private Integer horaFinalSabMin;
    @Column(name = "HORA_FINAL_SAB_MAX")
    @Getter @Setter private Integer horaFinalSabMax;
    @Column(name = "HORA_MAX_ANULAR_CLIENTE")
    @Getter @Setter private Integer horaMaxAnularCliente;
    @Column(name = "HORA_MAX_REGISTRAR_EN_EL_DIA")
    @Getter @Setter private Integer horaMaxRegistrarEnElDia;    
    @Column(name = "SERIE_FACTURACION_MOVIL")
    @Getter @Setter private String serieFacturacionMovil;
    @Column(name = "FLG_IMPRESION_ORYX")
    private Character flgImpresionOryx;
    @Column(name = "TOKENMP",length = 200)
    @Getter @Setter private String tokenMP;
    @Column(name = "IDMP",length = 100)
    @Getter @Setter private String idMP;
    @Column(name = "URLMP",length = 200)
    @Getter @Setter private String urlMP;
    @Column(name = "TIMEMP",length = 200)
    @Getter @Setter private String timeMP;
	
	
    public Sede() {
    }

	public Sede(BigDecimal idSede) {
		this.idSede = idSede;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSede != null ? idSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.idSede == null && other.idSede != null) || (this.idSede != null && !this.idSede.equals(other.idSede))) {
            return false;
        }
        return true;
    }
    
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5170105527675955670L;

	
	
}
