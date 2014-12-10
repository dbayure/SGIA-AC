
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsEliminarFilaPerfilActivacionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsEliminarFilaPerfilActivacionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEliminarFilaPerfilActivacionResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEliminarFilaPerfilActivacionResponse", propOrder = {
    "wsEliminarFilaPerfilActivacionResult"
})
public class WsEliminarFilaPerfilActivacionResponse {

    @XmlElement(required = true)
    protected Mensaje wsEliminarFilaPerfilActivacionResult;

    /**
     * Gets the value of the wsEliminarFilaPerfilActivacionResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsEliminarFilaPerfilActivacionResult() {
        return wsEliminarFilaPerfilActivacionResult;
    }

    /**
     * Sets the value of the wsEliminarFilaPerfilActivacionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsEliminarFilaPerfilActivacionResult(Mensaje value) {
        this.wsEliminarFilaPerfilActivacionResult = value;
    }

}
