package uy.com.ceoyphoibe.sgia.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import uy.com.ceoyphoibe.SGIA.controller.RegistroFactor;
import uy.com.ceoyphoibe.SGIA.data.LecturaFactorListProducer;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
/**
 * La clase GraficaBean controla a las páginas de la vista relacionadas a los factores y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 *	
 */
@ManagedBean(name = "graficaBean")
@SessionScoped
public class GraficaBean {

	private String nombreFactorGraficar;
	private String nombreSensorGraficar;
	private LineChartModel graficaFactores;

	private String opcionVisualizacion;
	private Date fechaMin;
	private Date fechaMax;
	private Factor factorTemp;
	private boolean mostrarGrafica=false;
	
	@Inject
	private LecturaFactorListProducer lecturasFactorList;
	
	@Inject
	private RegistroFactor registroFactor;
	
	@PostConstruct
	public void init() {
		graficaFactores= new LineChartModel();
     	 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series Temp");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
        graficaFactores.addSeries(series1);

	}
	
	
	public String getOpcionVisualizacion() {
		return opcionVisualizacion;
	}

	public void setOpcionVisualizacion(String opcionVisualizacion) {
		this.opcionVisualizacion = opcionVisualizacion;
	}

	

	public String getNombreSensorGraficar() {
		return nombreSensorGraficar;
	}

	public void setNombreSensorGraficar(String nombreSensorGraficar) {
		this.nombreSensorGraficar = nombreSensorGraficar;
	}
	
	/**
	 * @return the graficaFactores
	 */
	public LineChartModel getGraficaFactores() {
		return graficaFactores;
	}

	/**
	 * @param graficaFactores the graficaFactores to set
	 */
	public void setGraficaFactores(LineChartModel graficaFactores) {
		this.graficaFactores = graficaFactores;
	}

	
	public String getNombreFactorGraficar() {
		return nombreFactorGraficar;
	}

	public void setNombreFactorGraficar(String nombreFactorGraficar) {
		this.nombreFactorGraficar = nombreFactorGraficar;
	}

	public void definirFactorGrafica(Long idFactor) {
		
		factorTemp= registroFactor.obtenerFactorPorId(idFactor);
		graficarFactor();
		mostrarGrafica= true;
	}

	
	  private LineChartModel lineModel1;
	    private LineChartModel lineModel2;
	    
	 
	    public LineChartModel getLineModel1() {
	        return lineModel1;
	    }
	 
	    public LineChartModel getLineModel2() {
	        return lineModel2;
	    }
	     
	     
		/**
		 * @return the fechaMin
		 */
		public Date getFechaMin() {
			return fechaMin;
		}

		/**
		 * @param fechaMin the fechaMin to set
		 */
		public void setFechaMin(Date fechaMin) {
			this.fechaMin = fechaMin;
		}

		/**
		 * @return the fechaMax
		 */
		public Date getFechaMax() {
			return fechaMax;
		}

		/**
		 * @param fechaMax the fechaMax to set
		 */
		public void setFechaMax(Date fechaMax) {
			this.fechaMax = fechaMax;
		}
		
		public void graficarFactor()
		{
			graficaFactores = initLinearModel(factorTemp);
			graficaFactores.setTitle(factorTemp.getNombre());
			graficaFactores.setAnimate(true);
			graficaFactores.setLegendPosition("se");
	        Axis yAxis = graficaFactores.getAxis(AxisType.Y);
	        yAxis.setMin(factorTemp.getValorMin());
	        yAxis.setMax(factorTemp.getValorMax());
		}
		
		@SuppressWarnings("deprecation")
		private LineChartModel initLinearModel(Factor temp) {
	        LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel(temp.getNombre());
	 
	        Timestamp min= null;
	        Timestamp max= null;
	        Date ahora= new Date();
	        if (fechaMin == null && fechaMax == null)
	        {
	        	max=new Timestamp(ahora.getTime());
		        min=new Timestamp(ahora.getTime()-86400000);
	        }
			else
			{
				if (fechaMax == null)
					fechaMax= new Date();
				if (fechaMin == null)
				{
					fechaMin= new Date();
					fechaMin.setYear(fechaMin.getYear()-1);
				}
				min= new Timestamp(fechaMin.getTime());
				max= new Timestamp(fechaMax.getTime());
			}
	        
	        List<LecturaFactor> lecturas= lecturasFactorList.getLecturasFactorIdFactorEntreFechas(temp.getIdFactor(), min, max);
	        int j= lecturas.size() / 12;
	        if (j == 0)
	        	j= 1;
	        model.getAxes().put(AxisType.X, new CategoryAxis("Fecha y Hora"));
	        model.getAxis(AxisType.X).setTickAngle(-50);
	        System.out.println("OBTIENE LAS LECTURAS");
	        for (int i=0; i<lecturas.size(); i++)
	        {
	        	float valor=lecturas.get(i).getValor();
	        	System.out.println(lecturas.get(i).getFechaHora().toString());
	        	String hora= lecturas.get(i).getFechaHora().toString().substring(0, 16);
	        	if (valor >= 0 && i%j == 0)
	        	{
	        		System.out.println("Agrega para graficar: "+ valor);
	        		series1.set(hora, valor );
	        	}
	        }

	        model.addSeries(series1);
	         
	        return model;
	    }

		/**
		 * @return the factorTemp
		 */
		public Factor getFactorTemp() {
			return factorTemp;
		}

		/**
		 * @param factorTemp the factorTemp to set
		 */
		public void setFactorTemp(Factor factorTemp) {
			this.factorTemp = factorTemp;
		}


		/**
		 * @return the mostrarGrafica
		 */
		public boolean isMostrarGrafica() {
			return mostrarGrafica;
		}


		/**
		 * @param mostrarGrafica the mostrarGrafica to set
		 */
		public void setMostrarGrafica(boolean mostrarGrafica) {
			this.mostrarGrafica = mostrarGrafica;
		}
	

}
