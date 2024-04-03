<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="hero_area">
	<!-- header section strats -->
	<header class="header_section">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg custom_nav-container">
				<a class="navbar-brand" href="index.html"> <span>
						Bookstore </span>
				</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""> </span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link pl-lg-0"
							href="<%=request.getContextPath()%>/Home?acao=home">Home<span
								class="sr-only">Home</span></a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/Livro?acao=inserirLivro">Livros</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/Autor?acao=inserirAutor">Autores</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/Editora?acao=inserirEditora">Editoras</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/Carrinho?acao=listarCarrinho">Carrinho</a></li>
					</ul>
					<form class="search_form">
						<input type="text" class="form-control" placeholder="Pesquisar...">
						<button value="Pesquisar" class="" type="submit">
							<i class="fa fa-search" aria-hidden="true"></i>
						</button>
					</form>
				</div>
			</nav>
		</div>
	</header>
	<!-- end header section -->
</div>