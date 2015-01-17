
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La clase Mensaje representa a todos los mensajes emitidos desde la placa controladora para desplegar al usuario.
 */
@Entity
@XmlRootElement
@Table(name = "mensajes")
public class Mensaje implements Serializable {

	private static final long serialVersionUID = 8487567124541697125L;

	@Id
	private Long id;

	private String tipo;

	private String texto;

	public Mensaje() {
		super();
	}

	/**
	 * @return el identificador del mensaje.
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
	 * @return el tipo de mensaje (Error, Advertencia ó Informativo)
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 * 			El tipo de mensaje a asignar.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return el texto del mensaje.
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto
	 * 			El texto a asignar.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Mensaje other = (Mensaje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", tipo=" + tipo + ", texto=" + texto
				+ "]";
	}

}
