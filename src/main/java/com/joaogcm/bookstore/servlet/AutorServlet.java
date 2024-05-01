package com.joaogcm.bookstore.servlet;

import java.io.IOException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joaogcm.bookstore.dao.AutorDAO;
import com.joaogcm.bookstore.estabelecer.conexao.EstabelecerConexaoImpl;
import com.joaogcm.bookstore.model.Autor;
import com.joaogcm.bookstore.service.AutorService;

@WebServlet(name = "/Autor", urlPatterns = { "/Autor" })
public class AutorServlet extends HttpServlet implements EstabelecerConexaoImpl {

	private static final long serialVersionUID = 1L;

	private Autor autor = null;
	private AutorService autorService = null;
	private RequestDispatcher requestDispatcher = null;
	private String mensagem = "";

	public AutorServlet() throws ServletException {
		super();

		estabelecerConexao();
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
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			String codigo = request.getParameter("codigo");
			String nome = request.getParameter("nome");
			String dataNascimento = request.getParameter("dataNascimento");
			String nacionalidade = request.getParameter("nacionalidade");
			String biografia = request.getParameter("biografia");

			nome = removerAcentuacaoCampo(nome);
			nacionalidade = removerAcentuacaoCampo(nacionalidade);
			biografia = removerAcentuacaoCampo(biografia);

			autor.setCodigo(codigo != null && !codigo.isEmpty() ? Long.parseLong(codigo) : null);
			autor.setNome(nome);

			Date dataNascimentoFormatada = simpleDateFormat.parse(dataNascimento);
			java.sql.Date dataNascimentoConvertida = new java.sql.Date(dataNascimentoFormatada.getTime());
			autor.setDataNascimento(dataNascimentoConvertida);

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
		} catch (Exception e) {
			requestDispatcher = request.getRequestDispatcher("/paginas/autor/listarAutor.jsp");
			request.setAttribute("mensagem", "Ocorreu um erro inesperado ao tentar Atualizar e/ou Inserir o Autor!");
			requestDispatcher.forward(request, response);
		}
	}

	@Override
	public void estabelecerConexao() throws ServletException {
		try {
			AutorDAO autorDAO = new AutorDAO();
			autorService = new AutorService(autorDAO);
		} catch (Exception e) {
			throw new ServletException(
					"Ocorreu um problema ao tentar se conectar ao banco de dados: " + e.getMessage());
		}
	}

	private String removerAcentuacaoCampo(String campo) {
		return Normalizer.normalize(campo, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}