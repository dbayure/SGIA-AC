/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase LogEvento
 */
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.LogEvento;

@Stateless
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

	public void registro(LogEvento logEvento) throws Exception {
		em.persist(logEvento);
		logEventoEventSrc.fire(logEvento);
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
