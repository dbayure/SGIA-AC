package uy.com.ceoyphoibe.SGIA.controller;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.ceoyphoibe.SGIA.model.Dispositivo;
import uy.com.ceoyphoibe.SGIA.model.Placa;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
import uy.com.ceyphoibe.SGIA.exception.PlacaNoSeConectaExeption;

@Stateful
@Model
public class RegistroPlaca {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Placa> placaEventSrc;

	public void registro(Placa placa) throws Exception {
		em.merge(placa);
		placaEventSrc.fire(placa);
	}

	public void modificar(Placa placa) throws Exception {
		em.merge(placa);
		placaEventSrc.fire(placa);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		Placa placa = em.find(Placa.class, id);
		em.remove(placa);
	}

	public HashSet<Dispositivo> getListaDispositivosId(long id) {
		Placa placa = em.find(Placa.class, id);
		HashSet<Dispositivo> dispositivosPlaca = (HashSet<Dispositivo>) placa
				.getListaDispositivos();
		return dispositivosPlaca;
	}

	public Placa obtenerPlacaPorId(long id) {
		return em.find(Placa.class, id);
	}

	public boolean existePlaca(String nroSerie)
	{
		  CriteriaBuilder cb = em.getCriteriaBuilder();
	      CriteriaQuery<Placa> criteria = cb.createQuery(Placa.class);
	      Root<Placa> placa = criteria.from(Placa.class);
	      criteria.select(placa).orderBy(cb.asc(placa.get("id")));
	      List<Placa> placas = em.createQuery(criteria).getResultList();
	      boolean existe= false;
	      int i= 0;
	      while (!existe && i < placas.size() )
	      {
	    	  existe= placas.get(i).getNroSerie().equals(nroSerie);
	    	  i++;
	      }
	      return existe;
	   }

	public Placa conectarWs(String ip, int puerto)
			throws PlacaNoSeConectaExeption {
		try {
			FachadaWS ws= new FachadaWS();
			Placa placa = ws.obtenerDatosPlaca(ip, puerto);
			if (!existePlaca(placa.getNroSerie()))
			{
				em.merge(placa);
			}
			placaEventSrc.fire(placa);
			return placa;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlacaNoSeConectaExeption(
					"No fue posible establecer comunicacion con la placa centralizadora solicitada");
		}

	}
}