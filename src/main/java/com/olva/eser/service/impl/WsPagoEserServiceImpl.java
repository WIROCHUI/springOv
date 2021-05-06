package com.olva.eser.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.IComprobanteDetalleDao;
import com.olva.eser.dao.IWsPagoEserDao;
import com.olva.eser.entity.ClienteDetalle;
import com.olva.eser.entity.WsPagoEser;
import com.olva.eser.service.IComprobanteDetalleService;
import com.olva.eser.service.IWsPagoEserService;


/**
 * @author Wilder Chui
 * @version 1.0
 */
@Service
public class WsPagoEserServiceImpl implements IWsPagoEserService{

	@Autowired
	private IWsPagoEserDao pagoEserDao;

	@Override
	public WsPagoEser findById(BigDecimal id) {
		return pagoEserDao.findById(id).orElse(null);
	}
	
	

}
