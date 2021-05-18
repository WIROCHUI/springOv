package com.olva.eser.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Constante {
	
	public static final Character COLLECT = '0';	
	public static final Character FLG_FACTURA_ELECTRONICA = '1';
	public static final BigDecimal IGV = new BigDecimal(0.18);
	public static final Character FLG_DIVERSA_EMISION = '0';
	public static final String USUARIO_OLVA_COMPRA = "POLVACOMPRAS";
	public static final String NOMBRE_HOST_MOBILE = "P_OLVA_COMPRAS";
	public static final BigDecimal ID_SEDE_LIMA = new BigDecimal("43");
	public static final BigInteger ESTADO_CONECTIVE_OLVA_WIN = new BigInteger("3");
	public static final String CODIGO_FORM_CONSULTA_ENVIO = "0309";
	public static final String TIPO_DOC_DNI = "1";
	public static final String TIPO_DOC_RUC = "6";
	public static final String VACIO = "";
	public static final Character ESTADO_ACTIVO = '1';
	public static final BigInteger PENDIENTE_GENERAR_XML = new BigInteger("8");
	public static final String PREFIJO_COMP_TIPO_FACTURA = "F";
	public static final BigInteger GRUPO_MONEDA = new BigInteger("7");
	public static final BigInteger CODIGO_DOLAR = new BigInteger("2");
	public static final BigInteger CODIGO_FORMA_PAGO = new BigInteger("87");
	public static final String SEPARADOR_GUION = "\\-";
	public static final String GUION = " - ";
	public static final String COD_ERR_COMPROBANTE = "0";
	public static final BigInteger TIPO_FORMA_PAGO_EFECTIVO = new BigInteger("6");
	public static final BigInteger TIPO_FORMA_MERCADO_PAGO = new BigInteger("4");
	public static final BigDecimal ID_ESTADO_ENVIO_CONTADO_FACTURADO = BigDecimal.valueOf(83);
	
	public static final BigInteger OFICINA_PRINCIPAL = new BigInteger("1");
	public static final BigInteger COURIER_NACIONAL = new BigInteger("1");
	
	
	//MENSAJES
	public static final String NO_SE_CONFIRMO_EL_TIPO_DOC_VACIO = "5#El tipo de documento del cliente no ha sido enviado en el trama, por favor revisar";
	public static final String NO_SE_CONFIRMO_MONEDA_VACIO = "6#La moneda no ha sido enviado en el trama, por favor revisar";
	public static final String NO_SE_CONFIRMO_FORMA_PAGO_VACIO = "7#La forma de pago no ha sido enviado en el trama, por favor revisar";
	public static final String TIPO_DOCUENTO_NULO = "NO SE ENCONTRO TIPO DE DOCUMENTO";
	public static final String COMPROBANTE_ANTERIOR_NO_EXISTE = "El comprobante de pago anterior no esta registrado, avisar a sistemas => ";
	public static final String SERIE_ANTERIOR_NO_EXISTE = "No se encontro el registro del número del correlativo de la serie ";
	public static final String TICKETERA_ANTERIOR_NO_EXISTE = "No se encontro el registro del número del correlativo de la ticketera, avisar a sistemas (SP RETURN NULL)";

}
