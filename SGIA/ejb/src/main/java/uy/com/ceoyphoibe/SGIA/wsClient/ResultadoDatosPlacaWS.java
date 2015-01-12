package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ResultadoDatosPlacaWS complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ResultadoDatosPlacaWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="puertoWS_Centralizadora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="periodicidadNiveles" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="nroSeriePlaca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puertoWS_SMS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoAlerta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoPlaca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="periodicidadLecturas" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="hostWS_SMS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hostWS_Centralizadora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultadoDatosPlacaWS", propOrder = {
		"puertoWSCentralizadora", "periodicidadNiveles", "nroSeriePlaca",
		"puertoWSSMS", "estadoAlerta", "estadoPlaca", "periodicidadLecturas",
		"hostWSSMS", "hostWSCentralizadora" })
public class ResultadoDatosPlacaWS {

	@XmlElement(name = "puertoWS_Centralizadora")
	protected String puertoWSCentralizadora;
	protected BigInteger periodicidadNiveles;
	protected String nroSeriePlaca;
	@XmlElement(name = "puertoWS_SMS")
	protected String puertoWSSMS;
	protected String estadoAlerta;
	protected String estadoPlaca;
	protected BigInteger periodicidadLecturas;
	@XmlElement(name = "hostWS_SMS")
	protected String hostWSSMS;
	@XmlElement(name = "hostWS_Centralizadora")
	protected String hostWSCentralizadora;

	/**
	 * Gets the value of the puertoWSCentralizadora property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPuertoWSCentralizadora() {
		return puertoWSCentralizadora;
	}

	/**
	 * Sets the value of the puertoWSCentralizadora property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPuertoWSCentralizadora(String value) {
		this.puertoWSCentralizadora = value;
	}

	/**
	 * Gets the value of the periodicidadNiveles property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getPeriodicidadNiveles() {
		return periodicidadNiveles;
	}

	/**
	 * Sets the value of the periodicidadNiveles property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setPeriodicidadNiveles(BigInteger value) {
		this.periodicidadNiveles = value;
	}

	/**
	 * Gets the value of the nroSeriePlaca property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNroSeriePlaca() {
		return nroSeriePlaca;
	}

	/**
	 * Sets the value of the nroSeriePlaca property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNroSeriePlaca(String value) {
		this.nroSeriePlaca = value;
	}

	/**
	 * Gets the value of the puertoWSSMS property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPuertoWSSMS() {
		return puertoWSSMS;
	}

	/**
	 * Sets the value of the puertoWSSMS property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPuertoWSSMS(String value) {
		this.puertoWSSMS = value;
	}

	/**
	 * Gets the value of the estadoAlerta property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEstadoAlerta() {
		return estadoAlerta;
	}

	/**
	 * Sets the value of the estadoAlerta property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEstadoAlerta(String value) {
		this.estadoAlerta = value;
	}

	/**
	 * Gets the value of the estadoPlaca property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEstadoPlaca() {
		return estadoPlaca;
	}

	/**
	 * Sets the value of the estadoPlaca property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEstadoPlaca(String value) {
		this.estadoPlaca = value;
	}

	/**
	 * Gets the value of the periodicidadLecturas property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getPeriodicidadLecturas() {
		return periodicidadLecturas;
	}

	/**
	 * Sets the value of the periodicidadLecturas property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setPeriodicidadLecturas(BigInteger value) {
		this.periodicidadLecturas = value;
	}

	/**
	 * Gets the value of the hostWSSMS property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHostWSSMS() {
		return hostWSSMS;
	}

	/**
	 * Sets the value of the hostWSSMS property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHostWSSMS(String value) {
		this.hostWSSMS = value;
	}

	/**
	 * Gets the value of the hostWSCentralizadora property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHostWSCentralizadora() {
		return hostWSCentralizadora;
	}

	/**
	 * Sets the value of the hostWSCentralizadora property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHostWSCentralizadora(String value) {
		this.hostWSCentralizadora = value;
	}

}
