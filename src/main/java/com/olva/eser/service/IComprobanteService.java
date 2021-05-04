package com.olva.eser.service;

import com.olva.eser.entity.Cliente;

public interface IComprobanteService {
	public Cliente insertComprobante(Cliente cliente);
	public Cliente findById(Long id);
	
}
