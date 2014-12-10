
package ws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCrearActuadorAvance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearActuadorAvance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroPuerto" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="posicion" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idTipoPuerto" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idTipoActuador" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idPlacaPadre" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nroPuertoRetroceso" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="tipoPuertoRetroceso" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="tiempoEntrePosiciones" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idGrupoActuadores" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearActuadorAvance", propOrder = {
    "nombre",
    "modelo",
    "nroPuerto",
    "posicion",
    "idTipoPuerto",
    "idTipoActuador",
    "idPlacaPadre",
    "nroPuertoRetroceso",
    "tipoPuertoRetroceso",
    "tiempoEntrePosiciones",
    "idGrupoActuadores"
})
public class WsCrearActuadorAvance {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String modelo;
    @XmlElement(required = true)
    protected BigInteger nroPuerto;
    @XmlElement(required = true)
    protected BigInteger posicion;
    @XmlElement(required = true)
    protected BigInteger idTipoPuerto;
    @XmlElement(required = true)
    protected BigInteger idTipoActuador;
    @XmlElement(required = true)
    protected BigInteger idPlacaPadre;
    @XmlElement(required = true)
    protected BigInteger nroPuertoRetroceso;
    @XmlElement(required = true)
    protected BigInteger tipoPuertoRetroceso;
    @XmlElement(required = true)
    protected BigInteger tiempoEntrePosiciones;
    @XmlElement(required = true)
    protected BigInteger idGrupoActuadores;

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
     * Gets the value of the posicion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPosicion() {
        return posicion;
    }

    /**
     * Sets the value of the posicion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPosicion(BigInteger value) {
        this.posicion = value;
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
     * Gets the value of the idTipoActuador property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdTipoActuador() {
        return idTipoActuador;
    }

    /**
     * Sets the value of the idTipoActuador property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdTipoActuador(BigInteger value) {
        this.idTipoActuador = value;
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
     * Gets the value of the nroPuertoRetroceso property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNroPuertoRetroceso() {
        return nroPuertoRetroceso;
    }

    /**
     * Sets the value of the nroPuertoRetroceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNroPuertoRetroceso(BigInteger value) {
        this.nroPuertoRetroceso = value;
    }

    /**
     * Gets the value of the tipoPuertoRetroceso property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTipoPuertoRetroceso() {
        return tipoPuertoRetroceso;
    }

    /**
     * Sets the value of the tipoPuertoRetroceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTipoPuertoRetroceso(BigInteger value) {
        this.tipoPuertoRetroceso = value;
    }

    /**
     * Gets the value of the tiempoEntrePosiciones property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTiempoEntrePosiciones() {
        return tiempoEntrePosiciones;
    }

    /**
     * Sets the value of the tiempoEntrePosiciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTiempoEntrePosiciones(BigInteger value) {
        this.tiempoEntrePosiciones = value;
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

}
