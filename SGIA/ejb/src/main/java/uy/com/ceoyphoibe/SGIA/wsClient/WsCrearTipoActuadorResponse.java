package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearTipoActuadorResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearTipoActuadorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearTipoActuadorResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearTipoActuadorResponse", propOrder = { "wsCrearTipoActuadorResult" })
public class WsCrearTipoActuadorResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsCrearTipoActuadorResult;

	/**
	 * Gets the value of the wsCrearTipoActuadorResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsCrearTipoActuadorResult() {
		return wsCrearTipoActuadorResult;
	}

	/**
	 * Sets the value of the wsCrearTipoActuadorResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsCrearTipoActuadorResult(ResultadoCreacionWS value) {
		this.wsCrearTipoActuadorResult = value;
	}

}
