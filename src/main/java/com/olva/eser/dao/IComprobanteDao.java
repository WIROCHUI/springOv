package com.olva.eser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olva.eser.entity.Cliente;

/**
 * @author Wilder Chui
 * @version 1.0
 */
public interface IComprobanteDao extends JpaRepository<Cliente, Long>{

}
