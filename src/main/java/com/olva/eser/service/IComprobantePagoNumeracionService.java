/**
 * 
 */
package com.olva.eser.service;

import java.math.BigDecimal;

import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.entity.ComprobantePagoNumeracion;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public interface IComprobantePagoNumeracionService {
	
	public ComprobantePagoNumeracion findByOficinaSerie(BigDecimal idOficina, String serie);
	
	public ComprobantePagoNumeracion findByNumeroComprobante(String serie, String serieFacE, ComprobantePago comprobante);
	
	public void updCorrelativoCompPagoNumeracion(ComprobantePagoNumeracion compPagNumeracion, long nroCorrelativo);
	
}
