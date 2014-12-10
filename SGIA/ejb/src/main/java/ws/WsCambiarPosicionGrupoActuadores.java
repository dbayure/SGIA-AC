
package ws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCambiarPosicionGrupoActuadores complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCambiarPosicionGrupoActuadores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idGrupo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nroPosicion" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCambiarPosicionGrupoActuadores", propOrder = {
    "idGrupo",
    "nroPosicion"
})
public class WsCambiarPosicionGrupoActuadores {

    @XmlElement(required = true)
    protected BigInteger idGrupo;
    @XmlElement(required = true)
    protected BigInteger nroPosicion;

    /**
     * Gets the value of the idGrupo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdGrupo() {
        return idGrupo;
    }

    /**
     * Sets the value of the idGrupo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdGrupo(BigInteger value) {
        this.idGrupo = value;
    }

    /**
     * Gets the value of the nroPosicion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNroPosicion() {
        return nroPosicion;
    }

    /**
     * Sets the value of the nroPosicion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNroPosicion(BigInteger value) {
        this.nroPosicion = value;
    }

}
