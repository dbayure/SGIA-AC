package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.NivelSeveridad;

@Stateless
public class RegistroNivelSeveridad {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<NivelSeveridad> nivelSeveridadEventSrc;

	public NivelSeveridad obtenerNivelSeveridadPorId(long id) {
		NivelSeveridad temp=em.find(NivelSeveridad.class, id);
		nivelSeveridadEventSrc.fire(temp);
		return temp;
	}

	public void registro(NivelSeveridad n) throws Exception {
		em.merge(n);
		nivelSeveridadEventSrc.fire(n);
	}

	public void modificar(NivelSeveridad nivel) throws Exception {
		log.info("Modifico " + nivel);
		em.merge(nivel);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		NivelSeveridad nivel = em.find(NivelSeveridad.class, id);
		em.remove(nivel);
		nivelSeveridadEventSrc.fire(nivel);
	}
}
