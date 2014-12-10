
package ws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearSensor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearSensor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroPuerto" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="formulaConversion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idTipoPuerto" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idPlacaPadre" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idFactor" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearSensor", propOrder = {
    "nombre",
    "modelo",
    "nroPuerto",
    "formulaConversion",
    "idTipoPuerto",
    "idPlacaPadre",
    "idFactor"
})
public class WsCrearSensor {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String modelo;
    @XmlElement(required = true)
    protected BigInteger nroPuerto;
    @XmlElement(required = true)
    protected String formulaConversion;
    @XmlElement(required = true)
    protected BigInteger idTipoPuerto;
    @XmlElement(required = true)
    protected BigInteger idPlacaPadre;
    @XmlElement(required = true)
    protected BigInteger idFactor;

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
     * Gets the value of the modelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets the value of the modelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelo(String value) {
        this.modelo = value;
    }

    /**
     * Gets the value of the nroPuerto property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNroPuerto() {
        return nroPuerto;
    }

    /**
     * Sets the value of the nroPuerto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNroPuerto(BigInteger value) {
        this.nroPuerto = value;
    }

    /**
     * Gets the value of the formulaConversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormulaConversion() {
        return formulaConversion;
    }

    /**
     * Sets the value of the formulaConversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormulaConversion(String value) {
        this.formulaConversion = value;
    }

    /**
     * Gets the value of the idTipoPuerto property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdTipoPuerto() {
        return idTipoPuerto;
    }

    /**
     * Sets the value of the idTipoPuerto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdTipoPuerto(BigInteger value) {
        this.idTipoPuerto = value;
    }

    /**
     * Gets the value of the idPlacaPadre property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdPlacaPadre() {
        return idPlacaPadre;
    }

    /**
     * Sets the value of the idPlacaPadre property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdPlacaPadre(BigInteger value) {
        this.idPlacaPadre = value;
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

}
