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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */

@Entity
@Table(name = "IGV")
@NamedQueries({
    @NamedQuery(name = "Igv.findAll", query = "SELECT i FROM Igv i"),
    @NamedQuery(name = "Igv.findById", query = "SELECT i FROM Igv i WHERE i.id = :id"),
    @NamedQuery(name = "Igv.findByEstado", query = "SELECT i FROM Igv i WHERE i.estado = :estado")
})
public class Igv implements Serializable{
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
	@Getter @Setter private BigDecimal id;
    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fechaInicial;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_IGV")
    @Getter @Setter private BigDecimal porcentajeIgv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    @Getter @Setter private char estado;
    
    public Igv() {
    }

    public Igv(BigDecimal id) {
        this.id = id;
    }

    public Igv(BigDecimal id, BigDecimal porcentajeIgv, char estado) {
        this.id = id;
        this.porcentajeIgv = porcentajeIgv;
        this.estado = estado;
    }
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8234396460976656840L;

}
