package com.joaogcm.bookstore.service;

import java.util.HashSet;
import java.util.Set;

import com.joaogcm.bookstore.dao.AutorDAO;
import com.joaogcm.bookstore.model.Autor;

public class AutorService {

	private final AutorDAO autorDAO;

	public AutorService(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}

	public void inserirAutor(Autor autor) {
		try {
			autorDAO.inserirAutor(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarAutor(Autor autor) {
		try {
			autorDAO.atualizarAutor(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerAutor(Autor autor) {
		try {
			autorDAO.removerAutor(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Autor> listarAutores() {
		Set<Autor> autores = new HashSet<Autor>();

		try {
			autores = autorDAO.listarAutores();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return autores;
	}

	public Autor listarAutorPorCodigo(Autor autor) {
		try {
			autor = autorDAO.listarAutorPorCodigo(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return autor;
	}

	public Set<Autor> listarAutoresPorNome(String nome) {
		Set<Autor> autores = new HashSet<Autor>();

		try {
			autores = autorDAO.listarAutoresPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return autores;
	}
}