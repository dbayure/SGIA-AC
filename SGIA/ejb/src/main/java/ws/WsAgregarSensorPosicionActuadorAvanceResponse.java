
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAgregarSensorPosicionActuadorAvanceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAgregarSensorPosicionActuadorAvanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAgregarSensorPosicionActuadorAvanceResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAgregarSensorPosicionActuadorAvanceResponse", propOrder = {
    "wsAgregarSensorPosicionActuadorAvanceResult"
})
public class WsAgregarSensorPosicionActuadorAvanceResponse {

    @XmlElement(required = true)
    protected ResultadoCreacionWS wsAgregarSensorPosicionActuadorAvanceResult;

    /**
     * Gets the value of the wsAgregarSensorPosicionActuadorAvanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public ResultadoCreacionWS getWsAgregarSensorPosicionActuadorAvanceResult() {
        return wsAgregarSensorPosicionActuadorAvanceResult;
    }

    /**
     * Sets the value of the wsAgregarSensorPosicionActuadorAvanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public void setWsAgregarSensorPosicionActuadorAvanceResult(ResultadoCreacionWS value) {
        this.wsAgregarSensorPosicionActuadorAvanceResult = value;
    }

}
