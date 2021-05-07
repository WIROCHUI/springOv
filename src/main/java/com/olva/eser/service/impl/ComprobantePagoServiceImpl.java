package com.olva.eser.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.IComprobantePagoDao;
import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.service.IComprobantePagoService;

@Service
public class ComprobantePagoServiceImpl implements IComprobantePagoService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Autowired
	private IComprobantePagoDao comprobantePagoDao;

	@Override
	@Transactional
	public ComprobantePago insertaComprobantePago(ComprobantePago comprobantePago) {		
		return comprobantePagoDao.save(comprobantePago);
	}

}
