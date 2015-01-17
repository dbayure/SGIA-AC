
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La clase TipoLogEvento representa a los tipos de log que pueden generarse.
 * Sobre estos se define a que destinatarios notificar y mediante que medios.
 */
@Entity
@XmlRootElement
@Table(name = "tipoLogEventos")
public class TipoLogEvento implements Serializable {

	private static final long serialVersionUID = 6269429525368734305L;

	@Id
	private Long idTipoLogEvento;
	private String nombre;
	private char enviarSMS;
	private char enviarMail;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "destinatariosTiposLog", joinColumns = { @JoinColumn(name = "idTipoLogEvento", referencedColumnName = "idTipoLogEvento") }, inverseJoinColumns = { @JoinColumn(name = "idDestinatario", referencedColumnName = "idDestinatario") })
	private List<Destinatario> listaDestinatarios;

	public TipoLogEvento() {
		listaDestinatarios = new ArrayList<Destinatario>();
	}

	/**
	 * @return el identificador del tipo de log de evento
	 */
	public Long getIdTipoLogEvento() {
		return idTipoLogEvento;
	}

	/**
	 * @param idTipoLogEvento
	 *            el identificador a asignar
	 */
	public void setIdTipoLogEvento(Long idTipoLogEvento) {
		this.idTipoLogEvento = idTipoLogEvento;
	}

	/**
	 * @return el nombre del tipo de log de evento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            el nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el indicador si ante este tipo de log de evento se debe notificar mediante el envío de SMS
	 */
	public char getEnviarSMS() {
		return enviarSMS;
	}

	/**
	 * @param enviarSMS
	 *            el indicador si se debe enviar SMS a asignar
	 */
	public void setEnviarSMS(char enviarSMS) {
		this.enviarSMS = enviarSMS;
	}

	/**
	 * @return the el indicador si ante este tipo de log de evento se debe notificar mediante el envío de mail
	 */
	public char getEnviarMail() {
		return enviarMail;
	}

	/**
	 * @param enviarMail
	 *            el indicador si se debe enviar mail a asignar
	 */
	public void setEnviarMail(char enviarMail) {
		this.enviarMail = enviarMail;
	}

	/**
	 * @return la lista de destinatarios a notificar ante el cumplimiento del tipo de log de eventos
	 */
	public List<Destinatario> getListaDestinatarios() {
		return listaDestinatarios;
	}

	/**
	 * @param listaDestinatarios
	 *            la lista de destinatarios a asignar
	 */
	public void setListaDestinatarios(List<Destinatario> listaDestinatarios) {
		this.listaDestinatarios = listaDestinatarios;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enviarMail;
		result = prime * result + enviarSMS;
		result = prime * result
				+ ((idTipoLogEvento == null) ? 0 : idTipoLogEvento.hashCode());
		result = prime
				* result
				+ ((listaDestinatarios == null) ? 0 : listaDestinatarios
						.hashCode());
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
		TipoLogEvento other = (TipoLogEvento) obj;
		if (enviarMail != other.enviarMail)
			return false;
		if (enviarSMS != other.enviarSMS)
			return false;
		if (idTipoLogEvento == null) {
			if (other.idTipoLogEvento != null)
				return false;
		} else if (!idTipoLogEvento.equals(other.idTipoLogEvento))
			return false;
		if (listaDestinatarios == null) {
			if (other.listaDestinatarios != null)
				return false;
		} else if (!listaDestinatarios.equals(other.listaDestinatarios))
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
		return "TipoLogEvento [idTipoLogEvento=" + idTipoLogEvento
				+ ", nombre=" + nombre + ", enviarSMS=" + enviarSMS
				+ ", enviarMail=" + enviarMail + ", listaDestinatarios="
				+ listaDestinatarios + "]";
	}

}
