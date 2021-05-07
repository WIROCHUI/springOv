package com.olva.eser.job.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BillingService {

    private Logger log = LoggerFactory.getLogger(getClass());

    public static final long EXECUTION_TIME = 5000L;

    private AtomicInteger count = new AtomicInteger();

    public void callBillingProcess() {
    	int salto= 0;
        log.info("Ingresa al metodo.");
        try {
            Thread.sleep(EXECUTION_TIME);            
            
        } catch (InterruptedException e) {
            log.error("Error en job", e);
        } finally {
        	salto = getNumberOfInvocations();
            count.incrementAndGet();
            log.info("Job finalizado .." + salto);
            
        }
    }

    public int getNumberOfInvocations() {
        return count.get();  
    }
    
    
//    @Value("${billing.endpoint}")
//    private  String ENDPOINT;
//    @Value("${billing.resource.billing}")
//    private  String URL_BILLING;
//    @Value("${billing.username}")
//    private  String USER_NAME;
//    @Value("${billing.password}")
//    private  String PASSWORD;
//    @Value("${billing.parameter.status}")    
//    private String STATUS_PARAMETR;
//    @Value("${billing.iso.date.format}")
   
//    private String getPets() {
//       log.info("The gettoken Service was called...");
//        String token = "";
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ENDPOINT + URL_BILLING)                  
//                    .queryParam("status", STATUS_PARAMETR);
//            String fullUrl = builder.build().toString();                     
//             ResponseEntity<Object[]> response =  new RestTemplate().getForEntity(fullUrl,  Object[].class);
//             Object[] pets = response.getBody();      
//            log.info("The getPets Service finished sucessfuly..."+pets.length);
//        } catch (RestClientException e) {
//            log.error("Error while executing callBillingProcess job", e);
//        } 
//        return token;
//    }
      

}
