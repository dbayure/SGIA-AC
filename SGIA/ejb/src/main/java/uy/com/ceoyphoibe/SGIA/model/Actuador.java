
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * La clase Actuador representa a todos aquellos dispositivos sobre los que se puede actuar para encenderlos o apagarlos.
 */
@Entity
@XmlRootElement
@Table(name = "actuador")
@JsonIgnoreProperties({ "grupoActuadores", "placa" })
public class Actuador extends Dispositivo implements Serializable {


	private static final long serialVersionUID = 6858893439293443051L;

	private char estado;
	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_actuador_id", unique = false)
	private TipoActuador tipoActuador;

	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_puerto_id", unique = false)
	private TipoPuerto tipoPuerto;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "grupoActuadores_id", referencedColumnName = "id")
	private GrupoActuadores grupoActuadores;

	/**
	 * @return el estado
	 */
	public char getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 * 				Estado a asignar
	 */
	public void setEstado(char estado) {
		this.estado = estado;
	}

	
	/**
	 * @return el tipoActuador
	 */
	public TipoActuador getTipoActuador() {
		return tipoActuador;
	}

	/**
	 * @param tipoActuador
	 * 					TipoActuador a asignar
	 */
	public void setTipoActuador(TipoActuador tipoActuador) {
		this.tipoActuador = tipoActuador;
	}

	/**
	 * @return tipoPuerto
	 */
	public TipoPuerto getTipoPuerto() {
		return tipoPuerto;
	}

	/**
	 * @param tipoPuerto
	 * 				TipoPuerto a asignar
	 */
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}

	/**
	 * @return grupoActuadores
	 */
	public GrupoActuadores getGrupoActuadores() {
		return grupoActuadores;
	}

	/**
	 * @param grupoActuadores
	 * 					GrupoActuadores a asignar
	 */
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
				+ ", tipoPuerto=" + tipoPuerto + "]";
	}

}
