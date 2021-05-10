/**
 * 
 */
package com.olva.eser.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.olva.eser.entity.Igv;
import com.olva.eser.service.IIgvService;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public class IgvServiceImpl implements IIgvService{

	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;
	
	 
	@Override
	public Igv findByEstado(char estado) {
		try {
	         return (Igv) em.createNamedQuery("Igv.findByEstado").setParameter("estado", estado).getSingleResult();
	     } catch (Exception e) {
	         return new Igv();
	     }
	}
}
