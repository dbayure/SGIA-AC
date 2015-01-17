/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto TipoPlacaAuxiliar
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
import uy.com.ceoyphoibe.SGIA.model.TipoPlacaAuxiliar;

@RequestScoped
public class TipoPlacaAuxiliarListProducer {

	@Inject
	private EntityManager em;

	private List<TipoPlacaAuxiliar> tipoPlacasAuxiliares;

	@Produces
	@Named
	public List<TipoPlacaAuxiliar> getTipoPlacasAuxiliares() {
		return tipoPlacasAuxiliares;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final TipoPlacaAuxiliar tipoPlacaAuxiliar) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TipoPlacaAuxiliar> criteria = cb
				.createQuery(TipoPlacaAuxiliar.class);
		Root<TipoPlacaAuxiliar> tipoPlacaAuxiliar = criteria
				.from(TipoPlacaAuxiliar.class);
		criteria.select(tipoPlacaAuxiliar).orderBy(
				cb.asc(tipoPlacaAuxiliar.get("nombre")));
		tipoPlacasAuxiliares = em.createQuery(criteria).getResultList();
	}
}
