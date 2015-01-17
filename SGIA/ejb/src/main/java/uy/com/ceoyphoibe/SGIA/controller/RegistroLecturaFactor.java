
package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase LecturaFactor
 */
@Stateless
public class RegistroLecturaFactor {

	@Inject
	private EntityManager em;

	@Inject
	private Event<LecturaFactor> lecturaFactorEventSrc;

	public void registro(LecturaFactor lecturaFactor) throws Exception {
		em.persist(lecturaFactor);
		lecturaFactorEventSrc.fire(lecturaFactor);
	}

}
