package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsEliminarDestinatarioResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsEliminarDestinatarioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEliminarDestinatarioResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEliminarDestinatarioResponse", propOrder = { "wsEliminarDestinatarioResult" })
public class WsEliminarDestinatarioResponse {

	@XmlElement(required = true)
	protected Mensaje wsEliminarDestinatarioResult;

	/**
	 * Gets the value of the wsEliminarDestinatarioResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsEliminarDestinatarioResult() {
		return wsEliminarDestinatarioResult;
	}

	/**
	 * Sets the value of the wsEliminarDestinatarioResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsEliminarDestinatarioResult(Mensaje value) {
		this.wsEliminarDestinatarioResult = value;
	}

}
