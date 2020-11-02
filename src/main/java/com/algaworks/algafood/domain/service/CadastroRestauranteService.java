package com.algaworks.algafood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long idCozinha = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(idCozinha);
		if (cozinha==null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe cadastro de cozinha com codigo %d", idCozinha));
		}
		restaurante.setCozinha(cozinha);
		return restauranteRepository.salvar(restaurante);
	}

//	@Transactional
//	public Restaurante atualizar(Restaurante restauranteParam) {
//		Long restauranteId = restauranteParam.getId();
//		Restaurante atual = restauranteRepository.busca(restauranteId);
//		if (atual==null) {
//			throw new EntidadeNaoEncontradaException(
//					String.format("Restaurante código %d não cadastrado.", restauranteId));
//		}
//		
//		Long cozinhaId= restauranteParam.getCozinha().getId();
//		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
//		if (cozinha==null) {
//			throw new EntidadeNaoEncontradaException(
//					String.format("Cozinha código %d não cadastrada.", cozinhaId));
//		}
//		atual.setCozinha(cozinha);
//		BeanUtils.copyProperties(restauranteParam, atual, "id", "cozinha");
//		return this.restauranteRepository.salvar(atual);
//	}
	
//	@Transactional
//	public void remover(Long id) {
//		try {
//			restauranteRepository.remove(restaurante);
//		} catch ( )
//	}
}
