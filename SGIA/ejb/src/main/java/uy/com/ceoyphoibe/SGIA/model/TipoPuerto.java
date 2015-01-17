
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La clase TipoPuerto representa a cada uno de los tipos de puerto que se pueden definir en el sistema.
 */
@Entity
@XmlRootElement
@Table(name = "tipoPuerto")
public class TipoPuerto implements Serializable {


	private static final long serialVersionUID = -5195600533836100836L;

	@Id
	private Long id;

	private String nombre;
	private String descripcion;

	/**
	 * @return el identificador del tipo de puerto
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			el identificador a asignar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el nombre del tipo de puerto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 * 				el nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return la descripción del tipo de puerto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * 					la descripción a asignar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPuerto other = (TipoPuerto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoPuerto [id=" + id + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

}
