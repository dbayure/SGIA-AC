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
import uy.com.ceoyphoibe.SGIA.model.TipoPuerto;

@RequestScoped
public class TipoPuertoListProducer {

	@Inject
	private EntityManager em;

	private List<TipoPuerto> tipoPuertos;

	@Produces
	@Named
	public List<TipoPuerto> getTipoPuerto() {
		return tipoPuertos;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final TipoPuerto tipoPuerto) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TipoPuerto> criteria = cb.createQuery(TipoPuerto.class);
		Root<TipoPuerto> tipoPuerto = criteria.from(TipoPuerto.class);
		criteria.select(tipoPuerto).orderBy(cb.asc(tipoPuerto.get("nombre")));
		tipoPuertos = em.createQuery(criteria).getResultList();
	}
}
