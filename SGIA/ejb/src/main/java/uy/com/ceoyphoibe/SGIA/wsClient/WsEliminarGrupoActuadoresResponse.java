package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsEliminarGrupoActuadoresResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsEliminarGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEliminarGrupoActuadoresResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEliminarGrupoActuadoresResponse", propOrder = { "wsEliminarGrupoActuadoresResult" })
public class WsEliminarGrupoActuadoresResponse {

	@XmlElement(required = true)
	protected Mensaje wsEliminarGrupoActuadoresResult;

	/**
	 * Gets the value of the wsEliminarGrupoActuadoresResult property.
	 * 
	 * @return possible object is {@link Mensaje }
	 * 
	 */
	public Mensaje getWsEliminarGrupoActuadoresResult() {
		return wsEliminarGrupoActuadoresResult;
	}

	/**
	 * Sets the value of the wsEliminarGrupoActuadoresResult property.
	 * 
	 * @param value
	 *            allowed object is {@link Mensaje }
	 * 
	 */
	public void setWsEliminarGrupoActuadoresResult(Mensaje value) {
		this.wsEliminarGrupoActuadoresResult = value;
	}

}
