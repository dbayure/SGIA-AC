package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsReestablecerActuadorAvanceResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsReestablecerActuadorAvanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsReestablecerActuadorAvanceResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsReestablecerActuadorAvanceResponse", propOrder = { "wsReestablecerActuadorAvanceResult" })
public class WsReestablecerActuadorAvanceResponse {

	@XmlElement(required = true)
	protected Mensaje wsReestablecerActuadorAvanceResult;

	/**
	 * Gets the value of the wsReestablecerActuadorAvanceResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsReestablecerActuadorAvanceResult() {
		return wsReestablecerActuadorAvanceResult;
	}

	/**
	 * Sets the value of the wsReestablecerActuadorAvanceResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsReestablecerActuadorAvanceResult(Mensaje value) {
		this.wsReestablecerActuadorAvanceResult = value;
	}

}
