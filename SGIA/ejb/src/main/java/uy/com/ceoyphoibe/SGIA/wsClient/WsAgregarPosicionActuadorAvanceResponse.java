package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsAgregarPosicionActuadorAvanceResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsAgregarPosicionActuadorAvanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAgregarPosicionActuadorAvanceResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAgregarPosicionActuadorAvanceResponse", propOrder = { "wsAgregarPosicionActuadorAvanceResult" })
public class WsAgregarPosicionActuadorAvanceResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsAgregarPosicionActuadorAvanceResult;

	/**
	 * Gets the value of the wsAgregarPosicionActuadorAvanceResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsAgregarPosicionActuadorAvanceResult() {
		return wsAgregarPosicionActuadorAvanceResult;
	}

	/**
	 * Sets the value of the wsAgregarPosicionActuadorAvanceResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsAgregarPosicionActuadorAvanceResult(
			ResultadoCreacionWS value) {
		this.wsAgregarPosicionActuadorAvanceResult = value;
	}

}
