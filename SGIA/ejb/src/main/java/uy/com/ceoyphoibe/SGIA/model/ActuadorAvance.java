package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "actuadorAvance")
public class ActuadorAvance extends Dispositivo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4807811365963928429L;
	
	private char posicion;
	private int numeroPuertoRetroceso;
	private TipoActuador tipoActuador;
	private TipoPuerto tipoPuerto;
	
	public char getPosicion() {
		return posicion;
	}
	public void setPosicion(char posicion) {
		this.posicion = posicion;
	}
	public int getNumeroPuertoRetroceso() {
		return numeroPuertoRetroceso;
	}
	public void setNumeroPuertoRetroceso(int numeroPuertoRetroceso) {
		this.numeroPuertoRetroceso = numeroPuertoRetroceso;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numeroPuertoRetroceso;
		result = prime * result + posicion;
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
		ActuadorAvance other = (ActuadorAvance) obj;
		if (numeroPuertoRetroceso != other.numeroPuertoRetroceso)
			return false;
		if (posicion != other.posicion)
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
		return "ActuadorAvance [posicion=" + posicion
				+ ", numeroPuertoRetroceso=" + numeroPuertoRetroceso
				+ ", tipoActuador=" + tipoActuador + ", tipoPuerto="
				+ tipoPuerto + "]";
	}
	
}
