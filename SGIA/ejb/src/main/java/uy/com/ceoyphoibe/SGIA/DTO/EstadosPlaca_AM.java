
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de los estados de la placa a la aplicación móvil
 */
public class EstadosPlaca_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private String estadoSistema;
	private String estadoAlerta;
	
	public EstadosPlaca_AM() {
		
	}

	/**
	 * @param estadoSistema
	 * @param estadoAlerta
	 */
	public EstadosPlaca_AM(String estadoSistema, String estadoAlerta) {
		this.estadoSistema = estadoSistema;
		this.estadoAlerta = estadoAlerta;
	}

	/**
	 * @return the estadoSistema
	 */
	public String getEstadoSistema() {
		return estadoSistema;
	}

	/**
	 * @param estadoSistema the estadoSistema to set
	 */
	public void setEstadoSistema(String estadoSistema) {
		this.estadoSistema = estadoSistema;
	}

	/**
	 * @return the estadoAlerta
	 */
	public String getEstadoAlerta() {
		return estadoAlerta;
	}

	/**
	 * @param estadoAlerta the estadoAlerta to set
	 */
	public void setEstadoAlerta(String estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}

}
