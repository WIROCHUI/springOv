package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OFICINA")
@NamedQueries({
	@NamedQuery(name = "Oficina.findByTipoOficinaSede", query = "SELECT o FROM Oficina o WHERE o.idSubsede.idSede = :idSede AND o.tipoOficina = :tipoOficina and o.estado = '1'")
})
public class Oficina implements Serializable{
	

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OFICINA")
    @SequenceGenerator(name = "SEQ_OFICINA", sequenceName = "SEQ_OFICINA", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
	@Getter @Setter 
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMBRE")
    @Getter @Setter 
    private String nombre;
    @Column(name = "CODIGO")
    @Getter @Setter 
    private String codigo;
    @Column(name = "DESCRIPCION")
    @Getter @Setter 
    private String descripcion;
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter 
    private Date createDatetime;
    @Column(name = "MODIFY_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDatetime;
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    @Getter @Setter 
    private Usuario createUser;
    @JoinColumn(name = "MODIFY_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario modifyUser;

    @JoinColumn(name = "ID_SUBSEDE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @Getter @Setter 
    private Subsede idSubsede;
    
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    @Getter @Setter 
    private Persona idPersona;
    @JoinColumn(name = "TIPO_OFICINA", referencedColumnName = "ID")
    @ManyToOne
    @Getter @Setter 
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
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    @Getter @Setter 
    private Character estado;
	
	public Oficina() {
	}






	public Oficina(@NotNull BigDecimal id, @NotNull String nombre, String codigo, String descripcion,
			Date createDatetime, Date modifyDatetime, Usuario createUser, Usuario modifyUser, Subsede idSubsede,
			Persona idPersona, Parametros tipoOficina, String horAtencion, String radiosRpm, String nomEncargado,
			String docEncargado, Date fecNacEncargado, Character preventaOficinaActivo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.createDatetime = createDatetime;
		this.modifyDatetime = modifyDatetime;
		this.createUser = createUser;
		this.modifyUser = modifyUser;
		this.idSubsede = idSubsede;
		this.idPersona = idPersona;
		this.tipoOficina = tipoOficina;
		this.horAtencion = horAtencion;
		this.radiosRpm = radiosRpm;
		this.nomEncargado = nomEncargado;
		this.docEncargado = docEncargado;
		this.fecNacEncargado = fecNacEncargado;
		this.preventaOficinaActivo = preventaOficinaActivo;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = -8074073621389459926L;
}
