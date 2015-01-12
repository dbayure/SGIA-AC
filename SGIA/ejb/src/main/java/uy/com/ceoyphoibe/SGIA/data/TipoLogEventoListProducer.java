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
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;

@RequestScoped
public class TipoLogEventoListProducer {

	@Inject
	private EntityManager em;

	private List<TipoLogEvento> tipoLogEventos;

	@Produces
	@Named
	public List<TipoLogEvento> getTipoLogEventos() {
		return tipoLogEventos;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final TipoLogEvento tipoLogEvento) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TipoLogEvento> criteria = cb
				.createQuery(TipoLogEvento.class);
		Root<TipoLogEvento> tipoLogEvento = criteria.from(TipoLogEvento.class);
		criteria.select(tipoLogEvento).orderBy(
				cb.asc(tipoLogEvento.get("nombre")));
		tipoLogEventos = em.createQuery(criteria).getResultList();
	}
}
