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
import uy.com.ceoyphoibe.SGIA.model.TipoActuador;
/**
 * Clase utilizada para convertir un objeto TipoActuador para ser utilizado en la vista
 */
@FacesConverter(forClass = TipoActuador.class, value = "tipoActuadorConverter")
public class TipoActuadorConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.trim().equals("")) {
			value = ((HttpServletRequest) context.getExternalContext()
					.getRequest()).getParameter(component.getClientId()
					+ "_input");
			// return null;
		}
		TipoActuador tipoActuador = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			tipoActuador = mapper.readValue(new URL(context
					.getExternalContext().getRequestScheme()
					+ "://"
					+ context.getExternalContext().getRequestServerName()
					+ ":"
					+ context.getExternalContext().getRequestServerPort()
					+ context.getExternalContext().getRequestContextPath()
					+ "/rest/tipoActuadores/" + value), TipoActuador.class);
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error de Conversion",
					"Tipo Actuador no válido"));
		}
		return tipoActuador;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((TipoActuador) value).getId());
		}
	}

}
