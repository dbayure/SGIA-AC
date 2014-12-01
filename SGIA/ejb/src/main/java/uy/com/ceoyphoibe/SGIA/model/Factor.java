package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "factores")
public class Factor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 407757945510772852L;

	@Id
	private Long idFactor;
	
	private String nombre;
	private String unidad;
	private int valorMin;
	private int valorMax;
	private int umbral;
	@OneToMany( mappedBy = "factor", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER )
    private List<Sensor> sensores;
	private char activoSistema;
	
	
	
	//cascade = {CascadeType.MERGE, CascadeType.DETACH}
	
	/**
	 * 
	 */
	public Factor() {
		sensores= new ArrayList<Sensor>();
	}
	/**
	 * @return the activoSistema
	 */
	public char getActivoSistema() {
		return activoSistema;
	}
	/**
	 * @param activoSistema the activoSistema to set
	 */
	public void setActivoSistema(char activoSistema) {
		this.activoSistema = activoSistema;
	}
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
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}
	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	/**
	 * @return the valorMin
	 */
	public int getValorMin() {
		return valorMin;
	}
	/**
	 * @param valorMin the valorMin to set
	 */
	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}
	/**
	 * @return the valorMax
	 */
	public int getValorMax() {
		return valorMax;
	}
	/**
	 * @param valorMax the valorMax to set
	 */
	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}
	/**
	 * @return the umbral
	 */
	public int getUmbral() {
		return umbral;
	}
	/**
	 * @param umbral the umbral to set
	 */
	public void setUmbral(int umbral) {
		this.umbral = umbral;
	}
	/**
	 * @return the sensores
	 */
	public List<Sensor> getSensores() {
		return sensores;
	}
	/**
	 * @param sensores the sensores to set
	 */
	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activoSistema;
		result = prime * result
				+ ((idFactor == null) ? 0 : idFactor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + umbral;
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		result = prime * result + valorMax;
		result = prime * result + valorMin;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (idFactor == null) {
			if (other.idFactor != null)
				return false;
		} else if (!idFactor.equals(other.idFactor))
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Factor [idFactor=" + idFactor + ", nombre=" + nombre
				+ ", unidad=" + unidad + ", valorMin=" + valorMin
				+ ", valorMax=" + valorMax + ", umbral=" + umbral
				+ ", activoSistema=" + activoSistema + "]";
	}
	
	
	

	
	
}
