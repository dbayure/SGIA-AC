/**
 * La clase GrupoActuadores representa a un conjunto de actuadores sobre el que se puede actuar globalmente.
 * Es la unidad mínima sobre la que se puede definir un estado esperado.
 */
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "grupoActuadores")
public class GrupoActuadores implements Serializable {


	private static final long serialVersionUID = -1308127548538608653L;

	@Id
	private Long id;
	private String nombre;
	private char estado;
	private String deAvance;
	private char activoSistema;

	@OneToMany(mappedBy = "grupoActuadores", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Actuador> actuadores;

	@OneToMany(mappedBy = "grupoActuadores", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
	private Set<ActuadorAvance> actuadoresAvance;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "placa_id", referencedColumnName = "id")
	private Placa placa;

	public GrupoActuadores() {
		super();
		actuadores = new ArrayList<Actuador>();
		actuadoresAvance = new HashSet<ActuadorAvance>();
	}

	/**
	 * @return el identificador del grupo de actuadores
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			El identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el nombre del grupo de actuadores.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 * 			El nombre a asignar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el estado actual del grupo de actuadores
	 */
	public char getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 * 				El estado actual a asignar.
	 */
	public void setEstado(char estado) {
		this.estado = estado;
	}

	/**
	 * @return el indicador si se trata de un grupo de actuadores de avance
	 */
	public String getDeAvance() {
		return deAvance;
	}

	/**
	 * @param deAvance
	 * 				El parámetro si es un actuador de avance a asignar.
	 */
	public void setDeAvance(String deAvance) {
		this.deAvance = deAvance;
	}

	/**
	 * @return el parámetro que indica si el grupo de actuadores está activo en el sistema
	 */
	public char getActivoSistema() {
		return activoSistema;
	}

	/**
	 * @param activoSistema
	 * 					El parámetro que indica si está activo en el sistema a asignar.
	 */
	public void setActivoSistema(char activoSistema) {
		this.activoSistema = activoSistema;
	}

	/**
	 * @return la lista de actuadores del grupo de actuadores
	 */
	public List<Actuador> getActuadores() {
		return actuadores;
	}

	/**
	 * @param actuadores
	 * 				La lista de actuadores a asignar al grupo de actuadores
	 */
	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}

	/**
	 * @return la lista de actuadores de avance del grupo de actuadores.
	 */
	public Set<ActuadorAvance> getActuadoresAvance() {
		return actuadoresAvance;
	}

	/**
	 * @param actuadoresAvance
	 * 						La lista de actuadores de avance del grupo de actuadores.
	 */
	public void setActuadoresAvance(Set<ActuadorAvance> actuadoresAvance) {
		this.actuadoresAvance = actuadoresAvance;
	}

	/**
	 * @return la placa a la que pertenece el grupo de actuadores
	 */
	public Placa getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 * 			La placa controladora a asignar
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
				+ ((deAvance == null) ? 0 : deAvance.hashCode());
		result = prime * result + estado;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		GrupoActuadores other = (GrupoActuadores) obj;
		if (activoSistema != other.activoSistema)
			return false;
		if (deAvance == null) {
			if (other.deAvance != null)
				return false;
		} else if (!deAvance.equals(other.deAvance))
			return false;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoActuadores [id=" + id + ", nombre=" + nombre + ", estado="
				+ estado + ", deAvance=" + deAvance + ", actuadoresAvance="
				+ actuadoresAvance + ", placa=" + placa + "]";
	}

}
