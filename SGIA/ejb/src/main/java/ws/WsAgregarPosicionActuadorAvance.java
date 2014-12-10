
package ws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAgregarPosicionActuadorAvance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAgregarPosicionActuadorAvance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idActuadorAvance" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="numeroPosicion" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAgregarPosicionActuadorAvance", propOrder = {
    "idActuadorAvance",
    "numeroPosicion",
    "descripcion",
    "valor"
})
public class WsAgregarPosicionActuadorAvance {

    @XmlElement(required = true)
    protected BigInteger idActuadorAvance;
    @XmlElement(required = true)
    protected BigInteger numeroPosicion;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    protected BigInteger valor;

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

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValor(BigInteger value) {
        this.valor = value;
    }

}
