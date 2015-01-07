package uy.com.ceoyphoibe.sgia.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;

@ManagedBean(name= "placaBean")
@SessionScoped
public class PlacaBean {

	@Inject
	private RegistroPlaca registroPlaca;
	
	private Placa placa;
	private boolean mostrar = false;
	private boolean mostrarCambiarEstadoPlaca = false;
	private String ip;
	private int puerto;
	private String seleccion;
	private String estadoPlaca;
	
	
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
	
	
	public void seleccionarPlaca( Placa placa)
	{
		this.placa= placa;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public void registrar() {
		
		try {
			Mensaje mensaje=registroPlaca.modificar(placa);
			if (mensaje.getTipo().equals("Informativo"))
        	{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje.getTexto(), "");  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
        	}
        	else
        	{
        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje.getTexto(), "");  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
        	}
			
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al actualizar la placa controladora.", "");
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
			placa= registroPlaca.conectarWs(ip, puerto);
		}
		catch (Exception e){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return mostrar;
	}
	
	public String acciones()
	{
		return "/paginas/placas/accionesPlaca.xhtml?faces-redirect=true";
	}
	
	public String niveles()
	{
		return "/paginas/nivelesSeveridad/nivelSeveridad.xhtml?faces-redirect=true";
	}
	
	public String grupos()
	{
		return "/paginas/grupoActuadores/grupoActuadores.xhtml?faces-redirect=true";
	}
	
	public String graficas()
	{
		return "/paginas/graficas/grafica.xhtml?faces-redirect=true";
	}
	public String inicio()
	{
		return "/paginas/principal/principal.jsf?faces-redirect=true";
	}
	
	public void setFactores(){
		seleccion = "factores";
	}
	
	public void setActuadores(){
		seleccion = "actuadores";
	}
	
	public void setNiveles(){
		seleccion = "niveles";
	}
	
	public void mostrarCambioEstadoPlaca(){
		if (mostrarCambiarEstadoPlaca == false){
			mostrarCambiarEstadoPlaca = true;
		}
		else {
			mostrarCambiarEstadoPlaca = false;
		}
		
	}
	
	
	public void cambiarEstadoPlaca (){
		System.out.println("entra a cambiarEstadoPlaca en el BEAN");
		Mensaje mensaje = registroPlaca.cambiarEstadoPlaca(placa, estadoPlaca);
		if (mensaje.getTipo() == "Error"){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else{
			if (mensaje.getTipo() == "Advertencia"){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
	
	}
}