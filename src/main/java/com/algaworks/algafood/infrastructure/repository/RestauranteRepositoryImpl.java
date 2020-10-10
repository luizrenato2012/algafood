package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Restaurante busca(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Override
	public List<Restaurante> lista() {
		return manager.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}

	@Override
	public void remove(Restaurante restauranteParam) {
		Restaurante restaurante = manager.find(Restaurante.class, restauranteParam.getId());
		manager.remove(restaurante);
		
	}

	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}

}
