package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarTipoLogEventoResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarTipoLogEventoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarTipoLogEventoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarTipoLogEventoResponse", propOrder = { "wsActualizarTipoLogEventoResult" })
public class WsActualizarTipoLogEventoResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarTipoLogEventoResult;

	/**
	 * Gets the value of the wsActualizarTipoLogEventoResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarTipoLogEventoResult() {
		return wsActualizarTipoLogEventoResult;
	}

	/**
	 * Sets the value of the wsActualizarTipoLogEventoResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarTipoLogEventoResult(Mensaje value) {
		this.wsActualizarTipoLogEventoResult = value;
	}

}
