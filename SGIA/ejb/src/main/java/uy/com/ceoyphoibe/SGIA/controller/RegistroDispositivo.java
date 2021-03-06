
package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Dispositivo
 */
@Stateless
public class RegistroDispositivo {

	@Inject
	private EntityManager em;

	public Dispositivo obtenerDispositivoPorId(long id) {
		return em.find(Dispositivo.class, id);
	}

	public void pedirEstadoDispositivo(Dispositivo dispositivo) {
		try {
			FachadaWS ws = new FachadaWS();
			String estado = ws.obtenerEstadoAlertaDispositivo(dispositivo);
			if (!estado.equals(dispositivo.getEstadoAlerta())) {
				dispositivo.setEstadoAlerta(estado);
				em.merge(dispositivo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mensaje reestablecerDispositivo(Dispositivo dispositivo) throws WsPlacaControladoraException {
		FachadaWS wsClient = new FachadaWS();
		Mensaje resultado = wsClient.reestablecerDispositivo(dispositivo);
		if (resultado.getTipo().equals("Informativo"))
			em.merge(dispositivo);
		return resultado;
	}

	public Dispositivo obtenerDispositivoId(long id) {
		Dispositivo dispositivo = em.find(Dispositivo.class, id);
		return dispositivo;
	}

}
