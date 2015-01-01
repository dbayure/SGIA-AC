package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;


public class LogEventoWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135147364907375174L;
	
	private String fecha;
	private int tipoLog;
	private int idDispositivo;
	private int idMensaje;
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the tipoLog
	 */
	public int getTipoLog() {
		return tipoLog;
	}
	/**
	 * @param tipoLog the tipoLog to set
	 */
	public void setTipoLog(int tipoLog) {
		this.tipoLog = tipoLog;
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
	 * @return the idMensaje
	 */
	public int getIdMensaje() {
		return idMensaje;
	}
	/**
	 * @param idMensaje the idMensaje to set
	 */
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

}
