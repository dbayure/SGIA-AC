
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsActualizarTipoLogEvento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarTipoLogEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enviarMail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enviarSMS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idTipoLogEvento" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsActualizarTipoLogEvento", propOrder = {
    "enviarMail",
    "enviarSMS",
    "idTipoLogEvento"
})
public class WsActualizarTipoLogEvento {

    @XmlElement(required = true)
    protected String enviarMail;
    @XmlElement(required = true)
    protected String enviarSMS;
    @XmlElement(required = true)
    protected BigInteger idTipoLogEvento;

    /**
     * Gets the value of the enviarMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnviarMail() {
        return enviarMail;
    }

    /**
     * Sets the value of the enviarMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnviarMail(String value) {
        this.enviarMail = value;
    }

    /**
     * Gets the value of the enviarSMS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnviarSMS() {
        return enviarSMS;
    }

    /**
     * Sets the value of the enviarSMS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnviarSMS(String value) {
        this.enviarSMS = value;
    }

    /**
     * Gets the value of the idTipoLogEvento property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdTipoLogEvento() {
        return idTipoLogEvento;
    }

    /**
     * Sets the value of the idTipoLogEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdTipoLogEvento(BigInteger value) {
        this.idTipoLogEvento = value;
    }

}
