
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsObtenerDatosPlacaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerDatosPlacaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsObtenerDatosPlacaResult" type="{Comunicacion.Comunicacion}ResultadoDatosPlacaWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerDatosPlacaResponse", propOrder = {
    "wsObtenerDatosPlacaResult"
})
public class WsObtenerDatosPlacaResponse {

    @XmlElement(required = true)
    protected ResultadoDatosPlacaWS wsObtenerDatosPlacaResult;

    /**
     * Gets the value of the wsObtenerDatosPlacaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoDatosPlacaWS }
     *     
     */
    public ResultadoDatosPlacaWS getWsObtenerDatosPlacaResult() {
        return wsObtenerDatosPlacaResult;
    }

    /**
     * Sets the value of the wsObtenerDatosPlacaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoDatosPlacaWS }
     *     
     */
    public void setWsObtenerDatosPlacaResult(ResultadoDatosPlacaWS value) {
        this.wsObtenerDatosPlacaResult = value;
    }

}
