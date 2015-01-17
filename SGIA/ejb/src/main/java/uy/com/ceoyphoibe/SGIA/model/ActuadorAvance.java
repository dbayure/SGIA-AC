
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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * La clase Actuador Avance representa a todos aquellos dispositivos sobre los que se puede actuar para cambiar su posición.
 */
@Entity
@XmlRootElement
@Table(name = "actuadoresAvance")
@JsonIgnoreProperties({ "grupoActuadores", "placa" })
public class ActuadorAvance extends Dispositivo implements Serializable {

	private static final long serialVersionUID = -4807811365963928429L;

	private int posicion;
	private int numeroPuertoRetroceso;

	@ManyToOne(fetch = FetchType.EAGER)
	private TipoActuador tipoActuador;

	@ManyToOne(fetch = FetchType.EAGER)
	private TipoPuerto tipoPuerto;

	private int tiempoEntrePosiciones;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "actuadoresAvancePosiciones", joinColumns = { @JoinColumn(name = "idActuadorAvance", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idPosicion", referencedColumnName = "idPosicion") })
	private Set<Posicion> listaPosiciones;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "grupoActuadores_id", referencedColumnName = "id")
	private GrupoActuadores grupoActuadores;

	public ActuadorAvance() {
		listaPosiciones = new HashSet<Posicion>();
	}

	/**
	 * @return posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion
	 *            posicion a asignar
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	/**
	 * @return numeroPuertoRetroceso
	 */
	public int getNumeroPuertoRetroceso() {
		return numeroPuertoRetroceso;
	}

	/**
	 * @param numeroPuertoRetroceso
	 *            El número de puerto de retroceso a asignar
	 */
	public void setNumeroPuertoRetroceso(int numeroPuertoRetroceso) {
		this.numeroPuertoRetroceso = numeroPuertoRetroceso;
	}

	/**
	 * @return tipoActuador
	 */
	public TipoActuador getTipoActuador() {
		return tipoActuador;
	}

	/**
	 * @param tipoActuador
	 *            El TipoActuador a asignar
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
	 *            El TipoPuerto a asignar
	 */
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}

	/**
	 * @return listaPosiciones
	 */
	public Set<Posicion> getListaPosiciones() {
		return listaPosiciones;
	}

	/**
	 * @return tiempoEntrePosiciones
	 */
	public int getTiempoEntrePosiciones() {
		return tiempoEntrePosiciones;
	}

	/**
	 * @param tiempoEntrePosiciones
	 *            El tiempo entre posiciones a asignar
	 */
	public void setTiempoEntrePosiciones(int tiempoEntrePosiciones) {
		this.tiempoEntrePosiciones = tiempoEntrePosiciones;
	}

	/**
	 * @param listaPosiciones
	 *            La lista de posiciones a asignar
	 */
	public void setListaPosiciones(Set<Posicion> listaPosiciones) {
		this.listaPosiciones = listaPosiciones;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return grupoActuadores
	 */
	public GrupoActuadores getGrupoActuadores() {
		return grupoActuadores;
	}

	/**
	 * @param grupoActuadores
	 * 					El GrupoActuadores a asignar			
	 */
	public void setGrupoActuadores(GrupoActuadores grupoActuadores) {
		this.grupoActuadores = grupoActuadores;
	}


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
