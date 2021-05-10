/**
 * 
 */
package com.olva.eser.service.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.olva.eser.entity.ComprobantePagoNumeracion;
import com.olva.eser.service.IComprobantePagoNumeracionService;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public class ComprobantePagoNumeracionServiceImpl implements IComprobantePagoNumeracionService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public ComprobantePagoNumeracion findByOficinaSerie(BigDecimal idOficina, String serie) {
		try {
            return (ComprobantePagoNumeracion) em.createNamedQuery("ComprobantePagoNumeracion.findByOficinaSerie")
                    .setParameter("idOficina", idOficina)
                    .setParameter("serie", serie)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new NullPointerException();
        }
	}

}
