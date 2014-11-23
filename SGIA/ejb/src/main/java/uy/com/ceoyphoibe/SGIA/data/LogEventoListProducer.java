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

import uy.com.ceoyphoibe.SGIA.model.LogEvento;


@RequestScoped
public class LogEventoListProducer {
	
   @Inject
   private EntityManager em;

   private List<LogEvento> logEventos;


   @Produces
   @Named
   public List<LogEvento> getLogEventos() {
      return logEventos;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final LogEvento logEvento) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<LogEvento> criteria = cb.createQuery(LogEvento.class);
      Root<LogEvento> logEvento = criteria.from(LogEvento.class);
      criteria.select(logEvento).orderBy(cb.asc(logEvento.get("idLogEvento")));
      logEventos = em.createQuery(criteria).getResultList();
   }
}
