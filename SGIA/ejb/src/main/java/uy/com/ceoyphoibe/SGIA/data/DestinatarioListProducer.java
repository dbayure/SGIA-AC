/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Destinatario
 */
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
import uy.com.ceoyphoibe.SGIA.model.Destinatario;

@RequestScoped
public class DestinatarioListProducer {

	@Inject
	private EntityManager em;

	private List<Destinatario> destinatarios;

	@Produces
	@Named
	public List<Destinatario> getDestinatarios() {
		return destinatarios;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Destinatario destinatario) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Destinatario> criteria = cb
				.createQuery(Destinatario.class);
		Root<Destinatario> destinatario = criteria.from(Destinatario.class);
		criteria.select(destinatario).orderBy(
				cb.asc(destinatario.get("nombre")));
		criteria.where(cb.equal(destinatario.get("activoSistema"), 'S'));
		destinatarios = em.createQuery(criteria).getResultList();
	}
}
