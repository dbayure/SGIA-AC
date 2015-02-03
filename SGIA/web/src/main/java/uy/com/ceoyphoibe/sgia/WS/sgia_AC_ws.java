package uy.com.ceoyphoibe.sgia.WS;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import uy.com.ceoyphoibe.SGIA.DTO.AccionWS;
import uy.com.ceoyphoibe.SGIA.DTO.Accion_AM;
import uy.com.ceoyphoibe.SGIA.DTO.Dispositivo_AM;
import uy.com.ceoyphoibe.SGIA.DTO.EstadosPlaca_AM;
import uy.com.ceoyphoibe.SGIA.DTO.Factor_AM;
import uy.com.ceoyphoibe.SGIA.DTO.GrupoActuador_AM;
import uy.com.ceoyphoibe.SGIA.DTO.LecturaWS;
import uy.com.ceoyphoibe.SGIA.DTO.Lectura_AM;
import uy.com.ceoyphoibe.SGIA.DTO.LogEventoWS;
import uy.com.ceoyphoibe.SGIA.DTO.LogEvento_AM;
import uy.com.ceoyphoibe.SGIA.DTO.Placa_AM;
import uy.com.ceoyphoibe.SGIA.DTO.TipoLogEvento_AM;
import uy.com.ceoyphoibe.SGIA.controller.RegistroAccion;
import uy.com.ceoyphoibe.SGIA.controller.RegistroDispositivo;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLecturaFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLogEvento;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.controller.RegistroTipoLogEvento;
import uy.com.ceoyphoibe.SGIA.data.AccionListProducer;
import uy.com.ceoyphoibe.SGIA.data.DispositivoListProducer;
import uy.com.ceoyphoibe.SGIA.data.FactorListProducer;
import uy.com.ceoyphoibe.SGIA.data.GrupoActuadoresListProducer;
import uy.com.ceoyphoibe.SGIA.data.LecturaFactorListProducer;
import uy.com.ceoyphoibe.SGIA.data.LogEventoListProducer;
import uy.com.ceoyphoibe.SGIA.data.PlacaListProducer;
import uy.com.ceoyphoibe.SGIA.model.Accion;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Lectura;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;
import uy.com.ceoyphoibe.SGIA.model.LogEvento;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;

/**
 * Clase utilizada para publicar servicios web, para establecer comunicación con la placa controladora y los dispositivos móviles.
 */
