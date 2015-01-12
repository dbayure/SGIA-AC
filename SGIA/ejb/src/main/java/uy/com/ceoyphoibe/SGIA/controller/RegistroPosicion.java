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
import uy.com.ceoyphoibe.SGIA.model.Posicion;

@Stateful
@Model
public class RegistroPosicion {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Posicion> posicionEventSrc;

	private Posicion newPosicion;

	@Produces
	@Named
	public Posicion getNewPosicion() {
		return newPosicion;
	}

	public void registro() throws Exception {
		log.info("Registro " + newPosicion.getDescripcion());
		em.persist(newPosicion);
		posicionEventSrc.fire(newPosicion);
		initNewPosicion();
	}

	public void guardar(Posicion pos) throws Exception {
		log.info("Registro " + pos.getDescripcion());
		em.persist(pos);
		posicionEventSrc.fire(pos);
		initNewPosicion();
	}

	public void modificar(Posicion posicion) throws Exception {
		log.info("Modifico " + posicion);
		em.merge(posicion);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		Posicion posicion = em.find(Posicion.class, id);
		em.remove(posicion);
		posicionEventSrc.fire(newPosicion);
	}

	@PostConstruct
	public void initNewPosicion() {
		newPosicion = new Posicion();
	}
}
