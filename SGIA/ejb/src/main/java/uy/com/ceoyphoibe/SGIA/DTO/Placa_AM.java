
package uy.com.ceoyphoibe.SGIA.DTO;

import java.io.Serializable;
/**
 * Clase de apoyo utilizada para pasaje de datos de acciones con los servicios web 
 */
public class Placa_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;

	private Long id;
	private String estado;
	private String nroSerie;
	private String descripcion;
	private String estadoAlerta;
	
	
	public Placa_AM() {
		
	}
	
	/**
	 * @param id
	 * @param estado
	 * @param nroSerie
	 * @param descripcion
	 * @param estadoAlerta
	 */
	public Placa_AM(Long id, String estado, String nroSerie, String descripcion,
			String estadoAlerta) {
		this.id = id;
		this.estado = estado;
		this.nroSerie = nroSerie;
		this.descripcion = descripcion;
		this.estadoAlerta = estadoAlerta;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the nroSerie
	 */
	public String getNroSerie() {
		return nroSerie;
	}
	/**
	 * @param nroSerie the nroSerie to set
	 */
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
