/**
 * 
 */
package com.olva.eser.service;

import java.math.BigInteger;

import com.olva.eser.entity.Parametros;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public interface IParametrosService {
	
	public Parametros buscaXGrupoYCodigo(BigInteger grupo, BigInteger codigo);

}
