package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsObtenerEstadoAlertaDispositivoResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerEstadoAlertaDispositivoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsObtenerEstadoAlertaDispositivoResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerEstadoAlertaDispositivoResponse", propOrder = { "wsObtenerEstadoAlertaDispositivoResult" })
public class WsObtenerEstadoAlertaDispositivoResponse {

	@XmlElement(required = true)
	protected String wsObtenerEstadoAlertaDispositivoResult;

	/**
	 * Gets the value of the wsObtenerEstadoAlertaDispositivoResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWsObtenerEstadoAlertaDispositivoResult() {
		return wsObtenerEstadoAlertaDispositivoResult;
	}

	/**
	 * Sets the value of the wsObtenerEstadoAlertaDispositivoResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWsObtenerEstadoAlertaDispositivoResult(String value) {
		this.wsObtenerEstadoAlertaDispositivoResult = value;
	}

}
