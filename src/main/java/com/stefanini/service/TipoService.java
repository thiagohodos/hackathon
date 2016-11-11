package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.TipoInfracao;
import com.stefanini.repository.TipoRepository;

@Stateless
public class TipoService {

	@Inject
	private TipoRepository tipoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(TipoInfracao t) {
		tipoRepository.incluir(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<TipoInfracao> lista() {
		return tipoRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TipoInfracao buscar(Integer id) {
		return tipoRepository.busca(id);
	}

}
