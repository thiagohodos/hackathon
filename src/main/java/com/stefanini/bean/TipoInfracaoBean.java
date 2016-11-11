package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.TipoInfracao;
import com.stefanini.service.TipoService;
import com.stefanini.util.FacesUtil;

@Named
@RequestScoped
public class TipoInfracaoBean implements Serializable {

	@Inject
	private TipoInfracao tipo;
	@Inject
	private TipoService service;

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

	public void cadastrar() {
		try {
			service.incluir(tipo);
			FacesUtil.exibeSucesso("Tipo cadastrado com sucesso!");
			tipo = new TipoInfracao();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao inserir um tipo.");
		}

	}

}
