package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroPlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.PlacaAuxiliar;

@ManagedBean
@RequestScoped
public class PlacaAuxiliarBean {

	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	@Inject
	private RegistroPlacaAuxiliar registroPlacaAuxiliar;

	private PlacaAuxiliar placaAuxiliarTemp = new PlacaAuxiliar();

	/**
	 * @return the registroPlacaAuxiliar
	 */
	public RegistroPlacaAuxiliar getRegistroPlacaAuxiliar() {
		return registroPlacaAuxiliar;
	}

	/**
	 * @param registroPlacaAuxiliar
	 *            the registroPlacaAuxiliar to set
	 */
	public void setRegistroPlacaAuxiliar(
			RegistroPlacaAuxiliar registroPlacaAuxiliar) {
		this.registroPlacaAuxiliar = registroPlacaAuxiliar;
	}

	/**
	 * @return the placaAuxiliarTemp
	 */
	public PlacaAuxiliar getPlacaAuxiliarTemp() {
		return placaAuxiliarTemp;
	}

	/**
	 * @param placaAuxiliarTemp
	 *            the placaAuxiliarTemp to set
	 */
	public void setPlacaAuxiliarTemp(PlacaAuxiliar placaAuxiliarTemp) {
		this.placaAuxiliarTemp = placaAuxiliarTemp;
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
			placaAuxiliarTemp.setEstadoAlerta("N");
			placaAuxiliarTemp.setActivoSistema('S');
			placaAuxiliarTemp.setPlaca(placa);
			registroPlacaAuxiliar.registro(placaAuxiliarTemp);
			placaAuxiliarTemp = new PlacaAuxiliar();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEdit(RowEditEvent event) {
		PlacaAuxiliar placaAux = ((PlacaAuxiliar) event.getObject());
		try {
			Mensaje mensaje = registroPlacaAuxiliar.modificar(placaAux);
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
					"Error al modificar ", placaAux.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((PlacaAuxiliar) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			Mensaje mensaje = registroPlacaAuxiliar.eliminar(id);
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
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
