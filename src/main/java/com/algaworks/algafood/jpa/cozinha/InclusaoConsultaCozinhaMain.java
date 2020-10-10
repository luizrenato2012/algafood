package com.algaworks.algafood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.infrastructure.repository.CozinhaRepositoryImpl;

public class InclusaoConsultaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CozinhaRepositoryImpl cadastro = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinha1 = cadastro.salvar(cozinha1);
		cozinha2 = cadastro.salvar(cozinha2);
		System.out.printf("%d - %s" , cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s" , cozinha2.getId(), cozinha2.getNome());
	}
}
