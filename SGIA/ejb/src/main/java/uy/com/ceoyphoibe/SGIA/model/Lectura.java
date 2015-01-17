
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La clase Lectura representa a una lectura de un sensor recibida desde la placa controladora.
 */
@Entity
@XmlRootElement
@Table(name = "lecturas")
public class Lectura implements Serializable {


	private static final long serialVersionUID = 5571525997828429088L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float valor;
	private Long idSensor;
	private Long idPlaca;
	private Timestamp fechaHora;

	/**
	 * @return el valor obtenido en la lectura
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
	 * @return el identificador
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *           El identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el identificador del dispositivo sensor que obtuvo la lectura.
	 */
	public Long getIdSensor() {
		return idSensor;
	}

	/**
	 * @param idSensor
	 *            El identificador del dispositivo sensor a asignar.
	 */
	public void setIdSensor(Long idSensor) {
		this.idSensor = idSensor;
	}

	/**
	 * @return la fecha y hora en que se obtuvo la lectura
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
	 * @return el id de la placa desde la que se obtiene la lectura
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
