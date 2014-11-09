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

import uy.com.ceoyphoibe.SGIA.model.ResultadoLectura;


@Stateful
@Model
public class RegistroResultadoLectura {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<ResultadoLectura> resultadoLecturaEventSrc;

	   private ResultadoLectura newResultadoLectura;

	   @Produces
	   @Named
	   public ResultadoLectura getNewResultadoLectura() {
	      return newResultadoLectura;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newResultadoLectura.getValor());
	      em.persist(newResultadoLectura);
	      resultadoLecturaEventSrc.fire(newResultadoLectura);
	      initNewResultadoLectura();
	   }
	   
	   public void modificar(ResultadoLectura resultadoLectura) throws Exception {
		   log.info("Modifico " + resultadoLectura);
		   em.merge(resultadoLectura);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   ResultadoLectura resultadoLectura = em.find(ResultadoLectura.class, id);
		   em.remove(resultadoLectura);
		   resultadoLecturaEventSrc.fire(newResultadoLectura);
	   }

	   @PostConstruct
	   public void initNewResultadoLectura() {
		   newResultadoLectura = new ResultadoLectura();
	   }
}
