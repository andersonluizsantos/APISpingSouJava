package br.com.dominio.livros.api.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LivroDTO {
	private String nome;
	private LocalDate publicacao;
}
