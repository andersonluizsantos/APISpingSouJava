package br.com.dominio.livros.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dominio.livros.api.model.Livro;
import br.com.dominio.livros.api.service.LivroService;

@RestController
@RequestMapping(path = "livros/api")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<Livro> listarLivros() {
		return livroService.listarLivros();
	}
}
