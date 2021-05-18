/**
 * 
 */
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilder Chui
 * Date 12 may. 2021
 * Version 1.0
 */
@Entity
@Table(name = "SUBSEDE")
public class Subsede implements Serializable{
	

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBSEDE")
    @SequenceGenerator(name = "SEQ_SUBSEDE", sequenceName = "SEQ_SUBSEDE", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Getter @Setter
    private BigDecimal id;
    
    @Column(name = "NOMBRE")
    @Getter @Setter
    private String nombre;
    @Column(name = "ESTADO")
    @Getter @Setter
    private Character estado;
    @Column(name = "CREATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date createDatetime;
    @Column(name = "MODIFY_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date modifyDatetime;
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    @Getter @Setter
    private Usuario createUser;
    @JoinColumn(name = "MODIFY_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    @Getter @Setter
    private Usuario modifyUser;
    @JoinColumn(name = "ID_SEDE", referencedColumnName = "ID_SEDE")
    @ManyToOne(optional = false)
    @Getter @Setter
    
    private Sede idSede;
	public Subsede() {
		super();
	}

    

}
