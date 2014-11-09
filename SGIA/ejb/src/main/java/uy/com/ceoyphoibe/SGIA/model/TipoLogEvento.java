package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
	@OneToMany
	@JoinTable(name="destinatariosTiposLog", joinColumns={@JoinColumn(name= "idTipoLogEvento", referencedColumnName= "idTipoLogEvento")}, inverseJoinColumns= {@JoinColumn(name= "idDestinatario", referencedColumnName= "idDestinatario")}	)
	private List<Destinatario> listaDestinatarios;
	/**
	 * @return the idTipoLogEvento
	 */
	public Long getIdTipoLogEvento() {
		return idTipoLogEvento;
	}
	/**
	 * @param idTipoLogEvento the idTipoLogEvento to set
	 */
	public void setIdTipoLogEvento(Long idTipoLogEvento) {
		this.idTipoLogEvento = idTipoLogEvento;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the enviarSMS
	 */
	public char getEnviarSMS() {
		return enviarSMS;
	}
	/**
	 * @param enviarSMS the enviarSMS to set
	 */
	public void setEnviarSMS(char enviarSMS) {
		this.enviarSMS = enviarSMS;
	}
	/**
	 * @return the enviarMail
	 */
	public char getEnviarMail() {
		return enviarMail;
	}
	/**
	 * @param enviarMail the enviarMail to set
	 */
	public void setEnviarMail(char enviarMail) {
		this.enviarMail = enviarMail;
	}
	/**
	 * @return the listaDestinatarios
	 */
	public List<Destinatario> getListaDestinatarios() {
		return listaDestinatarios;
	}
	/**
	 * @param listaDestinatarios the listaDestinatarios to set
	 */
	public void setListaDestinatarios(List<Destinatario> listaDestinatarios) {
		this.listaDestinatarios = listaDestinatarios;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoLogEvento [idTipoLogEvento=" + idTipoLogEvento
				+ ", nombre=" + nombre + ", enviarSMS=" + enviarSMS
				+ ", enviarMail=" + enviarMail + ", listaDestinatarios="
				+ listaDestinatarios + "]";
	}

}
