/**
 * 
 */
package com.olva.eser.emun;

import java.math.BigInteger;

/**
 * @author Wilder Chui
 * Date 18 may. 2021
 * Version 1.0
 */
public enum EstadoComprobantePagoEnum {

	EMITIDO_PENDIENTE("1"), LIQUIDADO_ACTA("2"), CANCELADO("3"), ANULADO("4"), ANULADO_X_NOTA_CREDITO("5"), CANCELADO_ANULADO_X_NOTA_CREDITO("6");

    private final String value;

    EstadoComprobantePagoEnum(String value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return new BigInteger(value);
    }
}
