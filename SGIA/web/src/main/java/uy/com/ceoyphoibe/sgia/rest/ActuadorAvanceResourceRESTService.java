package uy.com.ceoyphoibe.sgia.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;

@Path("/actuadoresAvance")
@RequestScoped
public class ActuadorAvanceResourceRESTService {

	@Inject
	private EntityManager em;

	@Inject
	private RegistroActuadorAvance registroActuadorAvance;

	@GET
	@Produces("application/json")
	public List<ActuadorAvance> listAll() {
		@SuppressWarnings("unchecked")
		final List<ActuadorAvance> results = em.createQuery(
				"select c from actuadoresAvance c order by c.id")
				.getResultList();
		return results;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public ActuadorAvance lookupById(@PathParam("id") long id) {
		System.out.println("########### Id Actuador Avance: " + id);
		ActuadorAvance av = registroActuadorAvance.obtenerActuadorAvance(id);
		return av;
	}
}
