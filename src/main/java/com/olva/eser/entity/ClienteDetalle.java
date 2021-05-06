package com.olva.eser.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name="tb_cliente_detalle")
public class ClienteDetalle implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name="create_at")
	private Date createAt;

	
	
	
	public ClienteDetalle(Long id, String apellido, Date createAt) {
		this.id = id;
		this.apellido = apellido;
		this.createAt = createAt;
	}




	public ClienteDetalle() {
		
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public Date getCreateAt() {
		return createAt;
	}




	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
