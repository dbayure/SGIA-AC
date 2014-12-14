package uy.com.ceoyphoibe.SGIA.wsClient;

import java.math.BigInteger;
import java.net.URL;

import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Placa;
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

}
