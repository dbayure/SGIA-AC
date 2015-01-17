package uy.com.ceoyphoibe.sgia.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import uy.com.ceoyphoibe.SGIA.model.Factor;

/**
 * Clase utilizada para atender pedidos REST y devolver un recurso web de un Factor para ser utilizado en la vista
 */
@Path("/factor")
@RequestScoped
public class FactorResourceRESTService {

	@Inject
	private EntityManager em;

	@GET
	@Produces("application/json")
	public List<Factor> listAll() {
		// Use @SupressWarnings to force IDE to ignore warnings about
		// "genericizing" the results of
		// this query
		@SuppressWarnings("unchecked")
		// We recommend centralizing inline queries such as this one into
		// @NamedQuery annotations on
		// the @Entity class
		// as described in the named query blueprint:
		// https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
		final List<Factor> results = em.createQuery(
				"select c from factores c order by c.idFactor").getResultList();
		return results;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Factor lookupById(@PathParam("id") long id) {
		return em.find(Factor.class, id);
	}
}
