/**
 * La clase PerfilContradictorioFactorException se utiliza para el disparo de excepciones cuando se presenta una contradicción en el perfil de activación para un mismo factor en la definición de un nivel de severidad 
 */
package uy.com.ceoyphoibe.SGIA.exception;

import java.io.Serializable;

public class PerfilContradictorioFactorException extends Exception implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public PerfilContradictorioFactorException(String mensaje) {
		super(mensaje);
	}

	public PerfilContradictorioFactorException() {
	}

}
