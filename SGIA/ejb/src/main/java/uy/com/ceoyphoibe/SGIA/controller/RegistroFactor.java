package uy.com.ceoyphoibe.SGIA.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
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
	   
	   public Factor registroPlaca(Factor factor) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   factor= ws.registroFactor(factor);
		   
		   em.merge(factor);
		   factorEventSrc.fire(factor);
		   return factor;
	   }
	   
	   public void registro(Factor factor) throws Exception {
		   em.merge(factor);
		   factorEventSrc.fire(factor);
	   }
	   
	   public Mensaje modificar(Factor factor) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   Mensaje resultado= ws.actualizarFactor(factor);
		   if (resultado.getTipo().equals("Informativo"))
			   em.merge(factor);
		   factorEventSrc.fire(factor);
		   return resultado;
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
	   
	   public ResultadoLectura lecturaFactor(long idFactor){
		   System.out.println("Entra a pedir lectura del factor: "+idFactor);
		   ResultadoLectura rl = new ResultadoLectura();
		   Factor factor= obtenerFactorPorId(idFactor);
		   System.out.println("Obtiene el factor: "+factor.getNombre());
		   FachadaWS ws= new FachadaWS();
		   rl = ws.lecturaFactor(factor);
		   return rl;
	   }
}
