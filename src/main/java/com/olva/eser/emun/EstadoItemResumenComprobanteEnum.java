/**
 * 
 */
package com.olva.eser.emun;

import java.math.BigInteger;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public enum EstadoItemResumenComprobanteEnum {
	ADICIONAR("1"), MODIFICAR("2"), ANULADO("3"), ANULADO_EN_EL_DIA("4"), PRE_ANULAR("5");

    private final String value;

    EstadoItemResumenComprobanteEnum(String value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return new BigInteger(value);
    }

}
