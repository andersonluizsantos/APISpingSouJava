package br.com.dominio.livros.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
