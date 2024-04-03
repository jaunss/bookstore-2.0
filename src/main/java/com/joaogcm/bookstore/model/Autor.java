package com.joaogcm.bookstore.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Autor {

	private Long codigo;
	private String nome;
	private LocalDate dataNascimento;
	private String nascionalidade;
	private String biografia;
	private Set<Livro> livros;

	public Autor() {

	}

	public Autor(Long codigo, String nome, LocalDate dataNascimento, String nascionalidade, String biografia) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nascionalidade = nascionalidade;
		this.biografia = biografia;
		this.livros = new HashSet<Livro>();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNascionalidade() {
		return nascionalidade;
	}

	public void setNascionalidade(String nascionalidade) {
		this.nascionalidade = nascionalidade;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
}