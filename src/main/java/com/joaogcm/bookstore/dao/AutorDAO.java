package com.joaogcm.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.joaogcm.bookstore.conexao.ConexaoBancoDeDados;
import com.joaogcm.bookstore.model.Autor;

/**
 * @author joaog
 */
public class AutorDAO {

	private StringBuilder sqlQuery = new StringBuilder();
	private Connection conexao = null;

	public AutorDAO() throws Exception {
		conexao = ConexaoBancoDeDados.abrirConexao();
	}

	/**
	 * Insere um autor que será cadastrado no banco de dados
	 * 
	 * @param autor
	 */
	public void inserirAutor(Autor autor) {
		sqlQuery.setLength(0);
		sqlQuery.append(
				"INSERT INTO autor a (a.nome, a.dataNascimento, a.nacionalidade, a.biografia) VALUES (?, ?, ?, ?)");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setString(1, autor.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(autor.getDataNascimento()));
			preparedStatement.setString(3, autor.getNascionalidade());
			preparedStatement.setString(4, autor.getBiografia());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza um autor pelo código que está cadastrado no banco de dados
	 * 
	 * @param autor
	 */
	public void atualizarAutor(Autor autor) {
		sqlQuery.setLength(0);
		sqlQuery.append(
				"UPDATE autor a SET a.nome = ?, a.dataNascimento = ?, a.nacionalidade = :, a.biografia = ? WHERE a.codigo = ? ");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setString(1, autor.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(autor.getDataNascimento()));
			preparedStatement.setString(3, autor.getNascionalidade());
			preparedStatement.setString(4, autor.getBiografia());
			preparedStatement.setLong(5, autor.getCodigo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove um autor pelo código que está cadastrado no banco de dados
	 * 
	 * @param autor
	 */
	public void removerAutor(Autor autor) {
		sqlQuery.setLength(0);
		sqlQuery.append("DELETE FROM autor a WHERE a.codigo = ?");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setLong(1, autor.getCodigo());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna todos os autores que estão cadastrados no banco de dados
	 * 
	 * @return autores
	 */
	public Set<Autor> listarAutores() {
		sqlQuery.setLength(0);
		sqlQuery.append("SELECT * FROM autor a");

		Set<Autor> autores = new HashSet<Autor>();
		Autor autor = new Autor();

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString());
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				autor.setCodigo(resultSet.getLong("a.codigo"));
				autor.setNome(resultSet.getString("a.nome"));
				autor.setDataNascimento(resultSet.getDate("a.dataNascimento").toLocalDate());
				autor.setNascionalidade(resultSet.getString("nacionalidade"));
				autor.setBiografia(resultSet.getString("biografia"));

				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return autores;
	}

	/**
	 * Retorna o autor pelo código que está cadastrado no banco de dados
	 * 
	 * @return autor
	 */
	public Autor listarAutorPorCodigo(Autor autor) {
		sqlQuery.setLength(0);
		sqlQuery.append("SELECT * FROM autor a WHERE a.codigo = ?");

		autor = new Autor();

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString());
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				autor.setCodigo(resultSet.getLong("a.codigo"));
				autor.setNome(resultSet.getString("a.nome"));
				autor.setDataNascimento(resultSet.getDate("a.dataNascimento").toLocalDate());
				autor.setNascionalidade(resultSet.getString("nacionalidade"));
				autor.setBiografia(resultSet.getString("biografia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return autor;
	}
}