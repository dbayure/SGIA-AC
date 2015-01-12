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
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;

@RequestScoped
public class ActuadorAvanceListProducer {

	@Inject
	private EntityManager em;

	private List<ActuadorAvance> actuadoresAvance;

	@Produces
	@Named
	public List<ActuadorAvance> getActuadoresAvance() {
		return actuadoresAvance;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final ActuadorAvance actuadorAvance) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ActuadorAvance> criteria = cb
				.createQuery(ActuadorAvance.class);
		Root<ActuadorAvance> actuadorAvance = criteria
				.from(ActuadorAvance.class);
		criteria.select(actuadorAvance).orderBy(
				cb.asc(actuadorAvance.get("nombre")));
		criteria.where(cb.equal(actuadorAvance.get("activoSistema"), 'S'));
		actuadoresAvance = em.createQuery(criteria).getResultList();
	}
}
