package com.olva.eser.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.ISedeDao;
import com.olva.eser.entity.Sede;
import com.olva.eser.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Autowired
	private ISedeDao sedeDao;

	@Override
	@Transactional(readOnly = true)
	public Sede findByIdSede(Integer idSede) {
		return sedeDao.findById(idSede).orElse(null);
	}

}
