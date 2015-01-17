/**
 * La clase Sensor representa a todos aquellos dispositivos capaces de obtener lecturas del ambiente para determinado factor.
 */
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
@JsonIgnoreProperties({ "factor", "placa" })
public class Sensor extends Dispositivo implements Serializable {

	private static final long serialVersionUID = -2766478052400319078L;

	private String formulaConversion;
	@ManyToOne(fetch = FetchType.EAGER)
	private TipoPuerto tipoPuerto;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "factor_id", referencedColumnName = "idFactor")
	private Factor factor;

	/**
	 * @return la fórmula de conversión del valor bruto obtenido al valor final interpretado.
	 */
	public String getFormulaConversion() {
		return formulaConversion;
	}

	/**
	 * @param formulaConversion
	 * 						La fórmula de conversión a asignar.
	 */
	public void setFormulaConversion(String formulaConversion) {
		this.formulaConversion = formulaConversion;
	}

	/**
	 * @return el tipo de puerto
	 */
	public TipoPuerto getTipoPuerto() {
		return tipoPuerto;
	}

	/**
	 * @param tipoPuerto 
	 * 					El tipo de puerto a asignar.
	 */
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return el factor al que pertenece el sensor
	 */
	public Factor getFactor() {
		return factor;
	}

	/**
	 * @param factor
	 *            el factor a asignar.
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
