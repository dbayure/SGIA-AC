package uy.com.ceoyphoibe.SGIA.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Sensor;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroFactor {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event <Factor> factorEventSrc;
	   
	   public void registro(Factor factor) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   factor= ws.registroFactor(factor);
		   
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
