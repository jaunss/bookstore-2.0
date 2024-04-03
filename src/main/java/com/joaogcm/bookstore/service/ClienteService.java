package com.joaogcm.bookstore.service;

import java.util.HashSet;
import java.util.Set;

import com.joaogcm.bookstore.dao.ClienteDAO;
import com.joaogcm.bookstore.model.Cliente;

public class ClienteService {

	private final ClienteDAO clienteDAO;

	public ClienteService(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public void inserirCliente(Cliente cliente) {
		try {
			clienteDAO.inserirCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarCliente(Cliente cliente) {
		try {
			clienteDAO.atualizarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerCliente(Cliente cliente) {
		try {
			clienteDAO.removerCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Cliente> listarClientes() {
		Set<Cliente> clientes = new HashSet<Cliente>();

		try {
			clientes = clienteDAO.listarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clientes;
	}

	public Cliente listarClientePorCodigo(Cliente cliente) {
		try {
			cliente = clienteDAO.listarClientePorCodigo(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}
}