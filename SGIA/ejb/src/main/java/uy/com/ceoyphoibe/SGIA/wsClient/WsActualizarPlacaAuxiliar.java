
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsActualizarPlacaAuxiliar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsActualizarPlacaAuxiliar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroSerie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idTipoPlaca" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idPlacaPadre" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
@XmlType(name = "wsActualizarPlacaAuxiliar", propOrder = {
    "nombre",
    "modelo",
    "nroSerie",
    "idTipoPlaca",
    "idPlacaPadre",
    "idDispositivo"
})
public class WsActualizarPlacaAuxiliar {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String modelo;
    @XmlElement(required = true)
    protected String nroSerie;
    @XmlElement(required = true)
    protected BigInteger idTipoPlaca;
    @XmlElement(required = true)
    protected BigInteger idPlacaPadre;
    @XmlElement(required = true)
    protected BigInteger idDispositivo;

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
     * Gets the value of the nroSerie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroSerie() {
        return nroSerie;
    }

    /**
     * Sets the value of the nroSerie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroSerie(String value) {
        this.nroSerie = value;
    }

    /**
     * Gets the value of the idTipoPlaca property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdTipoPlaca() {
        return idTipoPlaca;
    }

    /**
     * Sets the value of the idTipoPlaca property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdTipoPlaca(BigInteger value) {
        this.idTipoPlaca = value;
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
