
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
import uy.com.ceoyphoibe.SGIA.model.PlacaAuxiliar;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto PlacaAuxiliar
 */
@RequestScoped
public class PlacaAuxiliarListProducer {

	@Inject
	private EntityManager em;

	private List<PlacaAuxiliar> placasAuxiliares;

	@Produces
	@Named
	public List<PlacaAuxiliar> getPlacasAuxiliares() {
		return placasAuxiliares;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final PlacaAuxiliar placaAux) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PlacaAuxiliar> criteria = cb
				.createQuery(PlacaAuxiliar.class);
		Root<PlacaAuxiliar> placaAux = criteria.from(PlacaAuxiliar.class);
		criteria.select(placaAux).orderBy(cb.asc(placaAux.get("id")));
		criteria.where(cb.equal(placaAux.get("activoSistema"), 'S'));
		placasAuxiliares = em.createQuery(criteria).getResultList();
	}
}
