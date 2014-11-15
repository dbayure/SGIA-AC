package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

public class PosicionPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6588696946760245451L;
	private long actuadorAvance;
	private long idPosicion;
	/**
	 * 
	 */
	public PosicionPK() {	}
	/**
	 * @param actuadorAvance
	 * @param idPosicion
	 */
	public PosicionPK(long actuadorAvance, long idPosicion) {
		this.actuadorAvance = actuadorAvance;
		this.idPosicion = idPosicion;
	}
	/**
	 * @return the actuadorAvance
	 */
	public long getActuadorAvance() {
		return actuadorAvance;
	}
	/**
	 * @param actuadorAvance the actuadorAvance to set
	 */
	public void setActuadorAvance(long actuadorAvance) {
		this.actuadorAvance = actuadorAvance;
	}
	/**
	 * @return the idPosicion
	 */
	public long getIdPosicion() {
		return idPosicion;
	}
	/**
	 * @param idPosicion the idPosicion to set
	 */
	public void setIdPosicion(long idPosicion) {
		this.idPosicion = idPosicion;
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
				+ (int) (actuadorAvance ^ (actuadorAvance >>> 32));
		result = prime * result + (int) (idPosicion ^ (idPosicion >>> 32));
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
		PosicionPK other = (PosicionPK) obj;
		if (actuadorAvance != other.actuadorAvance)
			return false;
		if (idPosicion != other.idPosicion)
			return false;
		return true;
	}
	
	
}
