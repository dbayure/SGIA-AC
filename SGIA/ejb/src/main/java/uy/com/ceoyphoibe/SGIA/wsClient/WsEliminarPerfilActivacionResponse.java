
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsEliminarPerfilActivacionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsEliminarPerfilActivacionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEliminarPerfilActivacionResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEliminarPerfilActivacionResponse", propOrder = {
    "wsEliminarPerfilActivacionResult"
})
public class WsEliminarPerfilActivacionResponse {

    @XmlElement(required = true)
    protected Mensaje wsEliminarPerfilActivacionResult;

    /**
     * Gets the value of the wsEliminarPerfilActivacionResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsEliminarPerfilActivacionResult() {
        return wsEliminarPerfilActivacionResult;
    }

    /**
     * Sets the value of the wsEliminarPerfilActivacionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsEliminarPerfilActivacionResult(Mensaje value) {
        this.wsEliminarPerfilActivacionResult = value;
    }

}
