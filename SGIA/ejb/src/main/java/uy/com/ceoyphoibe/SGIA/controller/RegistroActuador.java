
package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Actuador
 */
@Stateless
public class RegistroActuador {

	@Inject
	private EntityManager em;

	@Inject
	private Event<Actuador> actuadoresSrc;

	public Actuador obtenerActuadorPorId(long id) {
		return em.find(Actuador.class, id);
	}

	public void registro(Actuador a) throws WsPlacaControladoraException{
		FachadaWS ws = new FachadaWS();
		a = ws.registroActuador(a);

		em.persist(a);
		actuadoresSrc.fire(a);
	}

	public Mensaje modificar(Actuador actuador) throws WsPlacaControladoraException {
		FachadaWS wsClient = new FachadaWS();
		wsClient.asociarActuadorGrupoActuadores(actuador);
		Mensaje resultado = wsClient.actualizarActuador(actuador);
		System.out.println(resultado.getTipo()+ " - "+ resultado.getTexto());
		if (resultado.getTipo().equals("Informativo"))
		{
			System.out.println("entra a hacer merge del actuador");
			System.out.println("grupo de actuadores asociado: "+actuador.getGrupoActuadores());
			em.merge(actuador);
		}
		return resultado;
	}

	public Mensaje eliminar(Long id) throws WsPlacaControladoraException{
		Actuador actuador = em.find(Actuador.class, id);
		FachadaWS wsClient = new FachadaWS();
		Mensaje resultado = wsClient.eliminarActuador(actuador);
		if (resultado.getTipo().equals("Informativo")) {
			actuador.setActivoSistema('N');
			em.merge(actuador);
		}
		actuadoresSrc.fire(actuador);
		return resultado;
	}
	
	public void actualizarEstado(Actuador a) throws WsPlacaControladoraException {
		FachadaWS ws = new FachadaWS();
		String resultado = ws.obtenerEstadoActuador(a);
		if (a.getEstado() != resultado.charAt(0)) {
			a.setEstado(resultado.charAt(0));
			em.merge(a);
		}
	}

	public Actuador obtenerActuadorId(long id) {
		Actuador actuador = em.find(Actuador.class, id);
		return actuador;
	}

}
