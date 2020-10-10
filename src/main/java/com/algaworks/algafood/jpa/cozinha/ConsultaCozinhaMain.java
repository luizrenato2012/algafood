package com.algaworks.algafood.jpa.cozinha;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.infrastructure.repository.CozinhaRepositoryImpl;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CozinhaRepositoryImpl cadastro = applicationContext.getBean(CozinhaRepositoryImpl.class);
		List<Cozinha> cozinhas = cadastro.listar();
		cozinhas.stream().forEach(cozinha-> System.out.println(cozinha.getNome()));
	}
}
