
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de factores con los servicios web a consumir en la aplicación móvil
 */
public class Factor_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Long idFactor;
	private String nombre;
	private String unidad;
	private int valorMin;
	private int valorMax;
	
	
	public Factor_AM() {
		
	}


	/**
	 * @param idFactor
	 * @param nombre
	 * @param unidad
	 * @param valorMin
	 * @param valorMax
	 */
	public Factor_AM(Long idFactor, String nombre, String unidad, int valorMin,
			int valorMax) {
		this.idFactor = idFactor;
		this.nombre = nombre;
		this.unidad = unidad;
		this.valorMin = valorMin;
		this.valorMax = valorMax;
	}


	/**
	 * @return the idFactor
	 */
	public Long getIdFactor() {
		return idFactor;
	}


	/**
	 * @param idFactor the idFactor to set
	 */
	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
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
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}


	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	/**
	 * @return the valorMin
	 */
	public int getValorMin() {
		return valorMin;
	}


	/**
	 * @param valorMin the valorMin to set
	 */
	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}


	/**
	 * @return the valorMax
	 */
	public int getValorMax() {
		return valorMax;
	}


	/**
	 * @param valorMax the valorMax to set
	 */
	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}


}
