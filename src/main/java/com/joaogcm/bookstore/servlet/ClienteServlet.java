package com.joaogcm.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joaogcm.bookstore.dao.ClienteDAO;
import com.joaogcm.bookstore.estabelecer.conexao.EstabelecerConexaoImpl;
import com.joaogcm.bookstore.model.Cliente;
import com.joaogcm.bookstore.service.ClienteService;

@WebServlet(name = "/Cliente", urlPatterns = { "/Cliente" })
public class ClienteServlet extends HttpServlet implements EstabelecerConexaoImpl {

	private static final long serialVersionUID = 1L;

	private Cliente cliente = null;
	private ClienteService clienteService = null;
	private RequestDispatcher requestDispatcher = null;
	private String mensagem = null;

	public ClienteServlet() throws ServletException {
		super();

		estabelecerConexao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			cliente = new Cliente();

			String acao = request.getParameter("acao");

			if (acao.equalsIgnoreCase("inserirCliente")) {
				requestDispatcher = request.getRequestDispatcher("/paginas/cliente/inserirCliente.jsp");
				requestDispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("atualizarCliente")) {
				String codigo = request.getParameter("codigo");
				cliente.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);

				cliente = clienteService.listarClientePorCodigo(cliente);

				if (cliente != null && cliente.getCodigo() != null) {
					requestDispatcher = request.getRequestDispatcher("/paginas/cliente/inserirCliente.jsp");
					request.setAttribute("cliente", cliente);
					requestDispatcher.forward(request, response);
				} else {
					mensagem = "Não foi possível acessar o cadastro do Cliente!";

					requestDispatcher = request.getRequestDispatcher("/paginas/cliente/inserirCliente.jsp");
					request.setAttribute("mensagem", mensagem);
					requestDispatcher.forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("removerCliente")) {
				String codigo = request.getParameter("codigo");
				cliente.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);

				cliente = clienteService.listarClientePorCodigo(cliente);

				if (cliente != null && cliente.getCodigo() != null) {
					clienteService.removerCliente(cliente);

					mensagem = "Cliente removido com sucesso!";
				} else {
					mensagem = "Não foi possível remover o Cliente!";
				}

				requestDispatcher = request.getRequestDispatcher("/paginas/cliente/listarCliente.jsp");
				request.setAttribute("listarClientes", clienteService.listarClientes());
				request.setAttribute("mensagem", mensagem);
				requestDispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("listarClientes")) {
				requestDispatcher = request.getRequestDispatcher("/paginas/cliente/listarCliente.jsp");
				request.setAttribute("listarClientes", clienteService.listarClientes());
				requestDispatcher.forward(request, response);

			}

		} catch (Exception e) {
			requestDispatcher = request.getRequestDispatcher("/paginas/cliente/listarCliente.jsp");
			request.setAttribute("mensagem",
					"Ocorreu um erro inesperado ao tentar acessar uma das páginas do Cliente!");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			cliente = new Cliente();

			String codigo = request.getParameter("codigo");
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String telefone = request.getParameter("telefone");

			cliente.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setEmail(email);
			cliente.setCep(cep);
			cliente.setLogradouro(logradouro);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setTelefone(telefone);

			if (cliente != null && cliente.getCodigo() != null) {
				clienteService.atualizarCliente(cliente);

				mensagem = "Cliente atualizado com sucesso!";
			} else {
				clienteService.inserirCliente(cliente);

				mensagem = "Cliente inserido com sucesso!";
			}

			requestDispatcher = request.getRequestDispatcher("/paginas/cliente/listarCliente.jsp");
			request.setAttribute("listarClientes", clienteService.listarClientes());
			request.setAttribute("mensagem", mensagem);
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			requestDispatcher = request.getRequestDispatcher("/paginas/cliente/listarCliente.jsp");
			request.setAttribute("mensagem", "Ocorreu um erro inesperado ao tentar Atualizar e/ou Inserir o Cliente!");
			requestDispatcher.forward(request, response);
		}
	}

	@Override
	public void estabelecerConexao() throws ServletException {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteService = new ClienteService(clienteDAO);
		} catch (Exception e) {
			throw new ServletException(
					"Ocorreu um problema ao tentar se conectar ao banco de dados: " + e.getMessage());
		}
	}
}