package br.com.dominio.livros.api.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dominio.livros.api.dto.LivroDTO;
import br.com.dominio.livros.api.model.Livro;
import br.com.dominio.livros.api.service.LivroService;

@RestController
@RequestMapping(path = "livros/api")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Livro>> listarLivros() {
		return livroService.listarLivros();
	}
	
	@GetMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Livro> buscarLivros(@PathVariable int id) {
		return livroService.buscarLivros(id);
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<LinkedHashMap<String, Object>> incluirLivros(@RequestBody LivroDTO livroDTO) {
		return livroService.incluirLivros(livroDTO);
	}
	
	@PutMapping(path="/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<LinkedHashMap<String, Object>> atualizarLivros(@RequestBody LivroDTO livroDTO, 
			@PathVariable int id) {
		return livroService.atualizarLivros(id, livroDTO);
	}
	
}
