/**
 * La clase Placa representa a una placa controladora.
 */
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@XmlRootElement
@Table(name = "placas")
@JsonIgnoreProperties({ "listaDispositivos", "logsEventos", "niveles",
		"factores", "gruposActuadores", "tiposActuadores", "destinatarios" })
public class Placa implements Serializable {

	private static final long serialVersionUID = 6894536552258619248L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private char estado;
	private String nroSerie;
	private String descripcion;
	private int numPuertosAnalogicos;
	private int numPuertosEDigitales;
	private int numPuertosSDigitales;
	private char estadoAlerta;
	private String ipPlaca;
	private int puertoPlaca;
	private int periodicidadLecturas;
	private int periodicidadNiveles;
	private String ipCentralizadora;
	private int puertoCentralizadora;
	private String hostWSSMS;
	private int puertoWSSMS;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
	private Set<Dispositivo> listaDispositivos;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<LogEvento> logsEventos;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<NivelSeveridad> niveles;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Factor> factores;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<GrupoActuadores> gruposActuadores;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<TipoActuador> tiposActuadores;

	@OneToMany(mappedBy = "placa", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Destinatario> destinatarios;

	public Placa() {
		super();
		listaDispositivos = new HashSet<Dispositivo>();
		logsEventos = new HashSet<LogEvento>();
		niveles = new HashSet<NivelSeveridad>();
		factores = new HashSet<Factor>();
		gruposActuadores = new HashSet<GrupoActuadores>();

	}

	/**
	 * @return el identificador de la placa controladora.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			El identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el estado en el que se encuentra la placa (I=Inactivo, C=Configuración, M=Manual, A=Automático)
	 */
	public char getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 * 				El estado a asignar.
	 */
	public void setEstado(char estado) {
		this.estado = estado;
	}

	/**
	 * @return el número de serie de la placa.
	 */
	public String getNroSerie() {
		return nroSerie;
	}

	/**
	 * @param nroSerie
	 * 				El número de serie a asignar.
	 */
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}

	/**
	 * @return la descripción de la placa controladora.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * 					La descripción a asignar.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el número de puertos analógicos.
	 */
	public int getNumPuertosAnalogicos() {
		return numPuertosAnalogicos;
	}

	/**
	 * @param numPuertosAnalogicos
	 * 							El número de puertos analógicos a asignar.
	 */
	public void setNumPuertosAnalogicos(int numPuertosAnalogicos) {
		this.numPuertosAnalogicos = numPuertosAnalogicos;
	}

	/**
	 * @return el número de puertos de entrada digital
	 */
	public int getNumPuertosEDigitales() {
		return numPuertosEDigitales;
	}

	/**
	 * @param numPuertosEDigitales
	 * 						El número de puertos de entrada digital a asignar.
	 */
	public void setNumPuertosEDigitales(int numPuertosEDigitales) {
		this.numPuertosEDigitales = numPuertosEDigitales;
	}

	/**
	 * @return el número de puertos de salida digital
	 */
	public int getNumPuertosSDigitales() {
		return numPuertosSDigitales;
	}

	/**
	 * @param numPuertosSDigitales
	 * 							El número de puertos de salida digital a asignar
	 */
	public void setNumPuertosSDigitales(int numPuertosSDigitales) {
		this.numPuertosSDigitales = numPuertosSDigitales;
	}

	/**
	 * @return el estado de alerta de la placa (S/N)
	 */
	public char getEstadoAlerta() {
		return estadoAlerta;
	}

	/**
	 * @param estadoAlerta
	 * 					El estado de alerta a asignar.
	 */
	public void setEstadoAlerta(char estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}

	/**
	 * @return la dirección IP de la placa.
	 */
	public String getIpPlaca() {
		return ipPlaca;
	}

	/**
	 * @param ipPlaca
	 * 				La IP a asignar.
	 */
	public void setIpPlaca(String ipPlaca) {
		this.ipPlaca = ipPlaca;
	}

