package uy.com.ceoyphoibe.SGIA.controller;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class TimerService {
    @Inject
    RegistroPlaca registroPlaca;
  
    @Schedule(minute="*/5",hour="*", persistent=false)
    public void doWork(){
    	System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*LLAMA A ACTUALIZAR LOS ESTADOS ALERTA");
        registroPlaca.obtenerEstadoAlertaPlacas();
    }
}