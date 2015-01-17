
package uy.com.ceoyphoibe.SGIA.data;

import java.sql.Timestamp;
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
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto LecturaFactor
 */
@RequestScoped
public class LecturaFactorListProducer {

	@Inject
	private EntityManager em;

	private List<LecturaFactor> lecturasFactores;

	@Produces
	@Named
	public List<LecturaFactor> getLecturasFactores() {
		return lecturasFactores;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final LecturaFactor lecturaFactor) {
		retrieveAllOrderedByName();
	}

	public List<LecturaFactor> getLecturasFactorIdFactorEntreFechas(
			Long idFactor, Timestamp min, Timestamp max) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LecturaFactor> criteria = cb
				.createQuery(LecturaFactor.class);
		Root<LecturaFactor> lectura = criteria.from(LecturaFactor.class);
		criteria.select(lectura).orderBy(cb.asc(lectura.get("fechaHora")));

		Expression<Timestamp> fecha = lectura.get("fechaHora");
		Predicate p = cb.between(fecha, min, max);
		criteria.where(cb.equal(lectura.get("idFactor"), idFactor), p);

		lecturasFactores = em.createQuery(criteria).getResultList();
		return lecturasFactores;
	}

	public List<LecturaFactor> getLecturasIdFactor(Long idFactor) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LecturaFactor> criteria = cb
				.createQuery(LecturaFactor.class);
		Root<LecturaFactor> lectura = criteria.from(LecturaFactor.class);
		criteria.select(lectura).orderBy(cb.asc(lectura.get("fechaHora")));
		criteria.where(cb.equal(lectura.get("idFactor"), idFactor));
		lecturasFactores = em.createQuery(criteria).getResultList();
		return lecturasFactores;
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LecturaFactor> criteria = cb
				.createQuery(LecturaFactor.class);
		Root<LecturaFactor> lecturaFactor = criteria.from(LecturaFactor.class);
		criteria.select(lecturaFactor).orderBy(
				cb.asc(lecturaFactor.get("fechaHora")));
		criteria.where(cb.equal(lecturaFactor.get("idFactor"), 1));
		lecturasFactores = em.createQuery(criteria).getResultList();
	}
}
