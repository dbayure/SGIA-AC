package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearActuadorResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearActuadorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearActuadorResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearActuadorResponse", propOrder = { "wsCrearActuadorResult" })
public class WsCrearActuadorResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsCrearActuadorResult;

	/**
	 * Gets the value of the wsCrearActuadorResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsCrearActuadorResult() {
		return wsCrearActuadorResult;
	}

	/**
	 * Sets the value of the wsCrearActuadorResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsCrearActuadorResult(ResultadoCreacionWS value) {
		this.wsCrearActuadorResult = value;
	}

}
