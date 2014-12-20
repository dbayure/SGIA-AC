
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDesasociarDestinatarioTipoLogEventoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDesasociarDestinatarioTipoLogEventoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDesasociarDestinatarioTipoLogEventoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsDesasociarDestinatarioTipoLogEventoResponse", propOrder = {
    "wsDesasociarDestinatarioTipoLogEventoResult"
})
public class WsDesasociarDestinatarioTipoLogEventoResponse {

    @XmlElement(required = true)
    protected Mensaje wsDesasociarDestinatarioTipoLogEventoResult;

    /**
     * Gets the value of the wsDesasociarDestinatarioTipoLogEventoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsDesasociarDestinatarioTipoLogEventoResult() {
        return wsDesasociarDestinatarioTipoLogEventoResult;
    }

    /**
     * Sets the value of the wsDesasociarDestinatarioTipoLogEventoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsDesasociarDestinatarioTipoLogEventoResult(Mensaje value) {
        this.wsDesasociarDestinatarioTipoLogEventoResult = value;
    }

}
