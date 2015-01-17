
package uy.com.ceoyphoibe.SGIA.controller;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.ceoyphoibe.SGIA.exception.ContradiccionPrioridadException;
import uy.com.ceoyphoibe.SGIA.exception.PerfilContradictorioFactorException;
import uy.com.ceoyphoibe.SGIA.exception.RangoNivelException;
import uy.com.ceoyphoibe.SGIA.model.FilaPerfilActivacion;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.NivelSeveridad;
import uy.com.ceoyphoibe.SGIA.wsClient.FachadaWS;
/**
 * Clase de apoyo que permite la interacción con el entity manager para realizar tareas con la clase NivelSeveridad
 */
@Stateless
public class RegistroNivelSeveridad {

	@Inject
	private EntityManager em;

	@Inject
	private Event<NivelSeveridad> nivelSeveridadEventSrc;

	private boolean validarRangoFactor(List<NivelSeveridad> listaNiveles,
			NivelSeveridad nivel) {
		System.out
				.println("entra a validar el rango según el factor del nivel de severidad");
		boolean ok = true;
		if (nivel.getRangoMin() == nivel.getRangoMax())
			ok = false;
		int i = 0;
		while (ok && i < listaNiveles.size()) {
			NivelSeveridad nivelTemp = listaNiveles.get(i);
			if (nivel.getFactor().getIdFactor() == nivelTemp.getFactor()
					.getIdFactor() && nivelTemp.getId() != nivel.getId()) {
				if ((nivel.getRangoMin() >= nivelTemp.getRangoMin() && nivel
						.getRangoMin() < nivelTemp.getRangoMax())
						|| (nivel.getRangoMax() > nivelTemp.getRangoMin() && nivel
								.getRangoMax() <= nivelTemp.getRangoMax()))
					ok = false;
				else {
					if (nivel.getRangoMin() <= nivelTemp.getRangoMin()
							&& nivel.getRangoMax() >= nivelTemp.getRangoMax())
						ok = false;
					else
						ok = true;
				}

			}
			i++;
		}
		return ok;
	}

	private boolean validarContradiccionPrioridad(
			List<NivelSeveridad> listaNiveles, NivelSeveridad nivel) {
		System.out
				.println("entra a validar contradicciones de activacion segun la prioridad del nivel de severidad");
		boolean ok = true;

		int i = 0;
		while (ok && i < listaNiveles.size()) {
			NivelSeveridad nivelTemp = listaNiveles.get(i);
			if ((nivel.getFactor().getIdFactor() != nivelTemp.getFactor()
					.getIdFactor())
					&& (nivel.getPrioridad() == nivelTemp.getPrioridad())
					&& nivelTemp.getId() != nivel.getId()) {
				Iterator<FilaPerfilActivacion> perfilTemp = nivelTemp
						.getPerfilActivacion().iterator();
				while (ok && perfilTemp.hasNext()) {
					FilaPerfilActivacion filaTemp = perfilTemp.next();
					Iterator<FilaPerfilActivacion> perfilNuevo = nivel
							.getPerfilActivacion().iterator();
					while (ok && perfilNuevo.hasNext()) {
						FilaPerfilActivacion filaNueva = perfilNuevo.next();
						if (filaTemp.getGrupoActuadores().getId() == filaNueva
								.getGrupoActuadores().getId())
							ok = filaTemp.getEstado().equals(
									filaNueva.getEstado());
					}

				}

			}
			i++;
		}
		return ok;
	}

