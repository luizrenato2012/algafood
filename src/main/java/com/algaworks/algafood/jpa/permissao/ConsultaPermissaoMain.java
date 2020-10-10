package com.algaworks.algafood.jpa.permissao;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.infrastructure.repository.PermissaoRepositoryImpl;

public class ConsultaPermissaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		PermissaoRepositoryImpl cadastro = applicationContext.getBean(PermissaoRepositoryImpl.class);
		List<Permissao> Permissaos = cadastro.listar();
		Permissaos.stream().forEach(Permissao -> System.out.println(Permissao.getNome()));
	}
}
