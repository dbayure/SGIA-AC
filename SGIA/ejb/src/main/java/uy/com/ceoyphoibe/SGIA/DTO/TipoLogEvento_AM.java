
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de tipos de log de eventos con los servicios web a consumir en la aplicación móvil
 */
public class TipoLogEvento_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Long idTipoLogEventos;
	private String nombre;
	private String enviarSMS;
	private String enviarMail;
	
	
	
	public TipoLogEvento_AM() {
		
	}



	/**
	 * @param idTipoLogEventos
	 * @param nombre
	 * @param enviarSMS
	 * @param enviarMail
	 */
	public TipoLogEvento_AM(Long idTipoLogEventos, String nombre,
			String enviarSMS, String enviarMail) {
		this.idTipoLogEventos = idTipoLogEventos;
		this.nombre = nombre;
		this.enviarSMS = enviarSMS;
		this.enviarMail = enviarMail;
	}



	/**
	 * @return the idTipoLogEventos
	 */
	public Long getIdTipoLogEventos() {
		return idTipoLogEventos;
	}



	/**
	 * @param idTipoLogEventos the idTipoLogEventos to set
	 */
	public void setIdTipoLogEventos(Long idTipoLogEventos) {
		this.idTipoLogEventos = idTipoLogEventos;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the enviarSMS
	 */
	public String getEnviarSMS() {
		return enviarSMS;
	}



	/**
	 * @param enviarSMS the enviarSMS to set
	 */
	public void setEnviarSMS(String enviarSMS) {
		this.enviarSMS = enviarSMS;
	}



	/**
	 * @return the enviarMail
	 */
	public String getEnviarMail() {
		return enviarMail;
	}



	/**
	 * @param enviarMail the enviarMail to set
	 */
	public void setEnviarMail(String enviarMail) {
		this.enviarMail = enviarMail;
	}

	

}
