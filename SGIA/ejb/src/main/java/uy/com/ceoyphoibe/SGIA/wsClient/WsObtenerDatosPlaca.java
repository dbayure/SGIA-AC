package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsObtenerDatosPlaca complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerDatosPlaca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="temp" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerDatosPlaca", propOrder = { "temp" })
public class WsObtenerDatosPlaca {

	@XmlElement(required = true)
	protected BigInteger temp;

	/**
	 * Gets the value of the temp property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getTemp() {
		return temp;
	}

	/**
	 * Sets the value of the temp property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setTemp(BigInteger value) {
		this.temp = value;
	}

}
