package uy.com.ceoyphoibe.sgia.bean;

import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
import uy.com.ceoyphoibe.SGIA.model.Sensor;

@ManagedBean
@SessionScoped
public class ActuadorAvanceBean {

	@ManagedProperty("#{placaBean}")
	private PlacaBean placaBean;

	@Inject
	private RegistroActuadorAvance registroActuadorAvance;

	private ActuadorAvance actuadorAvanceSeleccionado = new ActuadorAvance();

	private Set<Posicion> listaPosiciones = new HashSet<Posicion>();

	private Set<Sensor> listaSensoresPosicion = new HashSet<Sensor>();

	private Posicion posicionTemp = new Posicion();

	private boolean skip;

	private char posicionRes;

	private boolean btnActualizar = true;

	/**
	 * @return the skip
	 */
	public boolean isSkip() {
		return skip;
	}

	/**
	 * @return the posicionTemp
	 */
	public Posicion getPosicionTemp() {
		return posicionTemp;
	}

	/**
	 * @param posicionTemp
	 *            the posicionTemp to set
	 */
	public void setPosicionTemp(Posicion posicionTemp) {
		this.posicionTemp = posicionTemp;
	}

	/**
	 * @param skip
	 *            the skip to set
	 */
	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	/**
	 * @return the registroActuadorAvance
	 */
	public RegistroActuadorAvance getRegistroActuadorAvance() {
		return registroActuadorAvance;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlacaBean(PlacaBean placaBean) {
		this.placaBean = placaBean;
	}

	/**
	 * @return the actuadorAvanceSeleccionado
	 */
	public ActuadorAvance getActuadorAvanceSeleccionado() {
		return actuadorAvanceSeleccionado;
	}

	/**
	 * @return the listaSensoresPosicion
	 */
	public Set<Sensor> getListaSensoresPosicion() {
		return listaSensoresPosicion;
	}

	/**
	 * @param listaSensoresPosicion
	 *            the listaSensoresPosicion to set
	 */
	public void setListaSensoresPosicion(Set<Sensor> listaSensoresPosicion) {
		this.listaSensoresPosicion = listaSensoresPosicion;
	}

	/**
	 * @param actuadorAvanceSeleccionado
	 *            the actuadorAvanceSeleccionado to set
	 */
	public void setActuadorAvanceSeleccionado(
			ActuadorAvance actuadorAvanceSeleccionado) {
		this.actuadorAvanceSeleccionado = actuadorAvanceSeleccionado;
		listaPosiciones = actuadorAvanceSeleccionado.getListaPosiciones();
	}

	public void seleccionarActuadorAvanceSeleccionado(Long id) {
		actuadorAvanceSeleccionado = registroActuadorAvance
				.obtenerActuadorAvance(id);
		listaPosiciones = actuadorAvanceSeleccionado.getListaPosiciones();
	}

	/**
	 * @param registroActuadorAvance
	 *            the registroActuadorAvance to set
	 */
	public void setRegistroActuadorAvance(
			RegistroActuadorAvance registroActuadorAvance) {
		this.registroActuadorAvance = registroActuadorAvance;
	}

	/**
	 * @return the listaPosiciones
	 */
	public Set<Posicion> getListaPosiciones() {
		return listaPosiciones;
	}

	/**
	 * @param listaPosiciones
	 *            the listaPosiciones to set
	 */
	public void setListaPosiciones(Set<Posicion> listaPosiciones) {
		this.listaPosiciones = listaPosiciones;
	}

	public char getPosicionRes() {
		return posicionRes;
	}

	public void setPosicionRes(char posicionRes) {
		this.posicionRes = posicionRes;
	}

	public boolean isBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(boolean btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public void guardar() {
		try {
			if (!skip)
				actuadorAvanceSeleccionado.setListaPosiciones(listaPosiciones);
			actuadorAvanceSeleccionado.setActivoSistema('S');
			actuadorAvanceSeleccionado.setEstadoAlerta("N");
			actuadorAvanceSeleccionado.setPlaca(placaBean.getPlaca());
			registroActuadorAvance.guardar(actuadorAvanceSeleccionado);
			actuadorAvanceSeleccionado = new ActuadorAvance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void actualizar() {
		try {

			actuadorAvanceSeleccionado.setListaPosiciones(listaPosiciones);
			Mensaje mensaje = registroActuadorAvance
					.modificar(actuadorAvanceSeleccionado);
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
					"Error al actualizar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void agregarPosicion() {
		posicionTemp.setListaSensores(listaSensoresPosicion);
		listaPosiciones.add(posicionTemp);
		posicionTemp = new Posicion();
		posicionTemp.setNroPosicion(listaPosiciones.size() + 1);
		listaSensoresPosicion = new HashSet<Sensor>();
	}

	public void impactarListaPosiciones() {
		try {

			actuadorAvanceSeleccionado.setListaPosiciones(listaPosiciones);
			registroActuadorAvance.modificar(actuadorAvanceSeleccionado);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", actuadorAvanceSeleccionado.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ",
					actuadorAvanceSeleccionado.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEditPosicion(RowEditEvent event) {
		Posicion posicion = ((Posicion) event.getObject());

		try {

			posicion.setListaSensores(listaSensoresPosicion);
			actuadorAvanceSeleccionado.setListaPosiciones(listaPosiciones);
			registroActuadorAvance.modificar(actuadorAvanceSeleccionado);
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", posicion.getDescripcion());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void eliminarPosicion(Posicion pos) {
		try {
			listaPosiciones.remove(pos);
			actuadorAvanceSeleccionado.setListaPosiciones(listaPosiciones);
			registroActuadorAvance.modificar(actuadorAvanceSeleccionado);
			FacesMessage msg = new FacesMessage("Se eliminó la posición",
					pos.getDescripcion());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(
					"Error al eliminar la posición", pos.getDescripcion());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void onEdit(RowEditEvent event) {
		ActuadorAvance actuadorAvance = ((ActuadorAvance) event.getObject());

		try {

			actuadorAvance.setListaPosiciones(listaPosiciones);
			registroActuadorAvance.modificar(actuadorAvance);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", actuadorAvance.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", actuadorAvance.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((ActuadorAvance) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			Mensaje mensaje = registroActuadorAvance.eliminar(id);
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

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirmacion";
		} else {
			return event.getNewStep();
		}
	}

	public boolean esDeAvance(long id) {
		boolean es = registroActuadorAvance.esDeAvance(id);
		return es;
	}

	public void reestablecerPosicion() {
		try {
			Mensaje mensaje = registroActuadorAvance
					.reestablecerPosicionActuadorAvance(
							actuadorAvanceSeleccionado, posicionRes);
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
			FacesMessage msg = new FacesMessage(
					"Error al restablecer la posicion ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void seleccionar(long id) {
		seleccionarActuadorAvanceSeleccionado(id);
	}

}
