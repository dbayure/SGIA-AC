
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * La clase TipoActuador representa a las categorías de actuadores que se puede definir.
 */
@Entity
@XmlRootElement
@Table(name = "tipoActuador")
@JsonIgnoreProperties({ "placa" })
public class TipoActuador implements Serializable {

	private static final long serialVersionUID = 6092319973077241634L;

	@Id
	private Long id;

	private String categoria;
	private String descripcion;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "placa_id", referencedColumnName = "id")
	private Placa placa;

	/**
	 * @return el identificador del tipo de actuador
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			el identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el nombre del tipo de actuador
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 * 				el nombre a asignar
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return la descripción del tipo de actuador
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * 					la descripción a asignar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return la placa a la que pertenece el tipo de actuador
	 */
	public Placa getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            la placa a asignar
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TipoActuador other = (TipoActuador) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoActuador [id=" + id + ", categoria=" + categoria
				+ ", descripcion=" + descripcion + "]";
	}

}
