package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.LocalInfracao;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.util.FacesUtil;

@Named
@RequestScoped
public class LocalInfracaoBean implements Serializable {

	@Inject
	private LocalInfracaoService service;
	@Inject
	private LocalInfracao local;

	public void cadastrar() {
		try {
			service.incluir(local);
			FacesUtil.exibeSucesso("Local inserido com sucesso!");
			local = new LocalInfracao();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao inserir um local.");
		}
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}

}
