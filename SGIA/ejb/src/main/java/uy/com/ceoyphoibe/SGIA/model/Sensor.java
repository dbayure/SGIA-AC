package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@XmlRootElement
@Table(name = "sensores")
@JsonIgnoreProperties({"factor"})
public class Sensor extends Dispositivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2766478052400319078L;
	
	private String formulaConversion;
	@ManyToOne (fetch = FetchType.EAGER)
	private TipoPuerto tipoPuerto;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn ( name = "factor_id",  referencedColumnName = "idFactor")
	private Factor factor;

	
	public String getFormulaConversion() {
		return formulaConversion;
	}
	public void setFormulaConversion(String formulaConversion) {
		this.formulaConversion = formulaConversion;
	}
	public TipoPuerto getTipoPuerto() {
		return tipoPuerto;
	}
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the factor
	 */
	public Factor getFactor() {
		return factor;
	}
	/**
	 * @param factor the factor to set
	 */
	public void setFactor(Factor factor) {
		this.factor = factor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((formulaConversion == null) ? 0 : formulaConversion
						.hashCode());
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
		Sensor other = (Sensor) obj;
		if (formulaConversion == null) {
			if (other.formulaConversion != null)
				return false;
		} else if (!formulaConversion.equals(other.formulaConversion))
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
		return "Sensor [formulaConversion=" + formulaConversion
				+ ", tipoPuerto=" + tipoPuerto + "]";
	}
	
}
