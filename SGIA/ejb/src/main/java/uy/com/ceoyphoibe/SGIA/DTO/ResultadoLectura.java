package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
import java.util.Date;

import uy.com.ceoyphoibe.SGIA.model.Mensaje;

public class ResultadoLectura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135147364907375174L;
	
	private Mensaje mensaje;
	private Date fecha;
	private int lectura;
	
	
	public Mensaje getMensaje() {
		return mensaje;
	}
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getLectura() {
		return lectura;
	}
	public void setLectura(int lectura) {
		this.lectura = lectura;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
