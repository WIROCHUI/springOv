/**
 * 
 */
package com.olva.eser.service.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.olva.eser.entity.Oficina;
import com.olva.eser.entity.Parametros;
import com.olva.eser.entity.Sede;
import com.olva.eser.service.IOficinaService;

/**
 * @author Wilder Chui
 * Date 12 may. 2021
 * Version 1.0
 */
@Service
public class OficinaServiceImpl implements IOficinaService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Oficina findByTipoOficinaSede(Parametros tipoOficina, Sede sede) {
		try {
			List<?> resultList = em.createNamedQuery("Oficina.findByTipoOficinaSede")
					.setParameter("tipoOficina", tipoOficina).setParameter("idSede", sede).getResultList();

			if (resultList.isEmpty()) {
				return null;
			}

			return (Oficina) resultList.get(0);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}
