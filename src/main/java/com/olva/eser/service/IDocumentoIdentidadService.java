package com.olva.eser.service;

import com.olva.eser.entity.DocumentoIdentidad;

public interface IDocumentoIdentidadService {
	
	public DocumentoIdentidad findByNumero(String numeroDocumento);
	
}
