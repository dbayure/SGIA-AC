
package ws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsAgregarFilaPerfilActivacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsAgregarFilaPerfilActivacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPerfilActivacion" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idGrupoActuadores" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsAgregarFilaPerfilActivacion", propOrder = {
    "idPerfilActivacion",
    "idGrupoActuadores",
    "estado"
})
public class WsAgregarFilaPerfilActivacion {

    @XmlElement(required = true)
    protected BigInteger idPerfilActivacion;
    @XmlElement(required = true)
    protected BigInteger idGrupoActuadores;
    @XmlElement(required = true)
    protected String estado;

    /**
     * Gets the value of the idPerfilActivacion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdPerfilActivacion() {
        return idPerfilActivacion;
    }

    /**
     * Sets the value of the idPerfilActivacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdPerfilActivacion(BigInteger value) {
        this.idPerfilActivacion = value;
    }

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
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

}
