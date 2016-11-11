package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Infracao;
import com.stefanini.repository.InfracaoRepository;

@Stateless
public class InfracaoService {

	@Inject
	private InfracaoRepository infracaoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Infracao i) {
		infracaoRepository.incluir(i);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Infracao> lista() {
		return infracaoRepository.lista();
	}
	
}
