package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.Actuador;


@Stateless
public class RegistroActuador {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;


	   public void registro(Actuador a) throws Exception {
	      em.merge(a);
	   }
	   
	   public void modificar(Actuador actudaror) throws Exception {
		   log.info("Modifico " + actudaror);
		   em.merge(actudaror);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Actuador actudaror = em.find(Actuador.class, id);
		   em.remove(actudaror);
	   }


}
