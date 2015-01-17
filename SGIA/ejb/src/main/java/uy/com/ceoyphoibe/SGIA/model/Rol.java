
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La clase Rol representa a un grupo de seguridad del sistema, según los usuarios pertenezcan a uno u otro rol tendrán permisos para ejecutar determinadas tareas en el sistema.
 */
@Entity
@XmlRootElement
@Table(name = "rol")
public class Rol implements Serializable {


	private static final long serialVersionUID = -5815809470148059527L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rol;

	private String descripcion;

	public Rol() {
		super();
	}

	/**
	 * @return la descripción del rol
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * 					La descripción a asignar.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el identificador del rol.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			El identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el nombre del rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol
	 * 			El nombre del rol a asignar.
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
		Rol other = (Rol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", rol=" + rol + ", descripcion="
				+ descripcion + "]";
	}
}
