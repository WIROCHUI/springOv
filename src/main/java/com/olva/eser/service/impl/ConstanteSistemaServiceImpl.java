package com.olva.eser.service.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.entity.ConstanteSistema;
import com.olva.eser.service.IConstanteSistemaService;

@Service
public class ConstanteSistemaServiceImpl implements IConstanteSistemaService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;


	@Override
	@Transactional(readOnly = true)
	public ConstanteSistema findByCodigo(BigInteger codigo) {
		try {
            return(ConstanteSistema)em.createNamedQuery("ConstanteSistema.findByCodigo")
            		.setParameter("codigo", codigo)
            		.getSingleResult();
        } catch (Exception e) {
            return null;
        }
	}

}
