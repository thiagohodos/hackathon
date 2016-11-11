package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.LocalInfracao;
import com.stefanini.model.TipoInfracao;
import com.stefanini.repository.AgenteRepository;
import com.stefanini.repository.LocalInfracaoRepository;

@Stateless
public class LocalInfracaoService {

	@Inject
	private LocalInfracaoRepository localrepo;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(LocalInfracao local) {
		localrepo.incluir(local);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<LocalInfracao> lista() {
		return localrepo.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public LocalInfracao buscar(Integer id) {
		return localrepo.busca(id);
	}
}
