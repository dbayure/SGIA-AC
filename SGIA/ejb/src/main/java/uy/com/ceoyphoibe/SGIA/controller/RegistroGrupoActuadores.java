package uy.com.ceoyphoibe.SGIA.controller;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroGrupoActuadores {
	

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
	   
	   public Mensaje modificar(GrupoActuadores grupoActuadores) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   Mensaje resultado= ws.actualizarGrupoActuadores(grupoActuadores);
		   if (resultado.getTipo().equals("Informativo"))
			   em.merge(grupoActuadores);
		   return resultado;
	   }
	   
	   public Mensaje eliminar(Long id) throws Exception {
		   GrupoActuadores grupoActuadores = em.find(GrupoActuadores.class, id);
		   FachadaWS ws= new FachadaWS();
		   Mensaje resultado= ws.eliminarGrupoActuadores(grupoActuadores);
		   if (resultado.getTipo().equals("Informativo"))
		   {
			   grupoActuadores.setActivoSistema('N');
			   em.merge(grupoActuadores);
		   }
		   grupoActuadoresSrc.fire(grupoActuadores);
		   return resultado;
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
