package com.olva.eser.service;

import java.math.BigInteger;

import com.olva.eser.entity.ConstanteSistema;

public interface IConstanteSistemaService {
	
	public ConstanteSistema findByCodigo(BigInteger codigo);
	
}
