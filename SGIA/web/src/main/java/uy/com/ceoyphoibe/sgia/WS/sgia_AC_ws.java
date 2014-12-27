package uy.com.ceoyphoibe.sgia.WS;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import uy.com.ceoyphoibe.SGIA.DTO.LecturaWS;
import uy.com.ceoyphoibe.SGIA.controller.RegistroLectura;
import uy.com.ceoyphoibe.SGIA.controller.RegistroPlaca;
import uy.com.ceoyphoibe.SGIA.model.Lectura;

@WebService
public class sgia_AC_ws implements Serializable{

	@Inject
	private RegistroPlaca rPlaca;
	
	@Inject
	private RegistroLectura rLectura;
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return true;
	}
	
//	@WebMethod
//	public boolean inLecturas(String nroSerie, LecturaWS lectura)
//	{
//		System.out.println("****************entra al ws");
//		Long idPlaca= rPlaca.obtenerIdPlacaNroSerie(nroSerie);
////		for (LecturaWS lectura : listaLecturas)
////		{
//			System.out.println("lectura recibida: ");
//			System.out.println("Fecha: "+lectura.getFecha());
//			System.out.println("Valor: "+lectura.getLectura());
//			System.out.println("Dispositivio: "+lectura.getIdDispositivo());
//			Lectura l= new Lectura();
//			l.setIdPlaca(idPlaca);
//			Timestamp fechaHora= Timestamp.valueOf(lectura.getFecha());
//			l.setFechaHora(fechaHora);
//			Long idDispositivo= new Long(lectura.getIdDispositivo());
//			l.setIdSensor(idDispositivo);
//			l.setValor(lectura.getLectura());
//			try {
//				rLectura.registro(l);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//	//	}
//		return true;
//	}
//	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2953071844666719795L;

	@WebMethod
	public String holaMundo()
	{
		String hola= "Hola hola";
		return hola;
	}
}
