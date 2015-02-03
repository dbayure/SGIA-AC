
package uy.com.ceoyphoibe.SGIA.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto GrupoActuadores
 */
@RequestScoped
public class GrupoActuadoresListProducer {

	@Inject
	private EntityManager em;

	private List<GrupoActuadores> grupoActuadores;

	@Produces
	@Named
	public List<GrupoActuadores> getGrupoActuadores() {
		return grupoActuadores;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final GrupoActuadores grupoActuador) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GrupoActuadores> criteria = cb
				.createQuery(GrupoActuadores.class);
		Root<GrupoActuadores> grupoActuador = criteria
				.from(GrupoActuadores.class);
		criteria.select(grupoActuador).orderBy(cb.asc(grupoActuador.get("id")));
		criteria.where(cb.equal(grupoActuador.get("activoSistema"), 'S'));
		grupoActuadores = em.createQuery(criteria).getResultList();
	}
	
	public List<GrupoActuadores> obtenerGrupoActuadoresPlaca(Long idPlaca) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GrupoActuadores> criteria = cb.createQuery(GrupoActuadores.class);
		Root<GrupoActuadores> grupo = criteria.from(GrupoActuadores.class);
		criteria.select(grupo).orderBy(cb.asc(grupo.get("nombre")));
		criteria.where(cb.equal(grupo.get("activoSistema"), 'S'), cb.equal(grupo.get("placa").get("id"), idPlaca));
		List<GrupoActuadores> listaGrupos = em.createQuery(criteria).getResultList();
		return listaGrupos;
	}
}
