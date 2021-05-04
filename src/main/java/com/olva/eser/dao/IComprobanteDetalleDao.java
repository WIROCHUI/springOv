package com.olva.eser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olva.eser.entity.ClienteDetalle;

public interface IComprobanteDetalleDao extends JpaRepository<ClienteDetalle, Long> {
	

}
