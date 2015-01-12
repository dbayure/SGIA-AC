package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearPlacaAuxiliar complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearPlacaAuxiliar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroPuerto" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nroSerie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idTipoPlaca" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="idPlacaPadre" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearPlacaAuxiliar", propOrder = { "nombre", "modelo",
		"nroPuerto", "nroSerie", "idTipoPlaca", "idPlacaPadre" })
public class WsCrearPlacaAuxiliar {

	@XmlElement(required = true)
	protected String nombre;
	@XmlElement(required = true)
	protected String modelo;
	@XmlElement(required = true)
	protected BigInteger nroPuerto;
	@XmlElement(required = true)
	protected String nroSerie;
	@XmlElement(required = true)
	protected BigInteger idTipoPlaca;
	@XmlElement(required = true)
	protected BigInteger idPlacaPadre;

	/**
	 * Gets the value of the nombre property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the value of the nombre property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}

	/**
	 * Gets the value of the modelo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Sets the value of the modelo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setModelo(String value) {
		this.modelo = value;
	}

	/**
	 * Gets the value of the nroPuerto property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getNroPuerto() {
		return nroPuerto;
	}

	/**
	 * Sets the value of the nroPuerto property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setNroPuerto(BigInteger value) {
		this.nroPuerto = value;
	}

	/**
	 * Gets the value of the nroSerie property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNroSerie() {
		return nroSerie;
	}

	/**
	 * Sets the value of the nroSerie property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNroSerie(String value) {
		this.nroSerie = value;
	}

	/**
	 * Gets the value of the idTipoPlaca property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getIdTipoPlaca() {
		return idTipoPlaca;
	}

	/**
	 * Sets the value of the idTipoPlaca property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setIdTipoPlaca(BigInteger value) {
		this.idTipoPlaca = value;
	}

	/**
	 * Gets the value of the idPlacaPadre property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getIdPlacaPadre() {
		return idPlacaPadre;
	}

	/**
	 * Sets the value of the idPlacaPadre property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setIdPlacaPadre(BigInteger value) {
		this.idPlacaPadre = value;
	}

}
