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
	
	
}
