package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoPlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoPlacaAuxiliar;

@ManagedBean
@RequestScoped
public class TipoPlacaAuxiliarBean {

	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	@Inject
	private RegistroTipoPlacaAuxiliar registroTipoPlacaAuxiliar;

	private TipoPlacaAuxiliar tipoPlacaAuxiliar = new TipoPlacaAuxiliar();
	
	@Inject
	private RegistroMensaje registroMensaje;

	/**
	 * @return the tipoPlacaAuxiliar
	 */
	public TipoPlacaAuxiliar getTipoPlacaAuxiliar() {
		return tipoPlacaAuxiliar;
	}

	/**
	 * @param tipoPlacaAuxiliar
	 *            the tipoPlacaAuxiliar to set
	 */
	public void setTipoPlacaAuxiliar(TipoPlacaAuxiliar tipoPlacaAuxiliar) {
		this.tipoPlacaAuxiliar = tipoPlacaAuxiliar;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public void registrar() {
		if (placa.getEstado() == 'C')
		{
			try {
				tipoPlacaAuxiliar.setPlaca(placa);
				registroTipoPlacaAuxiliar.registro(tipoPlacaAuxiliar);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				tipoPlacaAuxiliar = new TipoPlacaAuxiliar();
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Error al registrar ", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 33);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEdit(RowEditEvent event) {
		if (placa.getEstado() == 'C')
		{
			TipoPlacaAuxiliar tipoPlaca = ((TipoPlacaAuxiliar) event.getObject());
	
			try {
				Mensaje mensaje = registroTipoPlacaAuxiliar.modificar(tipoPlaca);
				if (mensaje.getTipo().equals("Informativo")) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
							mensaje.getTexto(), "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					FacesMessage msg = new FacesMessage(
							FacesMessage.SEVERITY_ERROR, mensaje.getTexto(), "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Error al modificar ", tipoPlaca.getNombre());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 33);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((TipoPlacaAuxiliar) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		if (placa.getEstado() == 'C')
		{
			try {
				registroTipoPlacaAuxiliar.eliminar(id);
				FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage("Error al eliminar",
						id.toString());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 33);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
