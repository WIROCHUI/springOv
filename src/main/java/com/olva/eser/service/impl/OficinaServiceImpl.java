/**
 * 
 */
package com.olva.eser.service.impl;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dto.PersonaJuridicaAreaDto;
import com.olva.eser.entity.Oficina;
import com.olva.eser.entity.Parametros;
import com.olva.eser.entity.Persona;
import com.olva.eser.entity.Sede;
import com.olva.eser.entity.Subsede;
import com.olva.eser.entity.Usuario;
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
	@Transactional(readOnly = true)
	public Oficina findByTipoOficinaSede(Parametros tipoOficina, Sede sede) {
		StringBuilder sql = new StringBuilder();
		Oficina oficina = new Oficina();
		try {
			
			sql.append("SELECT ID, ID_PERSONA, NOMBRE, CODIGO, DESCRIPCION, ");
			sql.append("ESTADO, CREATE_DATETIME, TIPO_OFICINA, ");
			sql.append("NOMBRE_ENCARGADO,DOC_ENCARGADO ");
			sql.append("FROM OFICINA ");
			sql.append("WHERE TIPO_OFICINA=?1 AND ID_SUBSEDE=?2  AND ESTADO = 1  ");
			em.createNativeQuery(sql.toString());
			Query query = em.createNativeQuery(sql.toString());
            query.setParameter(1, tipoOficina);
            query.setParameter(2, sede);
            Object[] result = (Object[]) query.getSingleResult();
            oficina.setId((BigDecimal) result[0]);
            oficina.setIdPersona(new Persona((BigDecimal) result[1]));
            oficina.setNombre((String) result[2]);
            oficina.setCodigo((String) result[3]);
            oficina.setDescripcion((String) result[4]);
            oficina.setEstado((char) result[5]);
            oficina.setCreateDatetime((Date) result[6]);
            oficina.setTipoOficina(new Parametros((BigDecimal) result[7]));
            oficina.setNomEncargado((String) result[8]);
            oficina.setDocEncargado((String) result[9]);
            return oficina;
		} catch (Exception e) {
			return null;
		}
	}

}
