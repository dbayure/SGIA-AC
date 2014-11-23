package uy.com.ceoyphoibe.sgia.bean;

import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroPosicion;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
import uy.com.ceoyphoibe.SGIA.model.Sensor;

@ManagedBean
@ViewScoped
public class PosicionBean {

	@Inject
	private RegistroPosicion registroPosicion;
	
	private Set<Sensor> listaSensores;
	
	
	/**
	 * @return the registroPosicion
	 */
	public RegistroPosicion getRegistroPosicion() {
		return registroPosicion;
	}

	/**
	 * @param registroPosicion the registroPosicion to set
	 */
	public void setRegistroPosicion(RegistroPosicion registroPosicion) {
		this.registroPosicion = registroPosicion;
	}

	/**
	 * @return the listaSensores
	 */
	public Set<Sensor> getListaSensores() {
		return listaSensores;
	}

	/**
	 * @param listaSensores the listaSensores to set
	 */
	public void setListaSensores(Set<Sensor> listaSensores) {
		this.listaSensores = listaSensores;
	}

	

	public void registrar() {
		try {
			registroPosicion.registro();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch (Exception e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	
	public void onEdit(RowEditEvent event) {  
            Posicion posicion = ((Posicion) event.getObject());
           
            try {

            	posicion.setListaSensores(listaSensores);
            	registroPosicion.modificar(posicion);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", posicion.getDescripcion());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", posicion.getDescripcion());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
    }
	
	public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((Posicion) event.getObject()).getDescripcion());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void eliminar(Long id) {
		try {
			registroPosicion.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
	}
}
