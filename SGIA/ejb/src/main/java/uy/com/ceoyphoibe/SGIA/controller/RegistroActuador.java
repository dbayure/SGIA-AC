package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroActuador {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;
	   
	   @Inject
	   private Event <Actuador> actuadoresSrc;

	   public Actuador obtenerActuadorPorId (long id){
		   return em.find(Actuador.class, id);
	   }

	   public void registro(Actuador a) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   a= ws.registroActuador(a);
		   
		   em.merge(a);
		   actuadoresSrc.fire(a);
	   }
	   
	   public void modificar(Actuador actuador) throws Exception {
		   log.info("Modifico " + actuador);
		   FachadaWS wsClient = new FachadaWS();
		   wsClient.asociarActuadorGrupoActuadores(actuador);
		   
		   em.merge(actuador);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Actuador actudaror = em.find(Actuador.class, id);
		   em.remove(actudaror);
		   actuadoresSrc.fire(actudaror);
	   }


}
