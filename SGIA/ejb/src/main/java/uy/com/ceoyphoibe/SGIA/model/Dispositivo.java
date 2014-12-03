package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "dispositivo")
public class Dispositivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8866292107833641690L;

	@Id
	private Long id;
	
	private String nombre;
	private String modelo;
	private int numeroPuerto;
	private char activoSistema;
	private char estadoAlerta;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn ( name = "padre_id",  referencedColumnName = "id")
	private PlacaAuxiliar padre;
	
	
	
	/**
	 * @return the padre
	 */
	public PlacaAuxiliar getPadre() {
		return padre;
	}
	/**
	 * @param padre the padre to set
	 */
	public void setPadre(PlacaAuxiliar padre) {
		this.padre = padre;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumeroPuerto() {
		return numeroPuerto;
	}
	public void setNumeroPuerto(int numeroPuerto) {
		this.numeroPuerto = numeroPuerto;
	}
	public char getActivoSistema() {
		return activoSistema;
	}
	public void setActivoSistema(char activoSistema) {
		this.activoSistema = activoSistema;
	}
	public char getEstadoAlerta() {
		return estadoAlerta;
	}
	public void setEstadoAlerta(char estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activoSistema;
		result = prime * result + estadoAlerta;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroPuerto;
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
		Dispositivo other = (Dispositivo) obj;
		if (activoSistema != other.activoSistema)
			return false;
		if (estadoAlerta != other.estadoAlerta)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroPuerto != other.numeroPuerto)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", modelo="
				+ modelo + ", numeroPuerto=" + numeroPuerto
				+ ", activoSistema=" + activoSistema + ", estadoAlerta="
				+ estadoAlerta + "]";
	}
	
	
}
