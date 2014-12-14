
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsReestablecerEstadoAlertaDispositivoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsReestablecerEstadoAlertaDispositivoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsReestablecerEstadoAlertaDispositivoResult" type="{Comunicacion.Comunicacion}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsReestablecerEstadoAlertaDispositivoResponse", propOrder = {
    "wsReestablecerEstadoAlertaDispositivoResult"
})
public class WsReestablecerEstadoAlertaDispositivoResponse {

    @XmlElement(required = true)
    protected Mensaje wsReestablecerEstadoAlertaDispositivoResult;

    /**
     * Gets the value of the wsReestablecerEstadoAlertaDispositivoResult property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getWsReestablecerEstadoAlertaDispositivoResult() {
        return wsReestablecerEstadoAlertaDispositivoResult;
    }

    /**
     * Sets the value of the wsReestablecerEstadoAlertaDispositivoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setWsReestablecerEstadoAlertaDispositivoResult(Mensaje value) {
        this.wsReestablecerEstadoAlertaDispositivoResult = value;
    }

}
