package com.joaogcm.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		sqlQuery.append("INSERT INTO autor (nome, dataNascimento, nacionalidade, biografia) VALUES (?, ?, ?, ?)");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setString(1, autor.getNome());
			preparedStatement.setDate(2, new Date(autor.getDataNascimento().getTime()));
			preparedStatement.setString(3, autor.getNacionalidade());
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
				"UPDATE autor SET nome = ?, dataNascimento = ?, nacionalidade = ?, biografia = ? WHERE codigo = ? ");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setString(1, autor.getNome());
			preparedStatement.setDate(2, new Date(autor.getDataNascimento().getTime()));
			preparedStatement.setString(3, autor.getNacionalidade());
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
		sqlQuery.append("DELETE FROM autor WHERE codigo = ?");

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
	 * @throws ParseException
	 */
	public Set<Autor> listarAutores() throws ParseException {
		sqlQuery.setLength(0);
		sqlQuery.append("SELECT * FROM autor");

		Set<Autor> autores = new HashSet<Autor>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor();

				autor.setCodigo(resultSet.getLong("codigo"));
				autor.setNome(resultSet.getString("nome"));

				autor.setDataNascimento(resultSet.getDate("dataNascimento"));
				autor.setDataNascimentoFormatada(simpleDateFormat.format(autor.getDataNascimento()));

				autor.setNacionalidade(resultSet.getString("nacionalidade"));
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
		sqlQuery.append("SELECT * FROM autor WHERE codigo = ?");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setLong(1, autor.getCodigo());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				autor = new Autor();

				autor.setCodigo(resultSet.getLong("codigo"));
				autor.setNome(resultSet.getString("nome"));
				autor.setDataNascimento(resultSet.getDate("dataNascimento"));
				autor.setNacionalidade(resultSet.getString("nacionalidade"));
				autor.setBiografia(resultSet.getString("biografia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return autor;
	}

	public Set<Autor> listarAutoresPorNome(String nome) {
		sqlQuery.setLength(0);
		sqlQuery.append("SELECT * FROM autor a WHERE UPPER(a.nome) LIKE UPPER('%" + nome + "%')");

		Set<Autor> autores = new HashSet<Autor>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor();

				autor.setCodigo(resultSet.getLong("codigo"));
				autor.setNome(resultSet.getString("nome"));

				autor.setDataNascimento(resultSet.getDate("dataNascimento"));
				autor.setDataNascimentoFormatada(simpleDateFormat.format(autor.getDataNascimento()));

				autor.setNacionalidade(resultSet.getString("nacionalidade"));
				autor.setBiografia(resultSet.getString("biografia"));

				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return autores;
	}
}