package uy.com.ceoyphoibe.sgia.bean;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroNivelSeveridad;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.NivelSeveridad;
import uy.com.ceoyphoibe.SGIA.model.Posicion;

@ManagedBean
@SessionScoped
public class NivelSeveridadBean {


	@Inject
	private RegistroNivelSeveridad registroNivelSeveridad;
	
	private NivelSeveridad nivelSeveridadSeleccionado = new NivelSeveridad();

	private Set<FilaPerfilActivacion> perfilActivacion= new HashSet<FilaPerfilActivacion>();
	
	private FilaPerfilActivacion filaPerfilTemp= new FilaPerfilActivacion();
	
	private GrupoActuadores grupoTemp= new GrupoActuadores();
	
	private boolean estadoTemp;
	
	private Set<Posicion> posicionesDisponibles= new HashSet<Posicion>();
	
	private int posicionTemp;
	
	private Factor factorTemp;


	/**
	 * @return the nivelSeveridadSeleccionado
	 */
	public NivelSeveridad getNivelSeveridadSeleccionado() {
		return nivelSeveridadSeleccionado;
	}

	/**
	 * @param nivelSeveridadSeleccionado the nivelSeveridadSeleccionado to set
	 */
	public void setNivelSeveridadSeleccionado(
			NivelSeveridad nivelSeveridadSeleccionado) {
		this.nivelSeveridadSeleccionado = nivelSeveridadSeleccionado;
	}

	/**
	 * @return the perfilActivacion
	 */
	public Set<FilaPerfilActivacion> getPerfilActivacion() {
		return perfilActivacion;
	}
	
	

	/**
	 * @return the filaPerfilTemp
	 */
	public FilaPerfilActivacion getFilaPerfilTemp() {
		return filaPerfilTemp;
	}

	/**
	 * @param filaPerfilTemp the filaPerfilTemp to set
	 */
	public void setFilaPerfilTemp(FilaPerfilActivacion filaPerfilTemp) {
		this.filaPerfilTemp = filaPerfilTemp;
	}

	/**
	 * @param perfilActivacion the perfilActivacion to set
	 */
	public void setPerfilActivacion(Set<FilaPerfilActivacion> perfilActivacion) {
		this.perfilActivacion = perfilActivacion;
	}
	
	public void seleccionGrupoActuadores()
	{
		if (grupoTemp.getDeAvance().equals("S"))
		{
			Iterator<ActuadorAvance> itActuadores= grupoTemp.getActuadoresAvance().iterator();
			if (itActuadores.hasNext())
				posicionesDisponibles= itActuadores.next().getListaPosiciones();
		}
	}
	
	public void agregarFilaPerfil()
	{
		filaPerfilTemp.setGrupoActuadores(grupoTemp);
		if (grupoTemp.getDeAvance().equals("S"))
		{
			filaPerfilTemp.setEstado(Integer.toString(posicionTemp));
		}
		else
		{
			if (estadoTemp)
				filaPerfilTemp.setEstado("E");
			else
				filaPerfilTemp.setEstado("A");
		}
		perfilActivacion.add(filaPerfilTemp);
		filaPerfilTemp= new FilaPerfilActivacion();
	}
	
	public void eliminarFilaPerfil(FilaPerfilActivacion fila)
	{
		
		perfilActivacion.remove(fila);
		System.out.println("Tamaño de la lista temp_1: "+perfilActivacion.size());
	//	filaPerfilTemp= new FilaPerfilActivacion();
	}

