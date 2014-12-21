package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoPlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoPlacaAuxiliar;

@ManagedBean
@RequestScoped
public class TipoPlacaAuxiliarBean {

	@ManagedProperty("#{placaBean.placa}")
    private Placa placa; 
	
	@Inject
	private RegistroTipoPlacaAuxiliar registroTipoPlacaAuxiliar;
	
	private TipoPlacaAuxiliar tipoPlacaAuxiliar= new TipoPlacaAuxiliar();

	
	
	/**
	 * @return the tipoPlacaAuxiliar
	 */
	public TipoPlacaAuxiliar getTipoPlacaAuxiliar() {
		return tipoPlacaAuxiliar;
	}

	/**
	 * @param tipoPlacaAuxiliar the tipoPlacaAuxiliar to set
	 */
	public void setTipoPlacaAuxiliar(TipoPlacaAuxiliar tipoPlacaAuxiliar) {
		this.tipoPlacaAuxiliar = tipoPlacaAuxiliar;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public void registrar() {
		try {
			tipoPlacaAuxiliar.setPlaca(placa);
			registroTipoPlacaAuxiliar.registro(tipoPlacaAuxiliar);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        tipoPlacaAuxiliar= new TipoPlacaAuxiliar();
		}
		catch (Exception e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	
	public void onEdit(RowEditEvent event) {  
            TipoPlacaAuxiliar tipoPlaca = ((TipoPlacaAuxiliar) event.getObject());
           
            try {
            	registroTipoPlacaAuxiliar.modificar(tipoPlaca);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", tipoPlaca.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", tipoPlaca.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
    }
	
	public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((TipoPlacaAuxiliar) event.getObject()).getNombre());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void eliminar(Long id) {
		try {
			registroTipoPlacaAuxiliar.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
	}
}