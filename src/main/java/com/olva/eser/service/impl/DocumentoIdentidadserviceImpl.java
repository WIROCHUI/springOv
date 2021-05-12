package com.olva.eser.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.entity.DocumentoIdentidad;
import com.olva.eser.service.IDocumentoIdentidadService;

@Service
public class DocumentoIdentidadserviceImpl implements IDocumentoIdentidadService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public DocumentoIdentidad findByNumero(String numeroDocumento) {
		
		try {
            return (DocumentoIdentidad) em.createNamedQuery("DocumentoIdentidad.findByNumero")
		    .setParameter("numero", numeroDocumento)
		    .setFirstResult(0).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new DocumentoIdentidad();
        }
	}

}
