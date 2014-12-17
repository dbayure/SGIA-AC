package uy.com.ceoyphoibe.SGIA.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroGrupoActuadores {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event <GrupoActuadores> grupoActuadoresSrc;
	   
	   public GrupoActuadores registroPlaca(GrupoActuadores ga) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   ga= ws.registroGrupoActuadores(ga);
		   
		   em.merge(ga);
		   grupoActuadoresSrc.fire(ga);
		   return ga;
	   }
	   
	   public void registro(GrupoActuadores ga) throws Exception {
		   em.merge(ga);
		   grupoActuadoresSrc.fire(ga);
	   }
	   
	   public void modificar(GrupoActuadores grupoActuadores) throws Exception {
		   log.info("Modifico " + grupoActuadores);
		   em.merge(grupoActuadores);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   GrupoActuadores grupoActuadores = em.find(GrupoActuadores.class, id);
		   em.remove(grupoActuadores);
	   }
	  
	   public ArrayList<Actuador> getListaActuadoresId(long id){
		   GrupoActuadores g = em.find(GrupoActuadores.class, id);
		   ArrayList<Actuador> actuadoresDelGrupo = (ArrayList<Actuador>) g.getActuadores();
		   return actuadoresDelGrupo;
	   }

	   public GrupoActuadores obtenerGrupoPorId (long id){
		   return em.find(GrupoActuadores.class, id);		   
	   }
}
