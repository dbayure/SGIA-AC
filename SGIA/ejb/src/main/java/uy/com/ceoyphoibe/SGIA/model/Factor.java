package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "factor")
public class Factor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 407757945510772852L;

	@Id
	private Long idFactor;
	
	private String nombre;
	private char estadado;
	private char deAvance;
	private char activoSistema;
	

	/**
	 * @return the idFactor
	 */
	public Long getIdFactor() {
		return idFactor;
	}
	/**
	 * @param idFactor the idFactor to set
	 */
	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getEstadado() {
		return estadado;
	}
	public void setEstadado(char estadado) {
		this.estadado = estadado;
	}
	public char getDeAvance() {
		return deAvance;
	}
	public void setDeAvance(char deAvance) {
		this.deAvance = deAvance;
	}
	public char getActivoSistema() {
		return activoSistema;
	}
	public void setActivoSistema(char activoSistema) {
		this.activoSistema = activoSistema;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activoSistema;
		result = prime * result + deAvance;
		result = prime * result + estadado;
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
		Factor other = (Factor) obj;
		if (activoSistema != other.activoSistema)
			return false;
		if (deAvance != other.deAvance)
			return false;
		if (estadado != other.estadado)
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
		return "GrupoActuadores [id=" + id + ", nombre=" + nombre
				+ ", estadado=" + estadado + ", deAvance=" + deAvance
				+ ", activoSistema=" + activoSistema + "]";
	}
	
}
