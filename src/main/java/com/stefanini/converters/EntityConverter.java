package com.stefanini.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.stefanini.util.EntityManagerProducer;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		if (object == null)
			return null;

		try {
			Class<?> classe = object.getClass();
			Long id = (Long) classe.getMethod("getId").invoke(object);

			return classe.getName() + "-" + id;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
		if (string == null || string.isEmpty())
			return null;
		try {
			EntityManagerProducer producer = new EntityManagerProducer();
			EntityManager manager = producer.getEntityManager();
			String[] values = string.split("-");
			System.out.println(manager == null);
			return manager.find(Class.forName(values[0]), Long.valueOf(values[1]));
		} catch (Exception e) {
			return null;
		}
	}

}
