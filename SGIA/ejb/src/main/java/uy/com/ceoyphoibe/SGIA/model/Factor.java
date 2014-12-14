package uy.com.ceoyphoibe.SGIA.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
	
    
    @OneToMany( mappedBy = "factor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
    private List<Sensor> sensores;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn ( name = "placa_id",  referencedColumnName = "id")
	private Placa placa;
	
	private char activoSistema;
	
	

	public Factor() {
		super();
		this.sensores = new ArrayList<Sensor>();
	}

	public Long getIdFactor() {
		return idFactor;
	}

	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
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

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
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
		result = prime * result
				+ ((idFactor == null) ? 0 : idFactor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
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
		return "Factor [idFactor=" + idFactor + ", nombre=" + nombre
				+ ", unidad=" + unidad + ", valorMin=" + valorMin
				+ ", valorMax=" + valorMax + ", umbral=" + umbral + ", placa="
				+ placa + ", activoSistema=" + activoSistema + "]";
	}
	
}
