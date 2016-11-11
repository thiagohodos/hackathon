package com.stefanini.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public static void exibeSucesso(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		getContext().addMessage(null, facesMessage);
	}

	public static void exibeErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem);
		getContext().addMessage(null, facesMessage);
	}

}
