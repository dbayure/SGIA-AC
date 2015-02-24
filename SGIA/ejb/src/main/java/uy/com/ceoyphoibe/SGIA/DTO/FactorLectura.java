
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;

import uy.com.ceoyphoibe.SGIA.model.Factor;
/**
 * Clase de apoyo utilizada para pasaje de datos de resultados de lecturas con los servicios web 
 */
public class FactorLectura implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Factor factor;
	private String lectura;

	/**
	 * @param factor
	 * @param lectura
	 */
	public FactorLectura(Factor factor, String lectura) {
		this.factor = factor;
		this.lectura = lectura;
	}

	/**
	 * @return the factor
	 */
	public Factor getFactor() {
		return factor;
	}

	/**
	 * @param factor the factor to set
	 */
	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	/**
	 * @return the lectura
	 */
	public String getLectura() {
		return lectura;
	}

	/**
	 * @param lectura the lectura to set
	 */
	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
