package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.LogEvento;



@Stateful
@Model
public class RegistroLogEvento {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<LogEvento> logEventoEventSrc;

	   private LogEvento newLogEvento;


	   @Produces
	   @Named
	   public LogEvento getNewLogEvento() {
	      return newLogEvento;
	   }
	   
	   
	   public void registro() throws Exception {
	      log.info("Registro " + newLogEvento.toString());
	      em.persist(newLogEvento);
	      logEventoEventSrc.fire(newLogEvento);
	      initNewLogEvento();
	   }
	   
	   public void modificar(LogEvento logEvento) throws Exception {
		   log.info("Modifico " + logEvento);
		   em.merge(logEvento);
	   }
	   
	   	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   LogEvento logEvento = em.find(LogEvento.class, id);
		   em.remove(logEvento);
		   logEventoEventSrc.fire(newLogEvento);
	   }

	   @PostConstruct
	   public void initNewLogEvento() {
		   newLogEvento = new LogEvento();
	   }
}
