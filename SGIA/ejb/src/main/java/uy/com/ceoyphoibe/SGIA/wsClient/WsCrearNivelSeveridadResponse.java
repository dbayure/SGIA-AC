
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearNivelSeveridadResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearNivelSeveridadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearNivelSeveridadResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearNivelSeveridadResponse", propOrder = {
    "wsCrearNivelSeveridadResult"
})
public class WsCrearNivelSeveridadResponse {

    @XmlElement(required = true)
    protected ResultadoCreacionWS wsCrearNivelSeveridadResult;

    /**
     * Gets the value of the wsCrearNivelSeveridadResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public ResultadoCreacionWS getWsCrearNivelSeveridadResult() {
        return wsCrearNivelSeveridadResult;
    }

    /**
     * Sets the value of the wsCrearNivelSeveridadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoCreacionWS }
     *     
     */
    public void setWsCrearNivelSeveridadResult(ResultadoCreacionWS value) {
        this.wsCrearNivelSeveridadResult = value;
    }

}
