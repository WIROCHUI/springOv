/**
 * 
 */
package com.olva.eser.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.olva.eser.entity.Parametros;
import com.olva.eser.service.IParametrosService;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
@Service
public class ParametrosServiceImpl implements IParametrosService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Parametros buscaXGrupoYCodigo(BigInteger grupo, BigInteger codigo) {
		try {
			return (Parametros) em.createNamedQuery("Parametros.buscaXGrupoYCodigo").setParameter(1, grupo)
					.setParameter(2, codigo).getSingleResult();
		} catch (NoResultException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public Parametros findbyId(BigDecimal id) {
		try {
			return (Parametros) em.createNamedQuery("Parametros.findById")
				.setParameter("id", id)
				.getSingleResult();
		    } catch (NoResultException e) {
			return new Parametros();
		    }
	}

}
