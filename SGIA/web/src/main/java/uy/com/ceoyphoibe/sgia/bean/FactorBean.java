package uy.com.ceoyphoibe.sgia.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.controller.RegistroSensor;
import uy.com.ceoyphoibe.SGIA.data.LecturaFactorListProducer;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Sensor;
/**
 * La clase FactorBean controla a las páginas de la vista relacionadas a los factores y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 *	
 */
@ManagedBean(name = "factorBean")
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
	@Inject
	private RegistroMensaje registroMensaje;
	

	private List<Sensor> sensores = new ArrayList<Sensor>();
	private Factor factorTemp = new Factor();
	private List<Sensor> sensoresSelecconados = new ArrayList<Sensor>();

	private ResultadoLectura rl = new ResultadoLectura();
	private boolean editando = false;
	private String nombreBoton = "Registrar";

	private LineChartModel animatedModel1 = new LineChartModel();

	@PostConstruct
	public void init() {
		animatedModel1 = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series Temp");

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);
		animatedModel1.addSeries(series1);

	}

	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	private LineChartModel initLinearModel(Factor temp) {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel(temp.getNombre());

		Date ahora = new Date();
		Timestamp max = new Timestamp(ahora.getTime());
		Timestamp min = new Timestamp(ahora.getTime() - 86400000);
		List<LecturaFactor> lecturas = lecturasFactorList
				.getLecturasFactorIdFactorEntreFechas(temp.getIdFactor(), min,
						max);
		int j = lecturas.size() / 15;
		if (j == 0)
			j = 1;
		model.getAxes().put(AxisType.X, new CategoryAxis("Hora"));
		for (int i = 0; i < lecturas.size(); i++) {
			float valor = lecturas.get(i).getValor();
			String hora = lecturas.get(i).getFechaHora().toString()
					.substring(11, 16);
			if (valor >= 0 && i % j == 0) {
				series1.set(hora, valor);
			}
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
	 * @param placa
	 *            the placa to set
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
		if (placaBean.getPlaca().getEstado() == 'C')
		{
			factorTemp.setActivoSistema('S');
			try {
				factorTemp.setPlaca(placaBean.getPlaca());
				if (editando) {
					Mensaje mensaje = registroFactor.modificar(factorTemp);
					if (mensaje.getTipo().equals("Informativo")) {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_INFO, mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					} else {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_ERROR, mensaje.getTexto(), "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				} else
					factorTemp = registroFactor.registroPlaca(factorTemp);
	
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
					factorTemp = new Factor();
					sensoresSelecconados = new ArrayList<Sensor>();
					if (!editando) {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_INFO, "Se registró ",
								"con éxito!");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					} else {
						editando = false;
						nombreBoton = "Registro";
					}
				} else {
					registroFactor.registro(factorTemp);
					factorTemp = new Factor();
					if (!editando) {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_INFO, "Se registró ",
								"con éxito!");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					} else {
						editando = false;
						nombreBoton = "Registro";
					}
				}
	
			}
	
			catch (Exception e) {
				e.printStackTrace();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al registrar ", "");
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

	public void onEditar(long id) {
		if (placaBean.getPlaca().getEstado() == 'C')
		{
			try {
				factorTemp = registroFactor.obtenerFactorPorId(id);
				sensoresSelecconados = factorTemp.getSensores();
				sensores = factorTemp.getSensores();
				editando = true;
				nombreBoton = "Actualizar";
			} catch (Exception e) {
				e.printStackTrace();
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

	public void desvincularSensor(UnselectEvent event) {
		try {
			Sensor sensor = (Sensor) event.getObject();
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
		if (placaBean.getPlaca().getEstado() == 'C')
		{
			if (placaBean.getPlaca().getEstado() == 'C')
			{
				try {
					Factor factorAEliminar = registroFactor.obtenerFactorPorId(id);
					sensoresSelecconados = factorAEliminar.getSensores();
					for (Sensor s : sensoresSelecconados) {
						s.setFactor(null);
					}
		
					factorAEliminar.setSensores(sensoresSelecconados);
					registroFactor.modificar(factorAEliminar);
					Mensaje mensaje = registroFactor.eliminar(id);
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
					e.printStackTrace();
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
		else
		{
			Mensaje mensaje= registroMensaje.obtenerMensajeId((long) 33);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					mensaje.getTexto(), "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void getSensoresId(long id) {
		sensoresSelecconados = (List<Sensor>) registroFactor
				.getListaSensoresId(id);
	}

	public String lecturaFactor(long idFactor) {
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
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		return String.format("%.2f", rl.getLectura());

	}

	public String factores() {
		return "/paginas/factores/factor.xhtml?faces-redirect=true";
	}

	/**
	 * @return the nombreBoton
	 */
	public String getNombreBoton() {
		return nombreBoton;
	}

	/**
	 * @param nombreBoton
	 *            the nombreBoton to set
	 */
	public void setNombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}

	public void graficarFactor(Long idFactor) {
		Factor temp = registroFactor.obtenerFactorPorId(idFactor);
		animatedModel1 = initLinearModel(temp);
		animatedModel1.setTitle(temp.getNombre());
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setMin(temp.getValorMin());
		yAxis.setMax(temp.getValorMax());
	}
}
