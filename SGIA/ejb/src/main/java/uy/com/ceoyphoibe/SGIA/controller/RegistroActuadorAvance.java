
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase ActuadorAvance
 */
@Stateless
public class RegistroActuadorAvance {

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

	public ActuadorAvance guardar(ActuadorAvance actuadorAvance) throws WsPlacaControladoraException {
		FachadaWS ws = new FachadaWS();
		actuadorAvance = ws.registroActuadorAvance(actuadorAvance);

		em.merge(actuadorAvance);
		actuadorAvanceEventSrc.fire(actuadorAvance);
		return actuadorAvance;
	}

	public Mensaje modificar(ActuadorAvance actuadorAvance) throws Exception {
		FachadaWS wsClient = new FachadaWS();
		wsClient.asociarActuadorAvanceGrupoActuadores(actuadorAvance);
		Mensaje resultado = wsClient.actualizarActuadorAvance(actuadorAvance);
		if (resultado.getTipo().equals("Informativo"))
			em.merge(actuadorAvance);
		return resultado;
	}

	public Mensaje eliminar(Long id) throws Exception {
		ActuadorAvance actuadorAvance = em.find(ActuadorAvance.class, id);
		FachadaWS wsClient = new FachadaWS();
		Mensaje resultado = wsClient.eliminarActuadorAvance(actuadorAvance);
		if (resultado.getTipo().equals("Informativo")) {
			actuadorAvance.setActivoSistema('N');
			em.merge(actuadorAvance);
		}
		actuadorAvanceEventSrc.fire(actuadorAvance);
		return resultado;
	}

	public ActuadorAvance obtenerActuadorAvance(Long id) {
		ActuadorAvance actuadorAvance = em.find(ActuadorAvance.class, id);
		Set<Posicion> listPos = actuadorAvance.getListaPosiciones();
		System.out.println(listPos.size());
		return actuadorAvance;
	}

	public boolean esDeAvance(long id) {
		boolean es = false;
		ActuadorAvance actuadorAvance = em.find(ActuadorAvance.class, id);
		if (actuadorAvance != null) {
			es = true;
		}
		return es;
	}
	
	public void actualizarEstado(ActuadorAvance a) throws WsPlacaControladoraException {
		FachadaWS ws = new FachadaWS();
		int resultado = ws.obtenerEstadoActuadorAvance(a);
		if (a.getPosicion() != resultado) {
			a.setPosicion(resultado);
			em.merge(a);
		}
	}

	@PostConstruct
	public void initNewActuadorAvance() {
		newActuadorAvance = new ActuadorAvance();
	}

	public Mensaje reestablecerPosicionActuadorAvance(
			ActuadorAvance actuadorAvance, char nroPosicion) throws WsPlacaControladoraException {
		FachadaWS wsClient = new FachadaWS();
		Mensaje resultado = wsClient.reestablecerActuadorAvance(actuadorAvance,
				nroPosicion);
		if (resultado.getTipo().equals("Informativo"))
			em.merge(actuadorAvance);
		return resultado;
	}

}
