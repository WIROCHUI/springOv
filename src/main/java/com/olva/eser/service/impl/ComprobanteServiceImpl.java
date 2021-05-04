package com.olva.eser.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.IComprobanteDao;
import com.olva.eser.entity.Cliente;
import com.olva.eser.service.IComprobanteService;

@Service
public class ComprobanteServiceImpl implements IComprobanteService{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private IComprobanteDao comprobanteDao;

	@Override
	@Transactional
	public Cliente insertComprobante(Cliente cliente) {
		entityManager.createNativeQuery("INSERT INTO OLVA.tb_cliente_detalle (apellido, create_at) VALUES (?,?)")
	     
	      .setParameter(1, cliente.getApellido())
	      .setParameter(2, cliente.getCreateAt())
	      .executeUpdate();
		return comprobanteDao.save(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		return comprobanteDao.findById(id).orElse(null);
	}
	
	

}
