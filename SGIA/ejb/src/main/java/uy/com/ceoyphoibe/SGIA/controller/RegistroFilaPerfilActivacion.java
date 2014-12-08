package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;

@Stateless
public class RegistroFilaPerfilActivacion {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<FilaPerfilActivacion> filaPerfilEventSrc;

	public FilaPerfilActivacion obtenerFilaPerfilActivacionPorId(long id) {
		return em.find(FilaPerfilActivacion.class, id);
	}

	public void registro(FilaPerfilActivacion fila) throws Exception {
		em.merge(fila);
		filaPerfilEventSrc.fire(fila);
	}

	public void modificar(FilaPerfilActivacion fila) throws Exception {
		log.info("Modifico " + fila);
		em.merge(fila);
		filaPerfilEventSrc.fire(fila);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		FilaPerfilActivacion fila = em.find(FilaPerfilActivacion.class, id);
		em.remove(fila);
		filaPerfilEventSrc.fire(fila);
	}
}
