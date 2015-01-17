
package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.Accion;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Accion
 */
@Stateless
public class RegistroAccion {

	@Inject
	private EntityManager em;

	@Inject
	private Event<Accion> accionEventSrc;

	public void registro(Accion accion) throws Exception {
		em.persist(accion);
		accionEventSrc.fire(accion);
	}
}
