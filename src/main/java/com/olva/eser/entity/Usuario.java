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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario ")
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    @Getter @Setter private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO", unique = true)
    @Getter @Setter private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CLAVE")
    @Getter @Setter private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    @Getter @Setter private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fechaRegistro;
    @JoinColumn(name = "ID_USU_EMP", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Usuario idUsuEmp;
    
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Persona idPersona;
    
    @Size(max = 50)
    @Column(name = "HORA_FECHA")
    @Getter @Setter private String horaFecha;
    @Column(name = "COD_DIGITADOR")
    @Getter @Setter private String codDigitador;
    @Size(max = 256)
    @Column(name = "CLAVE_OLD")
    @Getter @Setter private String claveOld;
    @Size(max = 1000)
    @Column(name = "REST_CONTRASENIA")
    @Getter @Setter private String restContrasenia;
    @Column(name = "FECHA_REST_CONTRASENIA")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fechaRestContrasenia;
    @Size(max = 50)
    @Column(name = "E_MAIL")
    @Getter @Setter private String eMail;
    @Size(max = 10)
    @Column(name = "COD_OPERADOR")
    @Getter @Setter  private String codOperador;

    @Size(max = 10)
    @Column(name = "COD_USUARIO_INTRANET")
    @Getter @Setter private String codUsuarioIntranet;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return (this.idUsuario != null || other.idUsuario == null) && (this.idUsuario == null || this.idUsuario.equals(other.idUsuario));
    }

    @Override
    public String toString() {
    	return "com.olva.job.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
