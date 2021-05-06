package com.olva.eser.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Jose Pariona
 *
 */
@Entity
@Table(name = "PERSONA")
@NamedQueries({
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")   
})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONA")
    @SequenceGenerator(name = "SEQ_PERSONA", sequenceName = "SEQ_PERSONA", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA")
    @Getter @Setter private Integer idPersona;
    @Column(name = "NOMBRES")
    @Getter @Setter private String nombres;
    @Column(name = "APELLIDO_PATERNO")
    @Getter @Setter private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    @Getter @Setter private String apellidoMaterno;
    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fecNacimiento;
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createDatetime;
    @Column(name = "ESTADO")
    @Getter @Setter private Character estado;
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Usuario createUser;
    @JoinColumn(name = "ID_TIPO_PERSONA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Parametros idTipoPersona;
    @Size(max = 20)
    @Column(name = "DOCUMENTO")
    @Getter @Setter private String documento;
    @Column(name = "RAZON_SOCIAL")
    @Getter @Setter private String razonSocial;
    @Column(name = "FLG_SEND_MAIL_FAC_E")
    @Getter @Setter private Character flgSendMailFacE;
    @Size(max = 4)
    @Column(name = "TIP_CLIENTE")
    @Getter @Setter private String tipCliente;
    @Column(name = "RPTE_PRE_ABONO_CLIENTE_EMISION")
    @Getter @Setter private String rptePreAbonoClienteEmision;    
    @Column(name = "RPTE_PRE_ABONO_CLI_CORRELATIVO")
    @Getter @Setter private Integer rptePreAbonoCliCorrelativo;
    @Column(name = "CONCAT_NOMBRE")
    @Getter @Setter private String concatNombre;    
    @Column(name = "API_KEY_CODE")
    @Getter @Setter private String apiKeyCode;    
    @Column(name = "NRO_API_KEY")
    @Getter @Setter private Integer nroApiKey;    
    @Column(name = "ESTADO_PRE_VENTA")
    @Getter @Setter private Character estadoPreVenta;

    @Transient @Getter @Setter private String nombreComercial;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
    public Persona(Integer idPersona, String concatNombre) {
        this.idPersona = idPersona;
        this.concatNombre = concatNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return "com.olva.job.entity.Persona[ idPersona=" + idPersona + " ]";
    }

}
