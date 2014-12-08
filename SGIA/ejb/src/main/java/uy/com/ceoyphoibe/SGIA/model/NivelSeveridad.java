package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "nivelesSeveridad")
public class NivelSeveridad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6092319973077241634L;

	@Id
	private Long id;
	
	private String nombre;
	private int prioridad;
	private int rangoMin;
	private int rangoMax;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn ( name = "factor_id",  referencedColumnName = "idFactor")
	private Factor factor;
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="perfilesActivacion", joinColumns={@JoinColumn(name= "idNivelSeveridad", referencedColumnName= "id")}, inverseJoinColumns= {@JoinColumn(name= "idFilaPerfilActivacion", referencedColumnName= "id")}	)
    private Set<FilaPerfilActivacion> perfilActivacion;
	private String activoSistema;
	
	
	
	
	/**
	 * 
	 */
	public NivelSeveridad() {
		perfilActivacion= new HashSet<FilaPerfilActivacion>();
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
	 * @return the prioridad
	 */
	public int getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * @return the rangoMin
	 */
	public int getRangoMin() {
		return rangoMin;
	}
	/**
	 * @param rangoMin the rangoMin to set
	 */
	public void setRangoMin(int rangoMin) {
		this.rangoMin = rangoMin;
	}
	/**
	 * @return the rangoMax
	 */
	public int getRangoMax() {
		return rangoMax;
	}
	/**
	 * @param rangoMax the rangoMax to set
	 */
	public void setRangoMax(int rangoMax) {
		this.rangoMax = rangoMax;
	}
	/**
	 * @return the factor
	 */
	public Factor getFactor() {
		return factor;
	}
	/**
	 * @param factor the factor to set
	 */
	public void setFactor(Factor factor) {
		this.factor = factor;
	}
	/**
	 * @return the perfilActivacion
	 */
	public Set<FilaPerfilActivacion> getPerfilActivacion() {
		return perfilActivacion;
	}
	/**
	 * @param perfilActivacion the perfilActivacion to set
	 */
	public void setPerfilActivacion(Set<FilaPerfilActivacion> perfilActivacion) {
		this.perfilActivacion = perfilActivacion;
	}
	/**
	 * @return the activoSistema
	 */
	public String getActivoSistema() {
		return activoSistema;
	}
	/**
	 * @param activoSistema the activoSistema to set
	 */
	public void setActivoSistema(String activoSistema) {
		this.activoSistema = activoSistema;
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
		result = prime * result
				+ ((activoSistema == null) ? 0 : activoSistema.hashCode());
		result = prime * result + ((factor == null) ? 0 : factor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime
				* result
				+ ((perfilActivacion == null) ? 0 : perfilActivacion.hashCode());
		result = prime * result + prioridad;
		result = prime * result + rangoMax;
		result = prime * result + rangoMin;
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
		NivelSeveridad other = (NivelSeveridad) obj;
		if (activoSistema == null) {
			if (other.activoSistema != null)
				return false;
		} else if (!activoSistema.equals(other.activoSistema))
			return false;
		if (factor == null) {
			if (other.factor != null)
				return false;
		} else if (!factor.equals(other.factor))
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
		if (perfilActivacion == null) {
			if (other.perfilActivacion != null)
				return false;
		} else if (!perfilActivacion.equals(other.perfilActivacion))
			return false;
		if (prioridad != other.prioridad)
			return false;
		if (rangoMax != other.rangoMax)
			return false;
		if (rangoMin != other.rangoMin)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NivelSeveridad [id=" + id + ", nombre=" + nombre
				+ ", prioridad=" + prioridad + ", rangoMin=" + rangoMin
				+ ", rangoMax=" + rangoMax + ", factor=" + factor
				+ ", perfilActivacion=" + perfilActivacion + ", activoSistema="
				+ activoSistema + "]";
	}
	
}
