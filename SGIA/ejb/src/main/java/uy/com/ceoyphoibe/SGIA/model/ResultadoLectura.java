package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "resultadoLectura")
public class ResultadoLectura extends Resultado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5571525997828429088L;
	
	private float valor;
	private Factor factor;
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Factor getFactor() {
		return factor;
	}
	public void setFactor(Factor factor) {
		this.factor = factor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((factor == null) ? 0 : factor.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
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
		ResultadoLectura other = (ResultadoLectura) obj;
		if (factor == null) {
			if (other.factor != null)
				return false;
		} else if (!factor.equals(other.factor))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResultadoLectura [valor=" + valor + ", factor=" + factor + "]";
	}
	
}
