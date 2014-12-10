package uy.com.ceyphoibe.SGIA.exception;

import java.io.Serializable;

public class perfilContradictorioFactorException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public perfilContradictorioFactorException(String mensaje) {
		super(mensaje);
	} 
	
	public perfilContradictorioFactorException(){}
		


}
