package com.olva.eser.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class LiquidacionClienteDto {

	@Getter @Setter private BigDecimal idLiquidacion;
	@Getter @Setter private String direccion;
	@Getter @Setter private BigDecimal total;
	@Getter @Setter private BigDecimal pesoTotal;
	@Getter @Setter private String serieFactura;
	@Getter @Setter private String numeroFactura;
	@Getter @Setter private String codClienteDniRuc;
	@Getter @Setter private String cip;
}
