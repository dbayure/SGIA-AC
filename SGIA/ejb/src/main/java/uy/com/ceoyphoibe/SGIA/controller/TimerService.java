/**
 * Clase de apoyo que permite invocar periódicamente el método para obtener el estado de alerta desde la placa controladora.
 */
package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class TimerService {
	@Inject
	RegistroPlaca registroPlaca;

	@Schedule(minute = "*/5", hour = "*", persistent = false)
	public void doWork() {
		registroPlaca.obtenerEstadoAlertaPlacas();
	}
}