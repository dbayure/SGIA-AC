package uy.com.ceoyphoibe.sgia.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroActuador;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;

@ManagedBean
@RequestScoped
public class ActuadorBean {

	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;

	@Inject
	private RegistroActuador regActuador;
	
	private Actuador actuador = new Actuador();
	private GrupoActuadores ga = new GrupoActuadores();
	
	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}	

	public void registrar() {
		
		try {
			if (actuador.getGrupoActuadores() != null) {
				System.out.println("Entro al registrar del actuador y llamo al registro del grupo.");
				actuador.setEstado('A');
				actuador.setEstadoAlerta('N');
				actuador.setActivoSistema('S');
				ga.setId(actuador.getGrupoActuadores().getId());
				ga.setActivoSistema(actuador.getGrupoActuadores().getActivoSistema());
				ga.setDeAvance(actuador.getGrupoActuadores().getDeAvance());
				ga.setEstado(actuador.getGrupoActuadores().getEstado());
				ga.setNombre(actuador.getGrupoActuadores().getNombre());
				ga.getActuadores().add(actuador);
				registroGrupoActuadores.registro(ga);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,	"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			else{
				System.out.println("Entro al registrar del actuador y llamo al registro del actuador.");
				actuador.setEstado('A');
				actuador.setEstadoAlerta('N');
				actuador.setActivoSistema('S');
				regActuador.registro(actuador);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,	"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEdit(RowEditEvent event) {
		Actuador actuador = ((Actuador) event.getObject());

		try {
//			registroActuador.modificar(actuador);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", actuador.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", actuador.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((Actuador) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
//			registroActuador.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
