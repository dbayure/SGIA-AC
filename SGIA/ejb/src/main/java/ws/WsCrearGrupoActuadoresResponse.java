
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearGrupoActuadoresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearGrupoActuadoresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearGrupoActuadoresResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearGrupoActuadoresResponse", propOrder = {
    "wsCrearGrupoActuadoresResult"
})
public class WsCrearGrupoActuadoresResponse {

    @XmlElement(required = true)
    protected ResultadoCreacionWS wsCrearGrupoActuadoresResult;

    /**
     * Gets the value of the wsCrearGrupoActuadoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public ResultadoCreacionWS getWsCrearGrupoActuadoresResult() {
        return wsCrearGrupoActuadoresResult;
    }

    /**
     * Sets the value of the wsCrearGrupoActuadoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public void setWsCrearGrupoActuadoresResult(ResultadoCreacionWS value) {
        this.wsCrearGrupoActuadoresResult = value;
    }

}
