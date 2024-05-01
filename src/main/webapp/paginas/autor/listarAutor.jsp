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
				<th class="text-center">Nome</th>
				<th class="text-center">Data de Nascimento</th>
				<th class="text-center">Nacionalidade</th>
				<th class="text-center">Biografia</th>
				<th class="text-center">Atualizar</th>
				<th class="text-center">Remover</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="autor" items="${listarAutores}">
				<tr>
					<td class="text-center"><c:out value="${autor.nome}" /></td>
					<td class="text-center"><c:out value="${autor.dataNascimento}" /></td>
					<td class="text-center"><c:out value="${autor.nacionalidade}" /></td>
					<td class="text-center"><c:out value="${autor.biografia}" /></td>
					<td class="text-center"><a
						href="<%=request.getContextPath()%>/Autor?acao=atualizarAutor&codigo=${autor.codigo}">
							<img src="<%=request.getContextPath()%>/icons/pencil.png"></a></td>
					<td class="text-center"><a
						href="<%=request.getContextPath()%>/Autor?acao=removerAutor&codigo=${autor.codigo}">
							<img src="<%=request.getContextPath()%>/icons/trash.png"></a></td>
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
		            "lengthMenu": "Mostrando _MENU_ registros por página",
		            "info": "Mostrando _START_ até _END_ (de _TOTAL_ registros)",
		            "infoEmpty": "Mostrando _START_ até _END_ (de _TOTAL_ registros)",
		            "entries": "Registros",
		            "infoFiltered": "(filtrados de _MAX_ registros)",
		            "zeroRecords": "Nenhum registro encontrado!",
		            "emptyTable": "Nenhum registro encontrado!",
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