/**
 * La clase LecturaFactor representa a una lectura de un factor, procesada a partir de la lectura de sus sensores asignados.
 */
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

	private static final long serialVersionUID = 5571525997828429088L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float valor;
	private Long idFactor;
	private Long idPlaca;
	private Timestamp fechaHora;

	/**
	 * @return el valor procesado de la lectura.
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            El valor a asignar.
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * @return el identificador de la lectura.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *         El identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el identificador del factor sobre el que se obtiene la lectura.
	 */
	public Long getIdFactor() {
		return idFactor;
	}

	/**
	 * @param idFactor
	 *            El identificador de factor a asignar.
	 */
	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
	}

	/**
	 * @return la fecha y hora en la que se obtiene la lectura.
	 */
	public Timestamp getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            La fecha y hora a asignar.
	 */
	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return el identificador de la placa desde donde se obtiene la lectura.
	 */
	public Long getIdPlaca() {
		return idPlaca;
	}

	/**
	 * @param idPlaca
	 *            El identificador de la placa a asignar.
	 */
	public void setIdPlaca(Long idPlaca) {
		this.idPlaca = idPlaca;
	}

}
