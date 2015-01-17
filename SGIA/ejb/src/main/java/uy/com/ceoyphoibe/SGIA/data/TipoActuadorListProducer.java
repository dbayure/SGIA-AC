/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto TipoActuador
 */
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
import uy.com.ceoyphoibe.SGIA.model.TipoActuador;

@RequestScoped
public class TipoActuadorListProducer {

	@Inject
	private EntityManager em;

	private List<TipoActuador> tipoActuadores;

	@Produces
	@Named
	public List<TipoActuador> getTipoActuador() {
		return tipoActuadores;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final TipoActuador tipoActuador) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TipoActuador> criteria = cb
				.createQuery(TipoActuador.class);
		Root<TipoActuador> tipoActuador = criteria.from(TipoActuador.class);
		criteria.select(tipoActuador).orderBy(
				cb.asc(tipoActuador.get("categoria")));
		tipoActuadores = em.createQuery(criteria).getResultList();
	}
}
