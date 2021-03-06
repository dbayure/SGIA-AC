
package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.xml.ws.BindingProvider;
import com.sun.xml.internal.ws.client.*;


import uy.com.ceoyphoibe.SGIA.DTO.ResultadoAccion;
import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroMensaje;
import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Destinatario;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.NivelSeveridad;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.PlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
import uy.com.ceoyphoibe.SGIA.model.Sensor;
import uy.com.ceoyphoibe.SGIA.model.TipoActuador;
import uy.com.ceoyphoibe.SGIA.model.TipoLogEvento;
import uy.com.ceoyphoibe.SGIA.model.TipoPlacaAuxiliar;
import uy.com.ceoyphoibe.SGIA.util.Herramientas;
/**
 * La clase FachadaWS permite conectar con los servicios web publicados en las placas controladoras e invocar los servicios publicados en esta.
 * Actúa como intermediario para el pasaje y la transformación de datos entre los métodos del sistema y los servicios web invocados.
 */
public class FachadaWS {

	@Inject
	RegistroMensaje registroMensaje;
	
	public FachadaWS() {

	}

	private Comunicacion iniciarConexion(String ip, int puerto) throws WsPlacaControladoraException {
		Comunicacion port1 = null;
		try
		{
			Herramientas h = new Herramientas();
			URL wsdl = h.obtenerWSDL(ip, String.valueOf(puerto));
			Comunicacion_Service service1 = new Comunicacion_Service(wsdl);
			port1 = service1.getComunicacion();
		}
		catch (Exception ex)
		{
			throw new WsPlacaControladoraException("Pérdida de conectividad con la placa controladora.");
		}
		
		return port1;
	}

	public Placa obtenerDatosPlaca(String ip, int puerto) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(ip, puerto);

		Placa placa = new Placa();

		ResultadoDatosPlacaWS datosPlaca = clienteWS
				.wsObtenerDatosPlaca(BigInteger.valueOf(0));

		placa.setNroSerie(datosPlaca.getNroSeriePlaca());
		placa.setEstado(datosPlaca.getEstadoPlaca().charAt(0));
		placa.setEstadoAlerta(datosPlaca.getEstadoAlerta().charAt(0));
		placa.setPeriodicidadLecturas(datosPlaca.getPeriodicidadLecturas()
				.intValue());
		placa.setPeriodicidadNiveles(datosPlaca.getPeriodicidadNiveles()
				.intValue());
		if (datosPlaca.getHostWSCentralizadora() != null
				&& !datosPlaca.getHostWSCentralizadora().equals(""))
			placa.setIpCentralizadora(datosPlaca.getHostWSCentralizadora());
		if (datosPlaca.getPuertoWSCentralizadora() != null
				&& !datosPlaca.getPuertoWSCentralizadora().equals(""))
			placa.setPuertoCentralizadora(Integer.valueOf(datosPlaca
					.getPuertoWSCentralizadora()));
		if (datosPlaca.getHostWSSMS() != null
				&& !datosPlaca.getHostWSSMS().equals(""))
			placa.setHostWSSMS(datosPlaca.getHostWSSMS());
		if (datosPlaca.getPuertoWSSMS() != null
				&& !datosPlaca.getPuertoWSSMS().equals(""))
			placa.setPuertoWSSMS(Integer.valueOf(datosPlaca.getPuertoWSSMS()));
		placa.setPuertoPlaca(puerto);
		placa.setIpPlaca(ip);

