package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarFactorResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarFactorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarFactorResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarFactorResponse", propOrder = { "wsActualizarFactorResult" })
public class WsActualizarFactorResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarFactorResult;

	/**
	 * Gets the value of the wsActualizarFactorResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarFactorResult() {
		return wsActualizarFactorResult;
	}

	/**
	 * Sets the value of the wsActualizarFactorResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarFactorResult(Mensaje value) {
		this.wsActualizarFactorResult = value;
	}

}
