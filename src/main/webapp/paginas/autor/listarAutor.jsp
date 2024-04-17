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

	<div class="text-center">${mensagem}</div>

	<br />

	<table id="listarAutor"
		class="table table-hover table-striped table-bordered table-warning"
		style="width: 100%">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Data de Nascimento</th>
				<th>Nacionalidade</th>
				<th>Biografia</th>
				<th>Atualizar</th>
				<th>Remover</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="autor" items="${listarAutores}">
				<tr>
					<td><c:out value="${autor.nome}" /></td>
					<td><c:out value="${autor.dataNascimentoFormatada}" /></td>
					<td><c:out value="${autor.nacionalidade}" /></td>
					<td><c:out value="${autor.biografia}" /></td>
					<td><a
						href="<%=request.getContextPath()%>/Autor?acao=atualizarAutor&codigo=${autor.codigo}"><i
							class="glyphicon glyphicon-pencil"></i></a></td>
					<td><a
						href="<%=request.getContextPath()%>/Autor?acao=removerAutor&codigo=${autor.codigo}"><i
							class="glyphicon glyphicon-trash"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="<%=request.getContextPath()%>/Autor?acao=inserirAutor"
		class="btn btn-outline-warning">Inserir Autor</a>

	<jsp:include
		page="${request.getContextPath()}/paginas/diretorios/scripts-footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
		    $("#listarAutor").DataTable({
		        language: {
		            "search": "Buscar Autor",
		            "entries": "Registros",
		            "info": "Mostrando _START_ até _END_ de _TOTAL_ registros",
		            "infoFiltered": "(filtrados de _MAX_ registros)",
		            "zeroRecords": "Nenhum registro encontrado",
		            "paginate": {
		                "previous": "Anterior",
		                "next": "Próximo"
		            }
		        },
		        lengthMenu: [
		            [5, 10, 25, 50, -1],
		            ["5", "10", "25", "50", "Todos"]
		        ]
		    });
		});
	</script>
</body>

</html>