/**
 * La clase RangoNivelException se utiliza para el disparo de excepciones cuando se presenta una contradicción en el rango de cumplimiento definido para un mismo factor en la definición de un nivel de severidad 
 */
package uy.com.ceoyphoibe.SGIA.exception;

import java.io.Serializable;

public class RangoNivelException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public RangoNivelException(String mensaje) {
		super(mensaje);
	}

	public RangoNivelException() {
	}

}
