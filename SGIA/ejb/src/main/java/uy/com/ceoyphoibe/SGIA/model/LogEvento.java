/**
 * La clase LogEvento representa a un elemento de log generado ante un evento disparado en la placa controladora.
 */
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@XmlRootElement
@Table(name = "logEventos")
@JsonIgnoreProperties({ "placa" })
public class LogEvento implements Serializable {

	private static final long serialVersionUID = 4371102659328973422L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLogEvento;
	private Timestamp fecha;

	@ManyToOne(fetch = FetchType.EAGER)
	private TipoLogEvento tipoLogEvento;

	@ManyToOne(fetch = FetchType.EAGER)
	private Mensaje mensaje;

	@ManyToOne(fetch = FetchType.EAGER)
	private Dispositivo dispositivo;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "placa_id", referencedColumnName = "id")
	private Placa placa;

	
	/**
	 * @return el identificador del log de evento.
	 */
	public Long getIdLogEvento() {
		return idLogEvento;
	}

	/**
	 * @param idLogEvento
	 * 					El identificador a asignar.
	 */
	public void setIdLogEvento(Long idLogEvento) {
		this.idLogEvento = idLogEvento;
	}

	/**
	 * @return la fecha y hora en la que se genera el log de eventos.
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 * 				La fecha y hora a asignar.
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return el tipo de log de evento.
	 */
	public TipoLogEvento getTipoLogEvento() {
		return tipoLogEvento;
	}

	/**
	 * @param tipoLogEvento
	 * 					El tipo de log de evento a asignar.
	 */
	public void setTipoLogEvento(TipoLogEvento tipoLogEvento) {
		this.tipoLogEvento = tipoLogEvento;
	}

	/**
	 * @return el mensaje asociado al log de evento.
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 * 				El mensaje a asignar.
	 */
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return el dispositivo sobre el que se genera el log de evento.
	 */
	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo
	 * 					El dispositivo a asignar.
	 */
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	/**
	 * @return la placa sobre la que se generó el log de evento.
	 */
	public Placa getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 * 				La placa a asignar.
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dispositivo == null) ? 0 : dispositivo.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result
				+ ((idLogEvento == null) ? 0 : idLogEvento.hashCode());
		result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result
				+ ((tipoLogEvento == null) ? 0 : tipoLogEvento.hashCode());
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
		LogEvento other = (LogEvento) obj;
		if (dispositivo == null) {
			if (other.dispositivo != null)
				return false;
		} else if (!dispositivo.equals(other.dispositivo))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idLogEvento == null) {
			if (other.idLogEvento != null)
				return false;
		} else if (!idLogEvento.equals(other.idLogEvento))
			return false;
		if (mensaje == null) {
			if (other.mensaje != null)
				return false;
		} else if (!mensaje.equals(other.mensaje))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (tipoLogEvento == null) {
			if (other.tipoLogEvento != null)
				return false;
		} else if (!tipoLogEvento.equals(other.tipoLogEvento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogEvento [idLogEvento=" + idLogEvento + ", fecha=" + fecha
				+ ", tipoLogEvento=" + tipoLogEvento + ", mensaje=" + mensaje
				+ ", dispositivo=" + dispositivo + ", placa=" + placa + "]";
	}

}
