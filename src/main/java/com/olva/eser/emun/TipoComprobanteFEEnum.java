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
public enum TipoComprobanteFEEnum {
	

    FACTURA("1", "01"),
    BOLETA("2", "03"),
    NOTA_CREDITO_FACTURA("3", "07"),
    NOTA_DEBITO_FACTURA("4", "08"),
    NOTA_CREDITO_BOLETA("5", "07"),
    NOTA_DEBITO_BOLETA("6", "08");

    private final String value;
    private final String codigoSunat;

    TipoComprobanteFEEnum(String value, String codigoSunat) {
        this.value = value;
        this.codigoSunat = codigoSunat;
    }

    public BigInteger getValue() {
        return new BigInteger(this.value);
    }

    public String getCodigoSunat() {
        return this.codigoSunat;
    }

}
