package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class Oficina implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OFICINA")
    @SequenceGenerator(name = "SEQ_OFICINA", sequenceName = "SEQ_OFICINA", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatetime;
    @Column(name = "MODIFY_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDatetime;
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario createUser;
    @JoinColumn(name = "MODIFY_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario modifyUser;

   
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Persona idPersona;
    @JoinColumn(name = "TIPO_OFICINA", referencedColumnName = "ID")
    @ManyToOne
    private Parametros tipoOficina;
    
    @Column(name = "HOR_ATENCION")
    @Getter @Setter 
    private String horAtencion;
    
    @Column(name = "RADIOS_RPM")
    @Getter @Setter 
    private String radiosRpm;
    
    @Column(name = "NOMBRE_ENCARGADO")
    @Getter @Setter
    private String nomEncargado;
    
    @Column(name = "DOC_ENCARGADO")
    @Getter @Setter
    private String docEncargado;
    
    @Column(name = "FNAC_ENCARGADO")
    @Temporal(TemporalType.DATE)
    @Getter @Setter
    private Date fecNacEncargado;
    
    @Column(name="PREVENTA_OFICINA_ACTIVO")
    private Character preventaOficinaActivo;   
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8074073621389459926L;
}
