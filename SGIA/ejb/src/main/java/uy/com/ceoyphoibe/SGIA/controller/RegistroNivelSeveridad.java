package uy.com.ceoyphoibe.SGIA.controller;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;
import uy.com.ceoyphoibe.SGIA.model.NivelSeveridad;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
import uy.com.ceyphoibe.SGIA.exception.contradiccionPrioridadException;
import uy.com.ceyphoibe.SGIA.exception.perfilContradictorioFactorException;
import uy.com.ceyphoibe.SGIA.exception.rangoNivelException;

@Stateless
public class RegistroNivelSeveridad {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<NivelSeveridad> nivelSeveridadEventSrc;
	
	
	
	private boolean validarRangoFactor( List<NivelSeveridad> listaNiveles, NivelSeveridad nivel)
	{
		System.out.println("entra a validar el rango según el factor del nivel de severidad");
		boolean ok= true;
		if (nivel.getRangoMin()==nivel.getRangoMax())
			ok= false;
		int i=0;
		while (ok && i<listaNiveles.size())
		{
			NivelSeveridad nivelTemp= listaNiveles.get(i);
			if (nivel.getFactor().getIdFactor() == nivelTemp.getFactor().getIdFactor())
			{
				if ( (nivel.getRangoMin() >= nivelTemp.getRangoMin() && nivel.getRangoMin() < nivelTemp.getRangoMax()) || (nivel.getRangoMax() > nivelTemp.getRangoMin() && nivel.getRangoMax() <= nivelTemp.getRangoMax()) )
					ok = false;
				else
				{
					if (nivel.getRangoMin() <= nivelTemp.getRangoMin() && nivel.getRangoMax() >= nivelTemp.getRangoMax())
						ok= false;
					else
						ok= true;
				}
				
			}
			i++;
		}
		return ok;
	}
	
	private boolean validarContradiccionPrioridad( List<NivelSeveridad> listaNiveles, NivelSeveridad nivel)
	{
		System.out.println("entra a validar contradicciones de activacion segun la prioridad del nivel de severidad");
		boolean ok= true;
		
		int i=0;
		while (ok && i<listaNiveles.size())
		{
			NivelSeveridad nivelTemp= listaNiveles.get(i);
			if ((nivel.getFactor().getIdFactor() != nivelTemp.getFactor().getIdFactor()) && (nivel.getPrioridad() == nivelTemp.getPrioridad()))
			{
				Iterator<FilaPerfilActivacion> perfilTemp= nivelTemp.getPerfilActivacion().iterator();
				while(ok && perfilTemp.hasNext())
				{
					FilaPerfilActivacion filaTemp= perfilTemp.next();
					Iterator<FilaPerfilActivacion> perfilNuevo= nivel.getPerfilActivacion().iterator();
					while (ok && perfilNuevo.hasNext())
					{
						FilaPerfilActivacion filaNueva= perfilNuevo.next();
						if (filaTemp.getGrupoActuadores().getId() == filaNueva.getGrupoActuadores().getId())
							ok= filaTemp.getEstado().equals(filaNueva.getEstado());
					}
					
				}
				
			}
			i++;
		}
		return ok;
	}
	
	private boolean validarPerfilActivacionFactor( List<NivelSeveridad> listaNiveles, NivelSeveridad nivel)
	{
		System.out.println("entra a validar el el conjunto de grupos de actuadores del perfil de activación según el factor del nivel de severidad");
		boolean ok= true;
		
		int i=0;
		while (ok && i<listaNiveles.size())
		{
			NivelSeveridad nivelTemp= listaNiveles.get(i);
			if (nivel.getFactor().getIdFactor() == nivelTemp.getFactor().getIdFactor())
			{
				ok= nivel.getPerfilActivacion().size() == nivelTemp.getPerfilActivacion().size();
				
				Iterator<FilaPerfilActivacion> perfilTemp= nivelTemp.getPerfilActivacion().iterator();
				while(ok && perfilTemp.hasNext())
				{
					FilaPerfilActivacion filaTemp= perfilTemp.next();
					Iterator<FilaPerfilActivacion> perfilNuevo= nivel.getPerfilActivacion().iterator();
					boolean estaGrupo= false;
					while (!estaGrupo && perfilNuevo.hasNext())
					{
						FilaPerfilActivacion filaNueva= perfilNuevo.next();
						estaGrupo= (filaTemp.getGrupoActuadores().getId() == filaNueva.getGrupoActuadores().getId());
					}
					ok= estaGrupo;
				}
				
			}
			i++;
		}
		return ok;
	}
	
	private boolean validarNivelSeveridad(NivelSeveridad nivel) throws rangoNivelException, contradiccionPrioridadException, perfilContradictorioFactorException
	{
		System.out.println("entra a validar el nivel de severidad");
		boolean control= true;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	      CriteriaQuery<NivelSeveridad> criteria = cb.createQuery(NivelSeveridad.class);
	      Root<NivelSeveridad> nivelT = criteria.from(NivelSeveridad.class);
	      criteria.select(nivelT).orderBy(cb.asc(nivelT.get("id")));
	      List<NivelSeveridad>listaNiveles = em.createQuery(criteria).getResultList();
		

		System.out.println("obtiene la lista de niveles con largo: "+ listaNiveles.size());
		if (listaNiveles.size() > 0)
		{
			control= validarRangoFactor(listaNiveles, nivel);
			if (!control)
				throw new rangoNivelException("Rango no válido para el Factor seleccionado");
			else
			{
				control= validarContradiccionPrioridad(listaNiveles, nivel);
				if (!control)
					throw new contradiccionPrioridadException("Perfil de activación contradictorio para la prioridad definida.");
				else
				{
					control= validarPerfilActivacionFactor(listaNiveles, nivel);
					if (!control)
						throw new perfilContradictorioFactorException("Los perfiles de activación de niveles de un mismo factor deben actuar sobre exactamente el mismo conjunto de grupos de actuadores");
					
				}
			}
		}
		return control;
	}
	

	public NivelSeveridad obtenerNivelSeveridadPorId(long id) {
		NivelSeveridad temp=em.find(NivelSeveridad.class, id);
		nivelSeveridadEventSrc.fire(temp);
		return temp;
	}

	public void registro(NivelSeveridad n) throws Exception {
		if (validarNivelSeveridad(n))
		{	
			FachadaWS ws= new FachadaWS();
			n= ws.registroNivelSeveridad(n);
			   
			em.merge(n);
			nivelSeveridadEventSrc.fire(n);
		}
		else
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!NO PASA EL CONTROL DE NIVELES");
	}

	public void modificar(NivelSeveridad nivel) throws Exception {
		log.info("Modifico " + nivel);
		em.merge(nivel);
	}

	public void eliminar(Long id) throws Exception {
		log.info("Elimino " + id);
		NivelSeveridad nivel = em.find(NivelSeveridad.class, id);
		em.remove(nivel);
		nivelSeveridadEventSrc.fire(nivel);
	}
}
