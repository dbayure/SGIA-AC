package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroSensor;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.Sensor;



@ManagedBean
@RequestScoped
public class SensorBean {

	@ManagedProperty("#{placaBean.placa}")
    private Placa placa; 
	
	@Inject
	private RegistroSensor registroSensor;
	
	private Sensor sensorTemp= new Sensor();
	
	public void registrar() {
		try {
			sensorTemp.setPlaca(placa);
			sensorTemp.setActivoSistema('S');
			sensorTemp.setEstadoAlerta('N');
			registroSensor.registro(sensorTemp);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        sensorTemp= new Sensor();
		}
		catch (Exception e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
	}
	
	/**
	 * @return the sensorTemp
	 */
	public Sensor getSensorTemp() {
		return sensorTemp;
	}

	/**
	 * @param sensorTemp the sensorTemp to set
	 */
	public void setSensorTemp(Sensor sensorTemp) {
		this.sensorTemp = sensorTemp;
	}
	
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}


	public void onEdit(RowEditEvent event) {  
            Sensor sensor = ((Sensor) event.getObject());
           
            try {
            	registroSensor.modificar(sensor);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", sensor.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			} catch (Exception e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", sensor.getNombre());  
	            FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
    }
	
	public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((Sensor) event.getObject()).getNombre());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void eliminar(Long id) {
		try {
			Sensor s= registroSensor.obtenerSensorPorId(id);
			s.setFactor(null);
			registroSensor.modificar(s);
			Mensaje mensaje=registroSensor.eliminar(id);
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
		}
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
	}
}
