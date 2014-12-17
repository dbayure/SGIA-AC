
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAsociarActuadorGrupoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAsociarActuadorGrupoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAsociarActuadorGrupoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAsociarActuadorGrupoResponse", propOrder = {
    "wsAsociarActuadorGrupoResult"
})
public class WsAsociarActuadorGrupoResponse {

    @XmlElement(required = true)
    protected Mensaje wsAsociarActuadorGrupoResult;

    /**
     * Gets the value of the wsAsociarActuadorGrupoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsAsociarActuadorGrupoResult() {
        return wsAsociarActuadorGrupoResult;
    }

    /**
     * Sets the value of the wsAsociarActuadorGrupoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsAsociarActuadorGrupoResult(Mensaje value) {
        this.wsAsociarActuadorGrupoResult = value;
    }

}
