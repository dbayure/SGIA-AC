package uy.com.ceoyphoibe.SGIA.controller;

import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;

@Stateless
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

	
	public ActuadorAvance guardar(ActuadorAvance actuadorAvance) {
		FachadaWS ws= new FachadaWS();
		actuadorAvance= ws.registroActuadorAvance(actuadorAvance);
		
		em.merge(actuadorAvance);
		actuadorAvanceEventSrc.fire(actuadorAvance);
		return actuadorAvance;
	}

	public Mensaje modificar(ActuadorAvance actuadorAvance) throws Exception {
		FachadaWS wsClient = new FachadaWS();
		wsClient.asociarActuadorAvanceGrupoActuadores(actuadorAvance);
		Mensaje resultado= wsClient.actualizarActuadorAvance(actuadorAvance);
		if (resultado.getTipo().equals("Informativo"))
			em.merge(actuadorAvance);
		return resultado;
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
