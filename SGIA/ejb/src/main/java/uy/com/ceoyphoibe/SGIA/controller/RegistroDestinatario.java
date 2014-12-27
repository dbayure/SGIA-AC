package uy.com.ceoyphoibe.SGIA.controller;

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

	public Mensaje eliminar(Long id) throws Exception {
		
		Destinatario destinatario = em.find(Destinatario.class, id);
		FachadaWS ws = new FachadaWS();
		Mensaje mensaje = ws.eliminarDestinatario(destinatario);
		if (mensaje.getTipo().equals("Informativo"))
		{
			destinatario.setActivoSistema('N');
			em.merge(destinatario);
		}
		destinatarioEventSrc.fire(destinatario);
		return mensaje;
	}

	@PostConstruct
	public void initNewDestinatario() {
		newDestinatario = new Destinatario();
	}
}
