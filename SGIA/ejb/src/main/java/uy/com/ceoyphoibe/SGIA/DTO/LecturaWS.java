package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;


public class LecturaWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135147364907375174L;
	
	private String fecha;
	private float lectura;
	private int idDispositivo;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getLectura() {
		return lectura;
	}
	public void setLectura(float lectura) {
		this.lectura = lectura;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the idDispositivo
	 */
	public int getIdDispositivo() {
		return idDispositivo;
	}
	/**
	 * @param idDispositivo the idDispositivo to set
	 */
	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

}
