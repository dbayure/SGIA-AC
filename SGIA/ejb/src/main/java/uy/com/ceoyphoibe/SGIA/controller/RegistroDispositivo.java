package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;


@Stateless
public class RegistroDispositivo {
	

	   @Inject
	   private EntityManager em;

	   public Dispositivo obtenerDispositivoPorId (long id){
		   return em.find(Dispositivo.class, id);
	   }

	   public void pedirEstadoDispositivo (Dispositivo dispositivo){
			try{
				FachadaWS ws= new FachadaWS();
				String estado = ws.obtenerEstadoAlertaDispositivo(dispositivo);
				dispositivo.setEstadoAlerta(estado);
				em.merge(dispositivo);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

}
