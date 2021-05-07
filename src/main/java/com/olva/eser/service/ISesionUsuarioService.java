package com.olva.eser.service;

import com.olva.eser.security.SesionUsuario;

public interface ISesionUsuarioService {
	
	public SesionUsuario findSesionUsuario(String usuario, String pc);

}
