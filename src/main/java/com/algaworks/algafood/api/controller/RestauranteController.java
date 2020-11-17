package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>> listar() {
		List<Restaurante> restaurantes = restauranteRepository.findAll();
		return ResponseEntity.ok(restaurantes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> busca(@PathVariable Long id ) {
		Optional<Restaurante> optional = restauranteRepository.findById(id);
		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			Restaurante restauranteNovo = cadastroRestaurante.salvar(restaurante);
			return ResponseEntity.ok(restauranteNovo);
		} catch ( EntidadeNaoEncontradaException e ) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restauranteParam) {
		try {
			Optional<Restaurante> optional = restauranteRepository.findById(id);
			if (optional.isPresent()) {
				Restaurante restauranteAtual = optional.get();
				BeanUtils.copyProperties(restauranteParam, restauranteAtual, "id");
				restauranteAtual = this.cadastroRestaurante.salvar(restauranteAtual);
				return ResponseEntity.ok(restauranteAtual);
			}
			return ResponseEntity.notFound().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long id, 
				@RequestBody Map<String,Object> campos){
		Optional<Restaurante> optional = restauranteRepository.findById(id);
		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Restaurante restauranteAtual = optional.get();
		merge(campos, restauranteAtual);
		return atualizar(restauranteAtual.getId(), restauranteAtual);
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteAtual) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		System.out.println(restauranteAtual);
		
		dadosOrigem.forEach((nomePropriedade, valor)-> {
			Field atributo = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			atributo.setAccessible(true);
			Object novoValor = ReflectionUtils.getField(atributo, restauranteOrigem);
			
			ReflectionUtils.setField(atributo, restauranteAtual, novoValor);
		});
	}
 	
	
	
}
