package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.DTO.ResultadoAccion;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuador;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuadorAvance;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
/**
 * La clase GrupoActuadoresBean controla a las páginas de la vista relacionadas a los grupos de actuadores y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 *	
 */
@ManagedBean
@SessionScoped
public class GrupoActuadoresBean {

	@ManagedProperty("#{placaBean}")
	private PlacaBean placaBean;

	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;

	@Inject
	private RegistroActuadorAvance registroActuadoresAvance;
	
	@Inject
	private RegistroMensaje registroMensaje;

	private List<Actuador> actuadores = new ArrayList<Actuador>();
	private List<ActuadorAvance> actuadoresAvance = new ArrayList<ActuadorAvance>();
	private GrupoActuadores ga = new GrupoActuadores();
	private List<Actuador> actuadoresSelecconados = new ArrayList<Actuador>();
	private List<ActuadorAvance> actuadoresDeAvanceSelecconados = new ArrayList<ActuadorAvance>();
	private boolean editando = false;
	private String nombreBoton = "Registrar";
	private List<Posicion> posicionesGrupoActuadorAvanceSeleccionado = new ArrayList<Posicion>();
	private Posicion posicion = new Posicion();
	private int posActual;
	private Long mostrarModificar = (long) 0;
	private Long mostrarEstado = (long) 0;
	private boolean estado;

	@Inject
	private RegistroActuador registroActuador;

	public List<ActuadorAvance> getActuadoresDeAvanceSelecconados() {
		return actuadoresDeAvanceSelecconados;
	}

	public GrupoActuadoresBean() {
		ga.setDeAvance("N");
	}

	public void setActuadoresDeAvanceSelecconados(
			List<ActuadorAvance> actuadoresDeAvanceSelecconados) {
		this.actuadoresDeAvanceSelecconados = actuadoresDeAvanceSelecconados;
	}

	public List<Actuador> getActuadoresSelecconados() {
		return actuadoresSelecconados;
	}

	public void setActuadoresSelecconados(List<Actuador> actuadoresSelecconados) {
		this.actuadoresSelecconados = actuadoresSelecconados;
	}

	public GrupoActuadores getGa() {
		return ga;
	}

	public void setGa(GrupoActuadores ga) {
		this.ga = ga;
	}

	public void setPlacaBean(PlacaBean placaBean) {
		this.placaBean = placaBean;
	}

	public RegistroGrupoActuadores getRegistroGrupoActuadores() {
		return registroGrupoActuadores;
	}

	public void setRegistroGrupoActuadores(
			RegistroGrupoActuadores registroGrupoActuadores) {
		this.registroGrupoActuadores = registroGrupoActuadores;
	}

	public List<ActuadorAvance> getActuadoresAvance() {
		return actuadoresAvance;
	}

	public void setActuadoresAvance(List<ActuadorAvance> actuadoresAvance) {
		this.actuadoresAvance = actuadoresAvance;
	}

