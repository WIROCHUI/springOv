package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CONSTANTE_SISTEMA")
@NamedQueries({
    @NamedQuery(name = "ConstanteSistema.findAll", query = "SELECT c FROM ConstanteSistema c"),
    @NamedQuery(name = "ConstanteSistema.findById", query = "SELECT c FROM ConstanteSistema c WHERE c.id = :id"),
    @NamedQuery(name = "ConstanteSistema.findByCodigo", query = "SELECT c FROM ConstanteSistema c WHERE c.codigo = :codigo")})
public class ConstanteSistema implements Serializable{


    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    @Getter @Setter private BigInteger codigo;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Getter private BigDecimal id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "VALOR")
    @Getter @Setter private String valor;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    @Getter @Setter private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createDate;
    
    @Column(name = "MODIFY_USER")
    @Getter @Setter private BigInteger modifyUser;
    
    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date modifyDate;

    public ConstanteSistema() {
    }

    public ConstanteSistema(BigDecimal id) {
        this.id = id;
    }

    public ConstanteSistema(BigDecimal id, String valor, String descripcion, Date createDate) {
        this.id = id;
        this.valor = valor;
        this.descripcion = descripcion;
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ConstanteSistema)) {
            return false;
        }
        ConstanteSistema other = (ConstanteSistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3588106522281418730L;

}
