package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	Restaurante busca(Long id);
	List<Restaurante> lista();
	void remove(Restaurante restaurante);
	Restaurante salvar(Restaurante restaurante);

}
