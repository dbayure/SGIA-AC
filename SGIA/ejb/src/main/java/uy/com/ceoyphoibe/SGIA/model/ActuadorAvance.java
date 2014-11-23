package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "actuadoresAvance")
public class ActuadorAvance extends Dispositivo implements Serializable {
	
	private static final long serialVersionUID = -4807811365963928429L;
	
	private int posicion;
	private int numeroPuertoRetroceso;
	@ManyToOne (fetch = FetchType.EAGER)
	private TipoActuador tipoActuador;
	@ManyToOne (fetch = FetchType.EAGER)
	private TipoPuerto tipoPuerto;
	private int tiempoEntrePosiciones;
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="actuadoresAvancePosiciones", joinColumns={@JoinColumn(name= "idActuadorAvance", referencedColumnName= "id")}, inverseJoinColumns= {@JoinColumn(name= "idPosicion", referencedColumnName= "idPosicion")}	)
	private Set<Posicion> listaPosiciones;
	
	public ActuadorAvance(){
		listaPosiciones= new HashSet<Posicion>();
	}

	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	/**
	 * @return the numeroPuertoRetroceso
	 */
	public int getNumeroPuertoRetroceso() {
		return numeroPuertoRetroceso;
	}

	/**
	 * @param numeroPuertoRetroceso the numeroPuertoRetroceso to set
	 */
	public void setNumeroPuertoRetroceso(int numeroPuertoRetroceso) {
		this.numeroPuertoRetroceso = numeroPuertoRetroceso;
	}

	/**
	 * @return the tipoActuador
	 */
	public TipoActuador getTipoActuador() {
		return tipoActuador;
	}

	/**
	 * @param tipoActuador the tipoActuador to set
	 */
	public void setTipoActuador(TipoActuador tipoActuador) {
		this.tipoActuador = tipoActuador;
	}

	/**
	 * @return the tipoPuerto
	 */
	public TipoPuerto getTipoPuerto() {
		return tipoPuerto;
	}

	/**
	 * @param tipoPuerto the tipoPuerto to set
	 */
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}

	/**
	 * @return the listaPosiciones
	 */
	public Set<Posicion> getListaPosiciones() {
		return listaPosiciones;
	}
	
	

	/**
	 * @return the tiempoEntrePosiciones
	 */
	public int getTiempoEntrePosiciones() {
		return tiempoEntrePosiciones;
	}

	/**
	 * @param tiempoEntrePosiciones the tiempoEntrePosiciones to set
	 */
	public void setTiempoEntrePosiciones(int tiempoEntrePosiciones) {
		this.tiempoEntrePosiciones = tiempoEntrePosiciones;
	}

	/**
	 * @param listaPosiciones the listaPosiciones to set
	 */
	public void setListaPosiciones(Set<Posicion> listaPosiciones) {
		this.listaPosiciones = listaPosiciones;
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
		int result = super.hashCode();
		result = prime * result + numeroPuertoRetroceso;
		result = prime * result + posicion;
		result = prime * result + tiempoEntrePosiciones;
		result = prime * result
				+ ((tipoActuador == null) ? 0 : tipoActuador.hashCode());
		result = prime * result
				+ ((tipoPuerto == null) ? 0 : tipoPuerto.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (tiempoEntrePosiciones != other.tiempoEntrePosiciones)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActuadorAvance [posicion=" + posicion
				+ ", numeroPuertoRetroceso=" + numeroPuertoRetroceso
				+ ", tipoActuador=" + tipoActuador + ", tipoPuerto="
				+ tipoPuerto + ", tiempoEntrePosiciones="
				+ tiempoEntrePosiciones + ", listaPosiciones="
				+ listaPosiciones + "]";
	}
}
