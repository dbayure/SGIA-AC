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

import uy.com.ceoyphoibe.SGIA.model.ResultadoLectura;



@RequestScoped
public class ResultadoLecturaListProducer {
	
   @Inject
   private EntityManager em;

   private List<ResultadoLectura> resultadoLecturas;


   @Produces
   @Named
   public List<ResultadoLectura> getResultadoLectura() {
      return resultadoLecturas;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final ResultadoLectura resultadoLecturas) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<ResultadoLectura> criteria = cb.createQuery(ResultadoLectura.class);
      Root<ResultadoLectura> resultadoLectura = criteria.from(ResultadoLectura.class);
      criteria.select(resultadoLectura).orderBy(cb.asc(resultadoLectura.get("valor")));
      resultadoLecturas = em.createQuery(criteria).getResultList();
   }
}
