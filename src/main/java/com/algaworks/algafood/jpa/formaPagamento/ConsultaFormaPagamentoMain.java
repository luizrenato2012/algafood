package com.algaworks.algafood.jpa.formaPagamento;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.infrastructure.repository.FormaPagamentoRepositoryImpl;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		FormaPagamentoRepositoryImpl cadastro = applicationContext.getBean(FormaPagamentoRepositoryImpl.class);
		List<FormaPagamento> FormaPagamentos = cadastro.listar();
		FormaPagamentos.stream().forEach(FormaPagamento -> System.out.println(FormaPagamento.getDescricao()));
	}
}
