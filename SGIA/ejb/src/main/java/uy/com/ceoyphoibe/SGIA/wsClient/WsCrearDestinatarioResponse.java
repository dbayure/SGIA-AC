package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearDestinatarioResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearDestinatarioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearDestinatarioResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearDestinatarioResponse", propOrder = { "wsCrearDestinatarioResult" })
public class WsCrearDestinatarioResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsCrearDestinatarioResult;

	/**
	 * Gets the value of the wsCrearDestinatarioResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsCrearDestinatarioResult() {
		return wsCrearDestinatarioResult;
	}

	/**
	 * Sets the value of the wsCrearDestinatarioResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsCrearDestinatarioResult(ResultadoCreacionWS value) {
		this.wsCrearDestinatarioResult = value;
	}

}