	public void registrar() {
		try {

			nivelSeveridadSeleccionado.setActivoSistema("S");
			nivelSeveridadSeleccionado.setPerfilActivacion(perfilActivacion);
			nivelSeveridadSeleccionado.setFactor(factorTemp);
			registroNivelSeveridad.registro(nivelSeveridadSeleccionado);
			nivelSeveridadSeleccionado= new NivelSeveridad();
			perfilActivacion= new HashSet<FilaPerfilActivacion>();
			grupoTemp= new GrupoActuadores();
			factorTemp= new Factor();
			posicionesDisponibles= new HashSet<Posicion>();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}



	public void onEdit(Long id) {
		NivelSeveridad nivelSeveridad = registroNivelSeveridad.obtenerNivelSeveridadPorId(id);
		try {
			nivelSeveridadSeleccionado= new NivelSeveridad();
			perfilActivacion= new HashSet<FilaPerfilActivacion>();
			grupoTemp= new GrupoActuadores();
			posicionesDisponibles= new HashSet<Posicion>();
			nivelSeveridadSeleccionado= nivelSeveridad;
			perfilActivacion= nivelSeveridad.getPerfilActivacion();
			factorTemp= nivelSeveridad.getFactor();
			
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", nivelSeveridad.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void onEditFila(RowEditEvent event) {
		FilaPerfilActivacion fila = ((FilaPerfilActivacion) event.getObject());
		try {
			Iterator<FilaPerfilActivacion> itPerfil= perfilActivacion.iterator();
			filaPerfilTemp= itPerfil.next();
			while (filaPerfilTemp.getGrupoActuadores().getId() != fila.getGrupoActuadores().getId())
				filaPerfilTemp= itPerfil.next();
			System.out.println("va a cambiar el estado del grupo: "+filaPerfilTemp.getGrupoActuadores().getNombre());
			filaPerfilTemp.setEstado(fila.getEstado());
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", fila.getGrupoActuadores().getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", fila.getGrupoActuadores().getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}


	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((NivelSeveridad) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onCancelFila(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar perfil de activación de ",
				((FilaPerfilActivacion) event.getObject()).getGrupoActuadores().getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			registroNivelSeveridad.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
	
	public void clonar(Long id) {
		try {
			nivelSeveridadSeleccionado= new NivelSeveridad();
			NivelSeveridad nivelTemp= registroNivelSeveridad.obtenerNivelSeveridadPorId(id);
			nivelSeveridadSeleccionado.setActivoSistema("S");
			factorTemp= nivelTemp.getFactor();
//			System.out.println("'''''''''''''''''''Con el factor: "+nivelTemp.getFactor().getNombre());
//			nivelSeveridadSeleccionado.setFactor(factorTemp);
			nivelSeveridadSeleccionado.setPrioridad(nivelTemp.getPrioridad());
			perfilActivacion= new HashSet<FilaPerfilActivacion>();
			Iterator<FilaPerfilActivacion> perfiltemp= nivelTemp.getPerfilActivacion().iterator();
			while (perfiltemp.hasNext())
			{
				FilaPerfilActivacion filaTemp=perfiltemp.next();
				filaPerfilTemp= new FilaPerfilActivacion();
				filaPerfilTemp.setGrupoActuadores(filaTemp.getGrupoActuadores());
				filaPerfilTemp.setEstado(filaTemp.getEstado());
				perfilActivacion.add(filaPerfilTemp);
			}

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al clonar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	/**
	 * @return the grupoTemp
	 */
	public GrupoActuadores getGrupoTemp() {
		return grupoTemp;
	}

	/**
	 * @param grupoTemp the grupoTemp to set
	 */
	public void setGrupoTemp(GrupoActuadores grupoTemp) {
		this.grupoTemp = grupoTemp;
	}

	/**
	 * @return the estadoTemp
	 */
	public boolean isEstadoTemp() {
		return estadoTemp;
	}

	/**
	 * @param estadoTemp the estadoTemp to set
	 */
	public void setEstadoTemp(boolean estadoTemp) {
		this.estadoTemp = estadoTemp;
	}

	/**
	 * @return the posicionesDisponibles
	 */
	public Set<Posicion> getPosicionesDisponibles() {
		return posicionesDisponibles;
	}

	/**
	 * @param posicionesDisponibles the posicionesDisponibles to set
	 */
	public void setPosicionesDisponibles(Set<Posicion> posicionesDisponibles) {
		this.posicionesDisponibles = posicionesDisponibles;
	}

	/**
	 * @return the posicionTemp
	 */
	public int getPosicionTemp() {
		return posicionTemp;
	}

	/**
	 * @param posicionTemp the posicionTemp to set
	 */
	public void setPosicionTemp(int posicionTemp) {
		this.posicionTemp = posicionTemp;
	}

	/**
	 * @return the factorTemp
	 */
	public Factor getFactorTemp() {
		return factorTemp;
	}

	/**
	 * @param factorTemp the factorTemp to set
	 */
	public void setFactorTemp(Factor factorTemp) {
		this.factorTemp = factorTemp;
	}

}
