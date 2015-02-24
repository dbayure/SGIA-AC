
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsActualizarGrupoActuadoresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsActualizarGrupoActuadoresResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarGrupoActuadoresResponse", propOrder = {
    "wsActualizarGrupoActuadoresResult"
})
public class WsActualizarGrupoActuadoresResponse {

    @XmlElement(required = true)
    protected Mensaje wsActualizarGrupoActuadoresResult;

    /**
     * Gets the value of the wsActualizarGrupoActuadoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsActualizarGrupoActuadoresResult() {
        return wsActualizarGrupoActuadoresResult;
    }

    /**
     * Sets the value of the wsActualizarGrupoActuadoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsActualizarGrupoActuadoresResult(Mensaje value) {
        this.wsActualizarGrupoActuadoresResult = value;
    }

}
