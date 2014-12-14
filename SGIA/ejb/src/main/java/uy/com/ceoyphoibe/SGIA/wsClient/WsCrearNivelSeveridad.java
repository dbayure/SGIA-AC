
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearNivelSeveridad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearNivelSeveridad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idFactor" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="prioridad" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="rangoMinimo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="rangoMaximo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearNivelSeveridad", propOrder = {
    "nombre",
    "idFactor",
    "prioridad",
    "rangoMinimo",
    "rangoMaximo"
})
public class WsCrearNivelSeveridad {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected BigInteger idFactor;
    @XmlElement(required = true)
    protected BigInteger prioridad;
    @XmlElement(required = true)
    protected BigInteger rangoMinimo;
    @XmlElement(required = true)
    protected BigInteger rangoMaximo;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the idFactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdFactor() {
        return idFactor;
    }

    /**
     * Sets the value of the idFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdFactor(BigInteger value) {
        this.idFactor = value;
    }

    /**
     * Gets the value of the prioridad property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrioridad() {
        return prioridad;
    }

    /**
     * Sets the value of the prioridad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrioridad(BigInteger value) {
        this.prioridad = value;
    }

    /**
     * Gets the value of the rangoMinimo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRangoMinimo() {
        return rangoMinimo;
    }

    /**
     * Sets the value of the rangoMinimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRangoMinimo(BigInteger value) {
        this.rangoMinimo = value;
    }

    /**
     * Gets the value of the rangoMaximo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRangoMaximo() {
        return rangoMaximo;
    }

    /**
     * Sets the value of the rangoMaximo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRangoMaximo(BigInteger value) {
        this.rangoMaximo = value;
    }

}
