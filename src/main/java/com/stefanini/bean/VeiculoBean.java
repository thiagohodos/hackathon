package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.model.Proprietario;
import com.stefanini.model.Veiculo;
import com.stefanini.service.ModeloService;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.FacesUtil;

@Named
@SessionScoped
public class VeiculoBean implements Serializable {

	@Inject
	private Veiculo veiculo;
	private List<Proprietario> proprietarios = new ArrayList<>();
	private List<Modelo> modelos = new ArrayList<>();
	@Inject
	private ProprietarioService proprietarioService;
	@Inject
	private VeiculoService veiculoService;
	@Inject
	private ModeloService modeloService;
	private Integer idProprietario;
	private Integer idModelo;
	
	private List<Veiculo> veiculos = new ArrayList<>();


	public Modelo procuraModelo(Integer id) {
		for (Modelo m : modelos) {
			if (m.getIdModelo().equals(id)) {
				return m;
			}
		}
		return null;
	}

	public Proprietario procuraProprietario(Integer id) {
		for (Proprietario p : proprietarios) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public void atualizarLista(){
		if(veiculos != null)
			veiculos = veiculoService.lista();
	}
	
	public void cadastrar() {
		Modelo m = procuraModelo(idModelo);
		Proprietario p = procuraProprietario(idProprietario);
		veiculo.setProprietario(p);
		veiculo.setModelo(m);
		try {
			veiculoService.incluir(veiculo);
			veiculo = new Veiculo();
			FacesUtil.exibeSucesso("Veículo cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao incluir");
		}
	}
	
	public void excluir(Veiculo veiculoRemove) {
		try {
			veiculoService.excluir(veiculoRemove);
			FacesUtil.exibeSucesso("Excluído com sucesso");
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao excluir proprietário");
		}
	}
	public List<Veiculo> getVeiculos() {
		if(veiculos == null){
			veiculos = veiculoService.lista();
		}
		return veiculos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	
}
