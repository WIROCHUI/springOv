package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */

@Entity
@Table(name = "COMPROBANTE_PAGO_NUMERACION")
@NamedQueries({
    @NamedQuery(name = "ComprobantePagoNumeracion.findByOficinaSerie", query = "SELECT c FROM ComprobantePagoNumeracion c WHERE c.serie = :serie AND c.idOficina.id = :idOficina AND c.estado = '1' AND c.tipo.id = 37 "),
    @NamedQuery(name = "ComprobantePagoNumeracion.getNumeroComprobante", query = "SELECT c FROM ComprobantePagoNumeracion c JOIN c.tipo t JOIN c.idOficina o WHERE c.serie = :serie AND t.id = :tipoComprobante AND o.id = :idOficina AND c.estado = '1'")
})
public class ComprobantePagoNumeracion implements Serializable{
	

    @Column(name = "NRO_CORRELATIVO")
    private Long nroCorrelativo = 0L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private Character estado;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMP_PAGO_NUM")
    @SequenceGenerator(name = "SEQ_COMP_PAGO_NUM", sequenceName = "SEQ_COMP_PAGO_NUM", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Getter private BigDecimal id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERIE", length = 5)
    @Getter @Setter private String serie;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_INICIAL")
    @Getter @Setter private long nroInicial;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_FINAL")
    @Getter @Setter private long nroFinal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECH_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fechAsignacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createDatetime;
    
    @Column(name = "MODIFY_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date modifyDatetime;
    
    @JoinColumn(name = "MODIFY_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Usuario modifyUser;
    
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Usuario createUser;
    
    @JoinColumn(name = "TIPO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Parametros tipo;
    
    @JoinColumn(name = "ID_OFICINA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Oficina idOficina;


    public ComprobantePagoNumeracion() {
    }

    public ComprobantePagoNumeracion(BigDecimal id) {
        this.id = id;
    }
    
    public ComprobantePagoNumeracion(BigDecimal id, long nroInicial, long nroFinal, char estado) {
        this.id = id;
        this.nroInicial = nroInicial;
        this.nroFinal = nroFinal;
        this.estado = estado;
    }

    public ComprobantePagoNumeracion(BigDecimal id, String serie, long nroInicial, long nroFinal, Date fechAsignacion, Date createDatetime, char estado) {
        this.id = id;
        this.serie = serie;
        this.nroInicial = nroInicial;
        this.nroFinal = nroFinal;
        this.fechAsignacion = fechAsignacion;
        this.createDatetime = createDatetime;
        this.estado = estado;
    }
	
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710998246415836375L;

}
