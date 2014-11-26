package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.TipoPuerto;

@Stateless
public class RegistroTipoPuerto {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<TipoPuerto> tipoPuertoEventSrc;

	   private TipoPuerto newTipoPuerto;

	   @Produces
	   @Named
	   public TipoPuerto getNewTipoPuerto() {
	      return newTipoPuerto;
	   }

	   public void registro(TipoPuerto tipoPuerto) throws Exception {
	      log.info("Registro " + tipoPuerto.getNombre());
	      em.persist(tipoPuerto);
	      tipoPuertoEventSrc.fire(tipoPuerto);
	   }
	   
	   public void modificar(TipoPuerto tipoPuerto) throws Exception {
		   log.info("Modifico " + tipoPuerto);
		   em.merge(tipoPuerto);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   TipoPuerto tipoPuerto = em.find(TipoPuerto.class, id);
		   em.remove(tipoPuerto);
		   tipoPuertoEventSrc.fire(newTipoPuerto);
	   }

	   @PostConstruct
	   public void initNewTipoPuerto() {
		   newTipoPuerto = new TipoPuerto();
	   }
	  

}
