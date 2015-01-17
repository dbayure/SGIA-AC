/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Lectura
 */
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
import uy.com.ceoyphoibe.SGIA.model.Lectura;

@RequestScoped
public class LecturaListProducer {

	@Inject
	private EntityManager em;

	private List<Lectura> lecturasSensor;

	@Produces
	@Named
	public List<Lectura> getLecturasSensor() {
		return lecturasSensor;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Lectura lectura) {
		retrieveAllOrderedByName();
	}

	public List<Lectura> getLecturasIdSensorEntreFechas(Long idDispositivo,
			Timestamp min, Timestamp max) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Lectura> criteria = cb.createQuery(Lectura.class);
		Root<Lectura> lectura = criteria.from(Lectura.class);
		criteria.select(lectura).orderBy(cb.asc(lectura.get("fechaHora")));

		Expression<Timestamp> fecha = lectura.get("fechaHora");
		Predicate p = cb.between(fecha, min, max);
		criteria.where(cb.equal(lectura.get("idSensor"), idDispositivo), p);

		lecturasSensor = em.createQuery(criteria).getResultList();
		return lecturasSensor;
	}

	public List<Lectura> getLecturasIdSensor(Long idDispositivo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Lectura> criteria = cb.createQuery(Lectura.class);
		Root<Lectura> lectura = criteria.from(Lectura.class);
		criteria.select(lectura).orderBy(cb.asc(lectura.get("fechaHora")));
		criteria.where(cb.equal(lectura.get("idSensor"), idDispositivo));
		lecturasSensor = em.createQuery(criteria).getResultList();
		return lecturasSensor;
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Lectura> criteria = cb.createQuery(Lectura.class);
		Root<Lectura> lectura = criteria.from(Lectura.class);
		criteria.select(lectura).orderBy(cb.asc(lectura.get("fechaHora")));
		lecturasSensor = em.createQuery(criteria).getResultList();
	}
}
