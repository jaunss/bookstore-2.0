package com.joaogcm.bookstore.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Autor {

	private Long codigo;
	private String nome;
	private Date dataNascimento;
	private String nacionalidade;
	private String biografia;
	private Set<Livro> livros;

	public Autor() {

	}

	public Autor(Long codigo, String nome, Date dataNascimento, String nacionalidade,
			String biografia) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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