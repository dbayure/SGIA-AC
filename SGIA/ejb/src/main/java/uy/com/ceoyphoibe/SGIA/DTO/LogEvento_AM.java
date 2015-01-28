
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;

import uy.com.ceoyphoibe.SGIA.model.Mensaje;
/**
 * Clase de apoyo utilizada para pasaje de datos de tipos de log de eventos con los servicios web a consumir en la aplicación móvil
 */
public class LogEvento_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Long idLogEvento;
	private String fechaHora;
	private Mensaje mensaje;
	private TipoLogEvento_AM tipoLog;
	private Dispositivo_AM dispositivo;
	
	
	
	public LogEvento_AM() {
		
	}



	/**
	 * @param idLogEvento
	 * @param fechaHora
	 * @param mensaje
	 * @param tipoLog
	 */
	public LogEvento_AM(Long idLogEvento, String fechaHora, Mensaje mensaje,
			TipoLogEvento_AM tipoLog, Dispositivo_AM dispositivo) {
		this.idLogEvento = idLogEvento;
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
		this.tipoLog = tipoLog;
		this.dispositivo=dispositivo;
	}



	/**
	 * @return the idLogEvento
	 */
	public Long getIdLogEvento() {
		return idLogEvento;
	}



	/**
	 * @param idLogEvento the idLogEvento to set
	 */
	public void setIdLogEvento(Long idLogEvento) {
		this.idLogEvento = idLogEvento;
	}



	/**
	 * @return the fechaHora
	 */
	public String getFechaHora() {
		return fechaHora;
	}



	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}



	/**
	 * @return the mensaje
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}



	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}



	/**
	 * @return the tipoLog
	 */
	public TipoLogEvento_AM getTipoLog() {
		return tipoLog;
	}



	/**
	 * @param tipoLog the tipoLog to set
	 */
	public void setTipoLog(TipoLogEvento_AM tipoLog) {
		this.tipoLog = tipoLog;
	}



	/**
	 * @return the dispositivo
	 */
	public Dispositivo_AM getDispositivo() {
		return dispositivo;
	}



	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(Dispositivo_AM dispositivo) {
		this.dispositivo = dispositivo;
	}

	
}
