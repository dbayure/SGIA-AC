
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.DTO.ResultadoLectura;
import uy.com.ceoyphoibe.SGIA.exception.WsPlacaControladoraException;
import uy.com.ceoyphoibe.SGIA.model.Factor;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Sensor;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase Factor
 */
@Stateless
public class RegistroFactor {


	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event <Factor> factorEventSrc;
	   
	   public Factor registroPlaca(Factor factor) throws WsPlacaControladoraException {
		   FachadaWS ws= new FachadaWS();
		   try
		   {
			   factor= ws.registroFactor(factor);
		   }
		   catch (Exception ex)
		   {
			   factor.getPlaca().setEstadoAlerta('O');
			   factorEventSrc.fire(factor);
			   throw new WsPlacaControladoraException("Pérdida de conectividad con Placa Controladora");
		   }
		   
		   em.merge(factor);
		   factorEventSrc.fire(factor);
		   return factor;
	   }
	   
	   public void registro(Factor factor) throws Exception {
		   em.merge(factor);
		   factorEventSrc.fire(factor);
	   }
	   
	   public Mensaje modificar(Factor factor) throws Exception {
		   FachadaWS ws= new FachadaWS();
		   Mensaje resultado= ws.actualizarFactor(factor);
		   if (resultado.getTipo().equals("Informativo"))
			   em.merge(factor);
		   factorEventSrc.fire(factor);
		   return resultado;
	   }
	   
	   public Mensaje eliminar(Long id) throws Exception {
		   Factor factor = em.find(Factor.class, id);
		   FachadaWS ws= new FachadaWS();
		   Mensaje resultado= ws.eliminarFactor(factor);
		   if (resultado.getTipo().equals("Informativo"))
		   {
			   factor.setActivoSistema('N');
			   em.merge(factor);
		   }
		   factorEventSrc.fire(factor);
		   return resultado;
	   }
	  
	   public List<Sensor> getListaSensoresId(long id){
		   Factor factor = em.find(Factor.class, id);
		   List<Sensor> sensoresFactor = factor.getSensores();
		   return sensoresFactor;
	   }

	   public Factor obtenerFactorPorId (long id){
		   return em.find(Factor.class, id);		   
	   }
	   
	   public ResultadoLectura lecturaFactor(long idFactor) throws WsPlacaControladoraException{
		   ResultadoLectura rl = new ResultadoLectura();
		   Factor factor= obtenerFactorPorId(idFactor);
		   FachadaWS ws= new FachadaWS();
		   rl = ws.lecturaFactor(factor);

		   return rl;
	   }
}
