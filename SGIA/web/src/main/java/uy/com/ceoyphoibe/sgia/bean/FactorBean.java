package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.UnselectEvent;

import uy.com.ceoyphoibe.SGIA.controller.RegistroFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroSensor;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Sensor;

@ManagedBean
@SessionScoped
public class FactorBean {

	@Inject
	private RegistroFactor registroFactor;
	@Inject
	private RegistroSensor registroSensor;

	private List<Sensor> sensores = new ArrayList<Sensor>();
	private Factor factorTemp = new Factor();
	private List<Sensor> sensoresSelecconados = new ArrayList<Sensor>();

	
	
	/**
	 * 
	 */
	public FactorBean() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------constructor factor");
	}

	/**
	 * @return the registroFactor
	 */
	public RegistroFactor getRegistroFactor() {
		return registroFactor;
	}

	/**
	 * @param registroFactor
	 *            the registroFactor to set
	 */
	public void setRegistroFactor(RegistroFactor registroFactor) {
		this.registroFactor = registroFactor;
	}

	/**
	 * @return the sensores
	 */
	public List<Sensor> getSensores() {
		return sensores;
	}

	/**
	 * @param sensores
	 *            the sensores to set
	 */
	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	/**
	 * @return the factorTemp
	 */
	public Factor getFactorTemp() {
		return factorTemp;
	}

	/**
	 * @param factorTemp
	 *            the factorTemp to set
	 */
	public void setFactorTemp(Factor factorTemp) {
		this.factorTemp = factorTemp;
	}

	/**
	 * @return the sensoresSelecconados
	 */
	public List<Sensor> getSensoresSelecconados() {
		return sensoresSelecconados;
	}

	/**
	 * @param sensoresSelecconados
	 *            the sensoresSelecconados to set
	 */
	public void setSensoresSelecconados(List<Sensor> sensoresSelecconados) {
		this.sensoresSelecconados = sensoresSelecconados;
	}

	public void registrar() {
		factorTemp.setActivoSistema('S');
		try {
			
			
			//asigno los nuevos sensores
			System.out.println("**************cantidad de seleccionados: "+sensoresSelecconados.size());
			System.out.println("**************cantidad de sensores temp: "+sensores.size());
			for (Sensor s : sensores) {
				s.setFactor(null);
				registroSensor.modificar(s);
			}
			if (sensoresSelecconados.size() > 0) {
				for (Sensor s : sensoresSelecconados) {
					s.setFactor(factorTemp);
					registroSensor.modificar(s);
				}
				factorTemp.setSensores(sensoresSelecconados);
				registroFactor.registro(factorTemp);
				factorTemp= new Factor();
				sensoresSelecconados= new ArrayList<Sensor>();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				registroFactor.registro(factorTemp);
				factorTemp= new Factor();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se registró ", "con éxito!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEditar(long id) {
		try {
			factorTemp = registroFactor.obtenerFactorPorId(id);
			sensoresSelecconados = factorTemp.getSensores();
			sensores= factorTemp.getSensores();
			
			System.out.println("**************cantidad de temp en onEditar: "+sensores.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desvincularSensor(UnselectEvent event) {
		try {
			System.out.println("+++++++++++++++++++++++entra a desvincular sensor");
			Sensor sensor= (Sensor) event.getObject();
			sensor.setFactor(null);
			registroSensor.modificar(sensor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((Factor) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			Factor factorAEliminar= registroFactor.obtenerFactorPorId(id);
			sensoresSelecconados= factorAEliminar.getSensores();
			for (Sensor s : sensoresSelecconados) {
				s.setFactor(null);
			}
			
			factorAEliminar.setSensores(sensoresSelecconados);
			registroFactor.modificar(factorAEliminar);
			registroFactor.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void getSensoresId(long id) {
		sensoresSelecconados = (List<Sensor>) registroFactor.getListaSensoresId(id);

	}
}
