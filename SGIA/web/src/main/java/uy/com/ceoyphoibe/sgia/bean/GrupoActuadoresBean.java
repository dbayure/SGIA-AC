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

import uy.com.ceoyphoibe.SGIA.controller.RegistroActuador;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuadorAvance;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;

@ManagedBean
@SessionScoped
public class GrupoActuadoresBean {

	@ManagedProperty("#{placaBean}")
    private PlacaBean placaBean; 
	
	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;
	

	@Inject
	private RegistroActuadorAvance registroActuadoresAvance;

	private List<Actuador> actuadores = new ArrayList<Actuador>();
	private List<ActuadorAvance> actuadoresAvance = new ArrayList<ActuadorAvance>();
	private GrupoActuadores ga = new GrupoActuadores();
	private List<Actuador> actuadoresSelecconados = new ArrayList<Actuador>();
	private List<ActuadorAvance> actuadoresDeAvanceSelecconados = new ArrayList<ActuadorAvance>();
	private boolean editando=false;
	private String nombreBoton= "Registrar";
	
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
	
	/**
	 * @param placa the placa to set
	 */
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

	public void registrar() {
		ga.setActivoSistema('S');
		ga.setEstado('A');
		ga.setPlaca(placaBean.getPlaca());
		try {
			if (editando)
			{
				Mensaje mensaje= registroGrupoActuadores.modificar(ga);
				if (mensaje.getTipo().equals("Informativo"))
				{
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje.getTexto(),	"");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
				}
				else
				{
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje.getTexto(), "");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
				}
			}
			else
				registroGrupoActuadores.registroPlaca(ga);
			String da = ga.getDeAvance();
			System.out.println("el valor de si es de avance es: " +  da);
		
			if(da.equals("N")){
				for (Actuador a : actuadores) {
					a.setGrupoActuadores(null);
					registroActuador.modificar(a);
				}
				
				
				if ((actuadoresSelecconados != null ) && (actuadoresSelecconados.size() > 0)) {
					for (Actuador a : actuadoresSelecconados) {
						a.setGrupoActuadores(ga);
						registroActuador.modificar(a);
					}
					ga.setActuadores(actuadoresSelecconados);
					registroGrupoActuadores.registro(ga);
					actuadoresSelecconados= new ArrayList<Actuador>();
					if (!editando)
					{
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ",	"con éxito!");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
					}
					else
					{
						editando= false;
						nombreBoton= "Registro";
					}
				} else {
					registroGrupoActuadores.registro(ga);
					actuadoresSelecconados= new ArrayList<Actuador>();
					if (!editando)
					{
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ",	"con éxito!");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
					}
					else
					{
						editando= false;
						nombreBoton= "Registro";
					}
				}
			}
			else
			{
				for (ActuadorAvance a : actuadoresAvance) {
					a.setGrupoActuadores(null);
					registroActuadoresAvance.modificar(a);
				}
				
				if ((actuadoresDeAvanceSelecconados != null ) && (actuadoresDeAvanceSelecconados.size() > 0)) {
					for (ActuadorAvance aa : actuadoresDeAvanceSelecconados) {
						System.out.println("Nombre del grupo a asignar: " + ga.getNombre() + "Al actuador de avance: " + aa.getNombre());
						aa.setGrupoActuadores(ga);
						ga.getActuadoresAvance().add(aa);
						registroActuadoresAvance.modificar(aa);
					}
					registroGrupoActuadores.registro(ga);
					actuadoresDeAvanceSelecconados= new ArrayList<ActuadorAvance>();
					if (!editando)
					{
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ",	"con éxito!");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
					}
					else
					{
						editando= false;
						nombreBoton= "Registro";
					}
				} else {
					registroGrupoActuadores.registro(ga);
					actuadoresDeAvanceSelecconados= new ArrayList<ActuadorAvance>();
					if (!editando)
					{
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ",	"con éxito!");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
					}
					else
					{
						editando= false;
						nombreBoton= "Registro";
					}
				}
			}
			ga= new GrupoActuadores();
		}

		catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEditar(long id) {
		
		try {
			editando= true;
			nombreBoton= "Actualizar";
			ga = registroGrupoActuadores.obtenerGrupoPorId(id);
			if (ga.getDeAvance().equals("S"))
			{
				actuadoresDeAvanceSelecconados= new ArrayList<ActuadorAvance>();
				actuadoresDeAvanceSelecconados.addAll(ga.getActuadoresAvance());
				actuadoresAvance= new ArrayList<ActuadorAvance>();
				actuadoresAvance.addAll(ga.getActuadoresAvance());
			}
			else
			{
				actuadoresSelecconados = ga.getActuadores();
				actuadores = ga.getActuadores();
			}

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error al modificar ", ga.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((GrupoActuadores) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			System.out.println("El valor del id de actuador que viene de la vista " + id);
			registroGrupoActuadores.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
	
	public void getActuadoresId(long id){
		actuadoresSelecconados = registroGrupoActuadores.getListaActuadoresId(id);
		
	}

	/**
	 * @return the nombreBoton
	 */
	public String getNombreBoton() {
		return nombreBoton;
	}

	/**
	 * @param nombreBoton the nombreBoton to set
	 */
	public void setNombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}
}
