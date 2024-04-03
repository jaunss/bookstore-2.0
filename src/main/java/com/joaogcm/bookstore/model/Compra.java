package com.joaogcm.bookstore.model;

import java.time.LocalDate;

public class Compra {

	private Long codigo;
	private LocalDate dataCompra;
	private Integer quantidadeLivrosAdquiridos;
	private Cliente cliente;

	public Compra() {

	}

	public Compra(Long codigo, LocalDate dataCompra, Integer quantidadeLivrosAdquiridos, Cliente cliente) {
		this.codigo = codigo;
		this.dataCompra = dataCompra;
		this.quantidadeLivrosAdquiridos = quantidadeLivrosAdquiridos;
		this.cliente = cliente;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getQuantidadeLivrosAdquiridos() {
		return quantidadeLivrosAdquiridos;
	}

	public void setQuantidadeLivrosAdquiridos(Integer quantidadeLivrosAdquiridos) {
		this.quantidadeLivrosAdquiridos = quantidadeLivrosAdquiridos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}