	private boolean validarPerfilActivacionFactor(
			List<NivelSeveridad> listaNiveles, NivelSeveridad nivel) {
		System.out
				.println("entra a validar el el conjunto de grupos de actuadores del perfil de activación según el factor del nivel de severidad");
		boolean ok = true;

		int i = 0;
		while (ok && i < listaNiveles.size()) {
			NivelSeveridad nivelTemp = listaNiveles.get(i);
			if (nivel.getFactor().getIdFactor() == nivelTemp.getFactor()
					.getIdFactor() && nivelTemp.getId() != nivel.getId()) {
				ok = nivel.getPerfilActivacion().size() == nivelTemp
						.getPerfilActivacion().size();

				Iterator<FilaPerfilActivacion> perfilTemp = nivelTemp
						.getPerfilActivacion().iterator();
				while (ok && perfilTemp.hasNext()) {
					FilaPerfilActivacion filaTemp = perfilTemp.next();
					Iterator<FilaPerfilActivacion> perfilNuevo = nivel
							.getPerfilActivacion().iterator();
					boolean estaGrupo = false;
					while (!estaGrupo && perfilNuevo.hasNext()) {
						FilaPerfilActivacion filaNueva = perfilNuevo.next();
						estaGrupo = (filaTemp.getGrupoActuadores().getId() == filaNueva
								.getGrupoActuadores().getId());
					}
					ok = estaGrupo;
				}

			}
			i++;
		}
		return ok;
	}

	private boolean validarNivelSeveridad(NivelSeveridad nivel)
			throws RangoNivelException, ContradiccionPrioridadException,
			PerfilContradictorioFactorException {
		boolean control = true;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<NivelSeveridad> criteria = cb
				.createQuery(NivelSeveridad.class);
		Root<NivelSeveridad> nivelT = criteria.from(NivelSeveridad.class);
		criteria.select(nivelT).orderBy(cb.asc(nivelT.get("id")));
		criteria.where(cb.equal(nivelT.get("activoSistema"), "S"));
		List<NivelSeveridad> listaNiveles = em.createQuery(criteria)
				.getResultList();

		if (nivel.getId() == null)
			nivel.setId(Long.valueOf(0));
		if (listaNiveles.size() > 0) {
			control = validarRangoFactor(listaNiveles, nivel);
			if (!control)
				throw new RangoNivelException(
						"Rango no válido para el Factor seleccionado");
			else {
				control = validarContradiccionPrioridad(listaNiveles, nivel);
				if (!control)
					throw new ContradiccionPrioridadException(
							"Perfil de activación contradictorio para la prioridad definida.");
				else {
					control = validarPerfilActivacionFactor(listaNiveles, nivel);
					if (!control)
						throw new PerfilContradictorioFactorException(
								"Los perfiles de activación de niveles de un mismo factor deben actuar sobre exactamente el mismo conjunto de grupos de actuadores");

				}
			}
		}
		return control;
	}

	public NivelSeveridad obtenerNivelSeveridadPorId(long id) {
		NivelSeveridad temp = em.find(NivelSeveridad.class, id);
		nivelSeveridadEventSrc.fire(temp);
		return temp;
	}

	public void registro(NivelSeveridad n) throws Exception {
		if (validarNivelSeveridad(n)) {
			FachadaWS ws = new FachadaWS();
			n = ws.registroNivelSeveridad(n);

			em.merge(n);
			nivelSeveridadEventSrc.fire(n);
		} else
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!NO PASA EL CONTROL DE NIVELES");
	}

	public Mensaje modificar(NivelSeveridad nivel) throws Exception {
		Mensaje resultado = null;
		if (validarNivelSeveridad(nivel)) {
			FachadaWS ws = new FachadaWS();
			resultado = ws.eliminarPerfilActivacion(nivel);
			if (resultado.getTipo().equals("Informativo")) {
				resultado = ws.actualizarNivelSeveridad(nivel);
				if (resultado.getTipo().equals("Informativo"))
					em.merge(nivel);
			}
			nivelSeveridadEventSrc.fire(nivel);
		}
		return resultado;
	}

	public Mensaje eliminar(Long id) throws Exception {
		NivelSeveridad nivel = em.find(NivelSeveridad.class, id);
		FachadaWS ws = new FachadaWS();
		Mensaje resultado = ws.eliminarNivelSeveridad(nivel);
		if (resultado.getTipo().equals("Informativo")) {
			nivel.setActivoSistema("N");
			em.merge(nivel);
		}
		nivelSeveridadEventSrc.fire(nivel);
		return resultado;
	}
}
