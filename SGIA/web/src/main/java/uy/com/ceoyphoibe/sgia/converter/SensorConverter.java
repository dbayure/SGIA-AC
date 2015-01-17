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
import uy.com.ceoyphoibe.SGIA.model.Sensor;
/**
 * Clase utilizada para convertir un objeto Sensor para ser utilizado en la vista
 */
@FacesConverter(forClass = Sensor.class, value = "sensorConverter")
public class SensorConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.trim().equals("")) {
			value = ((HttpServletRequest) context.getExternalContext()
					.getRequest()).getParameter(component.getClientId()
					+ "_input");
			// return null;
		}
		Sensor sensor = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			sensor = mapper.readValue(new URL(context.getExternalContext()
					.getRequestScheme()
					+ "://"
					+ context.getExternalContext().getRequestServerName()
					+ ":"
					+ context.getExternalContext().getRequestServerPort()
					+ context.getExternalContext().getRequestContextPath()
					+ "/rest/sensores/" + value), Sensor.class);
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error de Conversion",
					"Sensor no válido"));
		}
		return sensor;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((Sensor) value).getId());
		}
	}
}
