package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {

	@Inject
	private ProprietarioRepository proprietarioRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Proprietario p) {
		proprietarioRepository.incluir(p);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Proprietario> lista() {
		return proprietarioRepository.lista();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Proprietario buscar(Integer id) {
		return proprietarioRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Proprietario proprietario) throws Exception {
		try {
			proprietario = buscar(proprietario.getId());
			if (proprietario != null) {
				this.proprietarioRepository.excluir(proprietario);
			}
		} catch (Exception e) {
			throw new Exception("Agente não pode ser excluído!");
		}
	}
	
	
}
