package com.joaogcm.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.joaogcm.bookstore.conexao.ConexaoBancoDeDados;
import com.joaogcm.bookstore.model.Cliente;

/**
 * @author joaog
 */
public class ClienteDAO {

	private StringBuilder sqlQuery = new StringBuilder();
	private Connection conexao = null;

	public ClienteDAO() throws Exception {
		conexao = ConexaoBancoDeDados.abrirConexao();
	}

	/**
	 * Insere um cliente que será cadastrado no banco de dados
	 * 
	 * @param cliente
	 */
	public void inserirCliente(Cliente cliente) {
		sqlQuery.setLength(0);
		sqlQuery.append(
				"INSERT INTO cliente c (c.nome, c.cpf, c.email, c.cep, c.logradouro, c.bairro, c.cidade, c.estado, c.telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getEmail());
			preparedStatement.setString(4, cliente.getCep());
			preparedStatement.setString(5, cliente.getLogradouro());
			preparedStatement.setString(6, cliente.getBairro());
			preparedStatement.setString(7, cliente.getCidade());
			preparedStatement.setString(8, cliente.getEstado());
			preparedStatement.setString(9, cliente.getTelefone());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza um cliente pelo código que está cadastrado no banco de dados
	 * 
	 * @param cliente
	 */
	public void atualizarCliente(Cliente cliente) {
		sqlQuery.setLength(0);
		sqlQuery.append(
				"UPDATE cliente c SET c.nome = ?, c.cpf = ?, c.email = ?, c.cep, c.logradouro, c.bairro, c.cidade, c.estado, c.telefone = ? WHERE c.codigo = ?");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getEmail());
			preparedStatement.setString(4, cliente.getCep());
			preparedStatement.setString(5, cliente.getLogradouro());
			preparedStatement.setString(6, cliente.getBairro());
			preparedStatement.setString(7, cliente.getCidade());
			preparedStatement.setString(8, cliente.getEstado());
			preparedStatement.setString(9, cliente.getTelefone());
			preparedStatement.setLong(10, cliente.getCodigo());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove um cliente pelo código que está cadastrado no banco de dados
	 * 
	 * @param cliente
	 */
	public void removerCliente(Cliente cliente) {
		sqlQuery.setLength(0);
		sqlQuery.append("DELETE FROM cliente c WHERE c.codigo = ?");

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString())) {
			preparedStatement.setLong(1, cliente.getCodigo());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna todos os clientes que estão cadastrados no banco de dados
	 * 
	 * @return clientes
	 */
	public Set<Cliente> listarClientes() {
		sqlQuery.setLength(0);
		sqlQuery.append("SELECT * FROM cliente c");

		Set<Cliente> clientes = new HashSet<Cliente>();
		Cliente cliente = new Cliente();

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString());
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				cliente.setCodigo(resultSet.getLong("c.codigo"));
				cliente.setNome(resultSet.getString("c.nome"));
				cliente.setCpf(resultSet.getString("c.cpf"));
				cliente.setEmail(resultSet.getString("c.email"));
				cliente.setCep(resultSet.getString("c.cep"));
				cliente.setLogradouro(resultSet.getString("c.logradouro"));
				cliente.setBairro(resultSet.getString("c.bairro"));
				cliente.setCidade(resultSet.getString("c.cidade"));
				cliente.setEstado(resultSet.getString("c.estado"));
				cliente.setTelefone(resultSet.getString("c.telefone"));

				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	/**
	 * Retorna o cliente pelo código que está cadastrado no banco de dados
	 * 
	 * @return cliente
	 */
	public Cliente listarClientePorCodigo(Cliente cliente) {
		sqlQuery.setLength(0);
		sqlQuery.append("SELECT * FROM cliente c WHERE c.codigo = ?");

		cliente = new Cliente();

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlQuery.toString());
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				cliente.setCodigo(resultSet.getLong("c.codigo"));
				cliente.setNome(resultSet.getString("c.nome"));
				cliente.setCpf(resultSet.getString("c.cpf"));
				cliente.setEmail(resultSet.getString("c.email"));
				cliente.setCep(resultSet.getString("c.cep"));
				cliente.setLogradouro(resultSet.getString("c.logradouro"));
				cliente.setBairro(resultSet.getString("c.bairro"));
				cliente.setCidade(resultSet.getString("c.cidade"));
				cliente.setEstado(resultSet.getString("c.estado"));
				cliente.setTelefone(resultSet.getString("c.telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}
}