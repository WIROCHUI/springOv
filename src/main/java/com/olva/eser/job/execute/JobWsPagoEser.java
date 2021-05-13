package com.olva.eser.job.execute;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olva.eser.dto.LiquidacionClienteDto;
import com.olva.eser.dto.PersonaJuridicaAreaDto;
import com.olva.eser.emun.EstadoItemResumenComprobanteEnum;
import com.olva.eser.emun.GrupoParametrosEnum;
import com.olva.eser.emun.TipoComprobanteEnum;
import com.olva.eser.emun.TipoComprobanteFEEnum;
import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.entity.ComprobantePagoNumeracion;
import com.olva.eser.entity.DocumentoIdentidad;
import com.olva.eser.entity.Igv;
import com.olva.eser.entity.Oficina;
import com.olva.eser.entity.Parametros;
import com.olva.eser.entity.Sede;
import com.olva.eser.entity.Usuario;
import com.olva.eser.entity.WsPagoEser;
import com.olva.eser.job.service.BillingService;
import com.olva.eser.security.DatosGeneralEmpleado;
import com.olva.eser.security.SesionUsuario;
import com.olva.eser.service.IComprobantePagoNumeracionService;
import com.olva.eser.service.IComprobantePagoService;
import com.olva.eser.service.IDocumentoIdentidadService;
import com.olva.eser.service.IIgvService;
import com.olva.eser.service.IOficinaService;
import com.olva.eser.service.IParametrosService;
import com.olva.eser.service.ISedeService;
import com.olva.eser.service.ISesionUsuarioService;
import com.olva.eser.service.IWsPagoEserService;
import com.olva.eser.util.Constante;

/**
 * @author Wilder Chui
 * @version 1.0
 */
@Component
@DisallowConcurrentExecution
public class JobWsPagoEser implements Job{

	Logger log = LoggerFactory.getLogger(getClass());
    
    public static final long EXECUTION_TIME = 5000L;
    public static final String MSJ_ERROR = "No existe una preventa sin pago asociada al CIP ";
    public static final String COD_ERROR = "2";
    
    @Autowired
    private BillingService bs;
    
    @Autowired
    private IWsPagoEserService eserService;
    
    @Autowired
    private IComprobantePagoService comprobantePagoService;
    
    @Autowired
    private ISesionUsuarioService sesionUsuarioService;
    
    @Autowired
    private ISedeService sedeService;
    
    @Autowired
    private IDocumentoIdentidadService documentoIdentidadService;
    
    @Autowired
    private IIgvService igvService;
    
    @Autowired
    private IParametrosService parametrosService;
    
    @Autowired
    private IComprobantePagoNumeracionService comprobantePagoNumeracionService;
    
    @Autowired
    private IOficinaService iOficinaService;
    
    private List<WsPagoEser> listaWsPagoEser;
    
    private WsPagoEser wsPagoEser;
    private WsPagoEser updateWsPagoEser;
    private DatosGeneralEmpleado datosGeneralEmpleado;
    private Sede sedeEmpleado;
    private Parametros idMoneda;
	private Parametros estadoComprobante;
	private Parametros estadoEnvioContadoFacturado;   
	private Parametros idTipoComprobante;
    private Parametros idTipoComprobanteFE;
    private Parametros idEstadoComprobanteFe;
    private Parametros getOficinaTipoPrincipal;
    private Parametros getTipoServicioCourierNacional;
    private Parametros getTipoMoneda;
    private Igv igv;
    private ComprobantePagoNumeracion comprobantePagoNumeracion;
    private Oficina oficina;
    
    private BigInteger codTipoComprobante = BigInteger.ZERO;
	private BigInteger codTipoComprobanteFE = BigInteger.ZERO;
	private Parametros estadoResumenComp = null;   
	
	private LiquidacionClienteDto liquidacionClienteDto;
	
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	bs.callBillingProcess();  
    	int index = 0;  	
    	
    	
    	
