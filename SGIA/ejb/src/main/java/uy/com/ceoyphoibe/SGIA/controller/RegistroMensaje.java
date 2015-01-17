
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Mensaje
 */
@Stateless
public class RegistroMensaje {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Mensaje> mensajeEventSrc;

	private Mensaje newMensaje;

	@Produces
	@Named
	public Mensaje getNewMensaje() {
		return newMensaje;
	}

	public void registro() throws Exception {
		log.info("Registro " + newMensaje.getTexto());
		em.persist(newMensaje);
		mensajeEventSrc.fire(newMensaje);
		initNewMensaje();
	}

	public void modificar(Mensaje mensaje) throws Exception {
		log.info("Modifico " + mensaje);
		em.merge(mensaje);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		Mensaje mensaje = em.find(Mensaje.class, id);
		em.remove(mensaje);
		mensajeEventSrc.fire(newMensaje);
	}

	public Mensaje obtenerMensajeId(long id) {
		return em.find(Mensaje.class, id);
	}

	@PostConstruct
	public void initNewMensaje() {
		newMensaje = new Mensaje();
	}
}
