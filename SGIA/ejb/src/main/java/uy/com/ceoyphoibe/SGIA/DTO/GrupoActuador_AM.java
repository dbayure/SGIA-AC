
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de grupos de actuadores con los servicios web a consumir en la aplicación móvil
 */
public class GrupoActuador_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private String nombre;
	private String estado;
	
	
	
	public GrupoActuador_AM() {
		
	}



	/**
	 * @param nombre
	 * @param estado
	 */
	public GrupoActuador_AM(String nombre, String estado) {
		this.nombre = nombre;
		this.estado = estado;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}



	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
