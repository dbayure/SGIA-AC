package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsAsociarDestinatarioTipoLogEventoResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsAsociarDestinatarioTipoLogEventoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAsociarDestinatarioTipoLogEventoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAsociarDestinatarioTipoLogEventoResponse", propOrder = { "wsAsociarDestinatarioTipoLogEventoResult" })
public class WsAsociarDestinatarioTipoLogEventoResponse {

	@XmlElement(required = true)
	protected Mensaje wsAsociarDestinatarioTipoLogEventoResult;

	/**
	 * Gets the value of the wsAsociarDestinatarioTipoLogEventoResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsAsociarDestinatarioTipoLogEventoResult() {
		return wsAsociarDestinatarioTipoLogEventoResult;
	}

	/**
	 * Sets the value of the wsAsociarDestinatarioTipoLogEventoResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsAsociarDestinatarioTipoLogEventoResult(Mensaje value) {
		this.wsAsociarDestinatarioTipoLogEventoResult = value;
	}

}
