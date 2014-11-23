package uy.com.ceoyphoibe.SGIA.controller;

import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Posicion;

@Stateful
@Model
public class RegistroActuadorAvance {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<ActuadorAvance> actuadorAvanceEventSrc;

	private ActuadorAvance newActuadorAvance;

	@Produces
	@Named
	public ActuadorAvance getNewActuadorAvance() {
		return newActuadorAvance;
	}

	public void registro() throws Exception {
		log.info("Registro " + newActuadorAvance.getNombre());
		em.persist(newActuadorAvance);
		actuadorAvanceEventSrc.fire(newActuadorAvance);
		initNewActuadorAvance();
	}

	public void guardar(ActuadorAvance actuadorAvance) {
		log.info("Registro " + actuadorAvance.getNombre());
		em.merge(actuadorAvance);
		// actuadorAvanceEventSrc.fire(actuadorAvance);
		// initNewActuadorAvance();
	}

	public void modificar(ActuadorAvance actuadorAvance) throws Exception {
		log.info("Modifico " + actuadorAvance);

		em.merge(actuadorAvance);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		ActuadorAvance actuadorAvance = em.find(ActuadorAvance.class, id);
		em.remove(actuadorAvance);
		actuadorAvanceEventSrc.fire(newActuadorAvance);
	}

	public ActuadorAvance obtenerActuadorAvance(Long id) {
		ActuadorAvance actuadorAvance = em.find(ActuadorAvance.class, id);
		Set<Posicion> listPos = actuadorAvance.getListaPosiciones();
		System.out.println(listPos.size());

		return actuadorAvance;
	}

	@PostConstruct
	public void initNewActuadorAvance() {
		newActuadorAvance = new ActuadorAvance();
	}

}
