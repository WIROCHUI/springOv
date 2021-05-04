package com.olva.eser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olva.eser.entity.Cliente;

public interface IComprobanteDao extends JpaRepository<Cliente, Long>{

}
