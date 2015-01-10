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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@XmlRootElement
@Table(name = "nivelesSeveridad")
@JsonIgnoreProperties({"placa"})
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
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn ( name = "placa_id",  referencedColumnName = "id")
	private Placa placa;
	
	private String activoSistema;

	public NivelSeveridad() {
		perfilActivacion= new HashSet<FilaPerfilActivacion>();
	}

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

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getRangoMin() {
		return rangoMin;
	}

	public void setRangoMin(int rangoMin) {
		this.rangoMin = rangoMin;
	}

	public int getRangoMax() {
		return rangoMax;
	}

	public void setRangoMax(int rangoMax) {
		this.rangoMax = rangoMax;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public Set<FilaPerfilActivacion> getPerfilActivacion() {
		return perfilActivacion;
	}

	public void setPerfilActivacion(Set<FilaPerfilActivacion> perfilActivacion) {
		this.perfilActivacion = perfilActivacion;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public String getActivoSistema() {
		return activoSistema;
	}

	public void setActivoSistema(String activoSistema) {
		this.activoSistema = activoSistema;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activoSistema == null) ? 0 : activoSistema.hashCode());
		result = prime * result + ((factor == null) ? 0 : factor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + prioridad;
		result = prime * result + rangoMax;
		result = prime * result + rangoMin;
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
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (prioridad != other.prioridad)
			return false;
		if (rangoMax != other.rangoMax)
			return false;
		if (rangoMin != other.rangoMin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NivelSeveridad [id=" + id + ", nombre=" + nombre
				+ ", prioridad=" + prioridad + ", rangoMin=" + rangoMin
				+ ", rangoMax=" + rangoMax + ", factor=" + factor + ", placa="
				+ placa + ", activoSistema=" + activoSistema + "]";
	}
	
}
