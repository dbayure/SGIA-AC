
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsActualizarTipoPlacaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarTipoPlacaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarTipoPlacaResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarTipoPlacaResponse", propOrder = {
    "wsActualizarTipoPlacaResult"
})
public class WsActualizarTipoPlacaResponse {

    @XmlElement(required = true)
    protected Mensaje wsActualizarTipoPlacaResult;

    /**
     * Gets the value of the wsActualizarTipoPlacaResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsActualizarTipoPlacaResult() {
        return wsActualizarTipoPlacaResult;
    }

    /**
     * Sets the value of the wsActualizarTipoPlacaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsActualizarTipoPlacaResult(Mensaje value) {
        this.wsActualizarTipoPlacaResult = value;
    }

}
