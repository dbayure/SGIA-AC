
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsEncenderGrupoActuadoresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsEncenderGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsEncenderGrupoActuadoresResult" type="{Comunicacion.Comunicacion}ResultadoAccionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsEncenderGrupoActuadoresResponse", propOrder = {
    "wsEncenderGrupoActuadoresResult"
})
public class WsEncenderGrupoActuadoresResponse {

    @XmlElement(required = true)
    protected ResultadoAccionWS wsEncenderGrupoActuadoresResult;

    /**
     * Gets the value of the wsEncenderGrupoActuadoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoAccionWS }
     *     
     */
    public ResultadoAccionWS getWsEncenderGrupoActuadoresResult() {
        return wsEncenderGrupoActuadoresResult;
    }

    /**
     * Sets the value of the wsEncenderGrupoActuadoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoAccionWS }
     *     
     */
    public void setWsEncenderGrupoActuadoresResult(ResultadoAccionWS value) {
        this.wsEncenderGrupoActuadoresResult = value;
    }

}
