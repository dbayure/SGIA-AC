package uy.com.ceoyphoibe.sgia.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import uy.com.ceoyphoibe.SGIA.controller.RegistroDispositivo;
import uy.com.ceoyphoibe.SGIA.controller.RegistroGrupoActuadores;
import uy.com.ceoyphoibe.SGIA.data.AccionListProducer;
import uy.com.ceoyphoibe.SGIA.model.Accion;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "accionesBean")
@SessionScoped
public class AccionesBean {

	private GrupoActuadores grupoActuadoresTemp;
	private List<Long> listaIdActuadores;
	private int idActuadorSeleccionado;
	private long idGrupo;
	private List<Accion> listaAcciones = new ArrayList<Accion>();
	private Date fechaMin;
	private Date fechaMax;
	private Dispositivo dispositivoTemp;

	@Inject
	private AccionListProducer accionListProducer;

	@Inject
	private RegistroGrupoActuadores registroGrupoActuadores;

	@Inject
	private RegistroDispositivo registroDispositivo;

	/**
	 * @return the grupoActuadoresTemp
	 */
	public GrupoActuadores getGrupoActuadoresTemp() {
		return grupoActuadoresTemp;
	}

	/**
	 * @param grupoActuadoresTemp
	 *            the grupoActuadoresTemp to set
	 */
	public void setGrupoActuadoresTemp(GrupoActuadores grupoActuadoresTemp) {
		this.grupoActuadoresTemp = grupoActuadoresTemp;
	}

	/**
	 * @return the idActuadorSeleccionado
	 */
	public int getIdActuadorSeleccionado() {
		return idActuadorSeleccionado;
	}

	/**
	 * @param idActuadorSeleccionado
	 *            the idActuadorSeleccionado to set
	 */
	public void setIdActuadorSeleccionado(int idActuadorSeleccionado) {
		this.idActuadorSeleccionado = idActuadorSeleccionado;
	}

	public void cambioGrupoActuadores() {
		grupoActuadoresTemp = registroGrupoActuadores
				.obtenerGrupoPorId(idGrupo);
	}

	/**
	 * @return the idGrupo
	 */
	public long getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo
	 *            the idGrupo to set
	 */
	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}

	@SuppressWarnings("deprecation")
	public void obtenerAcciones() {
		listaAcciones = new ArrayList<Accion>();
		if (idActuadorSeleccionado != 0) {
			Long idAct = (long) idActuadorSeleccionado;
			if (fechaMin == null && fechaMax == null)
				listaAcciones = accionListProducer
						.getAccionesIdDispositivo(idAct);
			else {
				if (fechaMax == null)
					fechaMax = new Date();
				if (fechaMin == null) {
					fechaMin = new Date();
					fechaMin.setYear(fechaMin.getYear() - 1);
				}
				Timestamp min = new Timestamp(fechaMin.getTime());
				Timestamp max = new Timestamp(fechaMax.getTime());
				listaAcciones = accionListProducer
						.getAccionesIdDispositivoEntreFechas(idAct, min, max);
			}
		} else {
			listaIdActuadores = new ArrayList<Long>();
			if (grupoActuadoresTemp.getDeAvance().equals("N")) {
				List<Actuador> listaActuadores = grupoActuadoresTemp
						.getActuadores();
				for (Actuador a : listaActuadores) {
					listaIdActuadores.add(a.getId());
				}
			} else {
				Set<ActuadorAvance> listaActuadoresAvance = grupoActuadoresTemp
						.getActuadoresAvance();
				for (ActuadorAvance a : listaActuadoresAvance) {
					listaIdActuadores.add(a.getId());
				}
			}
			for (Long i : listaIdActuadores) {
				List<Accion> accionesTemp = new ArrayList<Accion>();
				if (fechaMin == null && fechaMax == null)
					accionesTemp = accionListProducer
							.getAccionesIdDispositivo(i);
				else {
					if (fechaMax == null)
						fechaMax = new Date();
					if (fechaMin == null) {
						fechaMin = new Date();
						fechaMin.setYear(fechaMin.getYear() - 1);
					}
					Timestamp min = new Timestamp(fechaMin.getTime());
					Timestamp max = new Timestamp(fechaMax.getTime());
					accionesTemp = accionListProducer
							.getAccionesIdDispositivoEntreFechas(i, min, max);
				}
				for (Accion acc : accionesTemp) {
					listaAcciones.add(acc);
				}
			}
		}
	}

	/**
	 * @return the listaAcciones
	 */
	public List<Accion> getListaAcciones() {
		return listaAcciones;
	}

	/**
	 * @param listaAcciones
	 *            the listaAcciones to set
	 */
	public void setListaAcciones(List<Accion> listaAcciones) {
		this.listaAcciones = listaAcciones;
	}

	/**
	 * @return the listaIdActuadores
	 */
	public List<Long> getListaIdActuadores() {
		return listaIdActuadores;
	}

	/**
	 * @param listaIdActuadores
	 *            the listaIdActuadores to set
	 */
	public void setListaIdActuadores(List<Long> listaIdActuadores) {
		this.listaIdActuadores = listaIdActuadores;
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

	/**
	 * @return the dispositivoTemp
	 */
	public Dispositivo getDispositivoTemp() {
		return dispositivoTemp;
	}

	/**
	 * @param dispositivoTemp
	 *            the dispositivoTemp to set
	 */
	public void setDispositivoTemp(Dispositivo dispositivoTemp) {
		this.dispositivoTemp = dispositivoTemp;
	}

	public void obtenerDispositivo(Long id) {
		dispositivoTemp = registroDispositivo.obtenerDispositivoPorId(id);
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
		pdf.addTitle("Acciones");
		pdf.add(new Paragraph("Grupo de Actuadores: "
				+ grupoActuadoresTemp.getNombre()));
		if (idActuadorSeleccionado == 0)
			pdf.add(new Paragraph("Actuadores: Todos"));
		else {
			Dispositivo dispositivo = registroDispositivo
					.obtenerDispositivoPorId(idActuadorSeleccionado);
			pdf.add(new Paragraph("Actuador: " + dispositivo.getNombre()));
		}
		if (fechaMin != null && fechaMax != null) {
			Timestamp min = new Timestamp(fechaMin.getTime());
			Timestamp max = new Timestamp(fechaMax.getTime());
			pdf.add(new Paragraph("Período: " + min + " - " + max));
		}
		pdf.add(new Paragraph(" "));
		pdf.add(new Paragraph(" "));

	}

}
