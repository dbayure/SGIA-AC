package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarActuadorResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarActuadorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarActuadorResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarActuadorResponse", propOrder = { "wsActualizarActuadorResult" })
public class WsActualizarActuadorResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarActuadorResult;

	/**
	 * Gets the value of the wsActualizarActuadorResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarActuadorResult() {
		return wsActualizarActuadorResult;
	}

	/**
	 * Sets the value of the wsActualizarActuadorResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarActuadorResult(Mensaje value) {
		this.wsActualizarActuadorResult = value;
	}

}
