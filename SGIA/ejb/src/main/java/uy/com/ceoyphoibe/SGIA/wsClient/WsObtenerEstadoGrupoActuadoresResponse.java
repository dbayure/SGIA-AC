
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsObtenerEstadoGrupoActuadoresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerEstadoGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsObtenerEstadoGrupoActuadoresResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerEstadoGrupoActuadoresResponse", propOrder = {
    "wsObtenerEstadoGrupoActuadoresResult"
})
public class WsObtenerEstadoGrupoActuadoresResponse {

    @XmlElement(required = true)
    protected String wsObtenerEstadoGrupoActuadoresResult;

    /**
     * Gets the value of the wsObtenerEstadoGrupoActuadoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsObtenerEstadoGrupoActuadoresResult() {
        return wsObtenerEstadoGrupoActuadoresResult;
    }

    /**
     * Sets the value of the wsObtenerEstadoGrupoActuadoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsObtenerEstadoGrupoActuadoresResult(String value) {
        this.wsObtenerEstadoGrupoActuadoresResult = value;
    }

}
