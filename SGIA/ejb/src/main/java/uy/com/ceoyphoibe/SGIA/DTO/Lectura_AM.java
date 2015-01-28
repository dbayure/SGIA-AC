
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de lecturas pertenecientes a un factor con los servicios web a consumir en la aplicación móvil
 */
public class Lectura_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private String fechaHora;
	private float valor;
	
	public Lectura_AM() {
		
	}

	/**
	 * @param fechaHora
	 * @param valor
	 */
	public Lectura_AM(String fechaHora, float valor) {
		this.fechaHora = fechaHora;
		this.valor = valor;
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
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	
	
}
