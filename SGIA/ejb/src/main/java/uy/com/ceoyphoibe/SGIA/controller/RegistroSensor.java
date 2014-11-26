package uy.com.ceoyphoibe.SGIA.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Sensor;


@Stateless
public class RegistroSensor {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Sensor> sensorEventSrc;

	   private Sensor newSensor;

	   @Produces
	   @Named
	   public Sensor getNewSensor() {
	      return newSensor;
	   }

	   public void registro(Sensor sensor) throws Exception {
	      log.info("Registro " + sensor.getNombre());
	      em.persist(sensor);
	      sensorEventSrc.fire(sensor);
	   }
	   
	   public void modificar(Sensor sensor) throws Exception {
		   log.info("Modifico " + sensor);
		   em.merge(sensor);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Sensor sensor = em.find(Sensor.class, id);
		   em.remove(sensor);
		   sensorEventSrc.fire(newSensor);
	   }

	   @PostConstruct
	   public void initNewSensor() {
		   newSensor = new Sensor();
	   }
}
