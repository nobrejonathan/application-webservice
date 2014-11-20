package br.ucb.talp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.talp.enums.ResponseType;

@FacesConverter ("responseTypeConverter")
public class ResponseTypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		for (ResponseType type : ResponseType.values()) {
			if (type.name().equals(value)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof ResponseType) {
			ResponseType type = ResponseType.valueOf(value.toString());
			return type.name();
		}
		return null;
	}
}
