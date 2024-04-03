package com.joaogcm.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joaogcm.bookstore.dao.ClienteDAO;
import com.joaogcm.bookstore.model.Cliente;
import com.joaogcm.bookstore.service.ClienteService;

@WebServlet(name = "/Cliente", urlPatterns = { "/Cliente" })
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Cliente cliente = null;
	private ClienteService clienteService = null;

	public ClienteServlet() throws ServletException {
		super();

		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteService = new ClienteService(clienteDAO);
		} catch (Exception e) {
			throw new ServletException(
					"Ocorreu um problema ao tentar se conectar ao banco de dados: " + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			cliente = new Cliente();

		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		} catch (Exception e) {

		}
	}
}