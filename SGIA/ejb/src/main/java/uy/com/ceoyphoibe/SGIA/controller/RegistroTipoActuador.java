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

import uy.com.ceoyphoibe.SGIA.model.TipoActuador;


@Stateful
@Model
public class RegistroTipoActuador {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<TipoActuador> tipoActuadorEventSrc;

	   private TipoActuador newTipoActuador;

	   @Produces
	   @Named
	   public TipoActuador getnewTipoActuador() {
	      return newTipoActuador;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newTipoActuador.getCategoria());
	      em.persist(newTipoActuador);
	      tipoActuadorEventSrc.fire(newTipoActuador);
	      initNewTipoActuador();
	   }
	   
	   public void modificar(TipoActuador tipoActuador) throws Exception {
		   log.info("Modifico " + tipoActuador);
		   em.merge(tipoActuador);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   TipoActuador tipoActuador = em.find(TipoActuador.class, id);
		   em.remove(tipoActuador);
		   tipoActuadorEventSrc.fire(newTipoActuador);
	   }

	   @PostConstruct
	   public void initNewTipoActuador() {
		   newTipoActuador = new TipoActuador();
	   }
	
}
