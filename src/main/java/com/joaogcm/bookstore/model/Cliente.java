package com.joaogcm.bookstore.model;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private Long codigo;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String telefone;
	private Set<Livro> livros;
	private Set<Compra> compras;

	public Cliente() {

	}

	public Cliente(Long codigo, String nome, String cpf, String email, String endereco, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.livros = new HashSet<Livro>();
		this.compras = new HashSet<Compra>();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
}