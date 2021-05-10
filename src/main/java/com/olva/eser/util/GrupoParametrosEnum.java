/**
 * 
 */
package com.olva.eser.util;

import java.math.BigInteger;

/**
 * @author Wilder Chui
 * Date 10 may. 2021
 * Version 1.0
 */
public enum GrupoParametrosEnum {
	

    TIPO_DOCUMENTO_IDENTIDAD("1"),	
    TIPO_PERSONA("2"),
    TIPO_COMPROBANTE("5"),
    ESTADO_COMPROBANTE("11"),
    ESTADO_TRACKING("34"),
    ESTADO_ITEM_RESUMEN_COMPROBANTE("46"),
    ESTADO_COMPROBANTE_FE("47"),
    TIPO_COMPROBANTE_FE("53"),
    ESTADO_TIPO_OFICINA("97"),
    TIPO_FACTURACION("111");

    private final String value;

    private GrupoParametrosEnum(String value) {
        this.value = value;
    }
    
    public BigInteger getValue() {
        return new BigInteger(value);
    }
}
