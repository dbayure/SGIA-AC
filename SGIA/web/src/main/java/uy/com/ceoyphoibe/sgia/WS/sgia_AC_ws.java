package uy.com.ceoyphoibe.sgia.WS;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import uy.com.ceoyphoibe.SGIA.DTO.AccionWS;
import uy.com.ceoyphoibe.SGIA.DTO.LecturaWS;
import uy.com.ceoyphoibe.SGIA.controller.RegistroAccion;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLecturaFactor;
import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.model.Accion;
import uy.com.ceoyphoibe.SGIA.model.Lectura;
import uy.com.ceoyphoibe.SGIA.model.LecturaFactor;

@WebService
public class sgia_AC_ws implements Serializable{

	private static final long serialVersionUID = 2953071844666719795L;
	
	@Inject
	private RegistroPlaca rPlaca;
	
	@Inject
	private RegistroLectura rLectura;
	
	@Inject
	private RegistroLecturaFactor rLecturaFactor;
	
	@Inject
	private RegistroAccion rAcciones;
	
	@WebMethod
	public boolean inLecturas(String nroSerie, List<LecturaWS> listaLecturas)
	{
		System.out.println("****************entra al ws");
		Long idPlaca= rPlaca.obtenerIdPlacaNroSerie(nroSerie);
		for (LecturaWS lectura : listaLecturas)
		{
			System.out.println("lectura recibida: ");
			System.out.println("Fecha: "+lectura.getFecha());
			System.out.println("Valor: "+lectura.getLectura());
			System.out.println("Dispositivio: "+lectura.getIdDispositivo());
			Lectura l= new Lectura();
			l.setIdPlaca(idPlaca);
			Timestamp fechaHora= Timestamp.valueOf(lectura.getFecha());
			l.setFechaHora(fechaHora);
			Long idDispositivo= new Long(lectura.getIdDispositivo());
			l.setIdSensor(idDispositivo);
			l.setValor(lectura.getLectura());
			try {
				rLectura.registro(l);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return true;
	}
	
	@WebMethod
	public boolean inLecturasFactor(String nroSerie, List<LecturaWS> listaLecturas)
	{
		Long idPlaca= rPlaca.obtenerIdPlacaNroSerie(nroSerie);
		for (LecturaWS lectura : listaLecturas)
		{
			System.out.println("lectura recibida: ");
			System.out.println("Fecha: "+lectura.getFecha());
			System.out.println("Valor: "+lectura.getLectura());
			System.out.println("Dispositivio: "+lectura.getIdDispositivo());
			LecturaFactor l= new LecturaFactor();
			l.setIdPlaca(idPlaca);
			Timestamp fechaHora= Timestamp.valueOf(lectura.getFecha());
			l.setFechaHora(fechaHora);
			Long idFactor= new Long(lectura.getIdDispositivo());
			l.setIdFactor(idFactor);
			l.setValor(lectura.getLectura());
			try {
				rLecturaFactor.registro(l);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	@WebMethod
	public boolean inAcciones(String nroSerie, List<AccionWS> listaAcciones)
	{
		Long idPlaca= rPlaca.obtenerIdPlacaNroSerie(nroSerie);
		for (AccionWS accion : listaAcciones)
		{
			System.out.println("accion recibida: ");
			System.out.println("Fecha: "+accion.getFecha());
			System.out.println("Tipo Accion: "+accion.getTipoAccion());
			System.out.println("Dispositivio: "+accion.getIdDispositivo());
			Accion a= new Accion();
			a.setIdPlaca(idPlaca);
			Timestamp fechaHora= Timestamp.valueOf(accion.getFecha());
			a.setFechaHora(fechaHora);
			Long idActuador= new Long(accion.getIdDispositivo());
			a.setIdDispositivo(idActuador);
			a.setTipoAccion(accion.getTipoAccion());
			try {
				rAcciones.registro(a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
