package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;

@Stateless
public class RegistroTipoLogEvento {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<TipoLogEvento> tipoLogEventoEventSrc;

	   private TipoLogEvento newTipoLogEvento;


	   @Produces
	   @Named
	   public TipoLogEvento getNewTipoLogEvento() {
	      return newTipoLogEvento;
	   }
	   
	   
	   public void registro() throws Exception {
	      log.info("Registro " + newTipoLogEvento.getNombre());
	      em.persist(newTipoLogEvento);
	      tipoLogEventoEventSrc.fire(newTipoLogEvento);
	      initNewTipoLogEvento();
	   }
	   
	   public Mensaje modificar(TipoLogEvento tipoLogEvento, Placa placa) throws Exception {
		   FachadaWS ws = new FachadaWS();
		   ws.asociarDestinatariosTipoLogEventos(tipoLogEvento, placa);
		   Mensaje resultado= ws.actualizarTipoLogEvento(tipoLogEvento, placa);
		   if (resultado.getTipo().equals("Informativo"))
			   em.merge(tipoLogEvento);
		   tipoLogEventoEventSrc.fire(tipoLogEvento);
		   return resultado;
	   }
	   
	   public void eliminarDestinatarios(TipoLogEvento tipoLogEvento, Placa placa) throws Exception {
		   FachadaWS ws = new FachadaWS();
		   ws.desasociarDestinatariosTipoLogEventos(tipoLogEvento, placa);
	   }
	   
	   	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   TipoLogEvento tipoLogEvento = em.find(TipoLogEvento.class, id);
		   em.remove(tipoLogEvento);
		   tipoLogEventoEventSrc.fire(newTipoLogEvento);
	   }
	   
	   public TipoLogEvento obtenerTipoLogEventoPorId(long id) {
			return em.find(TipoLogEvento.class, id);
		}

	   @PostConstruct
	   public void initNewTipoLogEvento() {
		   newTipoLogEvento = new TipoLogEvento();
	   }
}
