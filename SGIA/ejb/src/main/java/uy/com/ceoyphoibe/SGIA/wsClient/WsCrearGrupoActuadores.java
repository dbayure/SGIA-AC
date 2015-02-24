
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearGrupoActuadores complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearGrupoActuadores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deAvance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearGrupoActuadores", propOrder = {
    "nombre",
    "deAvance"
})
public class WsCrearGrupoActuadores {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String deAvance;

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
     * Gets the value of the deAvance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeAvance() {
        return deAvance;
    }

    /**
     * Sets the value of the deAvance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeAvance(String value) {
        this.deAvance = value;
    }

}
