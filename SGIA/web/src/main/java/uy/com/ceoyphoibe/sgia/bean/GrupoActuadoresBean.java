package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;

@ManagedBean
@RequestScoped
public class GrupoActuadoresBean {

	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;

	private List<Actuador> actuadores = new ArrayList<Actuador>();
	private GrupoActuadores ga = new GrupoActuadores();
	private List<Actuador> actuadoresSelecconados = new ArrayList<Actuador>();
	

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

	public RegistroGrupoActuadores getRegistroGrupoActuadores() {
		return registroGrupoActuadores;
	}

	public void setRegistroGrupoActuadores(
			RegistroGrupoActuadores registroGrupoActuadores) {
		this.registroGrupoActuadores = registroGrupoActuadores;
	}

	public List<Actuador> getActuadores() {
		return actuadores;
	}

	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}

	public void registrar() {
		System.out.println("tamaño de la lista de actuadores"
				+ actuadoresSelecconados.size());
		try {
			if (actuadoresSelecconados.size() > 0) {
				for (Actuador a : actuadoresSelecconados) {
					System.out.println("Nombre del grupo a asignar: " + ga.getNombre() + "Al actuador: " + a.getNombre());
					a.setGrupoActuadores(ga);
					ga.getActuadores().add(a);
				}
				registroGrupoActuadores.registro(ga);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ",	"con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			} else {
				registroGrupoActuadores.registro(ga);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			ga.setActivoSistema('S');
			ga.setEstado('A');
			registroGrupoActuadores.registro(ga);
		}

		catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEditar(long id) {
//		GrupoActuadores grupoActuadores = ((GrupoActuadores) event.getObject());
		System.out.println("id que viene de la vista: " + id);
		
		try {
			ga = registroGrupoActuadores.obtenerGrupoPorId(id);
			actuadoresSelecconados = ga.getActuadores();
			System.out.println("id que viene despues de cargar el grupo: " + ga.getId());
			//registroGrupoActuadores.modificar(grupoActuadores);
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Se modificó ", grupoActuadores.getNombre());
//			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Error al modificar ", grupoActuadores.getNombre());
//			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((GrupoActuadores) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
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
}
