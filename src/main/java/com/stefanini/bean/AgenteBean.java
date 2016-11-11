package com.stefanini.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.util.FacesUtil;

@Named
@SessionScoped
public class AgenteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Agente agente;
	@Inject
	private AgenteService agenteService;
	private boolean verificado;
	private List<Agente> agentes;

	public void cadastrar() {
		try {
			agenteService.incluir(agente);
			FacesUtil.exibeSucesso("Inserido");
			agente = new Agente();
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao inserir agente");
		}
	}

	
	public void excluir(Agente agenteRemover) {
		try {
			agenteService.excluir(agenteRemover);
			FacesUtil.exibeSucesso("Excluído com sucesso");
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao excluir agente");
		}
	}
	
	public void verificar() {
		Calendar c = Calendar.getInstance();
		c.setTime(agente.getDtContratacao());
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.YEAR, -1);
		if (c.compareTo(c2) == -1) {
			verificado = true;
		}
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	public List<Agente> getAgentes() {
		if(agentes == null){
			agentes = agenteService.lista();
		}
		return agentes;
	}

	
}
