/**
 * La clase PlacaNoSeConectaExeption se utiliza para el disparo de excepciones cuando no es posible establecer comunicación con la placa controladora. 
 */
package uy.com.ceoyphoibe.SGIA.exception;

import java.io.Serializable;

public class PlacaNoSeConectaExeption extends Exception implements Serializable {

	private static final long serialVersionUID = 8255003128146901408L;

	public PlacaNoSeConectaExeption(String mensaje) {
		super(mensaje);
	}

	public PlacaNoSeConectaExeption() {
	}

}
