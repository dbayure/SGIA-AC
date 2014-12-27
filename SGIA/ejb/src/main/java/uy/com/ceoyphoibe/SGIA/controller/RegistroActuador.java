package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroActuador {
	

	   @Inject
	   private EntityManager em;
	   
	   @Inject
	   private Event <Actuador> actuadoresSrc;

	   public Actuador obtenerActuadorPorId (long id){
		   return em.find(Actuador.class, id);
	   }

	   public void registro(Actuador a) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   a= ws.registroActuador(a);
		   
		   em.merge(a);
		   actuadoresSrc.fire(a);
	   }
	   
	   public Mensaje modificar(Actuador actuador) throws Exception {
		   FachadaWS wsClient = new FachadaWS();
		   wsClient.asociarActuadorGrupoActuadores(actuador);
		   Mensaje resultado= wsClient.actualizarActuador(actuador);
		   if (resultado.getTipo().equals("Informativo"))
			   em.merge(actuador);
		   return resultado;
	   }
	   
	   public Mensaje eliminar(Long id) throws Exception {
		   Actuador actuador = em.find(Actuador.class, id);
		   FachadaWS wsClient = new FachadaWS();
		   Mensaje resultado=wsClient.eliminarActuador(actuador);
		   if (resultado.getTipo().equals("Informativo"))
		   {
			   actuador.setActivoSistema('N');
			   em.merge(actuador);
		   }
		   actuadoresSrc.fire(actuador);
		   return resultado;
	   }

}
