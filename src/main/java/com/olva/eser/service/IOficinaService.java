package com.olva.eser.service;

import com.olva.eser.entity.Oficina;
import com.olva.eser.entity.Parametros;
import com.olva.eser.entity.Sede;

/**
 * 
 * @author Wilder Chui
 * Date 12 may. 2021
 * Version 1.0
 */

public interface IOficinaService {
	
	public Oficina findByTipoOficinaSede(Parametros tipoOficina, Sede sede);

}
