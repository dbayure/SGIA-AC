/**
 * 
 */
package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.DTO.FactorLectura;
import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuador;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuadorAvance;
import uy.com.ceoyphoibe.SGIA.controller.RegistroDispositivo;
import uy.com.ceoyphoibe.SGIA.controller.RegistroFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.data.DispositivoListProducer;
import uy.com.ceoyphoibe.SGIA.data.FactorListProducer;
import uy.com.ceoyphoibe.SGIA.data.GrupoActuadoresListProducer;
import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
/**
 * La clase PlacaBean controla a las páginas de la vista relacionadas a las placas y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 */
@ManagedBean(name = "placaBean")
@SessionScoped
public class PlacaBean {

	@Inject
	private RegistroPlaca registroPlaca;

	@Inject
	private RegistroDispositivo regDispositivo;

	@Inject
	private DispositivoListProducer dispositivoListProducer;
	
	@Inject
	private RegistroMensaje registroMensaje;
	
	@Inject
	private GrupoActuadoresListProducer grupoActuadoresListProducer;
	
	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;
	
	@Inject
	private RegistroActuador registroActuadores;
	
	@Inject
	private RegistroFactor registroFactor;
	
	@Inject
	private RegistroActuadorAvance registroActuadoresAvance;
	
	@Inject
	private FactorListProducer factorListProducer;
	
	private ResultadoLectura rl = new ResultadoLectura();
	
	private List<Actuador> listaActuadores= new ArrayList<Actuador>();
	private List<ActuadorAvance> listaActuadoresAvance= new ArrayList<ActuadorAvance>();
	private List<FactorLectura> listaFactoresLectura= new ArrayList<FactorLectura>();
	

	private Placa placa;
	private boolean mostrar = false;
	private boolean mostrarCambiarEstadoPlaca = false;
	private String ip;
	private int puerto;
	private String seleccion;
	private String estadoPlaca;
	private boolean mostrarMenu= false;
	
//	private String acciones="/paginas/placas/accionesPlaca.xhtml?faces-redirect=true";

	public boolean isMostrarCambiarEstadoPlaca() {
		return mostrarCambiarEstadoPlaca;
	}

	public void setMostrarCambiarEstadoPlaca(boolean mostrarCambiarEstadoPlaca) {
		this.mostrarCambiarEstadoPlaca = mostrarCambiarEstadoPlaca;
	}

	public String getEstadoPlaca() {
		return estadoPlaca;
	}

