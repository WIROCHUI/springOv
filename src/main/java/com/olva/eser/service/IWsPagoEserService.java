package com.olva.eser.service;

import java.math.BigDecimal;

import com.olva.eser.entity.WsPagoEser;


/**
 * @author Wilder Chui
 * @version 1.0
 */
public interface IWsPagoEserService {
	public WsPagoEser findById(BigDecimal id);
}