	/**
	 * @return el puerto de comunicación con la placa
	 */
	public int getPuertoPlaca() {
		return puertoPlaca;
	}

	/**
	 * @param puertoPlaca
	 * 					El puerto de comunicación con la placa a asignar 					
	 */
	public void setPuetroPlaca(int puertoPlaca) {
		this.puertoPlaca = puertoPlaca;
	}

	/**
	 * @return la periodicidad de lecturas definida.
	 */
	public int getPeriodicidadLecturas() {
		return periodicidadLecturas;
	}

	/**
	 * @param periodicidadLecturas
	 * 							La periodicidad de lecturas a asignar.
	 */
	public void setPeriodicidadLecturas(int periodicidadLecturas) {
		this.periodicidadLecturas = periodicidadLecturas;
	}

	/**
	 * @return la periodicidad de procesado de los niveles de severidad.
	 */
	public int getPeriodicidadNiveles() {
		return periodicidadNiveles;
	}

	/**
	 * @param periodicidadNiveles
	 * 							La periodicidad de procesado de los niveles de severidad a asignar.
	 */
	public void setPeriodicidadNiveles(int periodicidadNiveles) {
		this.periodicidadNiveles = periodicidadNiveles;
	}

	/**
	 * @return la lista de dispositivos pertenecientes a la placa controladora.
	 */
	public Set<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	/**
	 * @param listaDispositivos
	 * 						La lista de dispositivos a asignar.
	 */
	public void setListaDispositivos(Set<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}

	/**
	 * @return la lista de log de eventos de la placa controladora
	 */
	public Set<LogEvento> getLogsEventos() {
		return logsEventos;
	}

	/**
	 * @param logsEventos
	 * 					La lista de log de eventos a asignar.
	 */
	public void setLogsEventos(Set<LogEvento> logsEventos) {
		this.logsEventos = logsEventos;
	}

	/**
	 * @return la lista de niveles de severidad pertenecientes a la placa controladora.
	 */
	public Set<NivelSeveridad> getNiveles() {
		return niveles;
	}

	/**
	 * @param niveles
	 * 				La lista de niveles de severidad a asignar.
	 */
	public void setNiveles(Set<NivelSeveridad> niveles) {
		this.niveles = niveles;
	}

	/**
	 * @return la lista de factores pertenecientesa la placa controladora.
	 */
	public Set<Factor> getFactores() {
		return factores;
	}

	/**
	 * @param factores
	 * 				La lista de factores a asignar.
	 */
	public void setFactores(Set<Factor> factores) {
		this.factores = factores;
	}

	/**
	 * @return la lista de grupos de actuadores pertenecientes a la placa controladora
	 */
	public Set<GrupoActuadores> getGruposActuadores() {
		return gruposActuadores;
	}

