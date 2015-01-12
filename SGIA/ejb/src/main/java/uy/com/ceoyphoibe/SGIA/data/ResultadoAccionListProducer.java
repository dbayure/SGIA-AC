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
import uy.com.ceoyphoibe.SGIA.model.ResultadoAccion;

@RequestScoped
public class ResultadoAccionListProducer {

	@Inject
	private EntityManager em;

	private List<ResultadoAccion> resultadoAcciones;

	@Produces
	@Named
	public List<ResultadoAccion> getResultadoAccion() {
		return resultadoAcciones;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final ResultadoAccion resultadoAccion) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ResultadoAccion> criteria = cb
				.createQuery(ResultadoAccion.class);
		Root<ResultadoAccion> resultadoAccion = criteria
				.from(ResultadoAccion.class);
		criteria.select(resultadoAccion).orderBy(
				cb.asc(resultadoAccion.get("valor")));
		resultadoAcciones = em.createQuery(criteria).getResultList();
	}
}
