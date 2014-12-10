package uy.com.ceyphoibe.SGIA.exception;

import java.io.Serializable;

public class rangoNivelException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public rangoNivelException(String mensaje) {
		super(mensaje);
	} 
	
	public rangoNivelException(){}
		


}
