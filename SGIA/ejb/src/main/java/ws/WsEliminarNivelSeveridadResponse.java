
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsEliminarNivelSeveridadResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsEliminarNivelSeveridadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEliminarNivelSeveridadResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEliminarNivelSeveridadResponse", propOrder = {
    "wsEliminarNivelSeveridadResult"
})
public class WsEliminarNivelSeveridadResponse {

    @XmlElement(required = true)
    protected Mensaje wsEliminarNivelSeveridadResult;

    /**
     * Gets the value of the wsEliminarNivelSeveridadResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsEliminarNivelSeveridadResult() {
        return wsEliminarNivelSeveridadResult;
    }

    /**
     * Sets the value of the wsEliminarNivelSeveridadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsEliminarNivelSeveridadResult(Mensaje value) {
        this.wsEliminarNivelSeveridadResult = value;
    }

}
