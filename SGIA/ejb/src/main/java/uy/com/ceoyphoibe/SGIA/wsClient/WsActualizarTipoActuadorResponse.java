package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarTipoActuadorResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarTipoActuadorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarTipoActuadorResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarTipoActuadorResponse", propOrder = { "wsActualizarTipoActuadorResult" })
public class WsActualizarTipoActuadorResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarTipoActuadorResult;

	/**
	 * Gets the value of the wsActualizarTipoActuadorResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarTipoActuadorResult() {
		return wsActualizarTipoActuadorResult;
	}

	/**
	 * Sets the value of the wsActualizarTipoActuadorResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarTipoActuadorResult(Mensaje value) {
		this.wsActualizarTipoActuadorResult = value;
	}

}
