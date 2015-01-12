package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoPuerto;
import uy.com.ceoyphoibe.SGIA.model.TipoPuerto;

@ManagedBean
@RequestScoped
public class TipoPuertoBean {

	@Inject
	private RegistroTipoPuerto registroTipoPuerto;

	private TipoPuerto tipoPuerto = new TipoPuerto();

	public void registrar() {
		try {
			registroTipoPuerto.registro(tipoPuerto);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			tipoPuerto = new TipoPuerto();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/**
	 * @return the tipoPuerto
	 */
	public TipoPuerto getTipoPuerto() {
		return tipoPuerto;
	}

	/**
	 * @param tipoPuerto
	 *            the tipoPuerto to set
	 */
	public void setTipoPuerto(TipoPuerto tipoPuerto) {
		this.tipoPuerto = tipoPuerto;
	}

	public void onEdit(RowEditEvent event) {
		TipoPuerto tipoPuerto = ((TipoPuerto) event.getObject());

		try {
			registroTipoPuerto.modificar(tipoPuerto);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", tipoPuerto.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", tipoPuerto.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((TipoPuerto) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			registroTipoPuerto.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
