package com.olva.eser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.olva.eser.entity.ClienteDetalle;

/**
 * @author Wilder Chui
 * @version 1.0
 */
public interface IComprobanteDetalleDao extends JpaRepository<ClienteDetalle, Long> {
	

}
