
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAsociarFactorSensorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAsociarFactorSensorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAsociarFactorSensorResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAsociarFactorSensorResponse", propOrder = {
    "wsAsociarFactorSensorResult"
})
public class WsAsociarFactorSensorResponse {

    @XmlElement(required = true)
    protected Mensaje wsAsociarFactorSensorResult;

    /**
     * Gets the value of the wsAsociarFactorSensorResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsAsociarFactorSensorResult() {
        return wsAsociarFactorSensorResult;
    }

    /**
     * Sets the value of the wsAsociarFactorSensorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsAsociarFactorSensorResult(Mensaje value) {
        this.wsAsociarFactorSensorResult = value;
    }

}
