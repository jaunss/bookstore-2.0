<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<jsp:include
	page="${request.getContextPath()}/paginas/diretorios/header.jsp" />
</head>

<body>
	<jsp:include
		page="${request.getContextPath()}/paginas/diretorios/content.jsp"></jsp:include>

	<h2 class="text-center">Autores</h2>
	<form action="<%=request.getContextPath()%>/Autor"
		class="needs-validation" novalidate method="POST">
		<div class="container col-md-5">
			<input type="hidden" id="codigo" name="codigo"
				value="<c:out value="${autor.codigo}"/>">

			<div class="form-group">
				<label for="nome">Nome</label> <input type="text" id="nome"
					name="nome" value="<c:out value="${autor.nome}"/>"
					class="form-control" maxlength="40" required="required"
					autocomplete="off" />
				<div class="invalid-feedback">Nome é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="dataNascimento">Data de Nascimento</label> <input
					type="date" id="dataNascimento" name="dataNascimento"
					value="<c:out value="${autor.dataNascimento}"/>"
					class="form-control" pattern="yyyy-MM-dd" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Data de Nascimento é
					obrigatória!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="nacionalidade">Nacionalidade</label> <input type="text"
					id="nacionalidade" name="nacionalidade"
					value="<c:out value="${autor.nacionalidade}"/>"
					class="form-control" maxlength="40" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Nacionalidade é obrigatória!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="biografia">Biografia</label>
				<textarea rows="10" cols="10" id="biografia" name="biografia"
					value="<c:out value="${autor.biografia}"/>" class="form-control"
					maxlength="500" autocomplete="off"></textarea>
			</div>

			<br />

			<div class="text-center">
				<button type="submit" class="btn btn-outline-warning">Inserir
					Autor</button>
				<a href="<%=request.getContextPath()%>/Autor?acao=listarAutores"
					class="btn btn-outline-info">Voltar</a>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		(function() {
			'use strict'

			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.querySelectorAll('.needs-validation')

			// Loop over them and prevent submission
			Array.prototype.slice.call(forms).forEach(function(form) {
				form.addEventListener('submit', function(event) {
					if (!form.checkValidity()) {
						event.preventDefault()
						event.stopPropagation()
					}

					form.classList.add('was-validated')
				}, false)
			})
		})()
	</script>

	<jsp:include
		page="${request.getContextPath()}/paginas/diretorios/scripts-footer.jsp" />
</body>

</html>