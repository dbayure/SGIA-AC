package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "resultadoAccion")
public class ResultadoAccion extends Resultado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 775955751298424556L;

	private String tipoAccion;
	private GrupoActuadores grupoActuadores;

	public String getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
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
		result = prime * result
				+ ((grupoActuadores == null) ? 0 : grupoActuadores.hashCode());
		result = prime * result
				+ ((tipoAccion == null) ? 0 : tipoAccion.hashCode());
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
		ResultadoAccion other = (ResultadoAccion) obj;
		if (grupoActuadores == null) {
			if (other.grupoActuadores != null)
				return false;
		} else if (!grupoActuadores.equals(other.grupoActuadores))
			return false;
		if (tipoAccion == null) {
			if (other.tipoAccion != null)
				return false;
		} else if (!tipoAccion.equals(other.tipoAccion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoAccion [tipoAccion=" + tipoAccion
				+ ", grupoActuadores=" + grupoActuadores + "]";
	}

}
