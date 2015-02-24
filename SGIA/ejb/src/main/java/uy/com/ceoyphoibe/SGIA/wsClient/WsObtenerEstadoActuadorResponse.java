
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsObtenerEstadoActuadorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerEstadoActuadorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsObtenerEstadoActuadorResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerEstadoActuadorResponse", propOrder = {
    "wsObtenerEstadoActuadorResult"
})
public class WsObtenerEstadoActuadorResponse {

    @XmlElement(required = true)
    protected String wsObtenerEstadoActuadorResult;

    /**
     * Gets the value of the wsObtenerEstadoActuadorResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsObtenerEstadoActuadorResult() {
        return wsObtenerEstadoActuadorResult;
    }

    /**
     * Sets the value of the wsObtenerEstadoActuadorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsObtenerEstadoActuadorResult(String value) {
        this.wsObtenerEstadoActuadorResult = value;
    }

}
