package com.olva.eser.job.execute;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olva.eser.dto.LiquidacionClienteDto;
import com.olva.eser.entity.WsPagoEser;
import com.olva.eser.job.service.BillingService;
import com.olva.eser.service.IWsPagoEserService;

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
    
    private List<WsPagoEser> listaWsPagoEser;
    
    private WsPagoEser wsPagoEser;
    private WsPagoEser updateWsPagoEser;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	bs.callBillingProcess();  
    	int index = 0;
    	String msjError = "No existe una preventa sin pago asociada al CIP ";
    	
    	
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
    
    
    
}
