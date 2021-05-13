package com.olva.eser.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.IWsPagoEserDao;
import com.olva.eser.dto.LiquidacionClienteDto;
import com.olva.eser.dto.PersonaJuridicaAreaDto;
import com.olva.eser.entity.WsPagoEser;
import com.olva.eser.service.IWsPagoEserService;


/**
 * @author Wilder Chui
 * @version 1.0
 */
@Service
public class WsPagoEserServiceImpl implements IWsPagoEserService{
	
	Logger LOG = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Autowired
	private IWsPagoEserDao pagoEserDao;

	@Override
	@Transactional(readOnly = true)
	public WsPagoEser findById(Long id) {
		return pagoEserDao.findById(id).orElse(null);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<WsPagoEser> findByEstadoPendiente() {
		String estadoPendiente = "0";
		try {
            return  em.createNamedQuery("wsPagoEser.findByEstado")
                    .setParameter("estado", estadoPendiente)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            LOG.error("Mensaje: " + e.getMessage());
            return null;
        }
	}


	@Override
	@Transactional
	public WsPagoEser actualizar(WsPagoEser pagoEser) {		
		return pagoEserDao.save(pagoEser);
	}



	@Override
	@Transactional(readOnly = true)
	public LiquidacionClienteDto findByIdLiquidacion(BigDecimal idLiquidacion) {
		LiquidacionClienteDto liquidacionClienteDto = new LiquidacionClienteDto();
		StringBuilder sql = new StringBuilder();
		try {
			
			sql.append("SELECT ID_LIQUIDACION, DIRECCIONES, ");
			sql.append("TOTAL, PESO_TOTAL, SERIE_FACTURA, NUMERO_FACTURA, ");
			sql.append("COD_CLIENTE_RUC_DNI, CIP,TIPO_DOCUMENTO_CLIENTE ");
			sql.append("FROM OLVADESA.LIQUIDACION_CLIENTE ");
			sql.append("WHERE ID_LIQUIDACION = ?1 ");
			
			em.createNativeQuery(sql.toString());
			Query query = em.createNativeQuery(sql.toString());
            query.setParameter(1, idLiquidacion);
            Object[] result = (Object[]) query.getSingleResult();
            
            liquidacionClienteDto.setIdLiquidacion((BigDecimal) result[0]);
            liquidacionClienteDto.setDireccion((String) result[1]);
            liquidacionClienteDto.setTotal((BigDecimal) result[2]);
            liquidacionClienteDto.setPesoTotal((BigDecimal) result[3]);
            liquidacionClienteDto.setSerieFactura((String) result[4]);
            liquidacionClienteDto.setNumeroFactura((String) result[5]);
            liquidacionClienteDto.setCodClienteDniRuc((String) result[6]);
            liquidacionClienteDto.setCip((String) result[7]);
            liquidacionClienteDto.setTipoDocumentocliente(String.valueOf((char) result[8]));
            return liquidacionClienteDto;
		} catch (Exception e) {
			return null;
		}	

	}



	@Override
	@Transactional(readOnly = true)
	public PersonaJuridicaAreaDto findByCodigoUno(BigDecimal idPersona, BigDecimal idSede) {
		StringBuilder sql = new StringBuilder();
		PersonaJuridicaAreaDto perJurArea = new PersonaJuridicaAreaDto();
		try {
			sql.append("SELECT ID, ID_PERSONA, CODIGO ");
			sql.append("FROM PERSONA_JURIDICA_AREAS ");
			sql.append("WHERE ID_PERSONA = ?1 AND CODIGO = '1' AND ID_SEDE = ?2  ");
			em.createNativeQuery(sql.toString());
			Query query = em.createNativeQuery(sql.toString());
            query.setParameter(1, idPersona);
            query.setParameter(2, idSede);
            Object[] result = (Object[]) query.getSingleResult();
            perJurArea.setId((BigDecimal) result[0]);
            perJurArea.setIdPersona((BigDecimal) result[1]);
            perJurArea.setCodigo(String.valueOf((char) result[2]));
            return perJurArea;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	

}
