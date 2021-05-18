/**
 * 
 */
package com.olva.eser.service.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.entity.ComprobantePagoNumeracion;
import com.olva.eser.service.IComprobantePagoNumeracionService;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
@Service
public class ComprobantePagoNumeracionServiceImpl implements IComprobantePagoNumeracionService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Override
	@Transactional(readOnly = true)
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

	@Override
	@Transactional(readOnly = true)
	public ComprobantePagoNumeracion findByNumeroComprobante(String serie, String serieFacE, ComprobantePago comprobante) {
		ComprobantePagoNumeracion compPagNumeracion = (ComprobantePagoNumeracion) em
				.createNamedQuery("ComprobantePagoNumeracion.getNumeroComprobante").setParameter("serie", serieFacE)
				.setParameter("tipoComprobante", comprobante.getIdTipoComprobante().getId())
				.setParameter("idOficina", comprobante.getIdOficina().getId()).getSingleResult();
		return compPagNumeracion;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
    public void updCorrelativoCompPagoNumeracion(ComprobantePagoNumeracion compPagNumeracion, long nroCorrelativo) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaUpdate<ComprobantePagoNumeracion> update = cb.createCriteriaUpdate(ComprobantePagoNumeracion.class);
        Root e = update.from(ComprobantePagoNumeracion.class);
        update.set("nroCorrelativo", nroCorrelativo);
        update.where(cb.equal(e.get("id"), compPagNumeracion.getId()));
        this.em.createQuery(update).executeUpdate();;
    }

}
