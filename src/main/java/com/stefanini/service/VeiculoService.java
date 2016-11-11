package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Veiculo;
import com.stefanini.repository.VeiculoRepository;

@Stateless
public class VeiculoService {

	@Inject
	private VeiculoRepository veiculoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Veiculo t) {
		veiculoRepository.incluir(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Veiculo> lista() {
		return veiculoRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Veiculo buscar(Integer id) {
		return veiculoRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Veiculo veiculo) throws Exception {
		try {
			veiculo = buscar(veiculo.getId());
			if (veiculo != null) {
				this.veiculoRepository.excluir(veiculo);
			}
		} catch (Exception e) {
			throw new Exception("veiculo não pode ser excluído!");
		}
	}

}
