package com.olva.eser.security;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class SesionUsuario implements Serializable{


    DatosGeneralEmpleado datGenEmpleado;
    Map<BigInteger, BigDecimal> datPqteLeadTimePrincipal;
    String nombreLoginUsuario;
    @Getter @Setter private String fechaSistema;
    @Getter @Setter private String estadoOlvaWin;
    @Getter @Setter private DatosGeneralPersona datGenPersonaExtranet;
    @Getter @Setter private String msgExepcionLogin;
    @Getter @Setter private Date fechaDeAutenticacion;

    public SesionUsuario(BigDecimal idUser, String apePat, String ApeMat, String nombres, String user, BigDecimal idOficina, String estadoOlvaWin, String codDigitador) {
        this.datGenEmpleado = new DatosGeneralEmpleado();
        this.datGenEmpleado.setIdUsuario(idUser);
        this.datGenEmpleado.setApPaterno(apePat);
        this.datGenEmpleado.setApMaterno(ApeMat);
        this.datGenEmpleado.setNombres(nombres);
        this.datGenEmpleado.setUsuario(user);
        this.datGenEmpleado.setIdOficina(idOficina);
        this.datGenEmpleado.setCodDigitador(codDigitador);
        this.estadoOlvaWin = estadoOlvaWin;
    }

    public SesionUsuario(BigDecimal idUser, BigDecimal idPersona, String codigoOficina, String codDigitador, String host) {
        this.datGenEmpleado = new DatosGeneralEmpleado();
        this.datGenEmpleado.setIdUsuario(idUser);
        this.datGenEmpleado.setIdPersona(idPersona);
        this.datGenEmpleado.setCodOficina(codigoOficina);
        this.datGenEmpleado.setCodDigitador(codDigitador);
        //this.host = new Host(host);
    }

    public SesionUsuario(BigDecimal idUser, String codigoOficina, String codDigitador, String host) {
        this.datGenEmpleado = new DatosGeneralEmpleado();
        this.datGenEmpleado.setIdUsuario(idUser);
        this.datGenEmpleado.setCodOficina(codigoOficina);
        this.datGenEmpleado.setCodDigitador(codDigitador);
    }
    
    public SesionUsuario(String estadoOlvaWin , BigDecimal idSedeUsuario){
        this.estadoOlvaWin = estadoOlvaWin;
        this.datGenEmpleado = new DatosGeneralEmpleado(idSedeUsuario);
    }

    public String getNombreLoginUsuario() {
        return nombreLoginUsuario;
    }

    public void setNombreLoginUsuario(String nombreLoginUsuario) {
        this.nombreLoginUsuario = nombreLoginUsuario;
    }

    public SesionUsuario() {
    }

    public DatosGeneralEmpleado getDatGenEmpleado() {
        return datGenEmpleado;
    }

    public void setDatGenEmpleado(DatosGeneralEmpleado datGenEmpleado) {
        this.datGenEmpleado = datGenEmpleado;
    }     

    public Map<BigInteger, BigDecimal> getDatPqteLeadTimePrincipal() {
        return datPqteLeadTimePrincipal;
    }

    public void setDatPqteLeadTimePrincipal(Map<BigInteger, BigDecimal> datPqteLeadTimePrincipal) {
        this.datPqteLeadTimePrincipal = datPqteLeadTimePrincipal;
    }   



	/**
	 * 
	 */
	private static final long serialVersionUID = -2414781542337499900L;

}
