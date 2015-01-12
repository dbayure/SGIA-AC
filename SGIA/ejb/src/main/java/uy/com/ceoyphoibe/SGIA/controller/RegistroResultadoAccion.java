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
import uy.com.ceoyphoibe.SGIA.model.ResultadoAccion;

@Stateful
@Model
public class RegistroResultadoAccion {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<ResultadoAccion> resultadoAccionEventSrc;

	private ResultadoAccion newResultadoAccion;

	@Produces
	@Named
	public ResultadoAccion getNewResultadoAccion() {
		return newResultadoAccion;
	}

	public void registro() throws Exception {
		log.info("Registro " + newResultadoAccion.getTipoAccion());
		em.persist(newResultadoAccion);
		resultadoAccionEventSrc.fire(newResultadoAccion);
		initNewResultadoAccion();
	}

	public void modificar(ResultadoAccion resultadoAccion) throws Exception {
		log.info("Modifico " + resultadoAccion);
		em.merge(resultadoAccion);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		ResultadoAccion resultadoAccion = em.find(ResultadoAccion.class, id);
		em.remove(resultadoAccion);
		resultadoAccionEventSrc.fire(newResultadoAccion);
	}

	@PostConstruct
	public void initNewResultadoAccion() {
		newResultadoAccion = new ResultadoAccion();
	}
}
