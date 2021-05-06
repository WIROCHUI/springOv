package com.olva.eser.job.execute;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olva.eser.entity.Cliente;
import com.olva.eser.entity.ClienteDetalle;
import com.olva.eser.entity.WsPagoEser;
import com.olva.eser.job.service.BillingService;
import com.olva.eser.service.IComprobanteDetalleService;
import com.olva.eser.service.IComprobanteService;
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
    private AtomicInteger count = new AtomicInteger();
    @Autowired
    private BillingService bs;
    
    @Autowired
    private IComprobanteDetalleService comprobanteDetalleService;
    
    @Autowired
    private IComprobanteService comprobanteService;
    
    @Autowired
    private IWsPagoEserService eserService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	bs.callBillingProcess();  
    	int num;
    	Cliente cliente = new Cliente();
    	ClienteDetalle clienteDetalle = new ClienteDetalle();
    	WsPagoEser wsPagoEser = new WsPagoEser();
    	try {

//        		Thread.sleep(EXECUTION_TIME);
    			wsPagoEser = eserService.findById(new BigDecimal("39")); 
    			System.out.println("DATA --> "+ wsPagoEser.getCurrency());
//    			clienteDetalle.setApellido("Olva");
//    			clienteDetalle.setCreateAt(new Date());			
//    			comprobanteDetalleService.insertComprobanteDetalle(clienteDetalle);
//    			
//    			cliente.setApellido("TESTER");
//    			cliente.setCreateAt(new Date());
//    			comprobanteService.insertComprobante(cliente);
    			
		} catch (Exception e) {
			log.error(e.getMessage());
		}  		
    }
    
    
    
}
