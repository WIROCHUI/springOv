package com.olva.eser.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olva.eser.dao.IComprobantePagoDao;
import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.entity.ComprobantePagoNumeracion;
import com.olva.eser.entity.Parametros;
import com.olva.eser.entity.Persona;
import com.olva.eser.security.SesionUsuario;
import com.olva.eser.service.IComprobantePagoNumeracionService;
import com.olva.eser.service.IComprobantePagoService;
import com.olva.eser.util.Constante;

@Service
public class ComprobantePagoServiceImpl implements IComprobantePagoService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;

	@Autowired
	private IComprobantePagoDao comprobantePagoDao;
	
	@Autowired
	private IComprobantePagoNumeracionService comprobantePagoNumeracionService;

	@Override
	@Transactional
	public ComprobantePago insertaComprobantePago(ComprobantePago comprobantePago, SesionUsuario sesionUsuario) {
		ComprobantePago comprobante = comprobantePago;
		String serie = comprobante.getSerieComprobante();
		Character docCobro = comprobante.getIdTipoComprobante().getValor().charAt(0);
		String prefijo = docCobro == '1' ? "F" : "B";
		String serieFacE = prefijo.concat(serie);
		String numeroComprobante;
		String mensaje;
		String comprobanteGenerado;
		String[] dividirComprobante;

		try {

			ComprobantePagoNumeracion comprobanteNumeracion = comprobantePagoNumeracionService
					.findByNumeroComprobante(serie, serieFacE, comprobante);

			if (comprobanteNumeracion != null && comprobanteNumeracion.getId() != null) {
				Long nroCorrelativo = comprobanteNumeracion.getNroCorrelativo();
				nroCorrelativo = nroCorrelativo != null ? nroCorrelativo : 0;

				if (nroCorrelativo == 0) {
					nroCorrelativo = nroCorrelativo + 1;
					comprobantePagoNumeracionService.updCorrelativoCompPagoNumeracion(comprobanteNumeracion,
							nroCorrelativo);
					numeroComprobante = comprobanteNumeracion.getSerie().concat("-").concat(nroCorrelativo.toString())
							.concat("-").concat("0").concat("-").concat("OK");
				} else {
					Long cant = validateExistComprobante(serieFacE, nroCorrelativo, comprobante.getIdTipoComprobante(),
							sesionUsuario.getDatGenEmpleado().getIdEmisor());
					if (cant != null && cant != 0) {
						nroCorrelativo = nroCorrelativo + 1;
						comprobantePagoNumeracionService.updCorrelativoCompPagoNumeracion(comprobanteNumeracion,
								nroCorrelativo);
						numeroComprobante = comprobanteNumeracion.getSerie().concat("-")
								.concat(nroCorrelativo.toString()).concat("-").concat("0").concat("-").concat("OK");
					} else {
						String serieFormato = serie.concat(new DecimalFormat("00000000").format(nroCorrelativo));
						mensaje = Constante.COMPROBANTE_ANTERIOR_NO_EXISTE + serieFormato;
						numeroComprobante = comprobanteNumeracion.getSerie().concat("-")
								.concat(nroCorrelativo.toString()).concat("-").concat("1").concat("-").concat(mensaje);
					}
				}
				comprobanteGenerado = comprobanteNumeracion.getSerie() + Constante.GUION + nroCorrelativo.toString();
			} else {
				mensaje = Constante.SERIE_ANTERIOR_NO_EXISTE + " (".concat(serie).concat("). CONTACTAR A SISTEMAS");
				numeroComprobante = "0".concat("-").concat("0").concat("-").concat("1").concat("-").concat(mensaje);
			}

			if (numeroComprobante == null || numeroComprobante.isEmpty()) {
				log.warn(Constante.TICKETERA_ANTERIOR_NO_EXISTE);
			}

			dividirComprobante = numeroComprobante.split(Constante.SEPARADOR_GUION);

			if (!dividirComprobante[2].equals(Constante.COD_ERR_COMPROBANTE)) {
				log.warn("ERROR " + numeroComprobante + dividirComprobante[3]);
			}

			comprobante.setSerieComprobante(dividirComprobante[0].trim());
			comprobante.setNroComprobante(Integer.parseInt(dividirComprobante[1].trim()));
			comprobante.setIdEmisorComp(new Persona(sesionUsuario.getDatGenEmpleado().getIdEmisor()));

			return comprobantePagoDao.save(comprobante);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	private Long validateExistComprobante(String serie, Long nroCorrelativo, Parametros idTipoComprobante, BigDecimal idEmisor) {
		try {
			Query query = em.createNamedQuery("ComprobantePago.validateExistComprobante");
			query.setParameter("idEmisorComp", new Persona(idEmisor));
			query.setParameter("tipoComprobante", idTipoComprobante);
			query.setParameter("serie", serie);
			query.setParameter("nroComprobante", nroCorrelativo.intValue());
			return (Long) query.getSingleResult();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
       
    }

}