    	try {
    		listaWsPagoEser = eserService.findByEstadoPendiente();    			
			while (listaWsPagoEser.size() > index) {

				wsPagoEser = listaWsPagoEser.get(index);
				if (wsPagoEser == null) {
					System.out.println("SIN PENDIENTES");
					return;
				}

				liquidacionClienteDto = eserService.findByIdLiquidacion(new BigDecimal(wsPagoEser.getTransactionCode()));

				if (liquidacionClienteDto == null) {
					actualizarPagoEser(wsPagoEser);
				} else if (liquidacionClienteDto != null) {
					System.out.println("GENERAR COMPROBANTE!!");
					generarComprobantePago();
				}

				index++;
			}
    			
    			
		} catch (Exception e) {
			log.error(e.getMessage());
		}  		
    }
    
    

	private void actualizarPagoEser(WsPagoEser wsPagoEser){
		try {
	    	System.out.println("ACTUALIZAR");
			updateWsPagoEser = wsPagoEser;
			updateWsPagoEser.setMsjError(MSJ_ERROR + wsPagoEser.getTransactionCode());
			updateWsPagoEser.setEstado(COD_ERROR);
			eserService.actualizar(updateWsPagoEser);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
    }
	
	private void generarComprobantePago() {
		Date fecha = new Date();
		ComprobantePago comprobantePagoGenerico = new ComprobantePago();
		SesionUsuario sesionUsuario = sesionUsuarioService.findSesionUsuario(Constante.USUARIO_OLVA_COMPRA,
				Constante.NOMBRE_HOST_MOBILE);
		cargaParametrosLiquidacion();

		try {

			if (null == liquidacionClienteDto.getTipoDocumentocliente()) {
				log.warn(Constante.NO_SE_CONFIRMO_EL_TIPO_DOC_VACIO);
			} else if (null == getTipoMoneda) {
				log.warn(Constante.NO_SE_CONFIRMO_MONEDA_VACIO);
			}
//		else if(null == comprobanteAdapter.getIdFormaPago()) {
//			mensajeRespuesta = Constante.NO_SE_CONFIRMO_FORMA_PAGO_VACIO;
//		}
			else if (null != sesionUsuario) {
				datosGeneralEmpleado = sesionUsuario.getDatGenEmpleado();
				sedeEmpleado = sedeService.findByIdSede(datosGeneralEmpleado.getIdSede());

				if (null != sedeEmpleado) {
					oficina = iOficinaService.findByTipoOficinaSede(getOficinaTipoPrincipal, sedeEmpleado);

					if (null != oficina) {

						switch (liquidacionClienteDto.getTipoDocumentocliente()) {
						case Constante.TIPO_DOC_RUC:
							codTipoComprobante = TipoComprobanteEnum.FACTURA.getValue();
							codTipoComprobanteFE = TipoComprobanteFEEnum.FACTURA.getValue();
							estadoResumenComp = parametrosService.buscaXGrupoYCodigo(
									GrupoParametrosEnum.ESTADO_ITEM_RESUMEN_COMPROBANTE.getValue(),
									EstadoItemResumenComprobanteEnum.ADICIONAR.getValue());
							break;
						case Constante.TIPO_DOC_DNI:
							codTipoComprobante = TipoComprobanteEnum.BOLETA.getValue();
							codTipoComprobanteFE = TipoComprobanteFEEnum.BOLETA.getValue();
							break;
						default:
							log.warn(Constante.TIPO_DOCUENTO_NULO);
							break;
						}
						comprobantePagoNumeracion = comprobantePagoNumeracionService.findByOficinaSerie(oficina.getId(),
								Constante.PREFIJO_COMP_TIPO_FACTURA + sedeEmpleado.getSerieFacturacionMovil());
//						cargarValoresIniciales(sedeEmpleado,getTipoMoneda);
						cargarParametros();
						comprobantePagoGenerico = loadComprobantePagoGenerico(datosGeneralEmpleado.getIdUsuario(),
								sedeEmpleado.getSerieFacturacionMovil());
						DocumentoIdentidad documentoIdentidad = documentoIdentidadService
								.findById(Integer.parseInt(liquidacionClienteDto.getCodClienteDniRuc()));

						PersonaJuridicaAreaDto pja = eserService.findByCodigoUno(
								documentoIdentidad.getIdPersona().getIdPersona(), Constante.ID_SEDE_LIMA);
						datosGeneralEmpleado = sesionUsuario.getDatGenEmpleado();
						ComprobantePago comprobante = new ComprobantePago();
						comprobante.setSerieComprobante(comprobantePagoGenerico.getSerieComprobante());
						comprobante.setFechaEmision(fecha);
						comprobante.setCreateUser(comprobantePagoGenerico.getCreateUser());
						comprobante.setCreateDatetime(fecha);
						comprobante.setCreateTime(fecha);
						comprobante.setIdDocCliente(documentoIdentidad);
						comprobante.setIdTipoComprobante(idTipoComprobante);
						comprobante.setIdPersJurArea(pja.getId());
						comprobante.setCollect(Constante.COLLECT);
						comprobante.setIdMoneda(comprobantePagoGenerico.getIdMoneda());
						comprobante.setFlgFacturaElectronica(Constante.FLG_FACTURA_ELECTRONICA);
						comprobante.setIdTipoComprobanteFE(idTipoComprobanteFE);
						comprobante.setEfectivo(BigDecimal.ZERO);
						comprobante.setEstado(comprobantePagoGenerico.getEstado());
						comprobante.setPc(comprobantePagoGenerico.getPc());
						comprobante.setIdOficina(oficina);
						comprobante.setEstResCom(estadoResumenComp);
						comprobante.setIdTipoServicio(getTipoServicioCourierNacional);
//						comprobante.setIdFormaPago(new Parametros(comprobanteAdapter.getIdFormaPago()));
						comprobante.setIgv(igv.getPorcentajeIgv());
						comprobante.setFlgDivEmi(Constante.FLG_DIVERSA_EMISION);
						comprobante.setEstadoFacE(idEstadoComprobanteFe);
						comprobantePagoService.insertaComprobantePago(comprobante, sesionUsuario);						
					}
				}

			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private ComprobantePago loadComprobantePagoGenerico(BigDecimal idUsuario, String serie) {
		ComprobantePago cp = new ComprobantePago();
		cp.setIdMoneda(idMoneda);
		cp.setEstado(estadoComprobante);        
		cp.setSerieComprobante(serie);
		cp.setPc(Constante.NOMBRE_HOST_MOBILE);
		cp.setCreateUser(idUsuario);
		return cp;
	}
    
	private void cargarParametros() {
		igv = igvService.findByEstado(Constante.ESTADO_ACTIVO);
		idTipoComprobante = parametrosService.buscaXGrupoYCodigo(GrupoParametrosEnum.TIPO_COMPROBANTE.getValue(),codTipoComprobante);
		idTipoComprobanteFE = parametrosService.buscaXGrupoYCodigo(GrupoParametrosEnum.TIPO_COMPROBANTE_FE.getValue(),codTipoComprobanteFE);
		idEstadoComprobanteFe = parametrosService.buscaXGrupoYCodigo(
			GrupoParametrosEnum.ESTADO_COMPROBANTE_FE.getValue(), Constante.PENDIENTE_GENERAR_XML);
	}
    
	private void cargaParametrosLiquidacion(){
		getOficinaTipoPrincipal = parametrosService.buscaXGrupoYCodigo(
				GrupoParametrosEnum.ESTADO_TIPO_OFICINA.getValue(), Constante.OFICINA_PRINCIPAL);
		getTipoServicioCourierNacional = parametrosService.buscaXGrupoYCodigo(
				GrupoParametrosEnum.TIPO_FACTURACION.getValue(), Constante.COURIER_NACIONAL);
		getTipoMoneda = parametrosService.buscaXGrupoYCodigo(Constante.GRUPO_MONEDA,Constante.CODIGO_DOLAR);
	}
	
	
	
    
}
