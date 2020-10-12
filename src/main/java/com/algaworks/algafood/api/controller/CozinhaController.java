package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository repository;

	@GetMapping
	public List<Cozinha> listar(){
		return repository.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> busca(@PathVariable Long id) {
		Cozinha cozinha = repository.buscar(id);
		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return repository.salvar(cozinha);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
		Cozinha atual = repository.buscar(id);
		if (atual != null) {
			BeanUtils.copyProperties(cozinha, atual, "id");
			repository.salvar(atual);
			return ResponseEntity.ok(atual);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
		try {
			Cozinha cozinha = repository.buscar(id);
			if (cozinha != null) {
				repository.remove(cozinha);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) { // erro de cosntrant no banco
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
