package uy.com.ceoyphoibe.sgia.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import uy.com.ceoyphoibe.SGIA.data.LecturaFactorListProducer;

@ManagedBean(name = "graficaBean")
@SessionScoped
public class GraficaBean {

	private String nombreFactorGraficar;
	private String nombreSensorGraficar;
	private LineChartModel graficaFactores;
	private boolean mostrarFactorSensor = false;
	private String opcionVisualizacion;
	
	@Inject
	private LecturaFactorListProducer lecturasFactorList;
	
	public boolean isMostrarFactorSensor() {
		return mostrarFactorSensor;
	}

	public void setMostrarFactorSensor(boolean mostrarFactorSensor) {
		this.mostrarFactorSensor = mostrarFactorSensor;
	}

	
//	@PostConstruct
//	public void init() {
//		graficarFactores();
//	}

	public String getOpcionVisualizacion() {
		return opcionVisualizacion;
	}

	public void setOpcionVisualizacion(String opcionVisualizacion) {
		this.opcionVisualizacion = opcionVisualizacion;
	}

	public LineChartModel getAnimatedModel1() {
		return graficaFactores;
	}

	public String getNombreSensorGraficar() {
		return nombreSensorGraficar;
	}

	public void setNombreSensorGraficar(String nombreSensorGraficar) {
		this.nombreSensorGraficar = nombreSensorGraficar;
	}

	public void definirSensorGrafica(String nombreSensor) {
		nombreSensorGraficar = nombreSensor;
		System.out.println("nombre del Sensor seleccionado para graficar "
				+ nombreSensorGraficar);
	}
	
	public String getNombreFactorGraficar() {
		return nombreFactorGraficar;
	}

	public void setNombreFactorGraficar(String nombreFactorGraficar) {
		this.nombreFactorGraficar = nombreFactorGraficar;
	}

	public void definirFactorGrafica(String nombreFactor) {
		nombreFactorGraficar = nombreFactor;
		System.out.println("nombre del factor seleccionado para graficar "
				+ nombreFactorGraficar);
	}

//	private void graficarFactores() {
//		graficaFactores = initLinearModel();
//		graficaFactores.setTitle("Line Chart");
//		graficaFactores.setAnimate(true);
//		graficaFactores.setLegendPosition("se");
//		Axis yAxis = graficaFactores.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(50);
//	}

//	private LineChartModel initLinearModel() {
//		LineChartModel model = new LineChartModel();
//		LineChartSeries series1 = new LineChartSeries();
//		series1.setLabel("nombreFactorGraficar");
//		List<LecturaFactor> lecturas = lecturasFactorList.getLecturasFactores();
//		for (int i = 0; i < lecturas.size(); i++) {
//			float valor = lecturas.get(i).getValor();
//			if (valor >= 0 && i % 10 == 0) {
//				// int temp= (int)valor;
//				series1.set(i, valor);
//			}
//
//			System.out.println("Agrega para graficar: "
//					+ lecturas.get(i).getValor());
//		}
//		model.addSeries(series1);
//		return model;
//	}
//	
	public void mostrarFactorSensor (){
		if (mostrarFactorSensor == false){
			mostrarFactorSensor = true;
		}
		else {
			mostrarFactorSensor = false;
		}
		
	}
	
//#333333333#####################################
	
	
	  private LineChartModel lineModel1;
	    private LineChartModel lineModel2;
	    
	    @PostConstruct
	    public void init() {
	        createLineModels();
	    }
	 
	    public LineChartModel getLineModel1() {
	        return lineModel1;
	    }
	 
	    public LineChartModel getLineModel2() {
	        return lineModel2;
	    }
	     
	    private void createLineModels() {
	        lineModel1 = initLinearModel();
	        lineModel1.setTitle("Linear Chart");
	        lineModel1.setLegendPosition("e");
	        Axis yAxis = lineModel1.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	         
	        lineModel2 = initCategoryModel();
	        lineModel2.setTitle("Category Chart");
	        lineModel2.setLegendPosition("e");
	        lineModel2.setShowPointLabels(true);
	        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
	        yAxis = lineModel2.getAxis(AxisType.Y);
	        yAxis.setLabel("Births");
	        yAxis.setMin(0);
	        yAxis.setMax(200);
	    }
	     
	    private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Series 1");
	 
	        series1.set(1, 2);
	        series1.set(2, 1);
	        series1.set(3, 3);
	        series1.set(4, 6);
	        series1.set(5, 8);
	 
	        LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Series 2");
	 
	        series2.set(1, 6);
	        series2.set(2, 3);
	        series2.set(3, 2);
	        series2.set(4, 7);
	        series2.set(5, 9);
	 
	        model.addSeries(series1);
	        model.addSeries(series2);
	         
	        return model;
	    }
	     
	    private LineChartModel initCategoryModel() {
	        LineChartModel model = new LineChartModel();
	 
	        ChartSeries boys = new ChartSeries();
	        boys.setLabel("Boys");
	        boys.set("2004", 120);
	        boys.set("2005", 100);
	        boys.set("2006", 44);
	        boys.set("2007", 150);
	        boys.set("2008", 25);
	 
	        ChartSeries girls = new ChartSeries();
	        girls.setLabel("Girls");
	        girls.set("2004", 52);
	        girls.set("2005", 60);
	        girls.set("2006", 110);
	        girls.set("2007", 90);
	        girls.set("2008", 120);
	 
	        model.addSeries(boys);
	        model.addSeries(girls);
	         
	        return model;
	    }
	

}
