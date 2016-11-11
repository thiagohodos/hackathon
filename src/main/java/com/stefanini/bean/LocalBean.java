package com.stefanini.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

@javax.faces.bean.ManagedBean
@javax.faces.bean.ViewScoped
public class LocalBean {

	public void pontoSelecionado(PointSelectEvent event) {  
		LatLng latituteLongitude = event.getLatLng();  

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(
						FacesMessage.SEVERITY_INFO, 
						"Ponto selecionado", 
						"Lat:" + latituteLongitude.getLat() + ", Long:" + latituteLongitude.getLng()
						)
				);  
	}  
}