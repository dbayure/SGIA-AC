
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de factores con los servicios web a consumir en la aplicación móvil
 */
public class Accion_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private String fechaHora;
	private String tipoAccion;
	private Dispositivo_AM dispositivo;
	
	public Accion_AM() {
		
	}

	/**
	 * @param fechaHora
	 * @param tipoAccion
	 * @param dispositivo
	 */
	public Accion_AM(String fechaHora, String tipoAccion,
			Dispositivo_AM dispositivo) {
		this.fechaHora = fechaHora;
		this.tipoAccion = tipoAccion;
		this.dispositivo = dispositivo;
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
	 * @return the tipoAccion
	 */
	public String getTipoAccion() {
		return tipoAccion;
	}

	/**
	 * @param tipoAccion the tipoAccion to set
	 */
	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
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
