package uy.com.ceoyphoibe.sgia.bean;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.primefaces.event.RowEditEvent;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

import uy.com.ceoyphoibe.SGIA.controller.RegistroLogEvento;
import uy.com.ceoyphoibe.SGIA.data.LogEventoListProducer;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.LogEvento;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;

@ManagedBean
@RequestScoped
public class LogEventoBean {

	@Inject
	private RegistroLogEvento registroLogEvento;

	@Inject
	private LogEventoListProducer logEventosListProducer;

	private TipoLogEvento tipoLogEvento;
	private Mensaje mensaje;
	private Dispositivo dispositivo;
	private List<LogEvento> logEventos;
	private Date fechaMin;
	private Date fechaMax;


	@PostConstruct
	public void init() {
		logEventos = logEventosListProducer.getLogEventos();
		// logEventosSeleccionados = logEventosListProducer.getLogEventos();
	}

	/**
	 * @return the tipoLogEvento
	 */
	public TipoLogEvento getTipoLogEvento() {
		return tipoLogEvento;
	}

	/**
	 * @param tipoLogEvento
	 *            the tipoLogEvento to set
	 */
	public void setTipoLogEvento(TipoLogEvento tipoLogEvento) {
		this.tipoLogEvento = tipoLogEvento;
	}

	/**
	 * @return the mensaje
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the dispositivo
	 */
	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo
	 *            the dispositivo to set
	 */
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public void onEdit(RowEditEvent event) {
		LogEvento logEvento = ((LogEvento) event.getObject());

		try {
			registroLogEvento.modificar(logEvento);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", logEvento.getIdLogEvento().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", logEvento.getIdLogEvento()
							.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((LogEvento) event.getObject()).getIdLogEvento().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			registroLogEvento.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	/**
	 * @return the logEventos
	 */
	public List<LogEvento> getLogEventos() {
		return logEventos;
	}

	/**
	 * @param logEventos
	 *            the logEventos to set
	 */
	public void setLogEventos(List<LogEvento> logEventos) {
		this.logEventos = logEventos;
	}

	/**
	 * @return the fechaMin
	 */
	public Date getFechaMin() {
		return fechaMin;
	}

	/**
	 * @param fechaMin
	 *            the fechaMin to set
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
	 * @param fechaMax
	 *            the fechaMax to set
	 */
	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}

	@SuppressWarnings("deprecation")
	public void obtenerLogEventos() {
		logEventos = new ArrayList<LogEvento>();
		if (fechaMin == null && fechaMax == null)
			logEventos = logEventosListProducer.getLogEventos();
		else {
			if (fechaMax == null)
				fechaMax = new Date();
			if (fechaMin == null) {
				fechaMin = new Date();
				fechaMin.setYear(fechaMin.getYear() - 1);
			}
			Timestamp min = new Timestamp(fechaMin.getTime());
			Timestamp max = new Timestamp(fechaMax.getTime());
			logEventos = logEventosListProducer.getLogEventosEntreFechas(min,
					max);
		}
	}

	public void preProcessPDF(Object document) throws IOException,
			BadElementException, DocumentException {
		Document pdf = (Document) document;
		pdf.open();
		pdf.setPageSize(PageSize.A4);

		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "gfx" + File.separator
				+ "C&P2.png";

		pdf.add(Image.getInstance(logo));
		pdf.addTitle("Log de Eventos");
		pdf.add(new Paragraph("Log de Eventos: "));

		if (fechaMin != null && fechaMax != null) {
			Timestamp min = new Timestamp(fechaMin.getTime());
			Timestamp max = new Timestamp(fechaMax.getTime());
			pdf.add(new Paragraph("Período: " + min + " - " + max));
		}
		pdf.add(new Paragraph(" "));
		pdf.add(new Paragraph(" "));

	}

}
