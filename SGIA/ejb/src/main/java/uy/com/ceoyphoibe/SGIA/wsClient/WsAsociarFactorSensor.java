package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsAsociarFactorSensor complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsAsociarFactorSensor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFactor" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idDispositivo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAsociarFactorSensor", propOrder = { "idFactor",
		"idDispositivo" })
public class WsAsociarFactorSensor {

	@XmlElement(required = true)
	protected BigInteger idFactor;
	@XmlElement(required = true)
	protected BigInteger idDispositivo;

	/**
	 * Gets the value of the idFactor property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getIdFactor() {
		return idFactor;
	}

	/**
	 * Sets the value of the idFactor property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setIdFactor(BigInteger value) {
		this.idFactor = value;
	}

	/**
	 * Gets the value of the idDispositivo property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getIdDispositivo() {
		return idDispositivo;
	}

	/**
	 * Sets the value of the idDispositivo property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setIdDispositivo(BigInteger value) {
		this.idDispositivo = value;
	}

}
