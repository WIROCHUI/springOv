package com.olva.eser.emun;

import java.math.BigInteger;

public enum TipoComprobanteEnum {

    FACTURA("2", "01"),
    BOLETA("1", "03"),
    NOTA_CREDITO("3", "07"),
    NOTA_DEBITO("4", "08"),
    GUIA_REMISION("5", ""),
    TICKET("6", ""),
    GUIA_TRANSPORTISTA("7",""),
    RESUMEN_BOLETA("8", "RC"),
    COMUNICACION_BAJA("9", "RA"),
    ORDEN_SERVICIO("10", ""),
    RETENCION("11", "20"),
    RESUMEN_REVERSION("12", "RR");

    private final String value;
    private final String codigoSunat;

    TipoComprobanteEnum(String value, String codigoSunat) {
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
