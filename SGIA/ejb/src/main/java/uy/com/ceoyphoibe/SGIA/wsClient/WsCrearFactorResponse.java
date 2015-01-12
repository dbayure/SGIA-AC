package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearFactorResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearFactorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearFactorResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearFactorResponse", propOrder = { "wsCrearFactorResult" })
public class WsCrearFactorResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsCrearFactorResult;

	/**
	 * Gets the value of the wsCrearFactorResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsCrearFactorResult() {
		return wsCrearFactorResult;
	}

	/**
	 * Sets the value of the wsCrearFactorResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsCrearFactorResult(ResultadoCreacionWS value) {
		this.wsCrearFactorResult = value;
	}

}
