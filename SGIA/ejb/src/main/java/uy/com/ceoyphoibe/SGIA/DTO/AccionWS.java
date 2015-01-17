/**
 * Clase de apoyo utilizada para pasaje de datos de acciones con los servicios web 
 */
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;

public class AccionWS implements Serializable {


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


	public int getIdDispositivo() {
		return idDispositivo;
	}


	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}


	public String getTipoAccion() {
		return tipoAccion;
	}


	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

}
