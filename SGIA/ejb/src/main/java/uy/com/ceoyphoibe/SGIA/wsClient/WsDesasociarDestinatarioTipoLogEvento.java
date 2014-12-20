
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDesasociarDestinatarioTipoLogEvento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDesasociarDestinatarioTipoLogEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTipoLogEvento" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idDestinatario" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsDesasociarDestinatarioTipoLogEvento", propOrder = {
    "idTipoLogEvento",
    "idDestinatario"
})
public class WsDesasociarDestinatarioTipoLogEvento {

    @XmlElement(required = true)
    protected BigInteger idTipoLogEvento;
    @XmlElement(required = true)
    protected BigInteger idDestinatario;

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

    /**
     * Gets the value of the idDestinatario property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdDestinatario() {
        return idDestinatario;
    }

    /**
     * Sets the value of the idDestinatario property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdDestinatario(BigInteger value) {
        this.idDestinatario = value;
    }

}