		return placa;
	}

	public boolean asociarSensorFactor(Sensor sensor) throws WsPlacaControladoraException {
		boolean ok = false;
		Comunicacion clienteWS = iniciarConexion(
				sensor.getPlaca().getIpPlaca(), sensor.getPlaca()
						.getPuertoPlaca());
		BigInteger idFactor = null;
		if (sensor.getFactor() != null)
			idFactor = BigInteger.valueOf(sensor.getFactor().getIdFactor());
		BigInteger idDispositivo = BigInteger.valueOf(sensor.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje mensajeResultado = clienteWS
				.wsAsociarFactorSensor(idFactor, idDispositivo);
		ok = mensajeResultado.getTipo().equals("Informativo");
		return ok;
	}

	public Factor registroFactor(Factor factor) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(
				factor.getPlaca().getIpPlaca(), factor.getPlaca()
						.getPuertoPlaca());

		BigInteger valorMin = BigInteger.valueOf(factor.getValorMin());
		BigInteger valorMax = BigInteger.valueOf(factor.getValorMax());
		BigInteger umbral = BigInteger.valueOf(factor.getUmbral());
		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearFactor(
				factor.getNombre(), factor.getUnidad(), valorMin, valorMax,
				umbral);
		Long id = resultadoWS.getIdObjeto().longValue();
		factor.setIdFactor(id);

		return factor;
	}

	public Sensor registroSensor(Sensor sensor) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(
				sensor.getPlaca().getIpPlaca(), sensor.getPlaca()
						.getPuertoPlaca());

		BigInteger nroPuerto = BigInteger.valueOf(sensor.getNumeroPuerto());
		BigInteger idTipoPuerto = BigInteger.valueOf(sensor.getTipoPuerto()
				.getId());
		BigInteger idPlacaPadre = null;
		if (sensor.getPadre() != null)
			idPlacaPadre = BigInteger.valueOf(sensor.getPadre().getId());
		BigInteger idFactor = null;
		if (sensor.getFactor() != null)
			idFactor = BigInteger.valueOf(sensor.getFactor().getIdFactor());

		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearSensor(
				sensor.getNombre(), sensor.getModelo(), nroPuerto,
				sensor.getFormulaConversion(), idTipoPuerto, idPlacaPadre,
				idFactor);
		Long id = resultadoWS.getIdObjeto().longValue();
		sensor.setId(id);
		return sensor;
	}

	public Actuador registroActuador(Actuador actuador) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuador.getPlaca()
				.getIpPlaca(), actuador.getPlaca().getPuertoPlaca());

		BigInteger nroPuerto = BigInteger.valueOf(actuador.getNumeroPuerto());
		BigInteger idTipoPuerto = BigInteger.valueOf(actuador.getTipoPuerto()
				.getId());
		BigInteger idTipoActuador = BigInteger.valueOf(actuador
				.getTipoActuador().getId());
		BigInteger idPlacaPadre = null;
		if (actuador.getPadre() != null)
			idPlacaPadre = BigInteger.valueOf(actuador.getPadre().getId());
		BigInteger idGrupoActuadores = null;
		if (actuador.getGrupoActuadores() != null)
			idGrupoActuadores = BigInteger.valueOf(actuador
					.getGrupoActuadores().getId());

		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearActuador(
				actuador.getNombre(), actuador.getModelo(), nroPuerto,
				idTipoPuerto, idTipoActuador, idPlacaPadre, idGrupoActuadores);
		Long id = resultadoWS.getIdObjeto().longValue();
		actuador.setId(id);
		return actuador;
	}

	public ActuadorAvance registroActuadorAvance(ActuadorAvance actuadorAvance) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuadorAvance.getPlaca()
				.getIpPlaca(), actuadorAvance.getPlaca().getPuertoPlaca());

		BigInteger nroPuerto = BigInteger.valueOf(actuadorAvance
				.getNumeroPuerto());
		BigInteger nroPuertoRetroceso = BigInteger.valueOf(actuadorAvance
				.getNumeroPuertoRetroceso());
		BigInteger posicion = BigInteger.valueOf(actuadorAvance.getPosicion());
		BigInteger idTipoPuerto = BigInteger.valueOf(actuadorAvance
				.getTipoPuerto().getId());
		BigInteger tiempoEntrePosiciones = BigInteger.valueOf(actuadorAvance
				.getTiempoEntrePosiciones());
		BigInteger idTipoActuador = BigInteger.valueOf(actuadorAvance
				.getTipoActuador().getId());
		BigInteger idPlacaPadre = null;
		if (actuadorAvance.getPadre() != null)
			idPlacaPadre = BigInteger
					.valueOf(actuadorAvance.getPadre().getId());
		BigInteger idGrupoActuadores = null;
		if (actuadorAvance.getGrupoActuadores() != null)
			idGrupoActuadores = BigInteger.valueOf(actuadorAvance
					.getGrupoActuadores().getId());

		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearActuadorAvance(
				actuadorAvance.getNombre(), actuadorAvance.getModelo(),
				nroPuerto, posicion, idTipoPuerto, idTipoActuador,
				idPlacaPadre, nroPuertoRetroceso, idTipoPuerto,
				tiempoEntrePosiciones, idGrupoActuadores);
		Long id = resultadoWS.getIdObjeto().longValue();
		actuadorAvance.setId(id);

		BigInteger idActuadorAvance = resultadoWS.getIdObjeto();
		Set<Posicion> posiciones = actuadorAvance.getListaPosiciones();
		Iterator<Posicion> itPosiciones = posiciones.iterator();
		while (itPosiciones.hasNext()) {
			Posicion posicionTemp = itPosiciones.next();
			BigInteger numeroPosicion = BigInteger.valueOf(posicionTemp
					.getNroPosicion());
			BigInteger valor = BigInteger.valueOf(posicionTemp.getValor());
			clienteWS.wsAgregarPosicionActuadorAvance(idActuadorAvance,
					numeroPosicion, posicionTemp.getDescripcion(), valor);
			Set<Sensor> listaSensores = posicionTemp.getListaSensores();
			Iterator<Sensor> itSensor = listaSensores.iterator();
			while (itSensor.hasNext()) {
				Sensor sensorTemp = itSensor.next();
				BigInteger idSensor = BigInteger.valueOf(sensorTemp.getId());
				clienteWS.wsAgregarSensorPosicionActuadorAvance(idSensor,
						idActuadorAvance, numeroPosicion);
			}
		}

		return actuadorAvance;
	}

	public GrupoActuadores registroGrupoActuadores(GrupoActuadores grupo) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(grupo.getPlaca().getIpPlaca(),
				grupo.getPlaca().getPuertoPlaca());

		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearGrupoActuadores(
				grupo.getNombre(), grupo.getDeAvance());
		Long id = resultadoWS.getIdObjeto().longValue();
		grupo.setId(id);

		return grupo;
	}

	public boolean asociarActuadorGrupoActuadores(Actuador actuador) throws WsPlacaControladoraException {
		boolean ok = false;
		Comunicacion clienteWS = iniciarConexion(actuador.getPlaca()
				.getIpPlaca(), actuador.getPlaca().getPuertoPlaca());
		BigInteger idGrupoActuadores = null;
		if (actuador.getGrupoActuadores() != null)
			idGrupoActuadores = BigInteger.valueOf(actuador
					.getGrupoActuadores().getId());
		BigInteger idDispositivo = BigInteger.valueOf(actuador.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje mensajeResultado = clienteWS
				.wsAsociarActuadorGrupo(idGrupoActuadores, idDispositivo);
		ok = mensajeResultado.getTipo().equals("Informativo");
		return ok;
	}

	public boolean asociarActuadorAvanceGrupoActuadores(
			ActuadorAvance actuadorAvance) throws WsPlacaControladoraException {
		boolean ok = false;
		Comunicacion clienteWS = iniciarConexion(actuadorAvance.getPlaca()
				.getIpPlaca(), actuadorAvance.getPlaca().getPuertoPlaca());
		BigInteger idGrupoActuadores = null;
		if (actuadorAvance.getGrupoActuadores() != null)
			idGrupoActuadores = BigInteger.valueOf(actuadorAvance
					.getGrupoActuadores().getId());
		BigInteger idDispositivo = BigInteger.valueOf(actuadorAvance.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje mensajeResultado = clienteWS
				.wsAsociarActuadorAvanceGrupo(idGrupoActuadores, idDispositivo);
		ok = mensajeResultado.getTipo().equals("Informativo");
		return ok;
	}

	public TipoActuador registroTipoActuador(TipoActuador tipoActuador) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(tipoActuador.getPlaca()
				.getIpPlaca(), tipoActuador.getPlaca().getPuertoPlaca());

		ResultadoCreacionWS resultadoWS = clienteWS
				.wsCrearTipoActuador(tipoActuador.getCategoria());
		Long id = resultadoWS.getIdObjeto().longValue();
		tipoActuador.setId(id);

		return tipoActuador;
	}

	public Destinatario registroDestinatario(Destinatario destinatario) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(destinatario.getPlaca()
				.getIpPlaca(), destinatario.getPlaca().getPuertoPlaca());
		BigInteger horaMin = BigInteger.valueOf(destinatario.getHoraMin());
		BigInteger horaMax = BigInteger.valueOf(destinatario.getHoraMax());
		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearDestinatario(
				destinatario.getNombre(), destinatario.getCelular(),
				destinatario.getMail(), horaMin, horaMax);
		Long id = resultadoWS.getIdObjeto().longValue();
		destinatario.setIdDestinatario(id);

		return destinatario;
	}

	public Mensaje actualizarDestinatario(Destinatario destinatario) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(destinatario.getPlaca()
				.getIpPlaca(), destinatario.getPlaca().getPuertoPlaca());
		BigInteger horaMin = BigInteger.valueOf(destinatario.getHoraMin());
		BigInteger horaMax = BigInteger.valueOf(destinatario.getHoraMax());
		BigInteger idDestinatario = BigInteger.valueOf(destinatario
				.getIdDestinatario());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarDestinatario(destinatario.getNombre(),
						destinatario.getCelular(), destinatario.getMail(),
						horaMin, horaMax, idDestinatario);
		Mensaje mensaje = new Mensaje();
	
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());

		return mensaje;
	}

	public void asociarDestinatariosTipoLogEventos(TipoLogEvento tipoLogEvento,
			Placa placa) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placa.getIpPlaca(),
				placa.getPuertoPlaca());
		BigInteger idTipoLogEvento = BigInteger.valueOf(tipoLogEvento
				.getIdTipoLogEvento());
		List<Destinatario> destinatarios = tipoLogEvento
				.getListaDestinatarios();
		int i = 0;
		while (i < destinatarios.size()) {
			Destinatario destinatarioTemp = destinatarios.get(i);
			BigInteger idDestinatario = BigInteger.valueOf(destinatarioTemp
					.getIdDestinatario());
			clienteWS.wsAsociarDestinatarioTipoLogEvento(idTipoLogEvento,
					idDestinatario);
			i++;
		}
	}

	public void desasociarDestinatariosTipoLogEventos(
			TipoLogEvento tipoLogEvento, Placa placa) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placa.getIpPlaca(),
				placa.getPuertoPlaca());
		BigInteger idTipoLogEvento = BigInteger.valueOf(tipoLogEvento
				.getIdTipoLogEvento());
		List<Destinatario> destinatarios = tipoLogEvento
				.getListaDestinatarios();
		int i = 0;
		while (i < destinatarios.size()) {
			Destinatario destinatarioTemp = destinatarios.get(i);
			BigInteger idDestinatario = BigInteger.valueOf(destinatarioTemp
					.getIdDestinatario());
			clienteWS.wsDesasociarDestinatarioTipoLogEvento(idTipoLogEvento,
					idDestinatario);
			i++;
		}
	}

	public TipoPlacaAuxiliar registroTipoPlacaAuxiliar(
			TipoPlacaAuxiliar tipoPlacaAuxiliar) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(tipoPlacaAuxiliar.getPlaca()
				.getIpPlaca(), tipoPlacaAuxiliar.getPlaca().getPuertoPlaca());

		ResultadoCreacionWS resultadoWS = clienteWS
				.wsCrearTipoPlaca(tipoPlacaAuxiliar.getNombre());
		Long id = resultadoWS.getIdObjeto().longValue();
		tipoPlacaAuxiliar.setId(id);

		return tipoPlacaAuxiliar;
	}

	public PlacaAuxiliar registroPlacaAuxiliar(PlacaAuxiliar placaAux) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placaAux.getPlaca()
				.getIpPlaca(), placaAux.getPlaca().getPuertoPlaca());

		BigInteger nroPuerto = BigInteger.valueOf(placaAux.getNumeroPuerto());
		BigInteger idTipoPlaca = BigInteger.valueOf(placaAux
				.getTipoPlacaAuxiliar().getId());
		BigInteger idPlacaPadre = null;
		if (placaAux.getPadre() != null)
			idPlacaPadre = BigInteger.valueOf(placaAux.getPadre().getId());

		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearPlacaAuxiliar(
				placaAux.getNombre(), placaAux.getModelo(), nroPuerto,
				placaAux.getNumeroSerie(), idTipoPlaca, idPlacaPadre);
		Long id = resultadoWS.getIdObjeto().longValue();
		placaAux.setId(id);

		return placaAux;
	}

	public NivelSeveridad registroNivelSeveridad(NivelSeveridad nivel) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(nivel.getPlaca().getIpPlaca(),
				nivel.getPlaca().getPuertoPlaca());

		BigInteger idFactor = BigInteger.valueOf(nivel.getFactor()
				.getIdFactor());
		BigInteger prioridad = BigInteger.valueOf(nivel.getPrioridad());
		BigInteger rangoMinimo = BigInteger.valueOf(nivel.getRangoMin());
		BigInteger rangoMaximo = BigInteger.valueOf(nivel.getRangoMax());

		ResultadoCreacionWS resultadoWS = clienteWS.wsCrearNivelSeveridad(
				nivel.getNombre(), idFactor, prioridad, rangoMinimo,
				rangoMaximo);
		Long id = resultadoWS.getIdObjeto().longValue();
		nivel.setId(id);
		BigInteger idNivelSeveridad = BigInteger.valueOf(id);

		Iterator<FilaPerfilActivacion> perfilActivacion = nivel
				.getPerfilActivacion().iterator();
		while (perfilActivacion.hasNext()) {
			FilaPerfilActivacion filaPerfil = perfilActivacion.next();
			BigInteger idGrupoActuadores = BigInteger.valueOf(filaPerfil
					.getGrupoActuadores().getId());

			clienteWS.wsAgregarFilaPerfilActivacion(idNivelSeveridad,
					idGrupoActuadores, filaPerfil.getEstado());
		}

		return nivel;
	}

	public ResultadoLectura lecturaFactor(Factor factor) throws WsPlacaControladoraException  {
		ResultadoLectura resultado = new ResultadoLectura();
		try
		{
			Comunicacion clienteWS = iniciarConexion(
					factor.getPlaca().getIpPlaca(), factor.getPlaca()
							.getPuertoPlaca());
			BigInteger idFactor = BigInteger.valueOf(factor.getIdFactor());
			ResultadoLecturaWS resultadoWS = clienteWS.wsLecturaFactor(idFactor);
	
			Timestamp fechaHora = new Timestamp(resultadoWS.getFecha()
					.toGregorianCalendar().getTimeInMillis());
			float lectura = resultadoWS.getValor();
			Mensaje mensaje = new Mensaje();
			mensaje.setTexto(resultadoWS.getMensaje().getTexto());
			mensaje.setTipo(resultadoWS.getMensaje().getTipo());
			mensaje.setId(resultadoWS.getMensaje().getIdMensaje().longValue());
	
			resultado.setMensaje(mensaje);
			resultado.setFecha(fechaHora);
			resultado.setLectura(lectura);
		} catch (Exception ex)
		{
			throw new WsPlacaControladoraException("Pérdida de conectividad con la placa controladora."); 
		}
		return resultado;
	}

	public Mensaje cambiarEstadoPlaca(Placa placa, String estado) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placa.getIpPlaca(),
				placa.getPuertoPlaca());

		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsCambiarEstadoSistema(estado);
		Mensaje mensaje = new Mensaje();
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		mensaje.setId(resultadoWS.getIdMensaje().longValue());

		return mensaje;
	}

	public Mensaje actualizarSensor(Sensor sensor) throws WsPlacaControladoraException {

		Comunicacion clienteWS = iniciarConexion(
				sensor.getPlaca().getIpPlaca(), sensor.getPlaca()
						.getPuertoPlaca());
		BigInteger nroPuerto = BigInteger.valueOf(sensor.getNumeroPuerto());
		BigInteger idTipoPuerto = null;
		if (sensor.getTipoPuerto() != null)
			idTipoPuerto = BigInteger.valueOf(sensor.getTipoPuerto().getId());
		BigInteger idPlacaPadre = null;
		if (sensor.getPadre() != null)
			idPlacaPadre = BigInteger.valueOf(sensor.getPadre().getId());
		BigInteger idFactor = null;
		if (sensor.getFactor() != null)
			idFactor = BigInteger.valueOf(sensor.getFactor().getIdFactor());
		BigInteger idDispositivo = BigInteger.valueOf(sensor.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarSensor(sensor.getNombre(), sensor.getModelo(),
						nroPuerto, sensor.getFormulaConversion(), idTipoPuerto,
						idPlacaPadre, idFactor, idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());

		return mensaje;
	}

	public Mensaje actualizarActuadorAvance(ActuadorAvance actuadorAvance) throws WsPlacaControladoraException {

		Comunicacion clienteWS = iniciarConexion(actuadorAvance.getPlaca()
				.getIpPlaca(), actuadorAvance.getPlaca().getPuertoPlaca());
		BigInteger nroPuerto = BigInteger.valueOf(actuadorAvance
				.getNumeroPuerto());
		BigInteger idTipoPuerto = null;
		if (actuadorAvance.getTipoPuerto() != null)
			idTipoPuerto = BigInteger.valueOf(actuadorAvance.getTipoPuerto()
					.getId());
		BigInteger idTipoActuador = null;
		if (actuadorAvance.getTipoActuador() != null)
			idTipoActuador = BigInteger.valueOf(actuadorAvance
					.getTipoActuador().getId());
		BigInteger posicion = BigInteger.valueOf(actuadorAvance.getPosicion());
		BigInteger idPlacaPadre = null;
		if (actuadorAvance.getPadre() != null)
			idPlacaPadre = BigInteger
					.valueOf(actuadorAvance.getPadre().getId());
		BigInteger nroPuertoRetroceso = BigInteger.valueOf(actuadorAvance
				.getNumeroPuertoRetroceso());
		BigInteger tiempoEntrePosiciones = BigInteger.valueOf(actuadorAvance
				.getTiempoEntrePosiciones());
		BigInteger idGrupoActuadores = null;
		if (actuadorAvance.getGrupoActuadores() != null)
			idGrupoActuadores = BigInteger.valueOf(actuadorAvance
					.getGrupoActuadores().getId());
		BigInteger idDispositivo = BigInteger.valueOf(actuadorAvance.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarActuadorAvance(actuadorAvance.getNombre(),
						actuadorAvance.getModelo(), nroPuerto, posicion,
						idTipoPuerto, idTipoActuador, idPlacaPadre,
						nroPuertoRetroceso, tiempoEntrePosiciones,
						idGrupoActuadores, idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());

		return mensaje;
	}

	public Mensaje actualizarActuador(Actuador actuador) throws WsPlacaControladoraException {

		Comunicacion clienteWS = iniciarConexion(actuador.getPlaca()
				.getIpPlaca(), actuador.getPlaca().getPuertoPlaca());
		BigInteger nroPuerto = BigInteger.valueOf(actuador.getNumeroPuerto());
		BigInteger idTipoPuerto = null;
		if (actuador.getTipoPuerto() != null)
			idTipoPuerto = BigInteger.valueOf(actuador.getTipoPuerto().getId());
		BigInteger idTipoActuador = null;
		if (actuador.getTipoActuador() != null)
			idTipoActuador = BigInteger.valueOf(actuador.getTipoActuador()
					.getId());
		BigInteger idPlacaPadre = null;
		if (actuador.getPadre() != null)
			idPlacaPadre = BigInteger.valueOf(actuador.getPadre().getId());
		BigInteger idGrupoActuadores = null;
		if (actuador.getGrupoActuadores() != null)
			idGrupoActuadores = BigInteger.valueOf(actuador
					.getGrupoActuadores().getId());
		BigInteger idDispositivo = BigInteger.valueOf(actuador.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarActuador(actuador.getNombre(),
						actuador.getModelo(), nroPuerto, idTipoPuerto,
						idTipoActuador, idPlacaPadre, idGrupoActuadores,
						idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());

		return mensaje;
	}

	public Mensaje actualizarGrupoActuadores(GrupoActuadores grupoActuadores) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(grupoActuadores.getPlaca()
				.getIpPlaca(), grupoActuadores.getPlaca().getPuertoPlaca());
		BigInteger idGrupoActuadores = BigInteger.valueOf(grupoActuadores
				.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarGrupoActuadores(grupoActuadores.getNombre(),
						grupoActuadores.getDeAvance(), idGrupoActuadores);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarTipoActuador(TipoActuador tipoActuador) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(tipoActuador.getPlaca()
				.getIpPlaca(), tipoActuador.getPlaca().getPuertoPlaca());
		BigInteger idTipoActuador = BigInteger.valueOf(tipoActuador.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarTipoActuador(tipoActuador.getCategoria(),
						idTipoActuador);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarTipoPlaca(TipoPlacaAuxiliar tipoPlaca) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(tipoPlaca.getPlaca()
				.getIpPlaca(), tipoPlaca.getPlaca().getPuertoPlaca());
		BigInteger idTipoPlaca = BigInteger.valueOf(tipoPlaca.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarTipoPlaca(tipoPlaca.getNombre(), idTipoPlaca);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarTipoLogEvento(TipoLogEvento tipoLogEvento,
			Placa placa) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placa.getIpPlaca(),
				placa.getPuertoPlaca());
		BigInteger idTipoLogEvento = BigInteger.valueOf(tipoLogEvento
				.getIdTipoLogEvento());
		String enviarMail = String.valueOf(tipoLogEvento.getEnviarMail());
		String enviarSMS = String.valueOf(tipoLogEvento.getEnviarSMS());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarTipoLogEvento(enviarMail, enviarSMS,
						idTipoLogEvento);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarFactor(Factor factor) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(
				factor.getPlaca().getIpPlaca(), factor.getPlaca()
						.getPuertoPlaca());

		BigInteger valorMin = BigInteger.valueOf(factor.getValorMin());
		BigInteger valorMax = BigInteger.valueOf(factor.getValorMax());
		BigInteger idFactor = BigInteger.valueOf(factor.getIdFactor());
		BigInteger umbral = BigInteger.valueOf(factor.getUmbral());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarFactor(factor.getNombre(), factor.getUnidad(),
						valorMin, valorMax, umbral, idFactor);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarPlacaAuxiliar(PlacaAuxiliar placaAuxiliar) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placaAuxiliar.getPlaca()
				.getIpPlaca(), placaAuxiliar.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(placaAuxiliar.getId());
		BigInteger idTipoPlaca = BigInteger.valueOf(placaAuxiliar
				.getTipoPlacaAuxiliar().getId());
		BigInteger idPlacaPadre = null;
		if (placaAuxiliar.getPadre() != null)
			idPlacaPadre = BigInteger.valueOf(placaAuxiliar.getPadre().getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarPlacaAuxiliar(placaAuxiliar.getNombre(),
						placaAuxiliar.getModelo(),
						placaAuxiliar.getNumeroSerie(), idTipoPlaca,
						idPlacaPadre, idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarNivelSeveridad(NivelSeveridad nivelSeveridad) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(nivelSeveridad.getPlaca()
				.getIpPlaca(), nivelSeveridad.getPlaca().getPuertoPlaca());

		BigInteger idFactor = BigInteger.valueOf(nivelSeveridad.getFactor()
				.getIdFactor());
		BigInteger prioridad = BigInteger
				.valueOf(nivelSeveridad.getPrioridad());
		BigInteger rangoMinimo = BigInteger.valueOf(nivelSeveridad
				.getRangoMin());
		BigInteger rangoMaximo = BigInteger.valueOf(nivelSeveridad
				.getRangoMax());
		BigInteger idNivelSeveridad = BigInteger
				.valueOf(nivelSeveridad.getId());

		Iterator<FilaPerfilActivacion> perfilActivacion = nivelSeveridad
				.getPerfilActivacion().iterator();
		while (perfilActivacion.hasNext()) {
			FilaPerfilActivacion filaPerfil = perfilActivacion.next();
			BigInteger idGrupoActuadores = BigInteger.valueOf(filaPerfil
					.getGrupoActuadores().getId());

			clienteWS.wsAgregarFilaPerfilActivacion(idNivelSeveridad,
					idGrupoActuadores, filaPerfil.getEstado());
		}

		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarNivelSeveridad(nivelSeveridad.getNombre(),
						idFactor, prioridad, rangoMinimo, rangoMaximo,
						idNivelSeveridad);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarPerfilActivacion(NivelSeveridad nivelSeveridad) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(nivelSeveridad.getPlaca()
				.getIpPlaca(), nivelSeveridad.getPlaca().getPuertoPlaca());

		BigInteger idNivelSeveridad = BigInteger
				.valueOf(nivelSeveridad.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarPerfilActivacion(idNivelSeveridad);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje actualizarParametrosPlaca(Placa placa) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placa.getIpPlaca(),
				placa.getPuertoPlaca());

		BigInteger periodicidadLecturas = BigInteger.valueOf(placa
				.getPeriodicidadLecturas());
		BigInteger periodicidadNiveles = BigInteger.valueOf(placa
				.getPeriodicidadNiveles());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsActualizarPlaca(periodicidadLecturas, periodicidadNiveles);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarDestinatario(Destinatario destinatario) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(destinatario.getPlaca()
				.getIpPlaca(), destinatario.getPlaca().getPuertoPlaca());

		BigInteger idDestinatario = BigInteger.valueOf(destinatario
				.getIdDestinatario());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarDestinatario(idDestinatario);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarSensor(Sensor sensor) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(
				sensor.getPlaca().getIpPlaca(), sensor.getPlaca()
						.getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(sensor.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarActuadorAvance(ActuadorAvance actuadorAvance) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuadorAvance.getPlaca()
				.getIpPlaca(), actuadorAvance.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(actuadorAvance.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarActuador(Actuador actuador) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuador.getPlaca()
				.getIpPlaca(), actuador.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(actuador.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarGrupoActuadores(GrupoActuadores grupoActuadores) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(grupoActuadores.getPlaca()
				.getIpPlaca(), grupoActuadores.getPlaca().getPuertoPlaca());

		BigInteger idGrupo = BigInteger.valueOf(grupoActuadores.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarGrupoActuadores(idGrupo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarFactor(Factor factor) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(
				factor.getPlaca().getIpPlaca(), factor.getPlaca()
						.getPuertoPlaca());

		BigInteger idFactor = BigInteger.valueOf(factor.getIdFactor());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarFactor(idFactor);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarPlacaAuxiliar(PlacaAuxiliar placaAuxiliar) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placaAuxiliar.getPlaca()
				.getIpPlaca(), placaAuxiliar.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(placaAuxiliar.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje eliminarNivelSeveridad(NivelSeveridad nivelSeveridad) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(nivelSeveridad.getPlaca()
				.getIpPlaca(), nivelSeveridad.getPlaca().getPuertoPlaca());

		BigInteger idNivelSeveridad = BigInteger
				.valueOf(nivelSeveridad.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsEliminarNivelSeveridad(idNivelSeveridad);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public ResultadoAccion encenderGrupoActuadores(GrupoActuadores grupo) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(grupo.getPlaca().getIpPlaca(),
				grupo.getPlaca().getPuertoPlaca());

		BigInteger idGrupoActuadores = BigInteger.valueOf(grupo.getId());
		ResultadoAccionWS resultadoWS = clienteWS
				.wsEncenderGrupoActuadores(idGrupoActuadores);

		ResultadoAccion resultado = new ResultadoAccion();
		Timestamp fechaHora = new Timestamp(resultadoWS.getFecha()
				.toGregorianCalendar().getTimeInMillis());
		String accion = resultadoWS.getTipoAccion();

		Mensaje mensaje = new Mensaje();
		mensaje.setTexto(resultadoWS.getMensaje().getTexto());
		mensaje.setTipo(resultadoWS.getMensaje().getTipo());
		mensaje.setId(resultadoWS.getMensaje().getIdMensaje().longValue());

		resultado.setMensaje(mensaje);
		resultado.setFecha(fechaHora);
		resultado.setAccion(accion);

		return resultado;
	}

	public ResultadoAccion apagarGrupoActuadores(GrupoActuadores grupo) throws WsPlacaControladoraException {
		ResultadoAccion resultado = new ResultadoAccion();
		try{
			
			
			Comunicacion clienteWS = iniciarConexion(grupo.getPlaca().getIpPlaca(),
					grupo.getPlaca().getPuertoPlaca());
	
			BigInteger idGrupoActuadores = BigInteger.valueOf(grupo.getId());
			ResultadoAccionWS resultadoWS = clienteWS
					.wsApagarGrupoActuadores(idGrupoActuadores);
	
			
			Timestamp fechaHora = new Timestamp(resultadoWS.getFecha()
					.toGregorianCalendar().getTimeInMillis());
			String accion = resultadoWS.getTipoAccion();
	
			Mensaje mensaje = new Mensaje();
			mensaje.setTexto(resultadoWS.getMensaje().getTexto());
			mensaje.setTipo(resultadoWS.getMensaje().getTipo());
			mensaje.setId(resultadoWS.getMensaje().getIdMensaje().longValue());
	
			resultado.setMensaje(mensaje);
			resultado.setFecha(fechaHora);
			resultado.setAccion(accion);
		} catch (Exception ex)
		{
			throw new WsPlacaControladoraException("Pérdida de conectividad con la placa controladora."); 
		}
		return resultado;
	}

	public ResultadoAccion cambiarPosicionGrupoActuadores(
			GrupoActuadores grupo, int nroPosicion) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(grupo.getPlaca().getIpPlaca(),
				grupo.getPlaca().getPuertoPlaca());

		BigInteger idGrupoActuadores = BigInteger.valueOf(grupo.getId());
		BigInteger posicion = BigInteger.valueOf(nroPosicion);
		ResultadoAccionWS resultadoWS = clienteWS
				.wsCambiarPosicionGrupoActuadores(idGrupoActuadores, posicion);

		ResultadoAccion resultado = new ResultadoAccion();
		Timestamp fechaHora = new Timestamp(resultadoWS.getFecha()
				.toGregorianCalendar().getTimeInMillis());
		String accion = resultadoWS.getTipoAccion();

		Mensaje mensaje = new Mensaje();
		mensaje.setTexto(resultadoWS.getMensaje().getTexto());
		mensaje.setTipo(resultadoWS.getMensaje().getTipo());
		mensaje.setId(resultadoWS.getMensaje().getIdMensaje().longValue());

		resultado.setMensaje(mensaje);
		resultado.setFecha(fechaHora);
		resultado.setAccion(accion);

		return resultado;
	}

	public Mensaje reestablecerActuadorAvance(ActuadorAvance actuadorAvance,
			int nroPosicion) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuadorAvance.getPlaca()
				.getIpPlaca(), actuadorAvance.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(actuadorAvance.getId());
		BigInteger posicion = BigInteger.valueOf(nroPosicion);
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsReestablecerActuadorAvance(idDispositivo, posicion);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje reestablecerDispositivo(Dispositivo dispositivo) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(dispositivo.getPlaca()
				.getIpPlaca(), dispositivo.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(dispositivo.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsReestablecerEstadoAlertaDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje reestablecerSensor(Sensor sensor) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(
				sensor.getPlaca().getIpPlaca(), sensor.getPlaca()
						.getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(sensor.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsReestablecerEstadoAlertaDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje reestablecerActuador(Actuador actuador) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuador.getPlaca()
				.getIpPlaca(), actuador.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(actuador.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsReestablecerEstadoAlertaDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public Mensaje reestablecerPlacaAuxiliar(PlacaAuxiliar placaAuxiliar) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placaAuxiliar.getPlaca()
				.getIpPlaca(), placaAuxiliar.getPlaca().getPuertoPlaca());

		BigInteger idDispositivo = BigInteger.valueOf(placaAuxiliar.getId());
		uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS = clienteWS
				.wsReestablecerEstadoAlertaDispositivo(idDispositivo);
		Mensaje mensaje = new Mensaje();
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
		mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}

	public String obtenerEstadoAlertaPlaca(Placa placa) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(placa.getIpPlaca(),
				placa.getPuertoPlaca());
		String resultadoWS = clienteWS.wsObtenerEstadoAlertaPlaca(placa
				.getNroSerie());
		return resultadoWS;
	}

	public String obtenerEstadoAlertaDispositivo(Dispositivo dispositivo) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(dispositivo.getPlaca()
				.getIpPlaca(), dispositivo.getPlaca().getPuertoPlaca());
		BigInteger idDispositivo = BigInteger.valueOf(dispositivo.getId());
		String resultadoWS = clienteWS
				.wsObtenerEstadoAlertaDispositivo(idDispositivo);
		return resultadoWS;
	}
	
	public String obtenerEstadoGrupoActuadores(GrupoActuadores grupo) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(grupo.getPlaca()
				.getIpPlaca(), grupo.getPlaca().getPuertoPlaca());
		BigInteger idGrupo = BigInteger.valueOf(grupo.getId());
		String resultadoWS = clienteWS
				.wsObtenerEstadoGrupoActuadores(idGrupo);
		return resultadoWS;
	}
	
	public String obtenerEstadoActuador(Actuador actuador) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuador.getPlaca()
				.getIpPlaca(), actuador.getPlaca().getPuertoPlaca());
		BigInteger idDispositivo = BigInteger.valueOf(actuador.getId());
		String resultadoWS = clienteWS
				.wsObtenerEstadoActuador(idDispositivo);
		return resultadoWS;
	}
	
	public int obtenerEstadoActuadorAvance(ActuadorAvance actuadorAvance) throws WsPlacaControladoraException {
		Comunicacion clienteWS = iniciarConexion(actuadorAvance.getPlaca()
				.getIpPlaca(), actuadorAvance.getPlaca().getPuertoPlaca());
		BigInteger idDispositivo = BigInteger.valueOf(actuadorAvance.getId());
		BigInteger resultadoWS = clienteWS
				.wsObtenerPosicionActuadorAvance(idDispositivo);
		return resultadoWS.intValue();
	}

}
