
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCambiarEstadoSistemaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCambiarEstadoSistemaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCambiarEstadoSistemaResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCambiarEstadoSistemaResponse", propOrder = {
    "wsCambiarEstadoSistemaResult"
})
public class WsCambiarEstadoSistemaResponse {

    @XmlElement(required = true)
    protected Mensaje wsCambiarEstadoSistemaResult;

    /**
     * Gets the value of the wsCambiarEstadoSistemaResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsCambiarEstadoSistemaResult() {
        return wsCambiarEstadoSistemaResult;
    }

    /**
     * Sets the value of the wsCambiarEstadoSistemaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsCambiarEstadoSistemaResult(Mensaje value) {
        this.wsCambiarEstadoSistemaResult = value;
    }

}
