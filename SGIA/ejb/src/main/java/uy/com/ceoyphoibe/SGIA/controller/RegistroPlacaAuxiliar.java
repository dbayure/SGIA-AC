package uy.com.ceoyphoibe.SGIA.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.PlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroPlacaAuxiliar {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event <PlacaAuxiliar> placaAuxiliarEventSrc;
	   
	   public void registro(PlacaAuxiliar placaAux) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   placaAux= ws.registroPlacaAuxiliar(placaAux);
		   
		   em.merge(placaAux);
		   placaAuxiliarEventSrc.fire(placaAux);
	   }
	   
	   public Mensaje modificar(PlacaAuxiliar placaAux) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   Mensaje resultado= ws.actualizarPlacaAuxiliar(placaAux);
		   if (resultado.getTipo().equals("Informativo"))
			   em.merge(placaAux);
		   placaAuxiliarEventSrc.fire(placaAux);
		   return resultado;
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   PlacaAuxiliar placaAux = em.find(PlacaAuxiliar.class, id);
		   em.remove(placaAux);
	   }
	  
	   public ArrayList<Dispositivo> getListaDispositivosId(long id){
		   PlacaAuxiliar placaAux = em.find(PlacaAuxiliar.class, id);
		   ArrayList<Dispositivo> dispositivosPlaca = (ArrayList<Dispositivo>) placaAux.getListaDispositivos();
		   return dispositivosPlaca;
	   }

	   public PlacaAuxiliar obtenerPlacaAuxiliarPorId (long id){
		   return em.find(PlacaAuxiliar.class, id);		   
	   }
}
