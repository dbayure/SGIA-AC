package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroLogEvento;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.LogEvento;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;


@ManagedBean
@RequestScoped
public class LogEventoBean {

	@Inject
	private RegistroLogEvento registroLogEvento;
	
	private TipoLogEvento tipoLogEvento;
	private Mensaje mensaje;
	private Dispositivo dispositivo;
	
	public void registrar() {
		try {
			registroLogEvento.registro();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch (Exception e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	
	
	
	/**
	 * @return the tipoLogEvento
	 */
	public TipoLogEvento getTipoLogEvento() {
		return tipoLogEvento;
	}



	/**
	 * @param tipoLogEvento the tipoLogEvento to set
	 */
	public void setTipoLogEvento(TipoLogEvento tipoLogEvento) {
		this.tipoLogEvento = tipoLogEvento;
	}



	/**
	 * @return the mensaje
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}



	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}



	/**
	 * @return the dispositivo
	 */
	public Dispositivo getDispositivo() {
		return dispositivo;
	}



	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}



	public void onEdit(RowEditEvent event) {  
            LogEvento logEvento = ((LogEvento) event.getObject());
           
            try {
            	registroLogEvento.modificar(logEvento);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", logEvento.getIdLogEvento().toString());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", logEvento.getIdLogEvento().toString());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
    }
	
	public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((LogEvento) event.getObject()).getIdLogEvento().toString());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void eliminar(Long id) {
		try {
			registroLogEvento.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
	}
}
