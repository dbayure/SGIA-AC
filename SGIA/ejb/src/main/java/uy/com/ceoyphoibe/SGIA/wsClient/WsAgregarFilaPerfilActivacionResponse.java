package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsAgregarFilaPerfilActivacionResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsAgregarFilaPerfilActivacionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAgregarFilaPerfilActivacionResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAgregarFilaPerfilActivacionResponse", propOrder = { "wsAgregarFilaPerfilActivacionResult" })
public class WsAgregarFilaPerfilActivacionResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsAgregarFilaPerfilActivacionResult;

	/**
	 * Gets the value of the wsAgregarFilaPerfilActivacionResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsAgregarFilaPerfilActivacionResult() {
		return wsAgregarFilaPerfilActivacionResult;
	}

	/**
	 * Sets the value of the wsAgregarFilaPerfilActivacionResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsAgregarFilaPerfilActivacionResult(ResultadoCreacionWS value) {
		this.wsAgregarFilaPerfilActivacionResult = value;
	}

}
