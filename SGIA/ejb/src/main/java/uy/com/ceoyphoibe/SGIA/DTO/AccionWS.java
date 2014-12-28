package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;


public class AccionWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135147364907375174L;
	
	private String fecha;
	private String tipoAccion;
	private int idDispositivo;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	/**
	 * @return the tipoAccion
	 */
	public String getTipoAccion() {
		return tipoAccion;
	}
	/**
	 * @param tipoAccion the tipoAccion to set
	 */
	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

}
