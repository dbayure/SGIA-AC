package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
import java.util.Date;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;

public class ResultadoAccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 440338520655393531L;

	private Mensaje mensaje;
	private Date fecha;
	private String accion;

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

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
