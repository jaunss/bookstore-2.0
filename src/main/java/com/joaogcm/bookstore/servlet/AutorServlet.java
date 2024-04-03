package com.joaogcm.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joaogcm.bookstore.dao.AutorDAO;
import com.joaogcm.bookstore.model.Autor;
import com.joaogcm.bookstore.service.AutorService;

@WebServlet(name = "/Autor", urlPatterns = { "/Autor" })
public class AutorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Autor autor = null;
	private AutorService autorService = null;

	public AutorServlet() throws ServletException {
		super();

		try {
			AutorDAO autorDAO = new AutorDAO();
			autorService = new AutorService(autorDAO);
		} catch (Exception e) {
			throw new ServletException(
					"Ocorreu um problema ao tentar se conectar ao banco de dados: " + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String acao = request.getParameter("acao");

			if (acao.equalsIgnoreCase("inserirAutor")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/paginas/autor/inserirAutor.jsp");
				requestDispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("atualizarAutor")) {

			} else if (acao.equalsIgnoreCase("removerAutor")) {

			} else if (acao.equalsIgnoreCase("listarAutores")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
				request.setAttribute("listarAutores", autorService.listarAutores());
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}