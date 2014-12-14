
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearFactor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearFactor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="unidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valorMin" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="valorMax" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="umbral" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearFactor", propOrder = {
    "nombre",
    "unidad",
    "valorMin",
    "valorMax",
    "umbral"
})
public class WsCrearFactor {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String unidad;
    @XmlElement(required = true)
    protected BigInteger valorMin;
    @XmlElement(required = true)
    protected BigInteger valorMax;
    @XmlElement(required = true)
    protected BigInteger umbral;

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
     * Gets the value of the unidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Sets the value of the unidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidad(String value) {
        this.unidad = value;
    }

    /**
     * Gets the value of the valorMin property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValorMin() {
        return valorMin;
    }

    /**
     * Sets the value of the valorMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValorMin(BigInteger value) {
        this.valorMin = value;
    }

    /**
     * Gets the value of the valorMax property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValorMax() {
        return valorMax;
    }

    /**
     * Sets the value of the valorMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValorMax(BigInteger value) {
        this.valorMax = value;
    }

    /**
     * Gets the value of the umbral property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUmbral() {
        return umbral;
    }

    /**
     * Sets the value of the umbral property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUmbral(BigInteger value) {
        this.umbral = value;
    }

}
