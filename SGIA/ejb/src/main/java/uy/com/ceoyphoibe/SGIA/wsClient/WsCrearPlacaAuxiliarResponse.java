package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearPlacaAuxiliarResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearPlacaAuxiliarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearPlacaAuxiliarResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearPlacaAuxiliarResponse", propOrder = { "wsCrearPlacaAuxiliarResult" })
public class WsCrearPlacaAuxiliarResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsCrearPlacaAuxiliarResult;

	/**
	 * Gets the value of the wsCrearPlacaAuxiliarResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsCrearPlacaAuxiliarResult() {
		return wsCrearPlacaAuxiliarResult;
	}

	/**
	 * Sets the value of the wsCrearPlacaAuxiliarResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsCrearPlacaAuxiliarResult(ResultadoCreacionWS value) {
		this.wsCrearPlacaAuxiliarResult = value;
	}

}
