
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
 * La clase Accion se utiliza para representar las acciones disparadas por los actuadores desde la placa controladora.
 */
@Entity
@XmlRootElement
@Table(name = "acciones")
public class Accion implements Serializable {


	private static final long serialVersionUID = 5571525997828429088L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoAccion;
	private Long idDispositivo;
	private Long idPlaca;
	private Timestamp fechaHora;

	/**
	 * @return el id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            el id a setear
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el fechaHora
	 */
	public Timestamp getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            el fechaHora a setear
	 */
	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return el idPlaca
	 */
	public Long getIdPlaca() {
		return idPlaca;
	}

	/**
	 * @param idPlaca
	 *            el idPlaca a setear
	 */
	public void setIdPlaca(Long idPlaca) {
		this.idPlaca = idPlaca;
	}

	/**
	 * @return el tipoAccion
	 */
	public String getTipoAccion() {
		return tipoAccion;
	}

	/**
	 * @param tipoAccion
	 *            el tipoAccion a setear
	 */
	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	/**
	 * @return el idDispositivo
	 */
	public Long getIdDispositivo() {
		return idDispositivo;
	}

	/**
	 * @param idDispositivo
	 *            el idDispositivo a setear
	 */
	public void setIdDispositivo(Long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

}
