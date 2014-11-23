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

import uy.com.ceoyphoibe.SGIA.model.Actuador;



@RequestScoped
public class ActuadorListProducer {
	
   @Inject
   private EntityManager em;

   private List<Actuador> actuadores;


   @Produces
   @Named
   public List<Actuador> getActuadores() {
      return actuadores;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Actuador actuador) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Actuador> criteria = cb.createQuery(Actuador.class);
      Root<Actuador> actuador = criteria.from(Actuador.class);
      criteria.select(actuador).orderBy(cb.asc(actuador.get("id")));
      actuadores = em.createQuery(criteria).getResultList();
   }
}
