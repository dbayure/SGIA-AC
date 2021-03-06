
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
/**
 * Clase de apoyo utilizada para pasaje de datos de resultados de lecturas con los servicios web 
 */
public class ResultadoLectura implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Mensaje mensaje;
	private Timestamp fecha;
	private float lectura;

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
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

}
