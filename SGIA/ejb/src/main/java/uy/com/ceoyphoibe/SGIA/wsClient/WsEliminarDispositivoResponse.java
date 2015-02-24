
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsEliminarDispositivoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsEliminarDispositivoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEliminarDispositivoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEliminarDispositivoResponse", propOrder = {
    "wsEliminarDispositivoResult"
})
public class WsEliminarDispositivoResponse {

    @XmlElement(required = true)
    protected Mensaje wsEliminarDispositivoResult;

    /**
     * Gets the value of the wsEliminarDispositivoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsEliminarDispositivoResult() {
        return wsEliminarDispositivoResult;
    }

    /**
     * Sets the value of the wsEliminarDispositivoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsEliminarDispositivoResult(Mensaje value) {
        this.wsEliminarDispositivoResult = value;
    }

}
