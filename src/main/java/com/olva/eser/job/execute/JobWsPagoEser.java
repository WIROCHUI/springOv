package com.olva.eser.job.execute;

import java.math.BigDecimal;
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
import com.olva.eser.entity.ComprobantePago;
import com.olva.eser.entity.Sede;
import com.olva.eser.entity.WsPagoEser;
import com.olva.eser.job.service.BillingService;
import com.olva.eser.security.DatosGeneralEmpleado;
import com.olva.eser.security.SesionUsuario;
import com.olva.eser.service.IComprobantePagoService;
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
    
    private List<WsPagoEser> listaWsPagoEser;
    
    private WsPagoEser wsPagoEser;
    private WsPagoEser updateWsPagoEser;
    private ComprobantePago comprobante;
    private DatosGeneralEmpleado datosGeneralEmpleado;
    private Sede sedeEmpleado;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	bs.callBillingProcess();  
    	int index = 0;  	
    	
    	LiquidacionClienteDto liquidacionClienteDto = new LiquidacionClienteDto();
    	
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
//					generarComprobantePago();
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
	
	@SuppressWarnings("unused")
	private void generarComprobantePago() {
		SesionUsuario sesionUsuario = sesionUsuarioService.findSesionUsuario(Constante.USUARIO_OLVA_COMPRA, Constante.NOMBRE_HOST_MOBILE);
		
		if(null != sesionUsuario) {
			datosGeneralEmpleado = sesionUsuario.getDatGenEmpleado();
			sedeEmpleado = sedeService.findByIdSede(datosGeneralEmpleado.getIdSede().toBigInteger().intValueExact());
		}
		
		comprobante.setCreateUser(null);
		comprobante.setIdTipoAfectacionIgv(null);
		comprobante.setSerieComprobante(null);
		comprobante.setNroComprobante(null);
		comprobante.setIdDocCliente(null);
		comprobante.setFechaEmision(null);
		comprobante.setValorVenta(null);
		comprobante.setValorIgv(null);
		comprobante.setPrecioVenta(null);
		comprobante.setIdMoneda(null);
		comprobante.setIgv(null);
		comprobante.setBaseImponible(null);
		comprobante.setCollect(Constante.COLLECT);
		comprobante.setEstado(null);
		comprobante.setObservacion(null);
		comprobante.setIdOficina(null);
		comprobante.setCreateDatetime(new Date());
		comprobante.setCreateTime(new Date());
		comprobante.setPc(null);
		comprobante.setEfectivo(BigDecimal.ZERO);
		comprobante.setIdPersJurArea(null);
		comprobante.setFlgDivEmi(Constante.FLG_DIVERSA_EMISION);
		comprobantePagoService.insertaComprobantePago(comprobante);
		try {
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
    
    
    
}
