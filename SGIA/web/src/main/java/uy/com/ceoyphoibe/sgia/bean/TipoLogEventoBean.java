package uy.com.ceoyphoibe.sgia.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoLogEvento;
import uy.com.ceoyphoibe.SGIA.model.Destinatario;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;
/**
 * La clase TipoLogEventoBean controla a las páginas de la vista relacionadas a los tipos de log de eventos y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 */
@ManagedBean
@ViewScoped
public class TipoLogEventoBean {

	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	@Inject
	private RegistroTipoLogEvento registroTipoLogEvento;
	
	@Inject
	private RegistroMensaje registroMensaje;

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
	 * @param listaDestinatarios
	 *            the listaDestinatarios to set
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
	 * @param control
	 *            the control to set
	 */
	public void setControl(int control) {
		this.control = control;
	}

	/**
	 * @param destinatarioSeleccionado
	 *            the destinatarioSeleccionado to set
	 */
	public void setDestinatarioSeleccionado(
			Destinatario destinatarioSeleccionado) {
		this.destinatarioSeleccionado = destinatarioSeleccionado;

	}

	/**
	 * @return the tipoLogEventoSeleccionado
	 */
	public TipoLogEvento getTipoLogEventoSeleccionado() {
		return tipoLogEventoSeleccionado;

	}

	/**
	 * @param tipoLogEventoSeleccionado
	 *            the tipoLogEventoSeleccionado to set
	 */
	public void setTipoLogEventoSeleccionado(
			TipoLogEvento tipoLogEventoSeleccionado) {
		this.tipoLogEventoSeleccionado = tipoLogEventoSeleccionado;
		this.control = 1;
	}

	/**
	 * @return the registroTipoLogEvento
	 */
	public RegistroTipoLogEvento getRegistroTipoLogEvento() {
		return registroTipoLogEvento;
	}

	/**
	 * @param registroTipoLogEvento
	 *            the registroTipoLogEvento to set
	 */
	public void setRegistroTipoLogEvento(
			RegistroTipoLogEvento registroTipoLogEvento) {
		this.registroTipoLogEvento = registroTipoLogEvento;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public void onEdit(RowEditEvent event) {
		if (placa.getEstado() == 'C')
		{
			TipoLogEvento tipoLogEvento = ((TipoLogEvento) event.getObject());
	
			try {
				registroTipoLogEvento.eliminarDestinatarios(tipoLogEvento, placa);
				tipoLogEvento.setListaDestinatarios(listaDestinatarios);
				Mensaje mensaje = registroTipoLogEvento.modificar(tipoLogEvento,
						placa);
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
						"Error al modificar ", tipoLogEvento.getNombre());
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
				((TipoLogEvento) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		if (placa.getEstado() == 'C')
		{
			try {
				registroTipoLogEvento.eliminar(id);
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
