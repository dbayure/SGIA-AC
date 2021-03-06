package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroActuador;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
/**
 * La clase ActuadorBean controla a las páginas de la vista relacionadas a los Actuadores y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 *	
 */
@ManagedBean
@ViewScoped
public class ActuadorBean {

	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;

	@Inject
	private RegistroActuador regActuador;
	
	@Inject
	private RegistroMensaje registroMensaje;

	private Actuador actuador = new Actuador();
	private Actuador acatuadorSeleccionado = new Actuador();

	public Actuador getAcatuadorSeleccionado() {
		return acatuadorSeleccionado;
	}

	public void setAcatuadorSeleccionado(Actuador acatuadorSeleccionado) {
		this.acatuadorSeleccionado = acatuadorSeleccionado;
	}

	private List<Actuador> actuadorLis = new ArrayList<Actuador>();
//	private GrupoActuadores ga = new GrupoActuadores();

	public Actuador getActuador() {
		return actuador;
	}

//	public GrupoActuadores getGa() {
//		return ga;
//	}
//
//	public void setGa(GrupoActuadores ga) {
//		this.ga = ga;
//	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public List<Actuador> getActuadorLis() {
		return actuadorLis;
	}

	public void setActuadorLis(List<Actuador> actuadorLis) {
		this.actuadorLis = actuadorLis;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}

	public void registrar() {
		if (placa.getEstado() == 'C')
		{
			try {
//				if (actuador.getGrupoActuadores() != null) {
//	
//					actuador.setPlaca(placa);
//					actuador.setEstado('A');
//					actuador.setEstadoAlerta("N");
//					actuador.setActivoSistema('S');
//					long idGrupo=(actuador.getGrupoActuadores().getId());
//					ga= registroGrupoActuadores.obtenerGrupoPorId(idGrupo);
//					ga.getActuadores().add(actuador);
//					regActuador.registro(actuador);
//					registroGrupoActuadores.registro(ga);
//					actuador = new Actuador();
//					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//							"Se registró ", "con éxito!");
//					FacesContext.getCurrentInstance().addMessage(null, msg);
//				} else {
					actuador.setPlaca(placa);
					actuador.setEstado('A');
					actuador.setEstadoAlerta("N");
					actuador.setActivoSistema('S');
					actuador.getPadre().setPlaca(placa);
					regActuador.registro(actuador);
					actuador = new Actuador();
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Se registró ", "con éxito!");
					FacesContext.getCurrentInstance().addMessage(null, msg);
		//		}
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
			Actuador actuador = ((Actuador) event.getObject());
			System.out
					.println("Valor del grupo obtenido del actuador seleccionado "
							+ actuador.getNombre());
			try {
				actuador.setPlaca(placa);
				actuador.getPadre().setPlaca(placa);
				
				Mensaje mensaje = regActuador.modificar(actuador);
				
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
						"Error al modificar ", actuador.getNombre());
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
				((Actuador) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		if (placa.getEstado() == 'C')
		{
			try {
				Actuador a = regActuador.obtenerActuadorPorId(id);
				a.setGrupoActuadores(null);
				regActuador.modificar(a);
				Mensaje mensaje = regActuador.eliminar(id);
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
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 33);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
