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

	/**
	 * 
	 */
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
	private int puetroPlaca;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumPuertosAnalogicos() {
		return numPuertosAnalogicos;
	}

	public void setNumPuertosAnalogicos(int numPuertosAnalogicos) {
		this.numPuertosAnalogicos = numPuertosAnalogicos;
	}

	public int getNumPuertosEDigitales() {
		return numPuertosEDigitales;
	}

	public void setNumPuertosEDigitales(int numPuertosEDigitales) {
		this.numPuertosEDigitales = numPuertosEDigitales;
	}

	public int getNumPuertosSDigitales() {
		return numPuertosSDigitales;
	}

	public void setNumPuertosSDigitales(int numPuertosSDigitales) {
		this.numPuertosSDigitales = numPuertosSDigitales;
	}

	public char getEstadoAlerta() {
		return estadoAlerta;
	}

	public void setEstadoAlerta(char estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}

	public String getIpPlaca() {
		return ipPlaca;
	}

	public void setIpPlaca(String ipPlaca) {
		this.ipPlaca = ipPlaca;
	}

	public int getPuetroPlaca() {
		return puetroPlaca;
	}

	public void setPuetroPlaca(int puetroPlaca) {
		this.puetroPlaca = puetroPlaca;
	}

	public int getPeriodicidadLecturas() {
		return periodicidadLecturas;
	}

	public void setPeriodicidadLecturas(int periodicidadLecturas) {
		this.periodicidadLecturas = periodicidadLecturas;
	}

	public int getPeriodicidadNiveles() {
		return periodicidadNiveles;
	}

	public void setPeriodicidadNiveles(int periodicidadNiveles) {
		this.periodicidadNiveles = periodicidadNiveles;
	}

	public Set<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(Set<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}

	public Set<LogEvento> getLogsEventos() {
		return logsEventos;
	}

	public void setLogsEventos(Set<LogEvento> logsEventos) {
		this.logsEventos = logsEventos;
	}

	public Set<NivelSeveridad> getNiveles() {
		return niveles;
	}

	public void setNiveles(Set<NivelSeveridad> niveles) {
		this.niveles = niveles;
	}

	public Set<Factor> getFactores() {
		return factores;
	}

	public void setFactores(Set<Factor> factores) {
		this.factores = factores;
	}

	public Set<GrupoActuadores> getGruposActuadores() {
		return gruposActuadores;
	}

	public void setGruposActuadores(Set<GrupoActuadores> gruposActuadores) {
		this.gruposActuadores = gruposActuadores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIpCentralizadora() {
		return ipCentralizadora;
	}

	public void setIpCentralizadora(String ipCentralizadora) {
		this.ipCentralizadora = ipCentralizadora;
	}

	public int getPuertoCentralizadora() {
		return puertoCentralizadora;
	}

	public void setPuertoCentralizadora(int puertoCentralizadora) {
		this.puertoCentralizadora = puertoCentralizadora;
	}

	public String getHostWSSMS() {
		return hostWSSMS;
	}

	public void setHostWSSMS(String hostWSSMS) {
		this.hostWSSMS = hostWSSMS;
	}

	public int getPuertoWSSMS() {
		return puertoWSSMS;
	}

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
		result = prime * result + puetroPlaca;
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
		if (puetroPlaca != other.puetroPlaca)
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
				+ ", puetroPlaca=" + puetroPlaca + ", periodicidadLecturas="
				+ periodicidadLecturas + ", periodicidadNiveles="
				+ periodicidadNiveles + ", ipCentralizadora="
				+ ipCentralizadora + ", puertoCentralizadora="
				+ puertoCentralizadora + ", hostWSSMS=" + hostWSSMS
				+ ", puertoWSSMS=" + puertoWSSMS + "]";
	}

}