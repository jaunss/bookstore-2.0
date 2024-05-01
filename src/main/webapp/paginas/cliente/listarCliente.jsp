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

	<div class="text-center">${mensagem}</div>

	<br />

	<table id="listarCliente"
		class="table table-hover table-striped table-bordered table-warning"
		style="width: 100%">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>Telefone</th>
				<th>Atualizar</th>
				<th>Remover</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="cliente" items="${listarClientes}">
				<tr>
					<td><c:out value="${cliente.nome}" /></td>
					<td><c:out value="${cliente.email}" /></td>
					<td><c:out value="${cliente.cidade}" /></td>
					<td><c:out value="${cliente.estado}" /></td>
					<td><c:out value="${cliente.telefone}" /></td>
					<td><a
						href="<%=request.getContextPath()%>/Cliente?acao=atualizarCliente&codigo=${cliente.codigo}">
							<img src="<%=request.getContextPath()%>/icons/pencil.png"></a></td>
					<td><a
						href="<%=request.getContextPath()%>/Cliente?acao=removerCliente&codigo=${cliente.codigo}">
							<img src="<%=request.getContextPath()%>/icons/trash.png"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="<%=request.getContextPath()%>/Cliente?acao=inserirCliente"
		class="btn btn-outline-warning">Inserir Cliente</a>

	<jsp:include
		page="${request.getContextPath()}/paginas/diretorios/scripts-footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
		    $("#listarCliente").DataTable({
		        language: {
		            "search": "Buscar Cliente",
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