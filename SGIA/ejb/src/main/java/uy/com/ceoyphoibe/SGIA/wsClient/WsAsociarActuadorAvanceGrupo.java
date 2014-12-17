
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAsociarActuadorAvanceGrupo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAsociarActuadorAvanceGrupo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idGrupoActuadores" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idDispositivo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAsociarActuadorAvanceGrupo", propOrder = {
    "idGrupoActuadores",
    "idDispositivo"
})
public class WsAsociarActuadorAvanceGrupo {

    @XmlElement(required = true)
    protected BigInteger idGrupoActuadores;
    @XmlElement(required = true)
    protected BigInteger idDispositivo;

    /**
     * Gets the value of the idGrupoActuadores property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdGrupoActuadores() {
        return idGrupoActuadores;
    }

    /**
     * Sets the value of the idGrupoActuadores property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdGrupoActuadores(BigInteger value) {
        this.idGrupoActuadores = value;
    }

    /**
     * Gets the value of the idDispositivo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdDispositivo() {
        return idDispositivo;
    }

    /**
     * Sets the value of the idDispositivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdDispositivo(BigInteger value) {
        this.idDispositivo = value;
    }

}
