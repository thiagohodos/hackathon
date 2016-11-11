package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.service.ModeloService;
import com.stefanini.util.FacesUtil;

@Named
@SessionScoped
public class ModeloBean implements Serializable {

	@Inject
	private ModeloService modeloService;
	@Inject
	private Modelo modelo;
	private List<Modelo> modelos;

	public void cadastrar() {
		try {
			modeloService.incluir(modelo);
			modelo = new Modelo();
			FacesUtil.exibeSucesso("Modelo cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao cadastrar");
		}
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Modelo> getModelos() {
		if(modelos == null)
			modelos = modeloService.lista();
		return modelos;
	}
	
	
	

}
