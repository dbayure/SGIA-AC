
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de factores con los servicios web a consumir en la aplicación móvil
 */
public class Dispositivo_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Long idDispositivo;
	private String nombre;
	private String modelo;
	private String estadoAlerta;
	
	
	public Dispositivo_AM() {
		
	}


	/**
	 * @param idDispositivo
	 * @param nombre
	 * @param modelo
	 * @param estadoAlerta
	 */
	public Dispositivo_AM(Long idDispositivo, String nombre, String modelo,
			String estadoAlerta) {
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.modelo = modelo;
		this.estadoAlerta = estadoAlerta;
	}


	/**
	 * @return the idDispositivo
	 */
	public Long getIdDispositivo() {
		return idDispositivo;
	}


	/**
	 * @param idDispositivo the idDispositivo to set
	 */
	public void setIdDispositivo(Long idDispositivo) {
		this.idDispositivo = idDispositivo;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}


	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	/**
	 * @return the estadoAlerta
	 */
	public String getEstadoAlerta() {
		return estadoAlerta;
	}


	/**
	 * @param estadoAlerta the estadoAlerta to set
	 */
	public void setEstadoAlerta(String estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}

	
	
}
