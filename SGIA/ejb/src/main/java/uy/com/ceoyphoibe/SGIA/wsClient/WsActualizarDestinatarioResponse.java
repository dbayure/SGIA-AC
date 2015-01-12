package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarDestinatarioResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarDestinatarioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarDestinatarioResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarDestinatarioResponse", propOrder = { "wsActualizarDestinatarioResult" })
public class WsActualizarDestinatarioResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarDestinatarioResult;

	/**
	 * Gets the value of the wsActualizarDestinatarioResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarDestinatarioResult() {
		return wsActualizarDestinatarioResult;
	}

	/**
	 * Sets the value of the wsActualizarDestinatarioResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarDestinatarioResult(Mensaje value) {
		this.wsActualizarDestinatarioResult = value;
	}

}
