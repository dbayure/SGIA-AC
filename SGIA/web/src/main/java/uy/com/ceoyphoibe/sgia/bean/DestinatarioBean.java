package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroDestinatario;
import uy.com.ceoyphoibe.SGIA.model.Destinatario;


@ManagedBean
@RequestScoped
public class DestinatarioBean {

	@Inject
	private RegistroDestinatario registroDestinatario;
	
	private Destinatario destinatarioSeleccionado = new Destinatario();
	
	/**
	 * 
	 */
	public DestinatarioBean() {
		destinatarioSeleccionado.setHoraMin(0);
		destinatarioSeleccionado.setHoraMax(23);
	}

	/**
	 * @return the destinatarioSeleccionado
	 */
	public Destinatario getDestinatarioSeleccionado() {
		return destinatarioSeleccionado;
	}

	/**
	 * @param destinatarioSeleccionado the destinatarioSeleccionado to set
	 */
	public void setDestinatarioSeleccionado(Destinatario destinatarioSeleccionado) {
		this.destinatarioSeleccionado = destinatarioSeleccionado;
	}

	public void registrar() {
		try {
			destinatarioSeleccionado.setActivoSistema('S');
			registroDestinatario.registro(destinatarioSeleccionado);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        destinatarioSeleccionado= new Destinatario();
	        destinatarioSeleccionado.setHoraMin(0);
			destinatarioSeleccionado.setHoraMax(23);
		}
		catch (Exception e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	
	public void onEdit(RowEditEvent event) {  
            Destinatario destinatario = ((Destinatario) event.getObject());
           
            try {
            	registroDestinatario.modificar(destinatario);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", destinatario.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", destinatario.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
    }
	
	public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((Destinatario) event.getObject()).getNombre());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void eliminar(Long id) {
		try {
			registroDestinatario.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
	}
}
