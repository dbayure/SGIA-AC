package uy.com.ceoyphoibe.sgia.bean;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import uy.com.ceoyphoibe.SGIA.data.LecturaFactorListProducer;
import uy.com.ceoyphoibe.SGIA.data.LecturaListProducer;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Lectura;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
import uy.com.ceoyphoibe.SGIA.model.Sensor;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

@ManagedBean(name = "lecturasFactorBean")
@SessionScoped
public class LecturasFactorBean {

	private Factor factorTemp;
	private Sensor sensorTemp;
	private List<LecturaFactor> listaLecturas= new ArrayList<LecturaFactor>();
	private List<Lectura> listaLecturasSensor= new ArrayList<Lectura>();
	private Date fechaMin;
	private Date fechaMax;
	private boolean verFactores=true;
	//private Dispositivo dispositivoTemp;

	
	@Inject
	private  LecturaFactorListProducer lecturasFactorListProducer;
	
	@Inject
	private  LecturaListProducer lecturasSensorListProducer;
	


	public void obtenerLecturasFactor()
	{
		listaLecturas= new ArrayList<LecturaFactor>();
		if (fechaMin == null && fechaMax == null)
			listaLecturas= lecturasFactorListProducer.getLecturasIdFactor(factorTemp.getIdFactor());
		else
		{
			if (fechaMax == null)
				fechaMax= new Date();
			if (fechaMin == null)
			{
				fechaMin= new Date();
				fechaMin.setYear(fechaMin.getYear()-1);
			}
			Timestamp min= new Timestamp(fechaMin.getTime());
			Timestamp max= new Timestamp(fechaMax.getTime());
			listaLecturas= lecturasFactorListProducer.getLecturasFactorIdFactorEntreFechas(factorTemp.getIdFactor(), min, max);
		}
	}
	
	public void obtenerLecturasSensor()
	{
		listaLecturasSensor= new ArrayList<Lectura>();
		if (fechaMin == null && fechaMax == null)
			listaLecturasSensor= lecturasSensorListProducer.getLecturasIdSensor(sensorTemp.getId());
		else
		{
			if (fechaMax == null)
				fechaMax= new Date();
			if (fechaMin == null)
			{
				fechaMin= new Date();
				fechaMin.setYear(fechaMin.getYear()-1);
			}
			Timestamp min= new Timestamp(fechaMin.getTime());
			Timestamp max= new Timestamp(fechaMax.getTime());
			listaLecturasSensor= lecturasSensorListProducer.getLecturasIdSensorEntreFechas(sensorTemp.getId(), min, max);
		}
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

	
	
	
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "gfx" + File.separator + "C&P2.png";
         
        pdf.add(Image.getInstance(logo));
        pdf.addTitle("Lecturas");
        pdf.add(new Paragraph("Factor: "+ factorTemp.getNombre()));
        
        if (fechaMin != null && fechaMax != null)
        {
        	Timestamp min= new Timestamp(fechaMin.getTime());
			Timestamp max= new Timestamp(fechaMax.getTime());
        	pdf.add(new Paragraph("Período: "+ min + " - "+ max));
        }
        pdf.add(new Paragraph(" "));
        pdf.add(new Paragraph(" "));
	
    }
	
	public void preProcessPDF_Sens(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "gfx" + File.separator + "C&P2.png";
         
        pdf.add(Image.getInstance(logo));
        pdf.addTitle("Lecturas");
        pdf.add(new Paragraph("Sensor: "+ sensorTemp.getNombre()));
        
        if (fechaMin != null && fechaMax != null)
        {
        	Timestamp min= new Timestamp(fechaMin.getTime());
			Timestamp max= new Timestamp(fechaMax.getTime());
        	pdf.add(new Paragraph("Período: "+ min + " - "+ max));
        }
        pdf.add(new Paragraph(" "));
        pdf.add(new Paragraph(" "));
	
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
	 * @return the listaLecturas
	 */
	public List<LecturaFactor> getListaLecturas() {
		return listaLecturas;
	}



	/**
	 * @param listaLecturas the listaLecturas to set
	 */
	public void setListaLecturas(List<LecturaFactor> listaLecturas) {
		this.listaLecturas = listaLecturas;
	}



	/**
	 * @return the verFactores
	 */
	public boolean isVerFactores() {
		return verFactores;
	}



	/**
	 * @param verFactores the verFactores to set
	 */
	public void setVerFactores(boolean verFactores) {
		this.verFactores = verFactores;
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
	 * @return the listaLecturasSensor
	 */
	public List<Lectura> getListaLecturasSensor() {
		return listaLecturasSensor;
	}



	/**
	 * @param listaLecturasSensor the listaLecturasSensor to set
	 */
	public void setListaLecturasSensor(List<Lectura> listaLecturasSensor) {
		this.listaLecturasSensor = listaLecturasSensor;
	}
	
}
