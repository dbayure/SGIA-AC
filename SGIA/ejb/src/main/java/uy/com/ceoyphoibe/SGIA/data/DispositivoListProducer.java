
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

import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Dispositivo
 */
@RequestScoped
public class DispositivoListProducer {

	@Inject
	private EntityManager em;

	private List<Dispositivo> dispositivos;

	@Produces
	@Named
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Dispositivo dispositivo) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dispositivo> criteria = cb.createQuery(Dispositivo.class);
		Root<Dispositivo> dispositivo = criteria.from(Dispositivo.class);
		criteria.select(dispositivo).orderBy(cb.asc(dispositivo.get("id")));
		criteria.where(cb.equal(dispositivo.get("activoSistema"), 'S'));
		dispositivos = em.createQuery(criteria).getResultList();
	}
	
	public List<Dispositivo> obtenerDispositivosPlaca(Long idPlaca) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dispositivo> criteria = cb.createQuery(Dispositivo.class);
		Root<Dispositivo> dispositivo = criteria.from(Dispositivo.class);
		criteria.select(dispositivo).orderBy(cb.asc(dispositivo.get("nombre")));
		criteria.where(cb.equal(dispositivo.get("activoSistema"), 'S'), cb.equal(dispositivo.get("placa").get("id"), idPlaca));
		List<Dispositivo> listaDispositivos = em.createQuery(criteria).getResultList();
		return listaDispositivos;
	}
}
