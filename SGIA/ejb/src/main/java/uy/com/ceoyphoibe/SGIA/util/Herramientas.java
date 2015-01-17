/**
 * Clase de apoyo que permite la formación de urls
 */
package uy.com.ceoyphoibe.SGIA.util;

import java.net.MalformedURLException;
import java.net.URL;

import uy.com.ceoyphoibe.SGIA.wsClient.Comunicacion_Service;

public class Herramientas {

	public URL obtenerWSDL(String ip, String puerto) {
		URL url = null;
		try {
			url = new URL("http://" + ip + ":" + puerto + "/?wsdl");
		} catch (MalformedURLException e) {
			java.util.logging.Logger.getLogger(
					Comunicacion_Service.class.getName()).log(
					java.util.logging.Level.INFO,
					"Can not initialize the default wsdl from {0}",
					"http://" + ip + ":" + puerto + "/?wsdl");
		}
		return url;
	}

}
