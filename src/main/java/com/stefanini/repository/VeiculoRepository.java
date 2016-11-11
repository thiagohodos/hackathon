package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Agente;
import com.stefanini.model.Veiculo;

public class VeiculoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Veiculo tipo) {
		this.manager.persist(tipo);
	}

	public void altera(Veiculo tipo) {
		this.manager.merge(tipo);
	}

	public Veiculo busca(Integer id) {
		return this.manager.find(Veiculo.class, id);
	}

	public List<Veiculo> lista() {
		return this.manager.createQuery("from Veiculos", Veiculo.class).getResultList();
	}
	
	public void excluir(Veiculo veiculo){
		this.manager.remove(veiculo);
	}
	
	
	
}
