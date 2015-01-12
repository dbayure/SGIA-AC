package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarPlaca complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarPlaca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="periodicidadLecturas" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="periodicidadNiveles" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarPlaca", propOrder = { "periodicidadLecturas",
		"periodicidadNiveles" })
public class WsActualizarPlaca {

	@XmlElement(required = true)
	protected BigInteger periodicidadLecturas;
	@XmlElement(required = true)
	protected BigInteger periodicidadNiveles;

	/**
	 * Gets the value of the periodicidadLecturas property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getPeriodicidadLecturas() {
		return periodicidadLecturas;
	}

	/**
	 * Sets the value of the periodicidadLecturas property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setPeriodicidadLecturas(BigInteger value) {
		this.periodicidadLecturas = value;
	}

	/**
	 * Gets the value of the periodicidadNiveles property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getPeriodicidadNiveles() {
		return periodicidadNiveles;
	}

	/**
	 * Sets the value of the periodicidadNiveles property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setPeriodicidadNiveles(BigInteger value) {
		this.periodicidadNiveles = value;
	}

}
