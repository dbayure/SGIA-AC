package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroDispositivo {
	

	   @Inject
	   private EntityManager em;
	   
	   @Inject
	   private Event <Dispositivo> dispositivoSrc;

	   public Dispositivo obtenerDispositivoPorId (long id){
		   return em.find(Dispositivo.class, id);
	   }



}
