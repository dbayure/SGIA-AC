
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
import uy.com.ceoyphoibe.SGIA.model.Posicion;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Posicion
 */
@RequestScoped
public class PosicionListProducer {

	@Inject
	private EntityManager em;

	private List<Posicion> posiciones;

	@Produces
	@Named
	public List<Posicion> getPosiciones() {
		return posiciones;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Posicion posicion) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Posicion> criteria = cb.createQuery(Posicion.class);
		Root<Posicion> posicion = criteria.from(Posicion.class);
		criteria.select(posicion).orderBy(cb.asc(posicion.get("idPosicion")));
		posiciones = em.createQuery(criteria).getResultList();
	}
}
