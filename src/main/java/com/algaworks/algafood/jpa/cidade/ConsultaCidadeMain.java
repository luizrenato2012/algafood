package com.algaworks.algafood.jpa.cidade;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.infrastructure.repository.CidadeRepositoryImpl;

public class ConsultaCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CidadeRepositoryImpl cadastro = applicationContext.getBean(CidadeRepositoryImpl.class);
		List<Cidade> Cidades = cadastro.listar();
		Cidades.stream().forEach(Cidade -> System.out.println(Cidade.getNome()));
	}
}
