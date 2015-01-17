
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de log de eventos con los servicios web 
 */
public class LogEventoWS implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private String fecha;
	private int tipoLog;
	private int idDispositivo;
	private int idMensaje;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(int tipoLog) {
		this.tipoLog = tipoLog;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

}
