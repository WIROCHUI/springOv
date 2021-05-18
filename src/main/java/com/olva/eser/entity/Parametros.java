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
	@NamedQuery(name = "Parametros.findById", query = "SELECT p FROM Parametros p WHERE p.id = :id"),
	@NamedQuery(name = "Parametros.buscaXGrupoYCodigo", query = "SELECT p FROM Parametros p where p.grupo = ?1 and p.codigo = ?2"),
})  
public class Parametros implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARAMETROS")
    @SequenceGenerator(name = "SEQ_PARAMETROS", sequenceName = "SEQ_PARAMETROS", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Getter @Setter private BigDecimal id;
    @Column(name = "GRUPO")
    @Getter @Setter private BigInteger grupo;
    @Column(name = "CODIGO")
    @Getter @Setter private BigInteger codigo;
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


    
    public Parametros(BigDecimal id, String valor) {
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



	public Parametros(@NotNull BigDecimal id) {
		super();
		this.id = id;
	}



	public Parametros(@NotNull BigDecimal id, BigInteger grupo, BigInteger codigo, String descripcion, Character estado,
			String valor, String valor2, String pc, Date createTime, Date modifyDate, Usuario createUser,
			Usuario modifyUser, String tipo) {
		super();
		this.id = id;
		this.grupo = grupo;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.valor = valor;
		this.valor2 = valor2;
		this.pc = pc;
		this.createTime = createTime;
		this.modifyDate = modifyDate;
		this.createUser = createUser;
		this.modifyUser = modifyUser;
		this.tipo = tipo;
	}
}