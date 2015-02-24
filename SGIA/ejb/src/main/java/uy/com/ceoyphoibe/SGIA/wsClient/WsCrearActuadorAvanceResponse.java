
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearActuadorAvanceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearActuadorAvanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearActuadorAvanceResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearActuadorAvanceResponse", propOrder = {
    "wsCrearActuadorAvanceResult"
})
public class WsCrearActuadorAvanceResponse {

    @XmlElement(required = true)
    protected ResultadoCreacionWS wsCrearActuadorAvanceResult;

    /**
     * Gets the value of the wsCrearActuadorAvanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public ResultadoCreacionWS getWsCrearActuadorAvanceResult() {
        return wsCrearActuadorAvanceResult;
    }

    /**
     * Sets the value of the wsCrearActuadorAvanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public void setWsCrearActuadorAvanceResult(ResultadoCreacionWS value) {
        this.wsCrearActuadorAvanceResult = value;
    }

}
