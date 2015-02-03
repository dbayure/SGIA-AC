
package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import uy.com.ceoyphoibe.SGIA.model.Placa;

/**
 * La clase AndroidBean controla la vista para generación del código QR para descarga de la aplicación para android
 *	
 */
@ManagedBean(name = "androidBean")
@ViewScoped
public class AndroidBean {

	private String ip;
	private String url;
	
	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	/**
	 * 
	 */
	public AndroidBean() {
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		ip= placa.getIpCentralizadora();
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		ip= placa.getIpCentralizadora();
		url=ip+":8080/SGIA-web/resources/SGIA-AM.apk";
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	

}
