package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository repository;
	
//	public Estado atualizar(Long id, Estado estado) {
//		Estado estadoAtual = repository.buscar(id);
//		if (estadoAtual==null) {
//			throw new EntidadeNaoEncontradaException(String.format("Estado , args))
//		}
//		return null;
//	}
	
	public Estado salvar(Estado estado) {
		return repository.salvar(estado);
	}
	
	public void remover(Long id) {
		try {
			repository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado código %d.", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Este codigo %d não pode ser removido, pois está em uso.", id));
		}
	}
}
