
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
import uy.com.ceoyphoibe.SGIA.model.Accion;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Accion
 */
@RequestScoped
public class AccionListProducer {

	@Inject
	private EntityManager em;

	private List<Accion> acciones;

	private List<Accion> accionesActuador;

	@Produces
	@Named
	public List<Accion> getAcciones() {
		return acciones;
	}

	public List<Accion> getAccionesIdDispositivo(Long idDispositivo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Accion> criteria = cb.createQuery(Accion.class);
		Root<Accion> accion = criteria.from(Accion.class);
		criteria.select(accion).orderBy(cb.asc(accion.get("fechaHora")));
		criteria.where(cb.equal(accion.get("idDispositivo"), idDispositivo));
		accionesActuador = em.createQuery(criteria).getResultList();
		return accionesActuador;
	}

	public List<Accion> getAccionesIdDispositivoEntreFechas(Long idDispositivo,
			Timestamp min, Timestamp max) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Accion> criteria = cb.createQuery(Accion.class);
		Root<Accion> accion = criteria.from(Accion.class);
		criteria.select(accion).orderBy(cb.desc(accion.get("fechaHora")));

		Expression<Timestamp> fecha = accion.get("fechaHora");

		Predicate p = cb.between(fecha, min, max);
		criteria.where(cb.equal(accion.get("idDispositivo"), idDispositivo), p);

		accionesActuador = em.createQuery(criteria).getResultList();
		return accionesActuador;
	}
	
	public List<Accion> obtenerUltimasAcciones(Long idPlaca) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Accion> criteria = cb.createQuery(Accion.class);
		Root<Accion> accion = criteria.from(Accion.class);
		criteria.select(accion).orderBy(cb.desc(accion.get("fechaHora")));
		criteria.where(cb.equal(accion.get("idPlaca"), idPlaca));
		List<Accion> acciones = em.createQuery(criteria).setMaxResults(10).getResultList();
		return acciones;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Accion accion) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Accion> criteria = cb.createQuery(Accion.class);
		Root<Accion> accion = criteria.from(Accion.class);
		criteria.select(accion).orderBy(cb.asc(accion.get("fechaHora")));
		accionesActuador = em.createQuery(criteria).getResultList();
	}
}
