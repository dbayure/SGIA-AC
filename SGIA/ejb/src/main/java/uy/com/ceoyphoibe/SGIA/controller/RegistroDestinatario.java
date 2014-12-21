package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Destinatario;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;

@Stateless
public class RegistroDestinatario {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Destinatario> destinatarioEventSrc;

	private Destinatario newDestinatario;

	@Produces
	@Named
	public Destinatario getNewDestinatario() {
		return newDestinatario;
	}

	public void registro(Destinatario destinatario) throws Exception {
		FachadaWS ws = new FachadaWS();
		destinatario = ws.registroDestinatario(destinatario);

		em.persist(destinatario);
		destinatarioEventSrc.fire(destinatario);
	}

	public Mensaje modificar(Destinatario destinatario) throws Exception {
		FachadaWS ws = new FachadaWS();
		Mensaje mensaje = ws.actualizarDestinatario(destinatario);
		if (mensaje.getTipo().equals("Informativo"))
			em.merge(destinatario);
		return mensaje;
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		Destinatario destinatario = em.find(Destinatario.class, id);
		em.remove(destinatario);
		destinatarioEventSrc.fire(newDestinatario);
	}

	@PostConstruct
	public void initNewDestinatario() {
		newDestinatario = new Destinatario();
	}
}
