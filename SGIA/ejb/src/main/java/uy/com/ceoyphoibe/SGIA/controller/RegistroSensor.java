/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Sensor
 */
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
import uy.com.ceoyphoibe.SGIA.model.Sensor;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;

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
		FachadaWS ws = new FachadaWS();
		sensor = ws.registroSensor(sensor);

		log.info("Registro " + sensor.getNombre());
		em.persist(sensor);
		sensorEventSrc.fire(sensor);
	}

	public void modificar(Sensor sensor) throws Exception {

		FachadaWS wsClient = new FachadaWS();
		Mensaje resultado = wsClient.actualizarSensor(sensor);
		if (resultado.getTipo().equals("Informativo"))
			em.merge(sensor);
		sensorEventSrc.fire(sensor);
	}

	public Mensaje eliminar(Long id) throws Exception {
		Sensor sensor = em.find(Sensor.class, id);
		FachadaWS wsClient = new FachadaWS();
		Mensaje resultado = wsClient.eliminarSensor(sensor);
		if (resultado.getTipo().equals("Informativo")) {
			sensor.setActivoSistema('N');
			em.merge(sensor);
		}
		sensorEventSrc.fire(sensor);
		return resultado;
	}

	public Sensor obtenerSensorPorId(Long id) {
		Sensor s = em.find(Sensor.class, id);
		return s;
	}

	@PostConstruct
	public void initNewSensor() {
		newSensor = new Sensor();
	}
}
