package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "lecturasFactor")
public class LecturaFactor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5571525997828429088L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private float valor;
	private Long idFactor;
	private Long idPlaca;
	private Timestamp fechaHora;
	
	
	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
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
	 * @return the idSensor
	 */
	public Long getIdFactor() {
		return idFactor;
	}
	/**
	 * @param idSensor the idSensor to set
	 */
	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
	}
	/**
	 * @return the fechaHora
	 */
	public Timestamp getFechaHora() {
		return fechaHora;
	}
	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}
	/**
	 * @return the idPlaca
	 */
	public Long getIdPlaca() {
		return idPlaca;
	}
	/**
	 * @param idPlaca the idPlaca to set
	 */
	public void setIdPlaca(Long idPlaca) {
		this.idPlaca = idPlaca;
	}
	
	
}
