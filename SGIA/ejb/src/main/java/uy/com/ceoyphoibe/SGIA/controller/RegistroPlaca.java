package uy.com.ceoyphoibe.SGIA.controller;

import java.util.HashSet;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceyphoibe.SGIA.exception.PlacaNoSeConectaExeption;
import ws.Comunicacion;
import ws.Comunicacion_Service;
import ws.ResultadoCreacionWS;


@Stateful
@Model
public class RegistroPlaca {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event <Placa> placaEventSrc;
	   
	   public void registro(Placa placa) throws Exception {
		   em.merge(placa);
		   placaEventSrc.fire(placa);
	   }
	   
	   public void modificar(Placa placa) throws Exception {
		   log.info("Modifico " + placa);
		   em.merge(placa);
		   placaEventSrc.fire(placa);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Placa placa = em.find(Placa.class, id);
		   em.remove(placa);
	   }
	  
	   public HashSet<Dispositivo> getListaDispositivosId(long id){
		   Placa placa = em.find(Placa.class, id);
		   HashSet<Dispositivo> dispositivosPlaca = (HashSet<Dispositivo>) placa.getListaDispositivos();
		   return dispositivosPlaca;
	   }

	   public Placa obtenerPlacaPorId (long id){
		   return em.find(Placa.class, id);		   
	   }
	   
	   public void conectarWs(String ip, int puerto) throws PlacaNoSeConectaExeption{
		   try{
		        Placa placa = new Placa();
		        Comunicacion_Service service1 = new Comunicacion_Service();
		        Comunicacion port1 = service1.getComunicacion();
	//	        ResultadoCreacionWS resultadoWS= port1.wsConectarPlaca(ip, puerto);
	
	//	        placa.setEstado(resultadoWs.getEstado());
	//			placa.setEstadoAlerta(resultadoWS.getEstadoAlerta());
	//			placa.setPeriodicidadLecturas(resultadoWS.getPeriodicidadLecturas());
	//			placa.setPeriodicidadNiveles(resultadoWS.getPeriodicidadNiveles());
	//			placa.setIpCentralizadora(resultadoWS.getIPCentralizadora);
	//			placa.setPuertoCentralizadora(resultadoWS.getPuertoCentralizadora);
	//			placa.setHostWSSMS(resultadoWS.getHostWSSMS);
	//			placa.setPuertoWSSMS(resultadoWS.getPuertoWSSMS);
	//			placa.setPuetroPlaca(puerto);
				placa.setIpPlaca(ip);
				em.merge(placa);
			
		   }
		   catch (Exception e){
			   e.printStackTrace();
			   throw new PlacaNoSeConectaExeption("No fue posible establecer comunicacion con la placa centralizadora solicitada");
		   }

	   }
}