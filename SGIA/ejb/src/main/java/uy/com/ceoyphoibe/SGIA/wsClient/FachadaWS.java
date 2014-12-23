package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Destinatario;
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

public class FachadaWS {


	public FachadaWS() {
		
	}
	
	private Comunicacion iniciarConexion(String ip, int puerto)
	{
		Herramientas h = new Herramientas();
		URL wsdl = h.obtenerWSDL(ip, String.valueOf(puerto));
		Comunicacion_Service service1 = new Comunicacion_Service(wsdl);

		Comunicacion port1 = service1.getComunicacion();
		return port1;
	}
	
	public Placa obtenerDatosPlaca (String ip, int puerto)
	{
		Comunicacion clienteWS= iniciarConexion(ip, puerto);
		
		Placa placa= new Placa();
		
		ResultadoDatosPlacaWS datosPlaca = clienteWS.wsObtenerDatosPlaca(BigInteger.valueOf(0));
		System.out.println("Vuelven los siguientes datos: ");
		System.out.println("Estado: "
				+ datosPlaca.getEstadoPlaca().charAt(0));
		System.out.println("Estado de alerta: "
				+ datosPlaca.getEstadoAlerta().charAt(0));
		System.out.println("Periodicidad de niveles: "
				+ datosPlaca.getPeriodicidadNiveles());
		System.out.println("Periodicidad de lecturas: "
				+ datosPlaca.getPeriodicidadLecturas());
		System.out.println("IP centralizadora: "
				+ datosPlaca.getHostWSCentralizadora());
		System.out.println("Puerto Centralizadora: "
				+ datosPlaca.getPuertoWSCentralizadora());
		System.out.println("IP SMS: " + datosPlaca.getHostWSSMS());
		System.out.println("Puerto SMS: " + datosPlaca.getPuertoWSSMS());

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
			placa.setPuertoWSSMS(Integer.valueOf(datosPlaca
					.getPuertoWSSMS()));
		placa.setPuetroPlaca(puerto);
		placa.setIpPlaca(ip);
		
		return placa;
	}
	
