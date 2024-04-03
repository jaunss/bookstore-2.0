package com.joaogcm.bookstore.model;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Livro {

	private Long codigo;
	private String titulo;
	private LocalDate anoPublicacao;
	private String isbn;
	private BigDecimal precoUnitario;
	private Integer quantidadeEmEstoque;
	private String genero;
	private Integer edicao;
	private File imagemCapa;
	private Autor autor;
	private Editora editora;
	private Cliente cliente;

	public Livro() {

	}

	public Livro(Long codigo, String titulo, LocalDate anoPublicacao, String isbn, BigDecimal precoUnitario,
			Integer quantidadeEmEstoque, String genero, Integer edicao, File imagemCapa, Autor autor, Editora editora,
			Cliente cliente) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.isbn = isbn;
		this.precoUnitario = precoUnitario;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.genero = genero;
		this.edicao = edicao;
		this.imagemCapa = imagemCapa;
		this.autor = autor;
		this.editora = editora;
		this.cliente = cliente;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(LocalDate anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public File getImagemCapa() {
		return imagemCapa;
	}

	public void setImagemCapa(File imagemCapa) {
		this.imagemCapa = imagemCapa;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}