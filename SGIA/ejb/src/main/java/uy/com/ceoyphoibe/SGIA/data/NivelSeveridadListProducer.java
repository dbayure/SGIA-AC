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
import uy.com.ceoyphoibe.SGIA.model.NivelSeveridad;

@RequestScoped
public class NivelSeveridadListProducer {

	@Inject
	private EntityManager em;

	private List<NivelSeveridad> nivelesSeveridad;

	@Produces
	@Named
	public List<NivelSeveridad> getNivelesSeveridad() {
		return nivelesSeveridad;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final NivelSeveridad nivel) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<NivelSeveridad> criteria = cb
				.createQuery(NivelSeveridad.class);
		Root<NivelSeveridad> nivel = criteria.from(NivelSeveridad.class);
		criteria.select(nivel).orderBy(cb.asc(nivel.get("id")));
		criteria.where(cb.equal(nivel.get("activoSistema"), "S"));
		nivelesSeveridad = em.createQuery(criteria).getResultList();
	}
}
