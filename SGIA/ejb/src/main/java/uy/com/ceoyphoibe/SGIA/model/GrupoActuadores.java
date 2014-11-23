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
@Table(name = "grupoActuadores")
public class GrupoActuadores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1308127548538608653L;

	@Id
	private Long id;
	
	private String nombre;
	private char estado;
	private char deAvance;
	private char activoSistema;
	
    @OneToMany( mappedBy = "grupoActuadores", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
    private List<Actuador> actuadores;

    public GrupoActuadores(){
    	super();
    	actuadores = new ArrayList<Actuador>();
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

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
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

	public List<Actuador> getActuadores() {
		return actuadores;
	}

	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
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
		result = prime * result + estado;
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
		GrupoActuadores other = (GrupoActuadores) obj;
		if (activoSistema != other.activoSistema)
			return false;
		if (deAvance != other.deAvance)
			return false;
		if (estado != other.estado)
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
		return "GrupoActuadores [id=" + id + ", nombre=" + nombre + ", estado="
				+ estado + ", deAvance=" + deAvance + ", activoSistema="
				+ activoSistema + ", actuadores=" + actuadores + "]";
	}
	
    
	
}
