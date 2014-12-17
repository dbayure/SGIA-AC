
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAsociarActuadorAvanceGrupoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAsociarActuadorAvanceGrupoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAsociarActuadorAvanceGrupoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAsociarActuadorAvanceGrupoResponse", propOrder = {
    "wsAsociarActuadorAvanceGrupoResult"
})
public class WsAsociarActuadorAvanceGrupoResponse {

    @XmlElement(required = true)
    protected Mensaje wsAsociarActuadorAvanceGrupoResult;

    /**
     * Gets the value of the wsAsociarActuadorAvanceGrupoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsAsociarActuadorAvanceGrupoResult() {
        return wsAsociarActuadorAvanceGrupoResult;
    }

    /**
     * Sets the value of the wsAsociarActuadorAvanceGrupoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsAsociarActuadorAvanceGrupoResult(Mensaje value) {
        this.wsAsociarActuadorAvanceGrupoResult = value;
    }

}
