
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La clase Posicion representa a las posiciones que pueden poseer los actuadores de avance.
 * Cada posición pertenece a un solo actuador de avance.
 */
@Entity
@XmlRootElement
@Table(name = "posiciones")
public class Posicion implements Serializable {

	private static final long serialVersionUID = -5917099098470830186L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPosicion;
	private int nroPosicion;
	private String descripcion;
	private int valor;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sensoresPosicion", joinColumns = { @JoinColumn(name = "idPosicion", referencedColumnName = "idPosicion") }, inverseJoinColumns = { @JoinColumn(name = "idSensor", referencedColumnName = "id") })
	private Set<Sensor> listaSensores;

	public Posicion() {
		listaSensores = new HashSet<Sensor>();
	}

	/**
	 * @return el identificador de la posición
	 */
	public Long getIdPosicion() {
		return idPosicion;
	}

	/**
	 * @param idPosicion
	 *            el identificador a asignar.
	 */
	public void setIdPosicion(Long idPosicion) {
		this.idPosicion = idPosicion;
	}

	/**
	 * @return el número de posición
	 */
	public int getNroPosicion() {
		return nroPosicion;
	}

	/**
	 * @param nroPosicion
	 *            El número de posición a asignar
	 */
	public void setNroPosicion(int nroPosicion) {
		this.nroPosicion = nroPosicion;
	}

	/**
	 * @return la descripción de la posición
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            la descripción a asignar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el valor de cumplimiento de la posición
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            el valor de cumplimiento a asignar
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * @return la lista de sensores que obtienen valores para determinar el cumplimiento de la posición.
	 */
	public Set<Sensor> getListaSensores() {
		return listaSensores;
	}

	/**
	 * @param listaSensores
	 *            la lista de sensores a asignar
	 */
	public void setListaSensores(Set<Sensor> listaSensores) {
		this.listaSensores = listaSensores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Posicion [idPosicion=" + idPosicion + ", nroPosicion="
				+ nroPosicion + ", descripcion=" + descripcion + ", valor="
				+ valor + ", listaSensores=" + listaSensores + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idPosicion == null) ? 0 : idPosicion.hashCode());
		result = prime * result + nroPosicion;
		result = prime * result + valor;
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
		Posicion other = (Posicion) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idPosicion == null) {
			if (other.idPosicion != null)
				return false;
		} else if (!idPosicion.equals(other.idPosicion))
			return false;
		if (nroPosicion != other.nroPosicion)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

}
