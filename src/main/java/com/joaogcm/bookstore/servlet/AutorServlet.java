package com.joaogcm.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Set;

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
	private RequestDispatcher requestDispatcher = null;
	private String mensagem = "";

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
			autor = new Autor();

			String acao = request.getParameter("acao");

			if (acao.equalsIgnoreCase("inserirAutor")) {
				requestDispatcher = request.getRequestDispatcher("/paginas/autor/inserirAutor.jsp");
				requestDispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("atualizarAutor")) {
				String codigo = request.getParameter("codigo");
				autor.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);

				autor = autorService.listarAutorPorCodigo(autor);

				if (autor != null && autor.getCodigo() != null) {
					requestDispatcher = request.getRequestDispatcher("/paginas/autor/inserirAutor.jsp");
					request.setAttribute("autor", autor);
					requestDispatcher.forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("removerAutor")) {
				String codigo = request.getParameter("codigo");
				autor.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);

				autor = autorService.listarAutorPorCodigo(autor);

				if (autor != null && autor.getCodigo() != null) {
					autorService.removerAutor(autor);

					mensagem = "Autor excluído com sucesso!";
				} else {
					mensagem = "Não foi possível encontrar o Autor!";
				}

				requestDispatcher = request.getRequestDispatcher("/paginas/autor/listarAutor.jsp");
				request.setAttribute("listarAutores", autorService.listarAutores());
				request.setAttribute("mensagem", mensagem);
				requestDispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("listarAutores")) {
				requestDispatcher = request.getRequestDispatcher("/paginas/autor/listarAutor.jsp");
				request.setAttribute("listarAutores", autorService.listarAutores());
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			requestDispatcher = request.getRequestDispatcher("/paginas/autor/listarAutor.jsp");
			request.setAttribute("mensagem", "Ocorreu um erro inesperado ao tentar acessar uma das páginas do Autor!");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			autor = new Autor();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("aaaa/MM/dd");

			String acaoBuscar = request.getParameter("acaoBuscar");

			if (acaoBuscar == null || acaoBuscar.isEmpty()) {
				String codigo = request.getParameter("codigo");
				String nome = request.getParameter("nome");
				String dataNascimento = request.getParameter("dataNascimento");
				String nacionalidade = request.getParameter("nacionalidade");
				String biografia = request.getParameter("biografia");

				autor.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);
				autor.setNome(nome);
				autor.setDataNascimento(
						dataNascimento != null && !dataNascimento.isEmpty() ? simpleDateFormat.parse(dataNascimento)
								: null);
				autor.setNacionalidade(nacionalidade);
				autor.setBiografia(biografia);

				if (autor.getCodigo() != null) {
					autorService.atualizarAutor(autor);

					mensagem = "Autor atualizado com sucesso!";
				} else {
					autorService.inserirAutor(autor);

					mensagem = "Autor inserido com sucesso!";
				}

				requestDispatcher = request.getRequestDispatcher("/paginas/autor/listarAutor.jsp");
				request.setAttribute("listarAutores", autorService.listarAutores());
				request.setAttribute("mensagem", mensagem);
				requestDispatcher.forward(request, response);
			} else if (acaoBuscar != null && acaoBuscar.equalsIgnoreCase("listarAutoresPorNome")) {
				String nomeAutor = request.getParameter("nomeAutor");

				Set<Autor> resultadoBuscaAutores = autorService.listarAutoresPorNome(nomeAutor);
				String resultadosBusca = processSearchResultsForTable(resultadoBuscaAutores);

				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print(resultadosBusca);

				request.setAttribute("resultadoBuscaAutores", resultadoBuscaAutores);
			}
		} catch (Exception e) {
			requestDispatcher = request.getRequestDispatcher("/paginas/autor/listarAutor.jsp");
			request.setAttribute("mensagem", "Ocorreu um erro inesperado ao tentar Atualizar e/ou Inserir o Autor!");
			requestDispatcher.forward(request, response);
		}
	}

	private String processSearchResultsForTable(Set<Autor> autores) {
		StringBuilder sb = new StringBuilder();

		if (autores.isEmpty()) {
			sb.append("<tr><td colspan='6'>Nenhum autor encontrado.</td></tr>");
		} else {
			for (Autor autor : autores) {
				sb.append("<tr>");
				sb.append("<td>" + autor.getNome() + "</td>");
				sb.append("<td>" + autor.getDataNascimentoFormatada() + "</td>");
				sb.append("<td>" + autor.getNacionalidade() + "</td>");
				sb.append("<td>" + autor.getBiografia() + "</td>");
				sb.append("<td><a href='<%=request.getContextPath()%>/Autor?acao=atualizarAutor&codigo="
						+ autor.getCodigo() + "'><i class='glyphicon glyphicon-pencil'></i></a></td>");
				sb.append("<td><a href='<%=request.getContextPath()%>/Autor?acao=removerAutor&codigo="
						+ autor.getCodigo() + "'><i class='glyphicon glyphicon-trash'></i></a></td>");
				sb.append("</tr>");
			}
		}

		return sb.toString();
	}
}