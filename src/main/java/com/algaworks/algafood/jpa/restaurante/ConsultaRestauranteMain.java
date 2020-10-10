package com.algaworks.algafood.jpa.restaurante;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.infrastructure.repository.RestauranteRepositoryImpl;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		RestauranteRepository cadastro = applicationContext.getBean(RestauranteRepository.class);
		List<Restaurante> Restaurantes = cadastro.lista();
		Restaurantes.stream().forEach(Restaurante-> System.out.println(Restaurante.getNome()));
	}
}
