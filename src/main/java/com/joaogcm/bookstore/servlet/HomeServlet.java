package com.joaogcm.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/Home", urlPatterns = { "/Home" })
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String acao = request.getParameter("acao");

			if (acao.equalsIgnoreCase("home")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/inicio.jsp");
				requestDispatcher.forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/erro.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}