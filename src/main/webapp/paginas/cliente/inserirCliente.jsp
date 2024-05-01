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

	<h2 class="text-center">Clientes</h2>

	<form action="<%=request.getContextPath()%>/Cliente"
		class="needs-validation" novalidate method="POST">
		<div class="container col-md-5">
			<input type="hidden" id="codigo" name="codigo"
				value="<c:out value="${cliente.codigo}"/>">

			<div class="form-group">
				<label for="nome">Nome</label> <input type="text" id="nome"
					name="nome" value="<c:out value="${cliente.nome}"/>"
					class="form-control" maxlength="40" required="required"
					autocomplete="off" />
				<div class="invalid-feedback">Nome é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="cpf">CPF</label> <input type="text" id="cpf" name="cpf"
					value="<c:out value="${cliente.cpf}"/>" class="form-control"
					maxlength="11" required="required" autocomplete="off">
				<div class="invalid-feedback">CPF é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email" id="email"
					name="email" value="<c:out value="${cliente.email}"/>"
					class="form-control" maxlength="40" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Email é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="cep">CEP</label> <input type="text" id="cep" name="cep"
					value="<c:out value="${cliente.cep}"/>" class="form-control"
					maxlength="8" required="required" autocomplete="off">
				<div class="invalid-feedback">CEP é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="logradouro">Logradouro</label> <input type="text"
					id="logradouro" name="logradouro"
					value="<c:out value="${cliente.logradouro}"/>" class="form-control"
					maxlength="100" required="required" autocomplete="off">
				<div class="invalid-feedback">Logradouro é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="bairro">Bairro</label> <input type="text" id="bairro"
					name="bairro" value="<c:out value="${cliente.bairro}"/>"
					class="form-control" maxlength="100" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Bairro é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="cidade">Cidade</label> <input type="text" id="cidade"
					name="cidade" value="<c:out value="${cliente.cidade}"/>"
					class="form-control" maxlength="100" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Cidade é obrigatória!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="estado">Estado</label> <input type="text" id="estado"
					name="estado" value="<c:out value="${cliente.estado}"/>"
					class="form-control" maxlength="100" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Estado é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<div class="form-group">
				<label for="telefone">Telefone</label> <input type="tel"
					id="telefone" name="telefone"
					value="<c:out value="${cliente.telefone}"/>" class="form-control"
					maxlength="40" placeholder="XX XXXXX-XXXX"
					pattern="[0-9]{2} [0-9]{5}-[0-9]{4}" required="required"
					autocomplete="off">
				<div class="invalid-feedback">Telefone é obrigatório!</div>
				<div class="valid-feedback">Ok!</div>
			</div>

			<br />

			<div class="text-center">
				<button type="submit" class="btn btn-outline-warning">Inserir
					Cliente</button>
				<a href="<%=request.getContextPath()%>/Cliente?acao=listarClientes"
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