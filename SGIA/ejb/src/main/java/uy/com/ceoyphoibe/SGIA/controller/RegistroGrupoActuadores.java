package uy.com.ceoyphoibe.SGIA.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.DTO.ResultadoAccion;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
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
	   
	   public ArrayList<ActuadorAvance> getListaActuadoresAvanceId(long id){
		   GrupoActuadores ga = em.find(GrupoActuadores.class, id);
		   System.out.println("grupo seleccionado " + ga.getNombre());
		   List<ActuadorAvance> actuadoresAvanceDelGrupo = new ArrayList<ActuadorAvance>();
		   System.out.println("cantidad de elementos que vienen en el grupo " + ga.getActuadoresAvance().size());
		   for (ActuadorAvance av : ga.getActuadoresAvance()){
			   actuadoresAvanceDelGrupo.add(av);
		   }
		   return (ArrayList<ActuadorAvance>) actuadoresAvanceDelGrupo;
	   }
	   
	   public GrupoActuadores obtenerGrupoPorId (long id){
		   return em.find(GrupoActuadores.class, id);		   
	   }
	   
	   public Posicion obtenerPosicionId (long id){
		   return em.find(Posicion.class, id);		   
	   }
	   
	   public ResultadoAccion cambiarPosicionAvance(GrupoActuadores ga,  int p){
		   FachadaWS ws= new FachadaWS();
		   ResultadoAccion resultado = ws.cambiarPosicionGrupoActuadores(ga, p);
		   if(!resultado.getMensaje().getTipo().equals("Error")){
			   ga.setEstado(resultado.getAccion().charAt(0));
			   em.merge(ga);
		   }
		   return resultado;
	   }
	   
	   public ResultadoAccion encenderGrupo(GrupoActuadores ga){
		   FachadaWS ws= new FachadaWS();
		   ResultadoAccion resultado = ws.encenderGrupoActuadores(ga);
		   System.out.println("Encendiendo el grupo " + ga.getNombre());
		   if(!resultado.getMensaje().getTipo().equals("Error")){
			   ga.setEstado(resultado.getAccion().charAt(0));
			   em.merge(ga);
		   }
		   return resultado;
	   }
	   
	   public ResultadoAccion apagarGrupo(GrupoActuadores ga){
		   FachadaWS ws= new FachadaWS();
		   ResultadoAccion resultado = ws.apagarGrupoActuadores(ga);
		   System.out.println("Apagando el grupo " + ga.getNombre());
		   if(resultado.getMensaje().getTexto() != "Error"){
			   ga.setEstado(resultado.getAccion().charAt(0));
			   em.merge(ga);
		   }
		   return resultado;
	   }
}
