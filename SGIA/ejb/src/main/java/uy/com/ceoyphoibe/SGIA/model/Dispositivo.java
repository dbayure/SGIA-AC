/**
 * La clase Dispositivo representa a todo dispositivo perteneciente al sistema.
 * Sus especializaciones son Actuador, ActuadoresAvance, Sensor y PlacaAuxiliar.
 */
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dispositivo")
public class Dispositivo implements Serializable {


	private static final long serialVersionUID = 8866292107833641690L;

	@Id
	private Long id;
	private String nombre;
	private String modelo;
	private int numeroPuerto;
	private char activoSistema;
	private String estadoAlerta;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "padre_id", referencedColumnName = "id")
	private PlacaAuxiliar padre;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "placa_id", referencedColumnName = "id")
	private Placa placa;

	
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 		El id a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 * 			El nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 * 			El modelo a asignar
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return numeroPuerto
	 */
	public int getNumeroPuerto() {
		return numeroPuerto;
	}

	/**
	 * @param numeroPuerto
	 * 				El número de puerto a asignar.
	 */
	public void setNumeroPuerto(int numeroPuerto) {
		this.numeroPuerto = numeroPuerto;
	}

	/**
	 * @return activoSistema
	 */
	public char getActivoSistema() {
		return activoSistema;
	}

	/**
	 * @param activoSistema
	 * 					El parámetro activo sistema a asignar
	 */
	public void setActivoSistema(char activoSistema) {
		this.activoSistema = activoSistema;
	}

	/**
	 * @return estadoAlerta
	 */
	public String getEstadoAlerta() {
		return estadoAlerta;
	}

	/**
	 * @param estadoAlerta
	 * 				El estado de alerta a asignar.
	 */
	public void setEstadoAlerta(String estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}

	/**
	 * @return Placa auxiliar padre a la que está enchufado el dispositivo
	 */
	public PlacaAuxiliar getPadre() {
		return padre;
	}

	/**
	 * @param padre
	 * 			La PlacaAuxiliar a asignar.
	 */
	public void setPadre(PlacaAuxiliar padre) {
		this.padre = padre;
	}

	/**
	 * @return Placa controladora a la que pertenece el dispositivo.
	 */
	public Placa getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 * 			La placa a asignar.
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activoSistema;
		result = prime * result
				+ ((estadoAlerta == null) ? 0 : estadoAlerta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroPuerto;
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
		Dispositivo other = (Dispositivo) obj;
		if (activoSistema != other.activoSistema)
			return false;
		if (estadoAlerta == null) {
			if (other.estadoAlerta != null)
				return false;
		} else if (!estadoAlerta.equals(other.estadoAlerta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroPuerto != other.numeroPuerto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", modelo="
				+ modelo + ", numeroPuerto=" + numeroPuerto
				+ ", activoSistema=" + activoSistema + ", estadoAlerta="
				+ estadoAlerta + ", padre=" + padre + ", placa=" + placa + "]";
	}

}
