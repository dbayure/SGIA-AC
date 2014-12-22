
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsActualizarActuadorAvanceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarActuadorAvanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarActuadorAvanceResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarActuadorAvanceResponse", propOrder = {
    "wsActualizarActuadorAvanceResult"
})
public class WsActualizarActuadorAvanceResponse {

    @XmlElement(required = true)
    protected Mensaje wsActualizarActuadorAvanceResult;

    /**
     * Gets the value of the wsActualizarActuadorAvanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsActualizarActuadorAvanceResult() {
        return wsActualizarActuadorAvanceResult;
    }

    /**
     * Sets the value of the wsActualizarActuadorAvanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsActualizarActuadorAvanceResult(Mensaje value) {
        this.wsActualizarActuadorAvanceResult = value;
    }

}
