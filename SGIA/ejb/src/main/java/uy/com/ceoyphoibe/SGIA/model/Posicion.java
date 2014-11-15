package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@IdClass(PosicionPK.class)
@XmlRootElement
@Table(name = "posiciones")
public class Posicion implements Serializable {
	
	private static final long serialVersionUID = -5917099098470830186L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Id
	@JoinColumn(name="idActuadorAvance", referencedColumnName="id")
	private ActuadorAvance actuadorAvance;
	@Id
	private Long idPosicion;
	private String descripcion;
	private int valor;
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(name="sensoresPosicion", joinColumns= {@JoinColumn(name= "idActuadorAvance", referencedColumnName= "idActuadorAvance"), @JoinColumn(name= "idPosicion", referencedColumnName= "idPosicion")}, inverseJoinColumns=  {@JoinColumn(name= "idSensor", referencedColumnName= "id")}	)
	private List<Sensor> listaSensores;
	
	
	public Posicion() {
		listaSensores= new ArrayList<Sensor>();
	}
	
	
	/**
	 * @return the actuadorAvance
	 */
	public ActuadorAvance getActuadorAvance() {
		return actuadorAvance;
	}
	/**
	 * @param actuadorAvance the actuadorAvance to set
	 */
	public void setActuadorAvance(ActuadorAvance actuadorAvance) {
		this.actuadorAvance = actuadorAvance;
	}
	/**
	 * @return the idPosicion
	 */
	public Long getIdPosicion() {
		return idPosicion;
	}
	/**
	 * @param idPosicion the idPosicion to set
	 */
	public void setIdPosicion(Long idPosicion) {
		this.idPosicion = idPosicion;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	/**
	 * @return the listaSensores
	 */
	public List<Sensor> getListaSensores() {
		return listaSensores;
	}
	/**
	 * @param listaSensores the listaSensores to set
	 */
	public void setListaSensores(List<Sensor> listaSensores) {
		this.listaSensores = listaSensores;
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
				+ ((actuadorAvance == null) ? 0 : actuadorAvance.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idPosicion == null) ? 0 : idPosicion.hashCode());
		result = prime * result
				+ ((listaSensores == null) ? 0 : listaSensores.hashCode());
		result = prime * result + valor;
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
		Posicion other = (Posicion) obj;
		if (actuadorAvance == null) {
			if (other.actuadorAvance != null)
				return false;
		} else if (!actuadorAvance.equals(other.actuadorAvance))
			return false;
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
		if (listaSensores == null) {
			if (other.listaSensores != null)
				return false;
		} else if (!listaSensores.equals(other.listaSensores))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	
	
}
