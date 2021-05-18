package com.olva.eser.service;

import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.security.SesionUsuario;

/**
 * @author Wilder Chui
 * @version 1.0
 */
public interface IComprobantePagoService {
	
	public ComprobantePago insertaComprobantePago(ComprobantePago comprobantePago, SesionUsuario sesionUsuario);

}
