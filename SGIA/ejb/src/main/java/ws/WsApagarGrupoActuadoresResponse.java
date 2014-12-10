
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsApagarGrupoActuadoresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsApagarGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsApagarGrupoActuadoresResult" type="{Comunicacion.Comunicacion}ResultadoAccionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsApagarGrupoActuadoresResponse", propOrder = {
    "wsApagarGrupoActuadoresResult"
})
public class WsApagarGrupoActuadoresResponse {

    @XmlElement(required = true)
    protected ResultadoAccionWS wsApagarGrupoActuadoresResult;

    /**
     * Gets the value of the wsApagarGrupoActuadoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoAccionWS }
     *     
     */
    public ResultadoAccionWS getWsApagarGrupoActuadoresResult() {
        return wsApagarGrupoActuadoresResult;
    }

    /**
     * Sets the value of the wsApagarGrupoActuadoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoAccionWS }
     *     
     */
    public void setWsApagarGrupoActuadoresResult(ResultadoAccionWS value) {
        this.wsApagarGrupoActuadoresResult = value;
    }

}
