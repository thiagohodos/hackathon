package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Infracao;
import com.stefanini.model.LocalInfracao;

public class InfracaoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Infracao infra) {
		this.manager.persist(infra);
	}

	public void altera(Infracao infra) {
		this.manager.merge(infra);
	}

	public Infracao busca(Integer id) {
		return this.manager.find(Infracao.class, id);
	}

	public List<Infracao> lista() {
		return this.manager.createQuery("select l from infracoes l", Infracao.class).getResultList();
	}

}
