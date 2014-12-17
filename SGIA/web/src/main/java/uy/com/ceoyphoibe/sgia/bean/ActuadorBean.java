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
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Placa;

@ManagedBean
@ViewScoped
public class ActuadorBean {

	@ManagedProperty("#{placaBean.placa}")
    private Placa placa; 
	
	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;

	@Inject
	private RegistroActuador regActuador;
	
	private Actuador actuador = new Actuador();
	private Actuador acatuadorSeleccionado = new Actuador();
	
	
	public Actuador getAcatuadorSeleccionado() {
		return acatuadorSeleccionado;
	}


	public void setAcatuadorSeleccionado(Actuador acatuadorSeleccionado) {
		this.acatuadorSeleccionado = acatuadorSeleccionado;
	}

	private List<Actuador> actuadorLis = new ArrayList<Actuador>(); 
	private GrupoActuadores ga = new GrupoActuadores();
	

	public Actuador getActuador() {
		return actuador;
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
		
		try {
			if (actuador.getGrupoActuadores() != null) {
				
				actuador.setPlaca(placa);
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
				actuador= new Actuador();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,	"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			else{
				actuador.setPlaca(placa);
				actuador.setEstado('A');
				actuador.setEstadoAlerta('N');
				actuador.setActivoSistema('S');
				
				regActuador.registro(actuador);
				actuador= new Actuador();
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
		System.out.println("Valor del grupo obtenido del actuador seleccionado " + actuador.getNombre());
		try {
			actuador.setGrupoActuadores(ga);
			regActuador.modificar(actuador);
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
			System.out.println("El valor del id que tiene al actuador a eliminar : " + id);
			Actuador a =  regActuador.obtenerActuadorPorId(id);
			a.setGrupoActuadores(null);
			regActuador.modificar(a);
			regActuador.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
