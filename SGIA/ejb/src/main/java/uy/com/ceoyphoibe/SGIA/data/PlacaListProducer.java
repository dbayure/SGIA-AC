
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
import uy.com.ceoyphoibe.SGIA.model.Placa;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Placa
 */
@RequestScoped
public class PlacaListProducer {

	@Inject
	private EntityManager em;

	private List<Placa> placas;

	@Produces
	@Named
	public List<Placa> getPlacas() {
		return placas;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Placa placa) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Placa> criteria = cb.createQuery(Placa.class);
		Root<Placa> placa = criteria.from(Placa.class);
		criteria.select(placa).orderBy(cb.asc(placa.get("id")));
		placas = em.createQuery(criteria).getResultList();
	}
}