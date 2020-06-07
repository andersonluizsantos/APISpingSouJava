package br.com.dominio.livros.api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dominio.livros.api.dto.LivroDTO;
import br.com.dominio.livros.api.model.Livro;

@Service
public class LivroService {

	public ResponseEntity<List<Livro>> listarLivros() {
		List<Livro> livros = new ArrayList<>();
		Livro l1 = new Livro(1, "Spring Total", LocalDate.of(2020, 5, 15));
		Livro l2 = new Livro(2, "Java total", LocalDate.of(2019, 2, 15));
		Livro l3 = new Livro(3, "Angular total", LocalDate.of(2019, 2, 15));
		livros.add(l1);
		livros.add(l2);
		livros.add(l3);
		return ResponseEntity.ok(livros);
	}

	public ResponseEntity<Livro> buscarLivros(Integer id) {
		Livro l1 = new Livro(1, "Spring Total", LocalDate.of(2020, 5, 15));
		if (id.equals(1)) {
			return ResponseEntity.ok(l1);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	public ResponseEntity<LinkedHashMap<String, Object>> incluirLivros(LivroDTO livroDTO) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		if (livroDTO.getNome().equals("Java Total")) {
			map.put("id", 2);
			map.put("nome", livroDTO.getNome());
			map.put("publicacao", livroDTO.getPublicacao());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
		} else {
			map.put("id", 1);
			map.put("nome", livroDTO.getNome());
			map.put("publicacao", livroDTO.getPublicacao());
			map.put("dataCadastro", LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.CREATED).body(map);
		}
		
	}

	public ResponseEntity<LinkedHashMap<String, Object>> atualizarLivros(Integer id, LivroDTO livroDTO) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		if (id.equals(1)) {
			map.put("id", id);
			map.put("nome", livroDTO.getNome());
			map.put("publicacao", livroDTO.getPublicacao());
			map.put("dataAtualizacao", LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} else {
			map.put("nome", livroDTO.getNome());
			map.put("publicacao", livroDTO.getPublicacao());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
