package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.DTO.ResultadoAccion;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
import uy.com.ceoyphoibe.SGIA.wsClient.WsApagarGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.wsClient.WsCambiarPosicionGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.wsClient.WsEncenderGrupoActuadores;


@Stateless
public class RegistroActuador {
	
	@Inject
	   private Logger log;

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
	   
	   public void modificar(Actuador actuador) throws Exception {
		   log.info("Modifico " + actuador);
		   FachadaWS wsClient = new FachadaWS();
		   wsClient.asociarActuadorGrupoActuadores(actuador);
		   
		   em.merge(actuador);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Actuador actudaror = em.find(Actuador.class, id);
		   em.remove(actudaror);
		   actuadoresSrc.fire(actudaror);
	   }

	   public ResultadoAccion encenderGrupo(GrupoActuadores ga){
		   ResultadoAccion ra = new ResultadoAccion();
		   ra = WsEncenderGrupoActuadores(ga);
		   return ra;
	   }
	   
	   public ResultadoAccion apagarGrupo(GrupoActuadores ga){
		   ResultadoAccion ra = new ResultadoAccion();
		   ra = WsApagarGrupoActuadores(ga);
		   return ra;
	   }
	   
	   public ResultadoAccion cambiarPosicionGrupo(GrupoActuadores ga, int posicion){
		   ResultadoAccion ra = new ResultadoAccion();
		   ra = WsCambiarPosicionGrupoActuadores(ga, posicion);
		   return ra;
	   }
}
