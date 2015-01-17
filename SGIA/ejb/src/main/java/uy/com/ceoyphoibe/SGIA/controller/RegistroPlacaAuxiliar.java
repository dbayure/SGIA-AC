
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.PlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase PlacaAuxiliar
 */
@Stateless
public class RegistroPlacaAuxiliar {

	@Inject
	private EntityManager em;

	@Inject
	private Event<PlacaAuxiliar> placaAuxiliarEventSrc;

	public void registro(PlacaAuxiliar placaAux) throws Exception {
		FachadaWS ws = new FachadaWS();
		placaAux = ws.registroPlacaAuxiliar(placaAux);

		em.merge(placaAux);
		placaAuxiliarEventSrc.fire(placaAux);
	}

	public Mensaje modificar(PlacaAuxiliar placaAux) throws Exception {
		FachadaWS ws = new FachadaWS();
		Mensaje resultado = ws.actualizarPlacaAuxiliar(placaAux);
		if (resultado.getTipo().equals("Informativo"))
			em.merge(placaAux);
		placaAuxiliarEventSrc.fire(placaAux);
		return resultado;
	}

	public Mensaje eliminar(Long id) throws Exception {
		PlacaAuxiliar placaAux = em.find(PlacaAuxiliar.class, id);
		FachadaWS ws = new FachadaWS();
		Mensaje resultado = ws.actualizarPlacaAuxiliar(placaAux);
		if (resultado.getTipo().equals("Informativo")) {
			placaAux.setActivoSistema('N');
			em.merge(placaAux);
		}
		placaAuxiliarEventSrc.fire(placaAux);
		return resultado;
	}

	public ArrayList<Dispositivo> getListaDispositivosId(long id) {
		PlacaAuxiliar placaAux = em.find(PlacaAuxiliar.class, id);
		ArrayList<Dispositivo> dispositivosPlaca = (ArrayList<Dispositivo>) placaAux
				.getListaDispositivos();
		return dispositivosPlaca;
	}

	public PlacaAuxiliar obtenerPlacaAuxiliarPorId(long id) {
		return em.find(PlacaAuxiliar.class, id);
	}
}
