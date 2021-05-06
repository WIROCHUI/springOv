package com.olva.eser.service;

import com.olva.eser.entity.Cliente;


/**
 * @author Wilder Chui
 * @version 1.0
 */
public interface IComprobanteService {
	public Cliente insertComprobante(Cliente cliente);
	public Cliente findById(Long id);
	
}
