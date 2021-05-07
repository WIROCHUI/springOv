package com.olva.eser.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olva.eser.entity.WsPagoEser;

public interface IWsPagoEserDao extends JpaRepository<WsPagoEser, Long>{

}
