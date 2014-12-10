
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsLecturaFactorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsLecturaFactorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsLecturaFactorResult" type="{Comunicacion.Comunicacion}ResultadoLecturaWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsLecturaFactorResponse", propOrder = {
    "wsLecturaFactorResult"
})
public class WsLecturaFactorResponse {

    @XmlElement(required = true)
    protected ResultadoLecturaWS wsLecturaFactorResult;

    /**
     * Gets the value of the wsLecturaFactorResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoLecturaWS }
     *     
     */
    public ResultadoLecturaWS getWsLecturaFactorResult() {
        return wsLecturaFactorResult;
    }

    /**
     * Sets the value of the wsLecturaFactorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoLecturaWS }
     *     
     */
    public void setWsLecturaFactorResult(ResultadoLecturaWS value) {
        this.wsLecturaFactorResult = value;
    }

}
