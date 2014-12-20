package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import uy.com.ceoyphoibe.SGIA.model.Actuador;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.GrupoActuadores;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.model.Posicion;
import uy.com.ceoyphoibe.SGIA.model.Sensor;
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
        Mensaje mensajeResultado= clienteWS.wsAsociarFactorSensor(idFactor, idDispositivo);  
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
        Mensaje mensajeResultado= clienteWS.wsAsociarActuadorGrupo(idGrupoActuadores, idDispositivo); 
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
        Mensaje mensajeResultado= clienteWS.wsAsociarActuadorAvanceGrupo(idGrupoActuadores, idDispositivo);
        ok= mensajeResultado.getTipo().equals("Informativo");
        return ok;
	}
	
	

}