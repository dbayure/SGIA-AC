
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCambiarPosicionGrupoActuadoresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCambiarPosicionGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCambiarPosicionGrupoActuadoresResult" type="{Comunicacion.Comunicacion}ResultadoAccionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCambiarPosicionGrupoActuadoresResponse", propOrder = {
    "wsCambiarPosicionGrupoActuadoresResult"
})
public class WsCambiarPosicionGrupoActuadoresResponse {

    @XmlElement(required = true)
    protected ResultadoAccionWS wsCambiarPosicionGrupoActuadoresResult;

    /**
     * Gets the value of the wsCambiarPosicionGrupoActuadoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoAccionWS }
     *     
     */
    public ResultadoAccionWS getWsCambiarPosicionGrupoActuadoresResult() {
        return wsCambiarPosicionGrupoActuadoresResult;
    }

    /**
     * Sets the value of the wsCambiarPosicionGrupoActuadoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoAccionWS }
     *     
     */
    public void setWsCambiarPosicionGrupoActuadoresResult(ResultadoAccionWS value) {
        this.wsCambiarPosicionGrupoActuadoresResult = value;
    }

}
