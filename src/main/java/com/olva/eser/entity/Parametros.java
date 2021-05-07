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
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Jose Pariona
 *
 */
@Entity
@Table(name = "PARAMETROS")
@NamedQueries({
    @NamedQuery(name = "Parametros.findByGrupoAndCodigo", query = "SELECT new com.olva.eser.entity.Parametros(p.id) FROM Parametros p WHERE p.grupo = :grupo AND p.codigo = :codigo")
})  
public class Parametros implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARAMETROS")
    @SequenceGenerator(name = "SEQ_PARAMETROS", sequenceName = "SEQ_PARAMETROS", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Getter @Setter private Integer id;
    @Column(name = "GRUPO")
    @Getter @Setter private Integer grupo;
    @Column(name = "CODIGO")
    @Getter @Setter private Integer codigo;
    @Column(name = "DESCRIPCION")
    @Getter @Setter private String descripcion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    @Getter @Setter private Character estado;
    @Column(name = "VALOR")
    @Getter @Setter private String valor;
    @Column(name = "VALOR2")
    @Getter @Setter private String valor2;
    @Column(name = "PC")
    @Getter @Setter private String pc;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createTime;
    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date modifyDate;
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Usuario createUser;
    @JoinColumn(name = "MODIFY_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Usuario modifyUser; 
    @Column(name = "TIPO")
    private String tipo;
    
    public Parametros() {
    }

    public Parametros(Integer id) {
        this.id = id;
    }
    
    public Parametros(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.olva.job.entity.Parametros[ id=" + id + " ]";
    }
}