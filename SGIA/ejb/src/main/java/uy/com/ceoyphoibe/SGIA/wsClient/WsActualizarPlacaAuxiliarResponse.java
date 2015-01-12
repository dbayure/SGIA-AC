package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsActualizarPlacaAuxiliarResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarPlacaAuxiliarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarPlacaAuxiliarResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarPlacaAuxiliarResponse", propOrder = { "wsActualizarPlacaAuxiliarResult" })
public class WsActualizarPlacaAuxiliarResponse {

	@XmlElement(required = true)
	protected Mensaje wsActualizarPlacaAuxiliarResult;

	/**
	 * Gets the value of the wsActualizarPlacaAuxiliarResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsActualizarPlacaAuxiliarResult() {
		return wsActualizarPlacaAuxiliarResult;
	}

	/**
	 * Sets the value of the wsActualizarPlacaAuxiliarResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsActualizarPlacaAuxiliarResult(Mensaje value) {
		this.wsActualizarPlacaAuxiliarResult = value;
	}

}
