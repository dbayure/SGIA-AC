package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Rol;


@Stateless
public class RegistroRol {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Rol> rolEventSrc;

	   private Rol newRol;

	   @Produces
	   @Named
	   public Rol getNewRol() {
	      return newRol;
	   }

	   public void registro(Rol rol) throws Exception {
	      log.info("Registro " + newRol.getRol());
	      em.persist(rol);
	      rolEventSrc.fire(rol);
	   }
	   
	   public void modificar(Rol rol) throws Exception {
		   log.info("Modifico " + rol);
		   em.merge(rol);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Rol rol = em.find(Rol.class, id);
		   em.remove(rol);
		   rolEventSrc.fire(newRol);
	   }

	   @PostConstruct
	   public void initNewrol() {
		   newRol = new Rol();
	   }
	  

}