	public boolean asociarSensorFactor(Sensor sensor)
	{
		boolean ok= false;
		Comunicacion clienteWS= iniciarConexion(sensor.getPlaca().getIpPlaca(), sensor.getPlaca().getPuetroPlaca());
		BigInteger idFactor= null;
		if (sensor.getFactor() != null)
			idFactor= BigInteger.valueOf(sensor.getFactor().getIdFactor());
		BigInteger idDispositivo= BigInteger.valueOf(sensor.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje mensajeResultado= clienteWS.wsAsociarFactorSensor(idFactor, idDispositivo);  
        ok= mensajeResultado.getTipo().equals("Informativo");
        return ok;
	}
	
	public Factor registroFactor(Factor factor)
	{
		Comunicacion clienteWS= iniciarConexion(factor.getPlaca().getIpPlaca(), factor.getPlaca().getPuetroPlaca());
        
        BigInteger valorMin= BigInteger.valueOf(factor.getValorMin());
        BigInteger valorMax= BigInteger.valueOf(factor.getValorMax());
        BigInteger umbral= BigInteger.valueOf(factor.getUmbral());
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearFactor(factor.getNombre(), factor.getUnidad(), valorMin, valorMax, umbral);
        Long id=resultadoWS.getIdObjeto().longValue();
        System.out.println("Id que vuelve del WS: "+id);
        factor.setIdFactor(id);
        
		return factor;
	}
	
	public Sensor registroSensor (Sensor sensor)
	{
		Comunicacion clienteWS= iniciarConexion(sensor.getPlaca().getIpPlaca(), sensor.getPlaca().getPuetroPlaca());
		
		BigInteger nroPuerto= BigInteger.valueOf(sensor.getNumeroPuerto());
		BigInteger idTipoPuerto= BigInteger.valueOf(sensor.getTipoPuerto().getId());
		BigInteger idPlacaPadre= null;
		if (sensor.getPadre() != null)
			idPlacaPadre= BigInteger.valueOf(sensor.getPadre().getId());
		BigInteger idFactor= null;
		if (sensor.getFactor() != null)
			idFactor= BigInteger.valueOf(sensor.getFactor().getIdFactor());
		
		ResultadoCreacionWS resultadoWS= clienteWS.wsCrearSensor(sensor.getNombre(), sensor.getModelo(), nroPuerto, sensor.getFormulaConversion(), idTipoPuerto, idPlacaPadre, idFactor);
		Long id=resultadoWS.getIdObjeto().longValue();
		sensor.setId(id);
		return sensor;
	}
	
	public Actuador registroActuador (Actuador actuador)
	{
		Comunicacion clienteWS= iniciarConexion(actuador.getPlaca().getIpPlaca(), actuador.getPlaca().getPuetroPlaca());
		
		BigInteger nroPuerto= BigInteger.valueOf(actuador.getNumeroPuerto());
		BigInteger idTipoPuerto= BigInteger.valueOf(actuador.getTipoPuerto().getId());
		BigInteger idTipoActuador= BigInteger.valueOf(actuador.getTipoActuador().getId());
		BigInteger idPlacaPadre= null;
		if (actuador.getPadre() != null)
			idPlacaPadre= BigInteger.valueOf(actuador.getPadre().getId());
		BigInteger idGrupoActuadores= null;
		if (actuador.getGrupoActuadores() != null)
			idGrupoActuadores= BigInteger.valueOf(actuador.getGrupoActuadores().getId());
		
		ResultadoCreacionWS resultadoWS= clienteWS.wsCrearActuador(actuador.getNombre(), actuador.getModelo(), nroPuerto, idTipoPuerto, idTipoActuador, idPlacaPadre, idGrupoActuadores);
		Long id=resultadoWS.getIdObjeto().longValue();
		actuador.setId(id);
		return actuador;
	}
	
	public ActuadorAvance registroActuadorAvance (ActuadorAvance actuadorAvance)
	{
		Comunicacion clienteWS= iniciarConexion(actuadorAvance.getPlaca().getIpPlaca(), actuadorAvance.getPlaca().getPuetroPlaca());
		
		BigInteger nroPuerto= BigInteger.valueOf(actuadorAvance.getNumeroPuerto());
		BigInteger nroPuertoRetroceso= BigInteger.valueOf(actuadorAvance.getNumeroPuertoRetroceso());
		BigInteger posicion= BigInteger.valueOf(actuadorAvance.getPosicion());
		BigInteger idTipoPuerto= BigInteger.valueOf(actuadorAvance.getTipoPuerto().getId());
		BigInteger tiempoEntrePosiciones= BigInteger.valueOf(actuadorAvance.getTiempoEntrePosiciones());
		BigInteger idTipoActuador= BigInteger.valueOf(actuadorAvance.getTipoActuador().getId());
		BigInteger idPlacaPadre= null;
		if (actuadorAvance.getPadre() != null)
			idPlacaPadre= BigInteger.valueOf(actuadorAvance.getPadre().getId());
		BigInteger idGrupoActuadores= null;
		if (actuadorAvance.getGrupoActuadores() != null)
			idGrupoActuadores= BigInteger.valueOf(actuadorAvance.getGrupoActuadores().getId());
		
		ResultadoCreacionWS resultadoWS= clienteWS.wsCrearActuadorAvance(actuadorAvance.getNombre(), actuadorAvance.getModelo(), nroPuerto, posicion, idTipoPuerto, idTipoActuador, idPlacaPadre, nroPuertoRetroceso, idTipoPuerto, tiempoEntrePosiciones, idGrupoActuadores);
		Long id=resultadoWS.getIdObjeto().longValue();
		actuadorAvance.setId(id);
		
		BigInteger idActuadorAvance= resultadoWS.getIdObjeto();
		Set<Posicion> posiciones= actuadorAvance.getListaPosiciones();
		Iterator<Posicion> itPosiciones= posiciones.iterator();
		while (itPosiciones.hasNext())
		{
			Posicion posicionTemp= itPosiciones.next();
			BigInteger numeroPosicion= BigInteger.valueOf(posicionTemp.getNroPosicion());
			BigInteger valor= BigInteger.valueOf(posicionTemp.getValor());
			clienteWS.wsAgregarPosicionActuadorAvance(idActuadorAvance, numeroPosicion, posicionTemp.getDescripcion(), valor);
			Set<Sensor> listaSensores= posicionTemp.getListaSensores();
			Iterator<Sensor> itSensor= listaSensores.iterator();
			while (itSensor.hasNext())
			{
				Sensor sensorTemp= itSensor.next();
				BigInteger idSensor= BigInteger.valueOf(sensorTemp.getId());
				clienteWS.wsAgregarSensorPosicionActuadorAvance(idSensor, idActuadorAvance, numeroPosicion);
			}
		}
		
		return actuadorAvance;
	}
	
	public GrupoActuadores registroGrupoActuadores(GrupoActuadores grupo)
	{
		Comunicacion clienteWS= iniciarConexion(grupo.getPlaca().getIpPlaca(), grupo.getPlaca().getPuetroPlaca());
        
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearGrupoActuadores(grupo.getNombre(), grupo.getDeAvance());
        Long id=resultadoWS.getIdObjeto().longValue();
        grupo.setId(id);
        
		return grupo;
	}
	
	public boolean asociarActuadorGrupoActuadores(Actuador actuador)
	{
		boolean ok= false;
		Comunicacion clienteWS= iniciarConexion(actuador.getPlaca().getIpPlaca(), actuador.getPlaca().getPuetroPlaca());
		BigInteger idGrupoActuadores= null;
		if (actuador.getGrupoActuadores() != null)
			idGrupoActuadores= BigInteger.valueOf(actuador.getGrupoActuadores().getId());
		BigInteger idDispositivo= BigInteger.valueOf(actuador.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje mensajeResultado= clienteWS.wsAsociarActuadorGrupo(idGrupoActuadores, idDispositivo); 
        ok= mensajeResultado.getTipo().equals("Informativo");
        return ok;
	}
	
	public boolean asociarActuadorAvanceGrupoActuadores(ActuadorAvance actuadorAvance)
	{
		boolean ok= false;
		Comunicacion clienteWS= iniciarConexion(actuadorAvance.getPlaca().getIpPlaca(), actuadorAvance.getPlaca().getPuetroPlaca());
		BigInteger idGrupoActuadores= null;
		if (actuadorAvance.getGrupoActuadores() != null)
			idGrupoActuadores= BigInteger.valueOf(actuadorAvance.getGrupoActuadores().getId());
		BigInteger idDispositivo= BigInteger.valueOf(actuadorAvance.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje mensajeResultado= clienteWS.wsAsociarActuadorAvanceGrupo(idGrupoActuadores, idDispositivo);
        ok= mensajeResultado.getTipo().equals("Informativo");
        return ok;
	}
	
	public TipoActuador registroTipoActuador(TipoActuador tipoActuador)
	{
		Comunicacion clienteWS= iniciarConexion(tipoActuador.getPlaca().getIpPlaca(), tipoActuador.getPlaca().getPuetroPlaca());
        
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearTipoActuador(tipoActuador.getCategoria());
        Long id=resultadoWS.getIdObjeto().longValue();
        tipoActuador.setId(id);
        
		return tipoActuador;
	}
	
	public Destinatario registroDestinatario(Destinatario destinatario)
	{
		Comunicacion clienteWS= iniciarConexion(destinatario.getPlaca().getIpPlaca(), destinatario.getPlaca().getPuetroPlaca());
		BigInteger horaMin= BigInteger.valueOf(destinatario.getHoraMin());
		BigInteger horaMax= BigInteger.valueOf(destinatario.getHoraMax());
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearDestinatario(destinatario.getNombre(), destinatario.getCelular(), destinatario.getMail(), horaMin, horaMax);
        Long id=resultadoWS.getIdObjeto().longValue();
        destinatario.setIdDestinatario(id);
        
		return destinatario;
	}
	
	public Mensaje actualizarDestinatario(Destinatario destinatario)
	{
		System.out.println("intenta conectar a: "+ destinatario.getPlaca().getIpPlaca() + ", "+ destinatario.getPlaca().getPuetroPlaca());
		Comunicacion clienteWS= iniciarConexion(destinatario.getPlaca().getIpPlaca(), destinatario.getPlaca().getPuetroPlaca());
		BigInteger horaMin= BigInteger.valueOf(destinatario.getHoraMin());
		BigInteger horaMax= BigInteger.valueOf(destinatario.getHoraMax());
		BigInteger idDestinatario= BigInteger.valueOf(destinatario.getIdDestinatario());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarDestinatario(destinatario.getNombre(), destinatario.getCelular(), destinatario.getMail(), horaMin, horaMax, idDestinatario);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
        
		return mensaje;
	}
	
	public void asociarDestinatariosTipoLogEventos(TipoLogEvento tipoLogEvento, Placa placa)
	{
		Comunicacion clienteWS= iniciarConexion(placa.getIpPlaca(), placa.getPuetroPlaca());
		BigInteger idTipoLogEvento= BigInteger.valueOf(tipoLogEvento.getIdTipoLogEvento());
		List<Destinatario> destinatarios= tipoLogEvento.getListaDestinatarios();
		System.out.println("tamaño de la lista de destinatarios: "+ destinatarios.size());
		int i= 0;
		while (i<destinatarios.size())
		{
			Destinatario destinatarioTemp= destinatarios.get(i);
			BigInteger idDestinatario= BigInteger.valueOf(destinatarioTemp.getIdDestinatario());
			System.out.println("Invoca al WS con: "+idTipoLogEvento+", "+idDestinatario);
			clienteWS.wsAsociarDestinatarioTipoLogEvento(idTipoLogEvento, idDestinatario);
			i++;
		}
	}
	
	public void desasociarDestinatariosTipoLogEventos(TipoLogEvento tipoLogEvento, Placa placa)
	{
		Comunicacion clienteWS= iniciarConexion(placa.getIpPlaca(), placa.getPuetroPlaca());
		BigInteger idTipoLogEvento= BigInteger.valueOf(tipoLogEvento.getIdTipoLogEvento());
		List<Destinatario> destinatarios= tipoLogEvento.getListaDestinatarios();
		int i= 0;
		while (i<destinatarios.size())
		{
			Destinatario destinatarioTemp= destinatarios.get(i);
			BigInteger idDestinatario= BigInteger.valueOf(destinatarioTemp.getIdDestinatario());
			clienteWS.wsDesasociarDestinatarioTipoLogEvento(idTipoLogEvento, idDestinatario);
			i++;
		}
	}
	
	public TipoPlacaAuxiliar registroTipoPlacaAuxiliar(TipoPlacaAuxiliar tipoPlacaAuxiliar)
	{
		Comunicacion clienteWS= iniciarConexion(tipoPlacaAuxiliar.getPlaca().getIpPlaca(), tipoPlacaAuxiliar.getPlaca().getPuetroPlaca());
        
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearTipoPlaca(tipoPlacaAuxiliar.getNombre());
        Long id=resultadoWS.getIdObjeto().longValue();
        tipoPlacaAuxiliar.setId(id);
        
		return tipoPlacaAuxiliar;
	}
	
	
	public PlacaAuxiliar registroPlacaAuxiliar(PlacaAuxiliar placaAux)
	{
		Comunicacion clienteWS= iniciarConexion(placaAux.getPlaca().getIpPlaca(), placaAux.getPlaca().getPuetroPlaca());
        
        BigInteger nroPuerto= BigInteger.valueOf(placaAux.getNumeroPuerto());
        BigInteger idTipoPlaca= BigInteger.valueOf(placaAux.getTipoPlacaAuxiliar().getId());
        BigInteger idPlacaPadre= null;
        if (placaAux.getPadre() != null)
        	idPlacaPadre= BigInteger.valueOf(placaAux.getPadre().getId());
        
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearPlacaAuxiliar(placaAux.getNombre(), placaAux.getModelo(), nroPuerto, placaAux.getNumeroSerie(), idTipoPlaca, idPlacaPadre);
        Long id=resultadoWS.getIdObjeto().longValue();
        placaAux.setId(id);
        
		return placaAux;
	}
	
	public NivelSeveridad registroNivelSeveridad(NivelSeveridad nivel)
	{
		Comunicacion clienteWS= iniciarConexion(nivel.getPlaca().getIpPlaca(), nivel.getPlaca().getPuetroPlaca());
        
        BigInteger idFactor= BigInteger.valueOf(nivel.getFactor().getIdFactor());
        BigInteger prioridad= BigInteger.valueOf(nivel.getPrioridad());
        BigInteger rangoMinimo= BigInteger.valueOf(nivel.getRangoMin());
        BigInteger rangoMaximo= BigInteger.valueOf(nivel.getRangoMax());
                
        ResultadoCreacionWS resultadoWS= clienteWS.wsCrearNivelSeveridad(nivel.getNombre(), idFactor, prioridad, rangoMinimo, rangoMaximo);
        Long id=resultadoWS.getIdObjeto().longValue();
        nivel.setId(id);
        BigInteger idNivelSeveridad= BigInteger.valueOf(id);
        
        Iterator<FilaPerfilActivacion> perfilActivacion= nivel.getPerfilActivacion().iterator();
        while (perfilActivacion.hasNext())
        {
        	FilaPerfilActivacion filaPerfil= perfilActivacion.next();
        	BigInteger idGrupoActuadores= BigInteger.valueOf(filaPerfil.getGrupoActuadores().getId());
        	
        	clienteWS.wsAgregarFilaPerfilActivacion(idNivelSeveridad, idGrupoActuadores, filaPerfil.getEstado());
        }
        
		return nivel;
	}
	
	public ResultadoLectura lecturaFactor(Factor factor)
	{
		Comunicacion clienteWS= iniciarConexion(factor.getPlaca().getIpPlaca(), factor.getPlaca().getPuetroPlaca());
		
		BigInteger idFactor= BigInteger.valueOf(factor.getIdFactor());
		ResultadoLecturaWS resultadoWS=clienteWS.wsLecturaFactor(idFactor);
		System.out.println("Despues de llamar al WS vuelve con:");
		System.out.println("Mensjaje: "+ resultadoWS.getMensaje().getTexto());
		System.out.println("Lectura: "+ resultadoWS.getValor());
		
		ResultadoLectura resultado= new ResultadoLectura();
		System.out.println("1");
		Timestamp fechaHora= new Timestamp(resultadoWS.getFecha().toGregorianCalendar().getTimeInMillis());
		System.out.println("2");
		float lectura= resultadoWS.getValor();
		System.out.println("3");
		Long idMensaje= resultadoWS.getMensaje().getIdMensaje().longValue();
		System.out.println("Va a buscar el mensaje con id: "+idMensaje);
		Mensaje mensaje= new Mensaje();
		mensaje.setTexto(resultadoWS.getMensaje().getTexto());
		mensaje.setTipo(resultadoWS.getMensaje().getTipo());
		mensaje.setId(resultadoWS.getMensaje().getIdMensaje().longValue());
		
		resultado.setMensaje(mensaje);
		resultado.setFecha(fechaHora);
		resultado.setLectura(lectura);
		
		return resultado;
	}
	
	public Mensaje cambiarEstadoPlaca(Placa placa, String estado)
	{
		Comunicacion clienteWS= iniciarConexion(placa.getIpPlaca(), placa.getPuetroPlaca());
		
//		String estado= String.valueOf(placa.getEstado());
        
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsCambiarEstadoSistema(estado);
        Mensaje mensaje= new Mensaje();
        mensaje.setTexto(resultadoWS.getTexto());
		mensaje.setTipo(resultadoWS.getTipo());
		mensaje.setId(resultadoWS.getIdMensaje().longValue());
        
		return mensaje;
	}
	
	public Mensaje actualizarSensor(Sensor sensor)
	{
		
		Comunicacion clienteWS= iniciarConexion(sensor.getPlaca().getIpPlaca(), sensor.getPlaca().getPuetroPlaca());
		BigInteger nroPuerto= BigInteger.valueOf(sensor.getNumeroPuerto());
		BigInteger idTipoPuerto= null;
		if (sensor.getTipoPuerto() != null)
			idTipoPuerto= BigInteger.valueOf(sensor.getTipoPuerto().getId());
		BigInteger idPlacaPadre= null;
		if (sensor.getPadre() != null)
			idPlacaPadre= BigInteger.valueOf(sensor.getPadre().getId());
		BigInteger idFactor= null;
		if (sensor.getFactor() != null)
			idFactor= BigInteger.valueOf(sensor.getFactor().getIdFactor());
		BigInteger idDispositivo= BigInteger.valueOf(sensor.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarSensor(sensor.getNombre(), sensor.getModelo(), nroPuerto, sensor.getFormulaConversion(), idTipoPuerto, idPlacaPadre, idFactor, idDispositivo);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
        
		return mensaje;
	}
	
	public Mensaje actualizarActuadorAvance(ActuadorAvance actuadorAvance)
	{
		
		Comunicacion clienteWS= iniciarConexion(actuadorAvance.getPlaca().getIpPlaca(), actuadorAvance.getPlaca().getPuetroPlaca());
		BigInteger nroPuerto= BigInteger.valueOf(actuadorAvance.getNumeroPuerto());
		BigInteger idTipoPuerto= null;
		if (actuadorAvance.getTipoPuerto() != null)
			idTipoPuerto= BigInteger.valueOf(actuadorAvance.getTipoPuerto().getId());
		BigInteger idTipoActuador= null;
		if (actuadorAvance.getTipoActuador() != null)
			idTipoActuador= BigInteger.valueOf(actuadorAvance.getTipoActuador().getId());
		BigInteger posicion= BigInteger.valueOf(actuadorAvance.getPosicion());
		BigInteger idPlacaPadre= null;
		if (actuadorAvance.getPadre() != null)
			idPlacaPadre= BigInteger.valueOf(actuadorAvance.getPadre().getId());
		BigInteger nroPuertoRetroceso= BigInteger.valueOf(actuadorAvance.getNumeroPuertoRetroceso());
		BigInteger tiempoEntrePosiciones= BigInteger.valueOf(actuadorAvance.getTiempoEntrePosiciones());
		BigInteger idGrupoActuadores= null;
		if (actuadorAvance.getGrupoActuadores() != null)
			idGrupoActuadores= BigInteger.valueOf(actuadorAvance.getGrupoActuadores().getId());
		BigInteger idDispositivo= BigInteger.valueOf(actuadorAvance.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarActuadorAvance(actuadorAvance.getNombre(), actuadorAvance.getModelo(), nroPuerto, posicion, idTipoPuerto, idTipoActuador, idPlacaPadre, nroPuertoRetroceso, tiempoEntrePosiciones, idGrupoActuadores, idDispositivo);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
        
		return mensaje;
	}
	
	public Mensaje actualizarActuador(Actuador actuador)
	{
		
		Comunicacion clienteWS= iniciarConexion(actuador.getPlaca().getIpPlaca(), actuador.getPlaca().getPuetroPlaca());
		BigInteger nroPuerto= BigInteger.valueOf(actuador.getNumeroPuerto());
		BigInteger idTipoPuerto= null;
		if (actuador.getTipoPuerto() != null)
			idTipoPuerto= BigInteger.valueOf(actuador.getTipoPuerto().getId());
		BigInteger idTipoActuador= null;
		if (actuador.getTipoActuador() != null)
			idTipoActuador= BigInteger.valueOf(actuador.getTipoActuador().getId());
		BigInteger idPlacaPadre= null;
		if (actuador.getPadre() != null)
			idPlacaPadre= BigInteger.valueOf(actuador.getPadre().getId());
		BigInteger idGrupoActuadores= null;
		if (actuador.getGrupoActuadores() != null)
			idGrupoActuadores= BigInteger.valueOf(actuador.getGrupoActuadores().getId());
		BigInteger idDispositivo= BigInteger.valueOf(actuador.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarActuador(actuador.getNombre(), actuador.getModelo(), nroPuerto, idTipoPuerto, idTipoActuador, idPlacaPadre, idGrupoActuadores, idDispositivo);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
        
		return mensaje;
	}
	
	public Mensaje actualizarGrupoActuadores(GrupoActuadores grupoActuadores)
	{
		Comunicacion clienteWS= iniciarConexion(grupoActuadores.getPlaca().getIpPlaca(), grupoActuadores.getPlaca().getPuetroPlaca());
		BigInteger idGrupoActuadores= BigInteger.valueOf(grupoActuadores.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarGrupoActuadores(grupoActuadores.getNombre(), grupoActuadores.getDeAvance(), idGrupoActuadores);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}
	
	public Mensaje actualizarTipoActuador(TipoActuador tipoActuador)
	{
		Comunicacion clienteWS= iniciarConexion(tipoActuador.getPlaca().getIpPlaca(), tipoActuador.getPlaca().getPuetroPlaca());
		BigInteger idTipoActuador= BigInteger.valueOf(tipoActuador.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarTipoActuador(tipoActuador.getCategoria(), idTipoActuador);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}
	
	public Mensaje actualizarTipoPlaca(TipoPlacaAuxiliar tipoPlaca)
	{
		Comunicacion clienteWS= iniciarConexion(tipoPlaca.getPlaca().getIpPlaca(), tipoPlaca.getPlaca().getPuetroPlaca());
		BigInteger idTipoPlaca= BigInteger.valueOf(tipoPlaca.getId());
        uy.com.ceoyphoibe.SGIA.wsClient.Mensaje resultadoWS= clienteWS.wsActualizarTipoPlaca(tipoPlaca.getNombre(), idTipoPlaca);
        Mensaje mensaje= new Mensaje();
        mensaje.setId(resultadoWS.getIdMensaje().longValue());
        mensaje.setTexto(resultadoWS.getTexto());
        mensaje.setTipo(resultadoWS.getTipo());
		return mensaje;
	}
	
	

}
