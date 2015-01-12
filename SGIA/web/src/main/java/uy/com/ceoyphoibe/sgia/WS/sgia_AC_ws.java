package uy.com.ceoyphoibe.sgia.WS;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import uy.com.ceoyphoibe.SGIA.DTO.AccionWS;
import uy.com.ceoyphoibe.SGIA.DTO.LecturaWS;
import uy.com.ceoyphoibe.SGIA.DTO.LogEventoWS;
import uy.com.ceoyphoibe.SGIA.controller.RegistroAccion;
import uy.com.ceoyphoibe.SGIA.controller.RegistroDispositivo;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLecturaFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLogEvento;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoLogEvento;
import uy.com.ceoyphoibe.SGIA.model.Accion;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Lectura;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
import uy.com.ceoyphoibe.SGIA.model.LogEvento;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;

@WebService
public class sgia_AC_ws implements Serializable {

	private static final long serialVersionUID = 2953071844666719795L;

	@Inject
	private RegistroPlaca rPlaca;

	@Inject
	private RegistroLectura rLectura;

	@Inject
	private RegistroLecturaFactor rLecturaFactor;

	@Inject
	private RegistroLogEvento rLogEvento;

	@Inject
	private RegistroAccion rAcciones;

	@Inject
	private RegistroDispositivo rDispositivo;

	@Inject
	private RegistroTipoLogEvento rTipoLogEvento;

	@Inject
	private RegistroMensaje rMensaje;

	@WebMethod
	public boolean inLecturas(String nroSerie, List<LecturaWS> listaLecturas) {
		Long idPlaca = rPlaca.obtenerIdPlacaNroSerie(nroSerie);
		for (LecturaWS lectura : listaLecturas) {
			Lectura l = new Lectura();
			l.setIdPlaca(idPlaca);
			Timestamp fechaHora = Timestamp.valueOf(lectura.getFecha());
			l.setFechaHora(fechaHora);
			Long idDispositivo = new Long(lectura.getIdDispositivo());
			l.setIdSensor(idDispositivo);
			l.setValor(lectura.getLectura());
			try {
				rLectura.registro(l);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return true;
	}

	@WebMethod
	public boolean inLecturasFactor(String nroSerie,
			List<LecturaWS> listaLecturas) {
		Long idPlaca = rPlaca.obtenerIdPlacaNroSerie(nroSerie);
		for (LecturaWS lectura : listaLecturas) {
			LecturaFactor l = new LecturaFactor();
			l.setIdPlaca(idPlaca);
			Timestamp fechaHora = Timestamp.valueOf(lectura.getFecha());
			l.setFechaHora(fechaHora);
			Long idFactor = new Long(lectura.getIdDispositivo());
			l.setIdFactor(idFactor);
			l.setValor(lectura.getLectura());
			try {
				rLecturaFactor.registro(l);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@WebMethod
	public boolean inAcciones(String nroSerie, List<AccionWS> listaAcciones) {
		Long idPlaca = rPlaca.obtenerIdPlacaNroSerie(nroSerie);
		for (AccionWS accion : listaAcciones) {
			Accion a = new Accion();
			a.setIdPlaca(idPlaca);
			Timestamp fechaHora = Timestamp.valueOf(accion.getFecha());
			a.setFechaHora(fechaHora);
			Long idActuador = new Long(accion.getIdDispositivo());
			a.setIdDispositivo(idActuador);
			a.setTipoAccion(accion.getTipoAccion());
			try {
				rAcciones.registro(a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@WebMethod
	public boolean inLogEventosPendientes(String nroSerie,
			List<LogEventoWS> listaLogEventoWS) {
		Long idPlaca = rPlaca.obtenerIdPlacaNroSerie(nroSerie);

		for (LogEventoWS logEventoWS : listaLogEventoWS) {
			LogEvento logEvento = new LogEvento();
			Timestamp fechaHora = Timestamp.valueOf(logEventoWS.getFecha());
			logEvento.setFecha(fechaHora);
			Placa placaTemp = rPlaca.obtenerPlacaPorId(idPlaca);
			logEvento.setPlaca(placaTemp);
			Dispositivo dispositivoTemp = rDispositivo
					.obtenerDispositivoPorId(logEventoWS.getIdDispositivo());
			logEvento.setDispositivo(dispositivoTemp);
			TipoLogEvento tipoLogEventoTemp = rTipoLogEvento
					.obtenerTipoLogEventoPorId(logEventoWS.getTipoLog());
			logEvento.setTipoLogEvento(tipoLogEventoTemp);
			Mensaje mensajeTemp = rMensaje.obtenerMensajeId(logEventoWS
					.getIdMensaje());
			logEvento.setMensaje(mensajeTemp);

			try {
				rLogEvento.registro(logEvento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	@WebMethod
	public boolean inLogEvento(String nroSerie, LogEventoWS logEventoWS) {
		Long idPlaca = rPlaca.obtenerIdPlacaNroSerie(nroSerie);

		LogEvento logEvento = new LogEvento();
		Timestamp fechaHora = Timestamp.valueOf(logEventoWS.getFecha());
		logEvento.setFecha(fechaHora);
		Placa placaTemp = rPlaca.obtenerPlacaPorId(idPlaca);
		logEvento.setPlaca(placaTemp);
		Dispositivo dispositivoTemp = rDispositivo
				.obtenerDispositivoPorId(logEventoWS.getIdDispositivo());
		logEvento.setDispositivo(dispositivoTemp);
		TipoLogEvento tipoLogEventoTemp = rTipoLogEvento
				.obtenerTipoLogEventoPorId(logEventoWS.getTipoLog());
		logEvento.setTipoLogEvento(tipoLogEventoTemp);
		Mensaje mensajeTemp = rMensaje.obtenerMensajeId(logEventoWS
				.getIdMensaje());
		logEvento.setMensaje(mensajeTemp);

		try {
			rLogEvento.registro(logEvento);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}
