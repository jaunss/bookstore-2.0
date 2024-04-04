<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-warning">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-center"
			id="navbarSupportedContent">
			<ul class="nav nav-underline mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link text-white"
					href="<%=request.getContextPath()%>/inicio.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="<%=request.getContextPath()%>/paginas/autor/inserirAutor.jsp">Autores</a></li>
				<li class="nav-item"><a class="nav-link text-white" href="#">Editoras</a></li>
				<li class="nav-item"><a class="nav-link text-white" href="#">Livros</a></li>
				<li class="nav-item"><a class="nav-link text-white" href="#">Compras</a></li>
			</ul>
			<form class="d-flex ms-auto" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-light" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>