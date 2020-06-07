package br.com.dominio.livros.api.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dominio.livros.api.dto.LivroDTO;
import br.com.dominio.livros.api.model.Livro;
import br.com.dominio.livros.api.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Livros")
@RestController
@RequestMapping(path = "livros/api")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@ApiOperation(value="Retorna lista de todos os livros")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Livro>> listarLivros() {
		return livroService.listarLivros();
	}
	
	@ApiOperation(value="Busca livros por id")
	@GetMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Livro> buscarLivros(@PathVariable int id) {
		return livroService.buscarLivros(id);
	}
	
	@ApiOperation(value="Inserção de livros")
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<LinkedHashMap<String, Object>> incluirLivros(@RequestBody LivroDTO livroDTO) {
		return livroService.incluirLivros(livroDTO);
	}
	
	@ApiOperation(value="Atualização de livros")
	@PutMapping(path="/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<LinkedHashMap<String, Object>> atualizarLivros(@RequestBody LivroDTO livroDTO, 
			@PathVariable int id) {
		return livroService.atualizarLivros(id, livroDTO);
	}
	
	@ApiOperation(value="Exclusão de livros por Id")
	@DeleteMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> excluirLivros(@PathVariable int id) {
		return livroService.excluirLivros(id);
	}
	
	@ApiOperation(value="Busca Usando QueryParams")
	@GetMapping(path="/{q}")
	public ResponseEntity<Livro> pesquisarLivroPorId(@RequestParam(value = "id", defaultValue = "0") Integer id) {
		return livroService.buscarLivros(id);
	}
	
}
