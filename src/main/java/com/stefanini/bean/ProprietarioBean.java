package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.util.FacesUtil;

@Named
@SessionScoped
public class ProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;
	@Inject
	private Proprietario proprietario;
	@Inject
	private Telefone telefone;
	
	private List<Proprietario> proprietarios;

	public void salvar() {
		try {
			proprietarioService.incluir(proprietario);
			proprietario = new Proprietario();
			FacesUtil.exibeSucesso("Proprietário cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao incluir");
		}
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.adicionarTelefone(telefone);
			this.telefone = new Telefone();
		}
	}

	public void excluir(Proprietario proprietarioRemover) {
		try {
			proprietarioService.excluir(proprietarioRemover);
			FacesUtil.exibeSucesso("Excluído com sucesso");
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("Erro ao excluir proprietário");
		}
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Proprietario> getProprietarios() {
		if(proprietarios == null)
			proprietarios = proprietarioService.lista();
		return proprietarios;
	}
	
	

}