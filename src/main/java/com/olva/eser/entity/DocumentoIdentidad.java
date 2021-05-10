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
 * @author Wilder Chui
 */
@Entity
@Table(name = "DOCUMENTO_IDENTIDAD")
@NamedQueries({
    @NamedQuery(name = "DocumentoIdentidad.findAll", query = "SELECT d FROM DocumentoIdentidad d"),
    @NamedQuery(name = "DocumentoIdentidad.findByIdPersona", query = "SELECT new com.olva.eser.entity.DocumentoIdentidad(d.id, d.numeroDocumento, p.idPersona, p.concatNombre) FROM DocumentoIdentidad d JOIN d.idPersona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "DocumentoIdentidad.findByNumero", query = "SELECT d FROM DocumentoIdentidad d where d.estado = '1' and d.numeroDocumento = :numero"),
}) 
public class DocumentoIdentidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOC_IDENTIDAD")
    @SequenceGenerator(name = "SEQ_DOC_IDENTIDAD", sequenceName = "SEQ_DOC_IDENTIDAD", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Getter @Setter private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_DOCUMENTO")
    @Getter @Setter private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date createTime;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Persona idPersona;
    @JoinColumn(name = "ID_TIP_DOCUMENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Getter @Setter private Parametros idTipDocumento;
    @JoinColumn(name = "CREATE_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter private Usuario createUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    @Getter @Setter private Character estado;

    public DocumentoIdentidad() {
    }

    public DocumentoIdentidad(Integer id, String numeroDocumento, BigDecimal idPersona, String concatNombre) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.idPersona = new Persona(idPersona);
        this.idPersona.setConcatNombre(concatNombre);
        this.idPersona.setNombreComercial("OLVA COURIER");
    }
    
    public DocumentoIdentidad(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoIdentidad)) {
            return false;
        }
        DocumentoIdentidad other = (DocumentoIdentidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.olva.job.entity.DocumentoIdentidad[ id=" + id + " ]";
    }


}
