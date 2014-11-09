package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "grupoActuadores")
public class GrupoActuadores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1308127548538608653L;

	@Id
	private Long id;
	
	private String nombre;
	private String unidad;
	private int valorMin;
	private int valorMax;
	private int umbral;
	private char activoSistema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public int getValorMin() {
		return valorMin;
	}
	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}
	public int getValorMax() {
		return valorMax;
	}
	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}
	public int getUmbral() {
		return umbral;
	}
	public void setUmbral(int umbral) {
		this.umbral = umbral;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + umbral;
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		result = prime * result + valorMax;
		result = prime * result + valorMin;
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
		GrupoActuadores other = (GrupoActuadores) obj;
		if (activoSistema != other.activoSistema)
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
		if (umbral != other.umbral)
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		if (valorMax != other.valorMax)
			return false;
		if (valorMin != other.valorMin)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GrupoActuadores [id=" + id + ", nombre=" + nombre + ", unidad="
				+ unidad + ", valorMin=" + valorMin + ", valorMax=" + valorMax
				+ ", umbral=" + umbral + ", activoSistema=" + activoSistema
				+ "]";
	}
	
}
