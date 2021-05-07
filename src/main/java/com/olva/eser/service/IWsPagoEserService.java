package com.olva.eser.service;

import java.math.BigDecimal;
import java.util.List;

import com.olva.eser.dto.LiquidacionClienteDto;
import com.olva.eser.entity.WsPagoEser;


/**
 * @author Wilder Chui
 * @version 1.0
 */
public interface IWsPagoEserService {
	
	public WsPagoEser findById(Long id);
	
	public WsPagoEser actualizar(WsPagoEser pagoEser);
	
	public List<WsPagoEser> findByEstadoPendiente();
	
	public LiquidacionClienteDto findByIdLiquidacion(BigDecimal idLiquidacion);
	
	
}
