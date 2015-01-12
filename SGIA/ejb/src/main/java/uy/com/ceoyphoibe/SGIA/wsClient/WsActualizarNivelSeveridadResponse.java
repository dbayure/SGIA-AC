package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarNivelSeveridadResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarNivelSeveridadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarNivelSeveridadResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarNivelSeveridadResponse", propOrder = { "wsActualizarNivelSeveridadResult" })
public class WsActualizarNivelSeveridadResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarNivelSeveridadResult;

	/**
	 * Gets the value of the wsActualizarNivelSeveridadResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarNivelSeveridadResult() {
		return wsActualizarNivelSeveridadResult;
	}

	/**
	 * Sets the value of the wsActualizarNivelSeveridadResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarNivelSeveridadResult(Mensaje value) {
		this.wsActualizarNivelSeveridadResult = value;
	}

}
