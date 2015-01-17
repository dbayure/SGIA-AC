
package uy.com.ceoyphoibe.SGIA.exception;

import java.io.Serializable;
/**
 * La clase ContradiccionPrioridadException se utiliza para el disparo de excepciones cuando se presenta una contradicción en la prioridad en la definición de un nivel de severidad 
 */
public class ContradiccionPrioridadException extends Exception implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public ContradiccionPrioridadException(String mensaje) {
		super(mensaje);
	}

	public ContradiccionPrioridadException() {
	}

}