	public void setEstadoPlaca(String estadoPlaca) {
		this.estadoPlaca = estadoPlaca;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public RegistroPlaca getRegistroPlaca() {
		return registroPlaca;
	}

	public void setRegistroPlaca(RegistroPlaca registroPlaca) {
		this.registroPlaca = registroPlaca;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public void seleccionarPlaca(Placa placa) {
		this.placa = placa;
		mostrarMenu= true;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public void registrar() {
		if (placa.getEstado() == 'C')
		{
			try {
				Mensaje mensaje = registroPlaca.modificar(placa);
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
						"Error al actualizar la placa controladora.", "");
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
			Placa placa = ((Placa) event.getObject());
			try {
				registroPlaca.modificar(placa);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se modificó ", placa.getNroSerie());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Error al modificar ", placa.getNroSerie());
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
				((Placa) event.getObject()).getNroSerie());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		if (placa.getEstado() == 'C')
		{
			try {
				registroPlaca.eliminar(id);
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

	public boolean conectar() {
		try {
			placa = registroPlaca.conectarWs(ip, puerto);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return mostrar;
	}

	public String acciones() {
		return "/paginas/placas/accionesPlaca.xhtml?faces-redirect=true";
	}
	
	public String principal() {
		System.out.println("entra a redireccionar");
		return "/paginas/principal/principal.xhtml?faces-redirect=true";
	}

	public String niveles() {
		return "/paginas/nivelesSeveridad/nivelSeveridad.xhtml?faces-redirect=true";
	}

	public String grupos() {
		return "/paginas/grupoActuadores/grupoActuadores.xhtml?faces-redirect=true";
	}

	public String graficas() {
		return "/paginas/graficas/grafica.xhtml?faces-redirect=true";
	}

	public String inicio() {
		return "/paginas/principal/principal.jsf?faces-redirect=true";
	}

	public String alertas() {
		actualizarListaAlertas();
		return "/paginas/alertas/alertas.jsf?faces-redirect=true";
	}
	
	public String lecturaFactor(long idFactor) throws WsPlacaControladoraException {
		String res=null;
		rl = registroFactor.lecturaFactor(idFactor);
		Mensaje mensaje = rl.getMensaje();
		if (mensaje.getTipo().equals("Error")) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			if (mensaje.getTipo().equals("Advertencia")) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} 
		}
			
		
		res= String.format("%.2f", rl.getLectura());

		
		return res;
	}

	public void setFactores() {
		if (placa.getEstado() == 'M' || placa.getEstado() == 'A')
		{
			listaFactoresLectura= new ArrayList<FactorLectura>();
			List<Factor> listaFactores= factorListProducer.getFactores();
			try
			{
				for (Factor f: listaFactores)
				{
					String lectura= lecturaFactor(f.getIdFactor());
					FactorLectura fl= new FactorLectura(f, lectura);
					listaFactoresLectura.add(fl);
				}
			} catch (WsPlacaControladoraException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
						e.getMessage(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			seleccion = "factores";
		}
		else
		{
			Mensaje m= registroMensaje.obtenerMensajeId(32);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					m.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
			
	}
	
	

	public void setActuadores() {
		List<GrupoActuadores> listaGrupos= grupoActuadoresListProducer.getGrupoActuadores();
		try {
			for(GrupoActuadores grupo : listaGrupos)
			{
				
					registroGrupoActuadores.actualizarEstado(grupo);
				
			}
		} catch (WsPlacaControladoraException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
					e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		seleccion = "actuadores";
	}

	/**
	 * 
	 */
	public void setNiveles() {
		seleccion = "niveles";
	}

	public void mostrarCambioEstadoPlaca() {
		if (mostrarCambiarEstadoPlaca == false) {
			mostrarCambiarEstadoPlaca = true;
		} else {
			mostrarCambiarEstadoPlaca = false;
		}

	}

	public void cambiarEstadoPlaca() {
		try
		{
			Mensaje mensaje = registroPlaca.cambiarEstadoPlaca(placa, estadoPlaca);
			if (mensaje.getTipo() == "Error") {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				if (mensaje.getTipo() == "Advertencia") {
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

	public void actualizarListaAlertas() {
		List<Dispositivo> listaDispositivos = dispositivoListProducer
				.getDispositivos();
		for (Dispositivo d : listaDispositivos) {
			regDispositivo.pedirEstadoDispositivo(d);
		}
	}
	
	public void actualizarEstadoDispositivos(GrupoActuadores grupo) {
		if (grupo.getDeAvance().equals("N"))
		{
			listaActuadores = grupo.getActuadores();
			for (Actuador a : listaActuadores) {
				try {
					registroActuadores.actualizarEstado(a);
				} catch (WsPlacaControladoraException e) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
							e.getMessage(), "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
		}
		else
		{
			Set<ActuadorAvance> setActuadoresAvance = grupo.getActuadoresAvance();
			listaActuadoresAvance= new ArrayList<ActuadorAvance>();
			try {
				for (ActuadorAvance a : setActuadoresAvance) {
					
					registroActuadoresAvance.actualizarEstado(a);
					listaActuadoresAvance.add(a);
				}
			} catch (WsPlacaControladoraException e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
						e.getMessage(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
	}

	/**
	 * @return the listaActuadoresAvance
	 */
	public List<ActuadorAvance> getListaActuadoresAvance() {
		return listaActuadoresAvance;
	}

	/**
	 * @param listaActuadoresAvance the listaActuadoresAvance to set
	 */
	public void setListaActuadoresAvance(List<ActuadorAvance> listaActuadoresAvance) {
		this.listaActuadoresAvance = listaActuadoresAvance;
	}

	/**
	 * @param id
	 */
	public void reestablecerDispositivo(long id) {
		if (placa.getEstado() == 'C')
		{
			Dispositivo dispositivo = regDispositivo.obtenerDispositivoId(id);
	
			try {
				Mensaje mensaje = regDispositivo
						.reestablecerDispositivo(dispositivo);
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
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 33);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/**
	 * @return the listaActuadores
	 */
	public List<Actuador> getListaActuadores() {
		return listaActuadores;
	}

	/**
	 * @param listaActuadores the listaActuadores to set
	 */
	public void setListaActuadores(List<Actuador> listaActuadores) {
		this.listaActuadores = listaActuadores;
	}
	
	
	public String obtenerIconoGrupoActuador(GrupoActuadores grupo) {
		String icono= "/resources/gfx/GrupoActuadores.png";
		String nombreGrupo= grupo.getNombre();
		if (nombreGrupo.matches("(.*)Ventilador(.*)") || nombreGrupo.matches("(.*)ventilador(.*)") )
			icono= "/resources/gfx/ventiladores.png";
		else if (nombreGrupo.matches("(.*)Cortina(.*)") || nombreGrupo.matches("(.*)cortina(.*)") )
			icono= "/resources/gfx/cortina.png";
		else if (nombreGrupo.matches("(.*)Aspersor(.*)") || nombreGrupo.matches("(.*)aspersor(.*)") )
			icono= "/resources/gfx/aspersor.png";
		else if (nombreGrupo.matches("(.*)Extractor(.*)") || nombreGrupo.matches("(.*)extractor(.*)") )
			icono= "/resources/gfx/extractor.png";
		else if (nombreGrupo.matches("(.*)Luces(.*)") || nombreGrupo.matches("(.*)luces(.*)") || nombreGrupo.matches("(.*)Luz(.*)") || nombreGrupo.matches("(.*)luz(.*)"))
			icono= "/resources/gfx/luces.png";
		return icono;
	}

	/**
	 * @return the listaFactoresLectura
	 */
	public List<FactorLectura> getListaFactoresLectura() {
				
		return listaFactoresLectura;
	}

	/**
	 * @param listaFactoresLectura the listaFactoresLectura to set
	 */
	public void setListaFactoresLectura(List<FactorLectura> listaFactoresLectura) {
		this.listaFactoresLectura = listaFactoresLectura;
	}

	/**
	 * @return the mostrarMenu
	 */
	public boolean isMostrarMenu() {
		return mostrarMenu;
	}

	/**
	 * @param mostrarMenu the mostrarMenu to set
	 */
	public void setMostrarMenu(boolean mostrarMenu) {
		this.mostrarMenu = mostrarMenu;
	}
	
	


}