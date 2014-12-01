package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;


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
	      em.merge(a);
	      actuadoresSrc.fire(a);
	   }
	   
	   public void modificar(Actuador actudaror) throws Exception {
		   log.info("Modifico " + actudaror);
		   em.merge(actudaror);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Actuador actudaror = em.find(Actuador.class, id);
		   em.remove(actudaror);
		   actuadoresSrc.fire(actudaror);
	   }


}
