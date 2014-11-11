package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoLogEvento;
import uy.com.ceoyphoibe.SGIA.model.Destinatario;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;



@ManagedBean
@ViewScoped
public class TipoLogEventoBean {

	@Inject
	private RegistroTipoLogEvento registroTipoLogEvento;
	
	private TipoLogEvento tipoLogEventoSeleccionado;
	private Destinatario destinatarioSeleccionado;
	private int control;
	private List<Destinatario> listaDestinatarios;
	
	
	
	/**
	 * @return the destinatarioSeleccionado
	 */
	public Destinatario getDestinatarioSeleccionado() {
		return destinatarioSeleccionado;
	}

	/**
	 * @return the listaDestinatarios
	 */
	public List<Destinatario> getListaDestinatarios() {
		return listaDestinatarios;
	}

	/**
	 * @param listaDestinatarios the listaDestinatarios to set
	 */
	public void setListaDestinatarios(List<Destinatario> listaDestinatarios) {
		this.listaDestinatarios = listaDestinatarios;
	}

	/**
	 * @return the control
	 */
	public int getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(int control) {
		this.control = control;
	}

	/**
	 * @param destinatarioSeleccionado the destinatarioSeleccionado to set
	 */
	public void setDestinatarioSeleccionado(Destinatario destinatarioSeleccionado) {
		this.destinatarioSeleccionado = destinatarioSeleccionado;

	}

	/**
	 * @return the tipoLogEventoSeleccionado
	 */
	public TipoLogEvento getTipoLogEventoSeleccionado() {
		return tipoLogEventoSeleccionado;

	}

	/**
	 * @param tipoLogEventoSeleccionado the tipoLogEventoSeleccionado to set
	 */
	public void setTipoLogEventoSeleccionado(TipoLogEvento tipoLogEventoSeleccionado) {
		this.tipoLogEventoSeleccionado = tipoLogEventoSeleccionado;
		this.control= 1;
	}

	/**
	 * @return the registroTipoLogEvento
	 */
	public RegistroTipoLogEvento getRegistroTipoLogEvento() {
		return registroTipoLogEvento;
	}

	/**
	 * @param registroTipoLogEvento the registroTipoLogEvento to set
	 */
	public void setRegistroTipoLogEvento(RegistroTipoLogEvento registroTipoLogEvento) {
		this.registroTipoLogEvento = registroTipoLogEvento;
	}

	public void registrar() {
		try {
			registroTipoLogEvento.registro();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch (Exception e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	
	public void modificar () {  
        
       
        try {
        	tipoLogEventoSeleccionado.setListaDestinatarios(listaDestinatarios);
        	ArrayList<Destinatario> dests= (ArrayList<Destinatario>) tipoLogEventoSeleccionado.getListaDestinatarios();
        	System.out.println("tamaño de lista: "+ dests.size());
        	tipoLogEventoSeleccionado.setListaDestinatarios(dests);
        	registroTipoLogEvento.modificar(tipoLogEventoSeleccionado);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", tipoLogEventoSeleccionado.getNombre());  
            FacesContext.getCurrentInstance().addMessage(null, msg); 
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", tipoLogEventoSeleccionado.getNombre());  
            FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	

	public void onEdit(RowEditEvent event) {  
            TipoLogEvento tipoLogEvento = ((TipoLogEvento) event.getObject());
           
            try {

            	tipoLogEvento.setListaDestinatarios(listaDestinatarios);
            	registroTipoLogEvento.modificar(tipoLogEvento);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", tipoLogEvento.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", tipoLogEvento.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
    }
	
	public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((TipoLogEvento) event.getObject()).getNombre());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void eliminar(Long id) {
		try {
			registroTipoLogEvento.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
	}
}
