package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "actuador")
public class Actuador extends Dispositivo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6858893439293443051L;

	private char estado;
	private TipoActuador tipoActuador;
	private TipoPuerto tipoPuerto;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn ( name = "grupoActuadores_id", nullable = true )
	private GrupoActuadores grupoActuadores;
	
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public TipoActuador getTipoActuador() {
		return tipoActuador;
	}
	public void setTipoActuador(TipoActuador tipoActuador) {
		this.tipoActuador = tipoActuador;
	}
	public TipoPuerto getTipoPuerto() {
		return tipoPuerto;
	}
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}
	public GrupoActuadores getGrupoActuadores() {
		return grupoActuadores;
	}
	public void setGrupoActuadores(GrupoActuadores grupoActuadores) {
		this.grupoActuadores = grupoActuadores;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + estado;
		result = prime * result
				+ ((grupoActuadores == null) ? 0 : grupoActuadores.hashCode());
		result = prime * result
				+ ((tipoActuador == null) ? 0 : tipoActuador.hashCode());
		result = prime * result
				+ ((tipoPuerto == null) ? 0 : tipoPuerto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actuador other = (Actuador) obj;
		if (estado != other.estado)
			return false;
		if (grupoActuadores == null) {
			if (other.grupoActuadores != null)
				return false;
		} else if (!grupoActuadores.equals(other.grupoActuadores))
			return false;
		if (tipoActuador == null) {
			if (other.tipoActuador != null)
				return false;
		} else if (!tipoActuador.equals(other.tipoActuador))
			return false;
		if (tipoPuerto == null) {
			if (other.tipoPuerto != null)
				return false;
		} else if (!tipoPuerto.equals(other.tipoPuerto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Actuador [estado=" + estado + ", tipoActuador=" + tipoActuador
				+ ", tipoPuerto=" + tipoPuerto + ", grupoActuadores="
				+ grupoActuadores + "]";
	}
	
}