	public List<Actuador> getActuadores() {
		return actuadores;
	}

	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}

	public void getActuadoresId(long id) {
		actuadoresSelecconados = registroGrupoActuadores
				.getListaActuadoresId(id);

	}

	public String getNombreBoton() {
		return nombreBoton;
	}

	public void setNombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public List<Posicion> getPosicionesGrupoActuadorAvanceSeleccionado() {
		return posicionesGrupoActuadorAvanceSeleccionado;
	}

	public void setPosicionesGrupoActuadorAvanceSeleccionado(
			List<Posicion> posicionesGrupoActuadorAvanceSeleccionado) {
		this.posicionesGrupoActuadorAvanceSeleccionado = posicionesGrupoActuadorAvanceSeleccionado;
	}

	public int getPosActual() {
		return posActual;
	}

	public void setPosActual(int posActual) {
		this.posActual = posActual;
	}

	public Long getMostrarModificar() {
		return mostrarModificar;
	}

	public void setMostrarModificar(Long mostrarModificar) {
		this.mostrarModificar = mostrarModificar;
	}

	public Long getMostrarEstado() {
		return mostrarEstado;
	}

	public void setMostrarEstado(Long mostrarEstado) {
		this.mostrarEstado = mostrarEstado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void registrar() {
		if (placaBean.getPlaca().getEstado() == 'C')
		{
			ga.setActivoSistema('S');
			ga.setEstado('A');
			ga.setPlaca(placaBean.getPlaca());
			try {
				if (editando) {
					Mensaje mensaje = registroGrupoActuadores.modificar(ga);
					if (mensaje.getTipo().equals("Informativo")) {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_INFO, mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					} else {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_ERROR, mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				} else
					registroGrupoActuadores.registroPlaca(ga);
				String da = ga.getDeAvance();
	
				if (da.equals("N")) {
					for (Actuador a : actuadores) {
						a.setGrupoActuadores(null);
						registroActuador.modificar(a);
					}
					if ((actuadoresSelecconados != null)
							&& (actuadoresSelecconados.size() > 0)) {
						for (Actuador a : actuadoresSelecconados) {
							a.setGrupoActuadores(ga);
							registroActuador.modificar(a);
						}
						ga.setActuadores(actuadoresSelecconados);
						registroGrupoActuadores.registro(ga);
						ga = new GrupoActuadores();
						actuadoresSelecconados = new ArrayList<Actuador>();
						if (!editando) {
							FacesMessage msg = new FacesMessage(
									FacesMessage.SEVERITY_INFO, "Se registró ",
									"con éxito!");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						} else {
							editando = false;
							nombreBoton = "Registro";
						}
					} else {
						registroGrupoActuadores.registro(ga);
						ga = new GrupoActuadores();
						if (!editando) {
							FacesMessage msg = new FacesMessage(
									FacesMessage.SEVERITY_INFO, "Se registró ",
									"con éxito!");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						} else {
							editando = false;
							nombreBoton = "Registro";
						}
					}
				} else {
					for (ActuadorAvance a : actuadoresAvance) {
						a.setGrupoActuadores(null);
						registroActuadoresAvance.modificar(a);
					}
					if ((actuadoresDeAvanceSelecconados != null)
							&& (actuadoresDeAvanceSelecconados.size() > 0)) {
						for (ActuadorAvance aa : actuadoresDeAvanceSelecconados) {
							aa.setGrupoActuadores(ga);
							ga.getActuadoresAvance().add(aa);
							registroActuadoresAvance.modificar(aa);
						}
						registroGrupoActuadores.registro(ga);
						actuadoresDeAvanceSelecconados = new ArrayList<ActuadorAvance>();
						if (!editando) {
							FacesMessage msg = new FacesMessage(
									FacesMessage.SEVERITY_INFO, "Se registró ",
									"con éxito!");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						} else {
							editando = false;
							nombreBoton = "Registro";
						}
					} else {
						registroGrupoActuadores.registro(ga);
						actuadoresDeAvanceSelecconados = new ArrayList<ActuadorAvance>();
						if (!editando) {
							FacesMessage msg = new FacesMessage(
									FacesMessage.SEVERITY_INFO, "Se registró ",
									"con éxito!");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						} else {
							editando = false;
							nombreBoton = "Registro";
						}
					}
				}
				//ga = new GrupoActuadores();
			}
			catch (Exception e) {
				e.printStackTrace();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
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

	public void onEditar(long id) {
		if (placaBean.getPlaca().getEstado() == 'C')
		{
			try {
				editando = true;
				nombreBoton = "Actualizar";
				ga = registroGrupoActuadores.obtenerGrupoPorId(id);
				if (ga.getDeAvance().equals("S")) {
					actuadoresDeAvanceSelecconados = new ArrayList<ActuadorAvance>();
					actuadoresDeAvanceSelecconados.addAll(ga.getActuadoresAvance());
					actuadoresAvance = new ArrayList<ActuadorAvance>();
					actuadoresAvance.addAll(ga.getActuadoresAvance());
				} else {
					actuadoresSelecconados = ga.getActuadores();
					actuadores = ga.getActuadores();
				}
	
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al modificar ", ga.getNombre());
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
				((GrupoActuadores) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		if (placaBean.getPlaca().getEstado() == 'C')
		{
			try {
				Mensaje mensaje = registroGrupoActuadores.eliminar(id);
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

	public void getActuadoresAvanceId(long id) {
		actuadoresDeAvanceSelecconados = registroGrupoActuadores
				.getListaActuadoresAvanceId(id);
	}

	public void getPosicionId(long id) {
		posicion = registroGrupoActuadores.obtenerPosicionId(id);
	}

	public void obtenerListaPosiciones(long id) {
		setGa(registroGrupoActuadores.obtenerGrupoPorId(id));
		getActuadoresAvanceId(id);
		posicionesGrupoActuadorAvanceSeleccionado.clear();
		posActual = actuadoresDeAvanceSelecconados.get(0).getPosicion();
		getPosicionId(actuadoresDeAvanceSelecconados.get(0).getId());
		for (Posicion p : actuadoresDeAvanceSelecconados.get(0)
				.getListaPosiciones()) {
			posicionesGrupoActuadorAvanceSeleccionado.add(p);
		}
	}

	public void cambiarEstado(long idGrupo) {
		if (placaBean.getPlaca().getEstado() == 'M')
		{
			try {
				ga = registroGrupoActuadores.obtenerGrupoPorId(idGrupo);
				ResultadoAccion resultado = new ResultadoAccion();
				if (estado == false) {
					resultado = registroGrupoActuadores.apagarGrupo(ga);
				} else {
					resultado = registroGrupoActuadores.encenderGrupo(ga);
				}
				Mensaje mensaje = resultado.getMensaje();
				if (mensaje.getTipo().equals("Error")) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							mensaje.getTexto(), "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					if (mensaje.getTipo().equals("Advertencia")) {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
								mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					} else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
								mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				}
			} catch (WsPlacaControladoraException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
						e.getMessage(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			
		}
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 31);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		cambiaMostrarEstado(idGrupo);
	}

	public void cambiarPosicion(Long idGrupo) {
		if (placaBean.getPlaca().getEstado() == 'M')
		{
			try
			{
				ResultadoAccion resultado = registroGrupoActuadores
						.cambiarPosicionAvance(ga, posActual);
				Mensaje mensaje = resultado.getMensaje();
				if (mensaje.getTipo().equals("Error")) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							mensaje.getTexto(), "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					if (mensaje.getTipo().equals("Advertencia")) {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
								mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					} else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
								mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				}
			} catch (WsPlacaControladoraException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
						e.getMessage(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 31);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		cambiaMostrarEstado(idGrupo);
	}

	public void cambiaMostrarModificar(Long idGrupo) {
		if (mostrarModificar != idGrupo) {
			mostrarModificar = idGrupo;
		} else {
			mostrarModificar = (long) 0;
		}
	}

	public void cambiaMostrarEstado(Long idGrupo) {
		if (mostrarEstado != idGrupo) {
			mostrarEstado = idGrupo;
		} else {
			mostrarEstado = (long) 0;
		}
	}

	public void setEstadoGrupo(char e) {
		if (e == 'E') {
			estado = true;
		} else {
			estado = false;
		}
	}
}
