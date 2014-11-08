package uy.com.ceoyphoibe.SGIA.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.ceoyphoibe.SGIA.model.Mensaje;



@RequestScoped
public class MensajeListProducer {
	
   @Inject
   private EntityManager em;

   private List<Mensaje> mensajes;


   @Produces
   @Named
   public List<Mensaje> getMensajes() {
      return mensajes;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Mensaje mensaje) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Mensaje> criteria = cb.createQuery(Mensaje.class);
      Root<Mensaje> mensaje = criteria.from(Mensaje.class);
      criteria.select(mensaje).orderBy(cb.asc(mensaje.get("texto")));
      mensajes = em.createQuery(criteria).getResultList();
   }
}
