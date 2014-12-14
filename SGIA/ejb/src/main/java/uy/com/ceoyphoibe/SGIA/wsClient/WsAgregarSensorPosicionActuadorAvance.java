
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAgregarSensorPosicionActuadorAvance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAgregarSensorPosicionActuadorAvance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSensor" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idActuadorAvance" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="numeroPosicion" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAgregarSensorPosicionActuadorAvance", propOrder = {
    "idSensor",
    "idActuadorAvance",
    "numeroPosicion"
})
public class WsAgregarSensorPosicionActuadorAvance {

    @XmlElement(required = true)
    protected BigInteger idSensor;
    @XmlElement(required = true)
    protected BigInteger idActuadorAvance;
    @XmlElement(required = true)
    protected BigInteger numeroPosicion;

    /**
     * Gets the value of the idSensor property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdSensor() {
        return idSensor;
    }

    /**
     * Sets the value of the idSensor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdSensor(BigInteger value) {
        this.idSensor = value;
    }

    /**
     * Gets the value of the idActuadorAvance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdActuadorAvance() {
        return idActuadorAvance;
    }

    /**
     * Sets the value of the idActuadorAvance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdActuadorAvance(BigInteger value) {
        this.idActuadorAvance = value;
    }

    /**
     * Gets the value of the numeroPosicion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroPosicion() {
        return numeroPosicion;
    }

    /**
     * Sets the value of the numeroPosicion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroPosicion(BigInteger value) {
        this.numeroPosicion = value;
    }

}
