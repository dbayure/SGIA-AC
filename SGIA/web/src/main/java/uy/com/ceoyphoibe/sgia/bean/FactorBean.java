package uy.com.ceoyphoibe.sgia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroSensor;
import uy.com.ceoyphoibe.SGIA.data.LecturaFactorListProducer;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Sensor;


@ManagedBean (name="factorBean")
@SessionScoped
public class FactorBean {

	@ManagedProperty("#{placaBean}")
    private PlacaBean placaBean; 
	
	@Inject
	private RegistroFactor registroFactor;
	@Inject
	private RegistroSensor registroSensor;
	@Inject
	private LecturaFactorListProducer lecturasFactorList;
	

	private List<Sensor> sensores = new ArrayList<Sensor>();
	private Factor factorTemp = new Factor();
	private List<Sensor> sensoresSelecconados = new ArrayList<Sensor>();
	
	private ResultadoLectura rl = new ResultadoLectura();
	private boolean editando=false;
	private String nombreBoton= "Registrar";
	
	
    private LineChartModel animatedModel1;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
 
    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Line Chart");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(50);
    }
     

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Temperatura");
 
        List<LecturaFactor> lecturas= lecturasFactorList.getLecturasFactores();
        for (int i=0; i<lecturas.size(); i++)
        {
        	float valor=lecturas.get(i).getValor();
        	if (valor >= 0 && i%10 == 0)
        	{
        		int temp= (int)valor;
        		series1.set(i, valor );
        	}
        		
        	System.out.println("Agrega para graficar: "+ lecturas.get(i).getValor());
        }

 
        model.addSeries(series1);
         
        return model;
    }


	public ResultadoLectura getRl() {
		return rl;
	}

	public void setRl(ResultadoLectura rl) {
		this.rl = rl;
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
	 * @param placa the placa to set
	 */
	public void setPlacaBean(PlacaBean placaBean) {
		this.placaBean = placaBean;
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
			factorTemp.setPlaca(placaBean.getPlaca());
			if (editando)
			{
				Mensaje mensaje= registroFactor.modificar(factorTemp);
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
				factorTemp= registroFactor.registroPlaca(factorTemp);

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
				registroFactor.registro(factorTemp);
				factorTemp= new Factor();
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
			editando= true;
			nombreBoton= "Actualizar";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desvincularSensor(UnselectEvent event) {
		try {
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
			Mensaje mensaje=registroFactor.eliminar(id);
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
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void getSensoresId(long id) {
		sensoresSelecconados = (List<Sensor>) registroFactor.getListaSensoresId(id);
	}
	
	public String lecturaFactor(long idFactor){
		rl = registroFactor.lecturaFactor(idFactor);
		Mensaje mensaje= rl.getMensaje();
		if (mensaje.getTipo().equals("Error"))
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else
		{
			if (mensaje.getTipo().equals("Advertencia"))
			{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			else
			{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		return Float.toString(rl.getLectura());
		
	}
	
	public String factores()
	{
		return "/paginas/factores/factor.xhtml?faces-redirect=true";
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
