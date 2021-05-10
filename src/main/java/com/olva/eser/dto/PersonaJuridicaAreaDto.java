package com.olva.eser.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public class PersonaJuridicaAreaDto {
	
	@Getter @Setter private BigDecimal id;	
	@Getter @Setter private BigDecimal idPersona;
	@Getter @Setter private String codigo;
		
	
	public PersonaJuridicaAreaDto() {
		
	}

	public PersonaJuridicaAreaDto(BigDecimal id, BigDecimal idPersona, String codigo) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.codigo = codigo;
	}
	

}
