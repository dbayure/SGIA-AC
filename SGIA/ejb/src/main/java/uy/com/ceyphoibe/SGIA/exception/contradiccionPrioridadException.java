package uy.com.ceyphoibe.SGIA.exception;

import java.io.Serializable;

public class contradiccionPrioridadException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public contradiccionPrioridadException(String mensaje) {
		super(mensaje);
	} 
	
	public contradiccionPrioridadException(){}
		


}
