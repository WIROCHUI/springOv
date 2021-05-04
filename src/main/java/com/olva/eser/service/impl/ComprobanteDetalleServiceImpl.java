package com.olva.eser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.IComprobanteDetalleDao;
import com.olva.eser.entity.ClienteDetalle;
import com.olva.eser.service.IComprobanteDetalleService;

@Service
public class ComprobanteDetalleServiceImpl implements IComprobanteDetalleService{

	@Autowired
	private IComprobanteDetalleDao comprobanteDetalleDao;
	

	@Override
	@Transactional
	public ClienteDetalle insertComprobanteDetalle(ClienteDetalle clienteDetalle) {
		return comprobanteDetalleDao.save(clienteDetalle);
	}


	
	

}
