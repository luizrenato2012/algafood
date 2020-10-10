package com.algaworks.algafood.jpa.estado;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.infrastructure.repository.EstadoRepositoryImpl;

public class ConsultaEstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		EstadoRepositoryImpl cadastro = applicationContext.getBean(EstadoRepositoryImpl.class);
		List<Estado> Estados = cadastro.listar();
		Estados.stream().forEach(estado -> System.out.println(estado.getNome()));
	}
}
