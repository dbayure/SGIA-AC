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
import uy.com.ceoyphoibe.SGIA.model.TipoActuador;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;

@Stateless
public class RegistroTipoActuador {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<TipoActuador> tipoActuadorEventSrc;

	private TipoActuador newTipoActuador;

	@Produces
	@Named
	public TipoActuador getnewTipoActuador() {
		return newTipoActuador;
	}

	public void registro(TipoActuador tipoActuador) throws Exception {
		FachadaWS ws = new FachadaWS();
		tipoActuador = ws.registroTipoActuador(tipoActuador);

		em.persist(tipoActuador);
		tipoActuadorEventSrc.fire(tipoActuador);
	}

	public Mensaje modificar(TipoActuador tipoActuador) throws Exception {
		FachadaWS ws = new FachadaWS();
		Mensaje respuesta = ws.actualizarTipoActuador(tipoActuador);
		if (respuesta.getTipo().equals("Informativo"))
			em.merge(tipoActuador);
		return respuesta;
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		TipoActuador tipoActuador = em.find(TipoActuador.class, id);
		em.remove(tipoActuador);
		tipoActuadorEventSrc.fire(newTipoActuador);
	}

	@PostConstruct
	public void initNewTipoActuador() {
		newTipoActuador = new TipoActuador();
	}

}
