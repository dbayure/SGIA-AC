package uy.com.ceoyphoibe.sgia.bean;


import java.util.concurrent.ExecutionException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.model.Placa;

@ManagedBean
@SessionScoped
public class PlacaBean {

	@Inject
	private RegistroPlaca registroPlaca;
	
	private Placa placa = new Placa();
	private boolean mostrar = false;
	private String ip;
	private int puerto;
	
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
	

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public void registrar() {
		
		try {
			placa.setEstadoAlerta('N');
			placa.setEstado('C');
			placa = new Placa();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,	"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEdit(RowEditEvent event) {
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

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((Placa) event.getObject()).getNroSerie());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
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
	
	public boolean conectar(){
		try{
			System.out.println("conectando al servidor mediante el ws ...  \n");
			registroPlaca.conectarWs(ip, puerto);
		}
		catch (Exception e){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return mostrar;
	}
}