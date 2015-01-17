/**
 * La clase FilaPerfilActivacion representa a una fila perteneciente a un perfil de activación definido sobre un nivel de severidad.
 */
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "filasPerfilesActivacion")
public class FilaPerfilActivacion implements Serializable {

	private static final long serialVersionUID = 6092319973077241634L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "grupoActuadores_id", referencedColumnName = "id")
	private GrupoActuadores grupoActuadores;
	private String estado;

	/**
	 * @return el identificador de la fila del perfil de activación.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            El identificador a asignar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el grupo de actuadores sobre el que se va a definir el estado esperado para el mismo.
	 */
	public GrupoActuadores getGrupoActuadores() {
		return grupoActuadores;
	}

	/**
	 * @param grupoActuadores
	 *            El grupoActuadores a asignar
	 */
	public void setGrupoActuadores(GrupoActuadores grupoActuadores) {
		this.grupoActuadores = grupoActuadores;
	}

	/**
	 * @return el estado en el que debe quedar el grupo de actuadores cuando se cumpla el perfil de activación.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            El estado a asignar
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((grupoActuadores == null) ? 0 : grupoActuadores.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FilaPerfilActivacion other = (FilaPerfilActivacion) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (grupoActuadores == null) {
			if (other.grupoActuadores != null)
				return false;
		} else if (!grupoActuadores.equals(other.grupoActuadores))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "FilaPerfilActivacion [id=" + id + ", grupoActuadores="
				+ grupoActuadores + ", estado=" + estado + "]";
	}

}
