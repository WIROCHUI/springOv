package com.olva.eser.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.entity.ConstanteSistema;
import com.olva.eser.security.DatosGeneralEmpleado;
import com.olva.eser.security.SesionUsuario;
import com.olva.eser.service.IConstanteSistemaService;
import com.olva.eser.service.ISesionUsuarioService;
import com.olva.eser.util.Constante;
import com.olva.eser.util.MetodosGeneral;

@Service
public class SesionUsuarioServiceImpl implements ISesionUsuarioService{

	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private IConstanteSistemaService constanteSistemaFacadeLocal;
	
	@Override
	@Transactional(readOnly = true)
	public SesionUsuario findSesionUsuario(String usuario, String pc) {

		try {
			SesionUsuario sesionUsuario;
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("SESION_USUARIO");
			query.setParameter("pvUsuario", usuario);
			query.setParameter("pvPc", pc);
			query.execute();

			@SuppressWarnings("unchecked")
			List<DatosGeneralEmpleado> lstUsuarioEmpleado = (List<DatosGeneralEmpleado>) query.getOutputParameterValue("pCursor");
			if (!lstUsuarioEmpleado.isEmpty() && lstUsuarioEmpleado.size() == 1) {
				sesionUsuario = new SesionUsuario();
				sesionUsuario.setDatGenEmpleado(lstUsuarioEmpleado.get(0));
				ConstanteSistema oConstanteSistema = constanteSistemaFacadeLocal.findByCodigo(Constante.ESTADO_CONECTIVE_OLVA_WIN);
				sesionUsuario.setEstadoOlvaWin(!Constante.ID_SEDE_LIMA.equals(sesionUsuario.getDatGenEmpleado().getIdSede()) || oConstanteSistema == null ? "0" : oConstanteSistema.getValor());
				sesionUsuario.setFechaSistema(MetodosGeneral.convertDateNowToStringFormatted("dd/MM/yyyy"));
				sesionUsuario.setNombreLoginUsuario(nombreUsuarioLogueado(lstUsuarioEmpleado.get(0)));
				sesionUsuario.getDatGenEmpleado().setCodigoFormCE(Constante.CODIGO_FORM_CONSULTA_ENVIO);


				return sesionUsuario;
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public String nombreUsuarioLogueado(DatosGeneralEmpleado pDatosGeneralEmpleado) {
		String apPat = pDatosGeneralEmpleado.getApPaterno() == null ? "" : pDatosGeneralEmpleado.getApPaterno().trim();
		String apeMat = pDatosGeneralEmpleado.getApMaterno() == null ? "" : pDatosGeneralEmpleado.getApMaterno().trim();
		String nombresCompleto = pDatosGeneralEmpleado.getNombres() == null ? "" : pDatosGeneralEmpleado.getNombres().trim();
		nombresCompleto = nombresCompleto + " " + apPat + " " + apeMat;
		return MetodosGeneral.formatString(1, nombresCompleto.trim());
	}

}
