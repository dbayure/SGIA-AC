package uy.com.ceoyphoibe.sgia.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;

/**
 * Clase utilizada para atender pedidos REST y devolver un recurso web de una FilaPerfilActivacion para ser utilizado en la vista
 */
@Path("/filaPerfil")
@RequestScoped
public class FilaPerfilActivacionResourceRESTService {

	@Inject
	private EntityManager em;

	@GET
	@Produces("application/json")
	public List<FilaPerfilActivacion> listAll() {
		// Use @SupressWarnings to force IDE to ignore warnings about
		// "genericizing" the results of
		// this query
		@SuppressWarnings("unchecked")
		// We recommend centralizing inline queries such as this one into
		// @NamedQuery annotations on
		// the @Entity class
		// as described in the named query blueprint:
		// https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
		final List<FilaPerfilActivacion> results = em.createQuery(
				"select c from filasPerfilesActivacion c order by c.id")
				.getResultList();
		return results;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public FilaPerfilActivacion lookupById(@PathParam("id") long id) {
		return em.find(FilaPerfilActivacion.class, id);
	}
}
