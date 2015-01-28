
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
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Factor
 */
@RequestScoped
public class FactorListProducer {

	@Inject
	private EntityManager em;

	private List<Factor> factores;

	@Produces
	@Named
	public List<Factor> getFactores() {
		return factores;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Factor factor) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Factor> criteria = cb.createQuery(Factor.class);
		Root<Factor> factor = criteria.from(Factor.class);
		criteria.select(factor).orderBy(cb.asc(factor.get("idFactor")));
		criteria.where(cb.equal(factor.get("activoSistema"), 'S'));
		factores = em.createQuery(criteria).getResultList();
	}
	
	public List<Factor> obtenerFactoresPlaca(Long idPlaca) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Factor> criteria = cb.createQuery(Factor.class);
		Root<Factor> factor = criteria.from(Factor.class);
		criteria.select(factor).orderBy(cb.asc(factor.get("idFactor")));
		criteria.where(cb.equal(factor.get("activoSistema"), 'S'), cb.equal(factor.get("placa").get("id"), idPlaca));
		List<Factor> listaFactores = em.createQuery(criteria).getResultList();
		return listaFactores;
	}
}
