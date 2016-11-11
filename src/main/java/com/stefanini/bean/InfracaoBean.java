package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracao;
import com.stefanini.model.LocalInfracao;
import com.stefanini.model.TipoInfracao;
import com.stefanini.model.Veiculo;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracaoService;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.service.TipoService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.FacesUtil;

@Named
@SessionScoped
public class InfracaoBean implements Serializable {

	@Inject
	private Infracao infracao;
	@Inject
	private InfracaoService infracaoService;
	@Inject
	private TipoService tipoService;
	@Inject
	private AgenteService agenteService;
	@Inject
	private LocalInfracaoService localService;
	@Inject
	private VeiculoService veiculoService;

	private List<LocalInfracao> locais = new ArrayList<>();
	private List<TipoInfracao> tipos = new ArrayList<>();
	private List<Agente> agentes = new ArrayList<>();
	private List<Infracao> infracoes;
	private List<Veiculo> veiculos = new ArrayList<>();

	private Integer agenteId;
	private Integer localId;
	private Integer tipoId;
	private Integer veiculoId;

	@PostConstruct
	public void init() {
		if (this.locais.isEmpty()) {
			locais = localService.lista();
		}

		if (this.tipos.isEmpty()) {
			tipos = tipoService.lista();
		}

		if (this.agentes.isEmpty()) {
			agentes = agenteService.lista();
		}

		if (this.veiculos.isEmpty()) {
			veiculos = veiculoService.lista();
		}
	}

	public List<Agente> completar(String nome) {
		List<Agente> results = new ArrayList<>();
		for (Agente a : agentes) {
			if (a.getNome().toUpperCase().contains(nome.toUpperCase())) {
				results.add(a);
			}
		}
		return results;
	}

	public List<Veiculo> completarVeiculo(String nome) {
		List<Veiculo> results = new ArrayList<>();
		for (Veiculo a : veiculos) {
			if (a.getPlaca().toUpperCase().contains(nome.toUpperCase())) {
				results.add(a);
			}
		}
		return results;
	}

	public void cadastrar() {
		Agente agente = getAgente(agenteId);
		LocalInfracao local = getLocal(localId);
		TipoInfracao tipo = getTipo(tipoId);
		Veiculo v = procuraVeiculo(veiculoId);

		try {
			infracao.setLocalInfracao(local);
			infracao.setTipoinfracao(tipo);
			infracao.setAgente(agente);
			infracao.setVeiculo(v);
			infracaoService.incluir(infracao);
			FacesUtil.exibeSucesso("Inserido com sucesso!");
			infracao = new Infracao();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao inserir infração");
		}
	}

	public Integer getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}

	public Integer getLocalId() {
		return localId;
	}

	public void setLocalId(Integer localId) {
		this.localId = localId;
	}

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public Agente getAgente(Integer id) {
		for (Agente a : agentes) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public LocalInfracao getLocal(Integer id) {
		for (LocalInfracao l : locais) {
			if (l.getId().equals(id)) {
				return l;
			}
		}
		return null;
	}

	public TipoInfracao getTipo(Integer id) {
		for (TipoInfracao t : tipos) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public Veiculo procuraVeiculo(Integer id) {
		for (Veiculo v : veiculos) {
			if (v.getId().equals(id)) {
				return v;
			}
		}
		return null;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	public List<Infracao> getInfracoes() {
		if(infracoes == null)
			infracoes = infracaoService.lista();
		return infracoes;
	}



	public List<TipoInfracao> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoInfracao> tipos) {
		this.tipos = tipos;
	}

	public List<LocalInfracao> getLocais() {
		return locais;
	}

	public void setLocais(List<LocalInfracao> locais) {
		this.locais = locais;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

}