@WebService(targetNamespace = "http://sgiaAC/")
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
	
	@Inject
	private PlacaListProducer placaListProducer;
	
	@Inject
	private FactorListProducer factorListProducer;
	
	@Inject
	private LecturaFactorListProducer lecturaFactorListProducer;
	
	@Inject
	private AccionListProducer accionListProducer;
	
	@Inject
	private LogEventoListProducer logEventoListProducer;
	
	@Inject
	private GrupoActuadoresListProducer grupoActuadoresListProducer;
	
	@Inject
	private DispositivoListProducer dispositivoListProducer;
	
	/**
	 * WS que permite recibir una lista de lecturas de una placa auxiliar y persistirlas en el sistema.
	 * @param nroSerie
	 * @param listaLecturas
	 * @return una confirmación si finalizó correctamente
	 */
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

	/**
	 * WS que permite recibir desde la placa controladora una lista de lecturas de factores.
	 * @param nroSerie
	 * @param listaLecturas
	 * @return una confirmación si finalizó correctamente
	 */
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

	/**
	 * WS que permite recibir desde la placa controladora una lista de acciones.
	 * @param nroSerie
	 * @param listaAcciones
	 * @return una confirmación si finalizó correctamente
	 */
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

	/**
	 * WS que permite recibir desde la placa controladora una lista de log eventos.
	 * @param nroSerie
	 * @param listaLogEventoWS
	 * @return una confirmación si finalizó correctamente
	 */
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

	/**
	 * WS que permite recibir desde la placa controladora un log de eventos
	 * @param nroSerie
	 * @param logEventoWS
	 * @return una confirmación si finalizó correctamente
	 */
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
	
	/**
	 * WS que permite obtener la lista de placas controladoras disponibles
	 * @return una lista de Placas como objetos Placa_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<Placa_AM> wsObtenerListaPlacas() {
		List<Placa> listaPlacas= placaListProducer.getPlacas();
		ArrayList<Placa_AM> listaPlacasWS= new ArrayList<Placa_AM>();
		for (Placa p : listaPlacas)
		{
			
			Placa_AM placa= new Placa_AM(p.getId(), String.valueOf(p.getEstado()), p.getNroSerie(), p.getDescripcion(), String.valueOf(p.getEstadoAlerta()) );
			listaPlacasWS.add(placa);
		}
		return listaPlacasWS;
	}
	
	/**
	 * WS que permite obtener la lista de factores pertenecientes a la placa controladora al que corresponde el id pasado como parámetro
	 * @return una lista de Factores como objetos Factor_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<Factor_AM> wsObtenerListaFactores(Long idPlaca) {
		
		List<Factor> listaFactores= factorListProducer.obtenerFactoresPlaca(idPlaca);
		ArrayList<Factor_AM> listaFactoresAM= new ArrayList<Factor_AM>();
		for (Factor f : listaFactores)
		{
			Factor_AM factor= new Factor_AM(f.getIdFactor(), f.getNombre(), f.getUnidad(), f.getValorMin(), f.getValorMax());
			listaFactoresAM.add(factor);
		}
		return listaFactoresAM;
	}
	
	/**
	 * WS que permite obtener la lista de lecturas pertenecientes a la placa controladora y al factor al que corresponden los ids pasados como parámetros
	 * @return una lista de Factores como objetos Factor_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<Lectura_AM> wsObtenerListaLecturas(Long idPlaca, Long idFactor) {
		
		List<LecturaFactor> listaLecturas= lecturaFactorListProducer.obtenerUltimasDiezLecturasFactor(idPlaca, idFactor);
		ArrayList<Lectura_AM> listaLecturasAM= new ArrayList<Lectura_AM>();
		for (LecturaFactor l : listaLecturas)
		{
			Lectura_AM lectura= new Lectura_AM(l.getFechaHora().toString(), l.getValor());
			listaLecturasAM.add(lectura);
		}
		return listaLecturasAM;
	}
	
	/**
	 * WS que permite obtener los estados de la placa controladora que corresponde con el id pasado como parámetro
	 */
	@WebMethod
	public EstadosPlaca_AM wsObtenerEstadosPlaca(Long idPlaca) {
		Placa placaSel= rPlaca.obtenerPlacaPorId(idPlaca);
		EstadosPlaca_AM estados= new EstadosPlaca_AM(String.valueOf(placaSel.getEstado()), String.valueOf(placaSel.getEstadoAlerta()));
		return estados;
	}
	
	/**
	 * WS que permite obtener la lista de lecturas pertenecientes a la placa controladora y al factor al que corresponden los ids pasados como parámetros
	 * @return una lista de Factores como objetos Factor_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<Accion_AM> wsObtenerListaAcciones(Long idPlaca) {
		
		List<Accion> listaAcciones= accionListProducer.obtenerUltimasAcciones(idPlaca);
		ArrayList<Accion_AM> listaAccionesAM= new ArrayList<Accion_AM>();
		for (Accion a : listaAcciones)
		{
			Dispositivo d= rDispositivo.obtenerDispositivoId(a.getIdDispositivo());
			Dispositivo_AM dispAM= new Dispositivo_AM(d.getId(), d.getNombre(), d.getModelo(), d.getEstadoAlerta());
			Accion_AM accionAM= new Accion_AM(a.getFechaHora().toString(), a.getTipoAccion(), dispAM);
			listaAccionesAM.add(accionAM);
		}
		return listaAccionesAM;
	}
	
	/**
	 * WS que permite obtener la lista de lecturas pertenecientes a la placa controladora y al factor al que corresponden los ids pasados como parámetros
	 * @return una lista de Factores como objetos Factor_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<LogEvento_AM> wsObtenerListaLogEventos(Long idPlaca) {
		
		List<LogEvento> listaLogEventos= logEventoListProducer.obtenerUltimosLogEventos(idPlaca);
		ArrayList<LogEvento_AM> listaLogEventosAM= new ArrayList<LogEvento_AM>();
		for (LogEvento l : listaLogEventos)
		{
			Dispositivo d= l.getDispositivo();
			Dispositivo_AM dispAM= new Dispositivo_AM(d.getId(), d.getNombre(), d.getModelo(), d.getEstadoAlerta());
			Mensaje m= l.getMensaje();
			TipoLogEvento t= l.getTipoLogEvento();
			TipoLogEvento_AM tipoLogAM= new TipoLogEvento_AM(t.getIdTipoLogEvento(), t.getNombre(), String.valueOf(t.getEnviarSMS()), String.valueOf(t.getEnviarMail()));
			LogEvento_AM logEventoAM= new LogEvento_AM(l.getIdLogEvento(), l.getFecha().toString(), m, tipoLogAM, dispAM);
			listaLogEventosAM.add(logEventoAM);
		}
		return listaLogEventosAM;
	}
	
	/**
	 * WS que permite obtener la lista de grupos de actuadores pertenecientes a la placa controladora al que corresponde el id pasado como parámetro
	 * @return una lista de Grupos de Actuadores como objetos GrupoActuador_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<GrupoActuador_AM> wsObtenerListaGrupoActuadores(Long idPlaca) {
		
		List<GrupoActuadores> listaGrupos= grupoActuadoresListProducer.obtenerGrupoActuadoresPlaca(idPlaca);
		ArrayList<GrupoActuador_AM> listaGruposAM= new ArrayList<GrupoActuador_AM>();
		for (GrupoActuadores g : listaGrupos)
		{
			String estado= String.valueOf(g.getEstado());
			GrupoActuador_AM grupoAM= new GrupoActuador_AM(g.getNombre(), estado);
			listaGruposAM.add(grupoAM);
		}
		return listaGruposAM;
	}
	
	/**
	 * WS que permite obtener la lista de dispositivos pertenecientes a la placa controladora al que corresponde el id pasado como parámetro
	 * @return una lista de Grupos de Actuadores como objetos GrupoActuador_AM para ser interpretados en la aplicación móvil
	 */
	@WebMethod
	public ArrayList<Dispositivo_AM> wsObtenerListaDispositivos(Long idPlaca) {
		
		List<Dispositivo> listaDispositivos= dispositivoListProducer.obtenerDispositivosPlaca(idPlaca);
		ArrayList<Dispositivo_AM> listaDispositivosAM= new ArrayList<Dispositivo_AM>();
		for (Dispositivo d : listaDispositivos)
		{
			
			Dispositivo_AM dispositivoAM= new Dispositivo_AM(d.getId(), d.getNombre(), d.getModelo(), d.getEstadoAlerta());
			listaDispositivosAM.add(dispositivoAM);
		}
		return listaDispositivosAM;
	}
}
