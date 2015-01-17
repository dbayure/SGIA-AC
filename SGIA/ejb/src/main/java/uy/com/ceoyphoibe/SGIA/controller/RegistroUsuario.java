
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.Usuario;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Usuario
 */
@Stateless
public class RegistroUsuario {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Usuario> usuarioEventSrc;

	private Usuario newUsuario;

	@Produces
	@Named
	public Usuario getNewUsuario() {
		return newUsuario;
	}

	public void registro(Usuario usuario) throws Exception {
		log.info("Registro " + usuario.getNombre());
		em.persist(usuario);
		usuarioEventSrc.fire(usuario);
	}

	public void modificar(Usuario usuario) throws Exception {
		log.info("Modifico " + usuario);
		em.merge(usuario);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		Usuario usuario = em.find(Usuario.class, id);
		em.remove(usuario);
		usuarioEventSrc.fire(newUsuario);
	}

	@PostConstruct
	public void initNewUsuario() {
		newUsuario = new Usuario();
	}
}
