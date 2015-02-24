
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsObtenerPosicionActuadorAvanceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerPosicionActuadorAvanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsObtenerPosicionActuadorAvanceResult" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerPosicionActuadorAvanceResponse", propOrder = {
    "wsObtenerPosicionActuadorAvanceResult"
})
public class WsObtenerPosicionActuadorAvanceResponse {

    @XmlElement(required = true)
    protected BigInteger wsObtenerPosicionActuadorAvanceResult;

    /**
     * Gets the value of the wsObtenerPosicionActuadorAvanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWsObtenerPosicionActuadorAvanceResult() {
        return wsObtenerPosicionActuadorAvanceResult;
    }

    /**
     * Sets the value of the wsObtenerPosicionActuadorAvanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWsObtenerPosicionActuadorAvanceResult(BigInteger value) {
        this.wsObtenerPosicionActuadorAvanceResult = value;
    }

}
