package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "logEventos")
public class LogEvento implements Serializable {


	private static final long serialVersionUID = 4371102659328973422L;
	
	@Id
	private Long idLogEvento;
	private Date fecha;
	@ManyToOne (fetch = FetchType.EAGER)
	private TipoLogEvento tipoLogEvento;
	@ManyToOne (fetch = FetchType.EAGER)
	private Mensaje mensaje;
	@ManyToOne (fetch = FetchType.EAGER)
	private Dispositivo dispositivo;
	/**
	 * @return the idLogEvento
	 */
	public Long getIdLogEvento() {
		return idLogEvento;
	}
	/**
	 * @param idLogEvento the idLogEvento to set
	 */
	public void setIdLogEvento(Long idLogEvento) {
		this.idLogEvento = idLogEvento;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the tipoLogEvento
	 */
	public TipoLogEvento getTipoLogEvento() {
		return tipoLogEvento;
	}
	/**
	 * @param tipoLogEvento the tipoLogEvento to set
	 */
	public void setTipoLogEvento(TipoLogEvento tipoLogEvento) {
		this.tipoLogEvento = tipoLogEvento;
	}
	/**
	 * @return the mensaje
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return the dispositivo
	 */
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
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
				+ ((dispositivo == null) ? 0 : dispositivo.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result
				+ ((idLogEvento == null) ? 0 : idLogEvento.hashCode());
		result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
		result = prime * result
				+ ((tipoLogEvento == null) ? 0 : tipoLogEvento.hashCode());
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
		if (tipoLogEvento == null) {
			if (other.tipoLogEvento != null)
				return false;
		} else if (!tipoLogEvento.equals(other.tipoLogEvento))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LogEvento [idLogEvento=" + idLogEvento + ", fecha=" + fecha
				+ ", tipoLogEvento=" + tipoLogEvento + ", mensaje=" + mensaje
				+ ", dispositivo=" + dispositivo + "]";
	}

}
