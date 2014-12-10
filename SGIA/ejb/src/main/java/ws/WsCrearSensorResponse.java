
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearSensorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearSensorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearSensorResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearSensorResponse", propOrder = {
    "wsCrearSensorResult"
})
public class WsCrearSensorResponse {

    @XmlElement(required = true)
    protected ResultadoCreacionWS wsCrearSensorResult;

    /**
     * Gets the value of the wsCrearSensorResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public ResultadoCreacionWS getWsCrearSensorResult() {
        return wsCrearSensorResult;
    }

    /**
     * Sets the value of the wsCrearSensorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public void setWsCrearSensorResult(ResultadoCreacionWS value) {
        this.wsCrearSensorResult = value;
    }

}
