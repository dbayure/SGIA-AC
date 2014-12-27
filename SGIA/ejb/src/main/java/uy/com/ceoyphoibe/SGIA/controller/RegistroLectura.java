package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Lectura;


@Stateless
public class RegistroLectura {


	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Lectura> lecturaEventSrc;



	   public void registro(Lectura lectura) throws Exception {
	      em.persist(lectura);
	      lecturaEventSrc.fire(lectura);
	   }
	   

}
