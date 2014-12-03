package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "placaAuxiliar")
public class PlacaAuxiliar extends Dispositivo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1207751157271188774L;
	
	private String numeroSerie;
	private String tipo;
	private int numeroPuertoAnal;
	private int numeroPuertoEDig;
	private int numeroPuertoSdig;
	
	@OneToMany( mappedBy = "padre", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER )
    private List<Dispositivo> listaDispositivos;
	
	
	
	
	/**
	 * @return the listaDispositivos
	 */
	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}
	/**
	 * @param listaDispositivos the listaDispositivos to set
	 */
	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumeroPuertoAnal() {
		return numeroPuertoAnal;
	}
	public void setNumeroPuertoAnal(int numeroPuertoAnal) {
		this.numeroPuertoAnal = numeroPuertoAnal;
	}
	public int getNumeroPuertoEDig() {
		return numeroPuertoEDig;
	}
	public void setNumeroPuertoEDig(int numeroPuertoEDig) {
		this.numeroPuertoEDig = numeroPuertoEDig;
	}
	public int getNumeroPuertoSdig() {
		return numeroPuertoSdig;
	}
	public void setNumeroPuertoSdig(int numeroPuertoSdig) {
		this.numeroPuertoSdig = numeroPuertoSdig;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numeroPuertoAnal;
		result = prime * result + numeroPuertoEDig;
		result = prime * result + numeroPuertoSdig;
		result = prime * result
				+ ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacaAuxiliar other = (PlacaAuxiliar) obj;
		if (numeroPuertoAnal != other.numeroPuertoAnal)
			return false;
		if (numeroPuertoEDig != other.numeroPuertoEDig)
			return false;
		if (numeroPuertoSdig != other.numeroPuertoSdig)
			return false;
		if (numeroSerie == null) {
			if (other.numeroSerie != null)
				return false;
		} else if (!numeroSerie.equals(other.numeroSerie))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PlacaAuxiliar [numeroSerie=" + numeroSerie + ", tipo=" + tipo
				+ ", numeroPuertoAnal=" + numeroPuertoAnal
				+ ", numeroPuertoEDig=" + numeroPuertoEDig
				+ ", numeroPuertoSdig=" + numeroPuertoSdig + "]";
	}
	
}
