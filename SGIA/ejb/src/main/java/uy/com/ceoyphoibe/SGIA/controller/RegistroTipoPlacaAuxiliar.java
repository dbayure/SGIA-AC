package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.TipoPlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroTipoPlacaAuxiliar {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<TipoPlacaAuxiliar> tipoPlacaAuxiliarEventSrc;




	   public void registro(TipoPlacaAuxiliar tipoPlacaAuxiliar) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   tipoPlacaAuxiliar= ws.registroTipoPlacaAuxiliar(tipoPlacaAuxiliar);
		   
	      em.persist(tipoPlacaAuxiliar);
	      tipoPlacaAuxiliarEventSrc.fire(tipoPlacaAuxiliar);
	   }
	   
	   public void modificar(TipoPlacaAuxiliar tipoPlacaAuxiliar) throws Exception {
		   log.info("Modifico " + tipoPlacaAuxiliar);
		   em.merge(tipoPlacaAuxiliar);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   TipoPlacaAuxiliar tipoPlacaAuxiliar = em.find(TipoPlacaAuxiliar.class, id);
		   em.remove(tipoPlacaAuxiliar);
		   tipoPlacaAuxiliarEventSrc.fire(tipoPlacaAuxiliar);
	   }


	
}