	/**
	 * @param gruposActuadores
	 * 						La lista de grupos de actuadores a asignar.
	 */
	public void setGruposActuadores(Set<GrupoActuadores> gruposActuadores) {
		this.gruposActuadores = gruposActuadores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return la dirección IP de la aplicación centralizadora.
	 */
	public String getIpCentralizadora() {
		return ipCentralizadora;
	}

	/**
	 * @param ipCentralizadora
	 * 						La ip de la placa centralizadora a asignar.
	 */
	public void setIpCentralizadora(String ipCentralizadora) {
		this.ipCentralizadora = ipCentralizadora;
	}

	/**
	 * @return el puerto de comunicación de la aplicación centralizadora.
	 */
	public int getPuertoCentralizadora() {
		return puertoCentralizadora;
	}

	/**
	 * @param puertoCentralizadora
	 * 							El puerto de comunicación de la aplicación centralizadora a asignar.
	 */
	public void setPuertoCentralizadora(int puertoCentralizadora) {
		this.puertoCentralizadora = puertoCentralizadora;
	}

	/**
	 * @return el host del servicio web para envío de SMS
	 */
	public String getHostWSSMS() {
		return hostWSSMS;
	}

	/**
	 * @param hostWSSMS
	 * 					El host del servicio web para envío de SMS a asignar.
	 */
	public void setHostWSSMS(String hostWSSMS) {
		this.hostWSSMS = hostWSSMS;
	}

	/**
	 * @return el puerto de comunicación con el servicio web para envío de SMS
	 */
	public int getPuertoWSSMS() {
		return puertoWSSMS;
	}

	/**
	 * @param puertoWSSMS
	 * 					El puerto de comunicación con el servicio web para envío de SMS a asignar.
	 */
	public void setPuertoWSSMS(int puertoWSSMS) {
		this.puertoWSSMS = puertoWSSMS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + estado;
		result = prime * result + estadoAlerta;
		result = prime * result
				+ ((hostWSSMS == null) ? 0 : hostWSSMS.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((ipCentralizadora == null) ? 0 : ipCentralizadora.hashCode());
		result = prime * result + ((ipPlaca == null) ? 0 : ipPlaca.hashCode());
		result = prime * result
				+ ((nroSerie == null) ? 0 : nroSerie.hashCode());
		result = prime * result + numPuertosAnalogicos;
		result = prime * result + numPuertosEDigitales;
		result = prime * result + numPuertosSDigitales;
		result = prime * result + periodicidadLecturas;
		result = prime * result + periodicidadNiveles;
		result = prime * result + puertoCentralizadora;
		result = prime * result + puertoWSSMS;
		result = prime * result + puertoPlaca;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placa other = (Placa) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado != other.estado)
			return false;
		if (estadoAlerta != other.estadoAlerta)
			return false;
		if (hostWSSMS == null) {
			if (other.hostWSSMS != null)
				return false;
		} else if (!hostWSSMS.equals(other.hostWSSMS))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipCentralizadora == null) {
			if (other.ipCentralizadora != null)
				return false;
		} else if (!ipCentralizadora.equals(other.ipCentralizadora))
			return false;
		if (ipPlaca == null) {
			if (other.ipPlaca != null)
				return false;
		} else if (!ipPlaca.equals(other.ipPlaca))
			return false;
		if (nroSerie == null) {
			if (other.nroSerie != null)
				return false;
		} else if (!nroSerie.equals(other.nroSerie))
			return false;
		if (numPuertosAnalogicos != other.numPuertosAnalogicos)
			return false;
		if (numPuertosEDigitales != other.numPuertosEDigitales)
			return false;
		if (numPuertosSDigitales != other.numPuertosSDigitales)
			return false;
		if (periodicidadLecturas != other.periodicidadLecturas)
			return false;
		if (periodicidadNiveles != other.periodicidadNiveles)
			return false;
		if (puertoCentralizadora != other.puertoCentralizadora)
			return false;
		if (puertoWSSMS != other.puertoWSSMS)
			return false;
		if (puertoPlaca != other.puertoPlaca)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Placa [id=" + id + ", estado=" + estado + ", nroSerie="
				+ nroSerie + ", descripcion=" + descripcion
				+ ", numPuertosAnalogicos=" + numPuertosAnalogicos
				+ ", numPuertosEDigitales=" + numPuertosEDigitales
				+ ", numPuertosSDigitales=" + numPuertosSDigitales
				+ ", estadoAlerta=" + estadoAlerta + ", ipPlaca=" + ipPlaca
				+ ", puetroPlaca=" + puertoPlaca + ", periodicidadLecturas="
				+ periodicidadLecturas + ", periodicidadNiveles="
				+ periodicidadNiveles + ", ipCentralizadora="
				+ ipCentralizadora + ", puertoCentralizadora="
				+ puertoCentralizadora + ", hostWSSMS=" + hostWSSMS
				+ ", puertoWSSMS=" + puertoWSSMS + "]";
	}

}