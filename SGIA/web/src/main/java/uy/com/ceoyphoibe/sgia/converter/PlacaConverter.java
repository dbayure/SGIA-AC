package uy.com.ceoyphoibe.sgia.converter;

import java.net.URL;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.map.ObjectMapper;
import uy.com.ceoyphoibe.SGIA.model.Placa;
/**
 * Clase utilizada para convertir un objeto Placa para ser utilizado en la vista
 */
@FacesConverter(forClass = Placa.class, value = "placaConverter")
public class PlacaConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Placa placa = null;
		if (value.trim().equals("")) {
			value = ((HttpServletRequest) context.getExternalContext()
					.getRequest()).getParameter(component.getClientId()
					+ "_input");
			// return null;
		} else {

			try {
				ObjectMapper mapper = new ObjectMapper();
				placa = mapper.readValue(new URL(context.getExternalContext()
						.getRequestScheme()
						+ "://"
						+ context.getExternalContext().getRequestServerName()
						+ ":"
						+ context.getExternalContext().getRequestServerPort()
						+ context.getExternalContext().getRequestContextPath()
						+ "/rest/placa/" + value), Placa.class);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Error de Conversion",
						"Placa no válida"));
			}
		}

		return placa;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((Placa) value).getId());
		}
	}

}