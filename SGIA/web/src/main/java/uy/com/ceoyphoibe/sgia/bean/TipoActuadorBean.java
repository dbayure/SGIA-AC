package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoActuador;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoActuador;

@ManagedBean
@RequestScoped
public class TipoActuadorBean {

	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	@Inject
	private RegistroTipoActuador registroTipoActuador;

	private TipoActuador tipoActuador = new TipoActuador();

	/**
	 * @return the tipoActuador
	 */
	public TipoActuador getTipoActuador() {
		return tipoActuador;
	}

	/**
	 * @param tipoActuador
	 *            the tipoActuador to set
	 */
	public void setTipoActuador(TipoActuador tipoActuador) {
		this.tipoActuador = tipoActuador;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public void registrar() {
		try {
			tipoActuador.setPlaca(placa);
			registroTipoActuador.registro(tipoActuador);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			tipoActuador = new TipoActuador();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEdit(RowEditEvent event) {
		TipoActuador tipoActuador = ((TipoActuador) event.getObject());

		try {
			Mensaje mensaje = registroTipoActuador.modificar(tipoActuador);
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
					"Error al modificar ", tipoActuador.getCategoria());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((TipoActuador) event.getObject()).getCategoria());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			registroTipoActuador.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
