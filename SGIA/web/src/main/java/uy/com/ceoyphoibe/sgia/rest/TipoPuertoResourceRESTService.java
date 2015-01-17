package uy.com.ceoyphoibe.sgia.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import uy.com.ceoyphoibe.SGIA.model.TipoPuerto;

/**
 * Clase utilizada para atender pedidos REST y devolver un recurso web de un TipoPuerto para ser utilizado en la vista
 */
@Path("/tipoPuertos")
@RequestScoped
public class TipoPuertoResourceRESTService {

	@Inject
	private EntityManager em;

	@GET
	@Produces("application/json")
	public List<TipoPuerto> listAll() {
		// Use @SupressWarnings to force IDE to ignore warnings about
		// "genericizing" the results of
		// this query
		@SuppressWarnings("unchecked")
		// We recommend centralizing inline queries such as this one into
		// @NamedQuery annotations on
		// the @Entity class
		// as described in the named query blueprint:
		// https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
		final List<TipoPuerto> results = em.createQuery(
				"select c from tipoPuerto c order by c.id").getResultList();
		return results;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public TipoPuerto lookupById(@PathParam("id") long id) {
		return em.find(TipoPuerto.class, id);
	}
}
