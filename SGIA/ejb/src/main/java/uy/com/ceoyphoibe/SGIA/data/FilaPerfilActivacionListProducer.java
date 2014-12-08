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

import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;

@RequestScoped
public class FilaPerfilActivacionListProducer {
	
   @Inject
   private EntityManager em;

   private List<FilaPerfilActivacion> filasPerfilActivacion;


   @Produces
   @Named
   public List<FilaPerfilActivacion> getFilasPerfilActivacion() {
      return filasPerfilActivacion;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final FilaPerfilActivacion fila) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<FilaPerfilActivacion> criteria = cb.createQuery(FilaPerfilActivacion.class);
      Root<FilaPerfilActivacion> fila = criteria.from(FilaPerfilActivacion.class);
      criteria.select(fila).orderBy(cb.asc(fila.get("id")));
      filasPerfilActivacion = em.createQuery(criteria).getResultList();
   }
}
