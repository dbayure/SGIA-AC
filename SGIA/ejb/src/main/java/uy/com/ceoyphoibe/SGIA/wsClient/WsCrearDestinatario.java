package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearDestinatario complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearDestinatario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="celular" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="horaMin" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="horaMax" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearDestinatario", propOrder = { "nombre", "celular",
		"mail", "horaMin", "horaMax" })
public class WsCrearDestinatario {

	@XmlElement(required = true)
	protected String nombre;
	@XmlElement(required = true)
	protected String celular;
	@XmlElement(required = true)
	protected String mail;
	@XmlElement(required = true)
	protected BigInteger horaMin;
	@XmlElement(required = true)
	protected BigInteger horaMax;

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
	 * Gets the value of the celular property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Sets the value of the celular property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCelular(String value) {
		this.celular = value;
	}

	/**
	 * Gets the value of the mail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the value of the mail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMail(String value) {
		this.mail = value;
	}

	/**
	 * Gets the value of the horaMin property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getHoraMin() {
		return horaMin;
	}

	/**
	 * Sets the value of the horaMin property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setHoraMin(BigInteger value) {
		this.horaMin = value;
	}

	/**
	 * Gets the value of the horaMax property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getHoraMax() {
		return horaMax;
	}

	/**
	 * Sets the value of the horaMax property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setHoraMax(BigInteger value) {
		this.horaMax = value;
	}

}
