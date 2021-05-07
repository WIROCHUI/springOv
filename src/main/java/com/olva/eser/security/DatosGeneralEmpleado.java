package com.olva.eser.security;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class DatosGeneralEmpleado {

	@Getter
	@Setter
	private BigDecimal idUsuario;
	@Getter
	@Setter
	private String usuario;
	@Getter
	@Setter
	private char estadoUsuario;
	@Getter
	@Setter
	private BigDecimal idPersona;
	@Getter
	@Setter
	private String codDigitador;
	@Getter
	@Setter
	private String nombres;
	@Getter
	@Setter
	private String apPaterno;
	@Getter
	@Setter
	private String apMaterno;
	@Getter
	@Setter
	private char estadoPersona;
	@Getter
	@Setter
	private BigDecimal idSubSedeArea;
	@Getter
	@Setter
	private char estadoSubSedeArea;
	@Getter
	@Setter
	private BigDecimal idArea;
	@Getter
	@Setter
	private String nombreArea;
	@Getter
	@Setter
	private char estadoArea;
	@Getter
	@Setter
	private BigDecimal idSubSede;
	@Getter
	@Setter
	private String nombreSubSede;
	@Getter
	@Setter
	private char estadoSubSede;
	@Getter
	@Setter
	private BigDecimal idSede;
	@Getter
	@Setter
	private String nombreSede;
	@Getter
	@Setter
	private char estadoSede;
	@Getter
	@Setter
	private BigDecimal idOficina;
	@Getter
	@Setter
	private String nombreOficina;
	@Getter
	@Setter
	private String codOficina;
	@Getter
	@Setter
	private char estadoOficina;
	@Getter
	@Setter
	private char estadoEmpleado;
	@Getter
	@Setter
	private BigDecimal idEmpleado;
	@Getter
	@Setter
	private BigDecimal idPlantilla;
	@Getter
	@Setter
	private char estadoPlantilla;
	@Getter
	@Setter
	private BigDecimal idAsigPlantillaUsu;
	@Getter
	@Setter
	private char estadoAsigPlantillaUsu;
	@Getter
	@Setter
	private BigDecimal idPaquete;
	@Getter
	@Setter
	private BigDecimal idTipoAcceso;
	@Getter
	@Setter
	private BigDecimal idEmisor;
	@Getter
	@Setter
	private String codigoForm;
	@Getter
	@Setter
	private String codigoFormCE;
	@Getter
	@Setter
	String codUbigeo;
	@Getter
	@Setter
	String codSede;
	@Getter
	@Setter
	BigDecimal idTipoAfectacion;

	@Getter
	@Setter
	private String tokenMP;
	@Getter
	@Setter
	private String idMP;
	@Getter
	@Setter
	private String urlMP;
	@Getter
	@Setter
	private String timeMP;
	
	public DatosGeneralEmpleado() {
    }

	public DatosGeneralEmpleado(BigDecimal idUsuario, String usuario, char estadoUsuario, BigDecimal idPersona,
			String nombres, String apPaterno, String apMaterno, char estadoPersona, BigDecimal idSubSedeArea,
			char estadoSubSedeArea, BigDecimal idArea, String nombreArea, char estadoArea, BigDecimal idSubSede,
			String nombreSubSede, char estadoSubSede, BigDecimal idSede, String nombreSede, char estadoSede,
			BigDecimal idOficina, String nombreOficina, char estadoOficina, char estadoEmpleado, BigDecimal idEmpleado,
			BigDecimal idPlantilla, char estadoPlantilla, BigDecimal idAsigPlantillaUsu, char estadoAsigPlantillaUsu,
			BigDecimal idPaquete, String codDigitador, String codOficina, BigDecimal idTipoAcceso, BigDecimal idEmisor,
			String codUbigeo, String codSede, BigDecimal idPaqueteZona, BigDecimal idTipoAfectacion) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.estadoUsuario = estadoUsuario;
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.estadoPersona = estadoPersona;
		this.idSubSedeArea = idSubSedeArea;
		this.estadoSubSedeArea = estadoSubSedeArea;
		this.idArea = idArea;
		this.nombreArea = nombreArea;
		this.estadoArea = estadoArea;
		this.idSubSede = idSubSede;
		this.nombreSubSede = nombreSubSede;
		this.estadoSubSede = estadoSubSede;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.estadoSede = estadoSede;
		this.idOficina = idOficina;
		this.nombreOficina = nombreOficina;
		this.estadoOficina = estadoOficina;
		this.estadoEmpleado = estadoEmpleado;
		this.idEmpleado = idEmpleado;
		this.idPlantilla = idPlantilla;
		this.estadoPlantilla = estadoPlantilla;
		this.idAsigPlantillaUsu = idAsigPlantillaUsu;
		this.estadoAsigPlantillaUsu = estadoAsigPlantillaUsu;
		this.idPaquete = idPaquete;
		this.codDigitador = codDigitador;
		this.codOficina = codOficina;
		this.idTipoAcceso = idTipoAcceso;
		this.idEmisor = idEmisor;
		this.codUbigeo = codUbigeo;
		this.codSede = codSede;
		this.idTipoAfectacion = idTipoAfectacion;
	}

	public DatosGeneralEmpleado(BigDecimal idUsuario, String usuario, char estadoUsuario, BigDecimal idPersona,
			String nombres, String apPaterno, String apMaterno, char estadoPersona, BigDecimal idSubSedeArea,
			char estadoSubSedeArea, BigDecimal idArea, String nombreArea, char estadoArea, BigDecimal idSubSede,
			String nombreSubSede, char estadoSubSede, BigDecimal idSede, String nombreSede, char estadoSede,
			BigDecimal idOficina, String nombreOficina, char estadoOficina, char estadoEmpleado, BigDecimal idEmpleado,
			BigDecimal idPlantilla, char estadoPlantilla, BigDecimal idAsigPlantillaUsu, char estadoAsigPlantillaUsu,
			BigDecimal idPaquete, String codDigitador, String codOficina, BigDecimal idTipoAcceso, BigDecimal idEmisor,
			String codUbigeo, String codSede, BigDecimal idPaqueteZona, BigDecimal idTipoAfectacion, String tokenMP,
			String idMP, String urlMP, String timeMP) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.estadoUsuario = estadoUsuario;
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.estadoPersona = estadoPersona;
		this.idSubSedeArea = idSubSedeArea;
		this.estadoSubSedeArea = estadoSubSedeArea;
		this.idArea = idArea;
		this.nombreArea = nombreArea;
		this.estadoArea = estadoArea;
		this.idSubSede = idSubSede;
		this.nombreSubSede = nombreSubSede;
		this.estadoSubSede = estadoSubSede;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.estadoSede = estadoSede;
		this.idOficina = idOficina;
		this.nombreOficina = nombreOficina;
		this.estadoOficina = estadoOficina;
		this.estadoEmpleado = estadoEmpleado;
		this.idEmpleado = idEmpleado;
		this.idPlantilla = idPlantilla;
		this.estadoPlantilla = estadoPlantilla;
		this.idAsigPlantillaUsu = idAsigPlantillaUsu;
		this.estadoAsigPlantillaUsu = estadoAsigPlantillaUsu;
		this.idPaquete = idPaquete;
		this.codDigitador = codDigitador;
		this.codOficina = codOficina;
		this.idTipoAcceso = idTipoAcceso;
		this.idEmisor = idEmisor;
		this.codUbigeo = codUbigeo;
		this.codSede = codSede;
		this.idTipoAfectacion = idTipoAfectacion;
		this.tokenMP = tokenMP;
		this.idMP = idMP;
		this.urlMP = urlMP;
		this.timeMP = timeMP;
	}

	public DatosGeneralEmpleado(BigDecimal idSede) {
		this.idSede = idSede;
	}

	

}
