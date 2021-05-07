package com.olva.eser.security;

import java.math.BigDecimal;

public class DatosGeneralPersona {	

    private BigDecimal idUsuario;
    private String usuario;
    private char estadoUsuario;
    private BigDecimal idPersona;

    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private char estadoPersona;

    private BigDecimal idPlantilla;
    private char estadoPlantilla;
    private BigDecimal idAsigPlantillaUsu;  
    private char estadoAsigPlantillaUsu;
    
    private String razonSocial;
    private BigDecimal idPersJurArea;
    private Character codigoPersJurArea;    
    private BigDecimal idSede;
    
    //....
    public DatosGeneralPersona(BigDecimal idUsuario, String usuario, char estadoUsuario, BigDecimal idPersona, String nombres, String apPaterno, String apMaterno, char estadoPersona, BigDecimal idPlantilla, char estadoPlantilla, BigDecimal idAsigPlantillaUsu, char estadoAsigPlantillaUsu, String razonSocial) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.estadoUsuario = estadoUsuario;
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.estadoPersona = estadoPersona;
        this.idPlantilla = idPlantilla;
        this.estadoPlantilla = estadoPlantilla;
        this.idAsigPlantillaUsu = idAsigPlantillaUsu;
        this.estadoAsigPlantillaUsu = estadoAsigPlantillaUsu;
        this.razonSocial = razonSocial;
    }

    public DatosGeneralPersona(BigDecimal idUsuario, String usuario, char estadoUsuario, BigDecimal idPersona, String nombres, String apPaterno, String apMaterno, char estadoPersona, BigDecimal idPlantilla, char estadoPlantilla, BigDecimal idAsigPlantillaUsu, char estadoAsigPlantillaUsu, String razonSocial, BigDecimal idPersJurArea, Character codigoPersJurArea) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.estadoUsuario = estadoUsuario;
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.estadoPersona = estadoPersona;
        this.idPlantilla = idPlantilla;
        this.estadoPlantilla = estadoPlantilla;
        this.idAsigPlantillaUsu = idAsigPlantillaUsu;
        this.estadoAsigPlantillaUsu = estadoAsigPlantillaUsu;
        this.razonSocial = razonSocial;
        this.idPersJurArea = idPersJurArea;
        this.codigoPersJurArea = codigoPersJurArea;
    }
    
    public DatosGeneralPersona(BigDecimal idUsuario, String usuario, char estadoUsuario, BigDecimal idPersona, String nombres, String apPaterno, String apMaterno, char estadoPersona, BigDecimal idPlantilla, char estadoPlantilla, BigDecimal idAsigPlantillaUsu, char estadoAsigPlantillaUsu, String razonSocial, BigDecimal idPersJurArea, Character codigoPersJurArea, BigDecimal idSede) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.estadoUsuario = estadoUsuario;
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.estadoPersona = estadoPersona;
        this.idPlantilla = idPlantilla;
        this.estadoPlantilla = estadoPlantilla;
        this.idAsigPlantillaUsu = idAsigPlantillaUsu;
        this.estadoAsigPlantillaUsu = estadoAsigPlantillaUsu;
        this.razonSocial = razonSocial;
        this.idPersJurArea = idPersJurArea;
        this.codigoPersJurArea = codigoPersJurArea;
        this.idSede = idSede;
    }

	public BigDecimal getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public char getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(char estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public BigDecimal getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(BigDecimal idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public char getEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(char estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

	public BigDecimal getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(BigDecimal idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public char getEstadoPlantilla() {
		return estadoPlantilla;
	}

	public void setEstadoPlantilla(char estadoPlantilla) {
		this.estadoPlantilla = estadoPlantilla;
	}

	public BigDecimal getIdAsigPlantillaUsu() {
		return idAsigPlantillaUsu;
	}

	public void setIdAsigPlantillaUsu(BigDecimal idAsigPlantillaUsu) {
		this.idAsigPlantillaUsu = idAsigPlantillaUsu;
	}

	public char getEstadoAsigPlantillaUsu() {
		return estadoAsigPlantillaUsu;
	}

	public void setEstadoAsigPlantillaUsu(char estadoAsigPlantillaUsu) {
		this.estadoAsigPlantillaUsu = estadoAsigPlantillaUsu;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public BigDecimal getIdPersJurArea() {
		return idPersJurArea;
	}

	public void setIdPersJurArea(BigDecimal idPersJurArea) {
		this.idPersJurArea = idPersJurArea;
	}

	public Character getCodigoPersJurArea() {
		return codigoPersJurArea;
	}

	public void setCodigoPersJurArea(Character codigoPersJurArea) {
		this.codigoPersJurArea = codigoPersJurArea;
	}

	public BigDecimal getIdSede() {
		return idSede;
	}

	public void setIdSede(BigDecimal idSede) {
		this.idSede = idSede;
	}
    
    

}
