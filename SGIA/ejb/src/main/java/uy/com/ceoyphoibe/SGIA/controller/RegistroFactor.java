package uy.com.ceoyphoibe.SGIA.controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Sensor;
import uy.com.ceoyphoibe.SGIA.util.Herramientas;
import ws.Comunicacion;
import ws.Comunicacion_Service;
import ws.ResultadoCreacionWS;


@Stateless
public class RegistroFactor {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event <Factor> factorEventSrc;
	   
	   public void registro(Factor factor) throws Exception {
		   System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        Herramientas h= new Herramientas();
	        URL wsdl= h.obtenerWSDL("192.168.0.101", "7789");
	        Comunicacion_Service service1 = new Comunicacion_Service(wsdl);
	     //  Comunicacion_Service service1 = new Comunicacion_Service();
	        System.out.println("Create Web Service...");
	        Comunicacion port1 = service1.getComunicacion();
	        System.out.println("Call Web Service Operation...");
	        
	        BigInteger valorMin= BigInteger.valueOf(factor.getValorMin());
	        BigInteger valorMax= BigInteger.valueOf(factor.getValorMax());
	        BigInteger umbral= BigInteger.valueOf(factor.getUmbral());
	        ResultadoCreacionWS resultadoWS= port1.wsCrearFactor(factor.getNombre(), factor.getUnidad(), valorMin, valorMax, umbral);
	        Long id=resultadoWS.getIdObjeto().longValue();
	        
	        factor.setIdFactor(id);
		   
		   
		   em.merge(factor);
		   factorEventSrc.fire(factor);
	   }
	   
	   public void modificar(Factor factor) throws Exception {
		   log.info("Modifico " + factor);
		   em.merge(factor);
		   factorEventSrc.fire(factor);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Factor factor = em.find(Factor.class, id);
		   em.remove(factor);
		   factorEventSrc.fire(factor);
	   }
	  
	   public List<Sensor> getListaSensoresId(long id){
		   Factor factor = em.find(Factor.class, id);
		   List<Sensor> sensoresFactor = factor.getSensores();
		   return sensoresFactor;
	   }

	   public Factor obtenerFactorPorId (long id){
		   return em.find(Factor.class, id);		   
	   }
}
