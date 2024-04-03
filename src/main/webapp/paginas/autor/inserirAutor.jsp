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
		page="${request.getContextPath()}/paginas/diretorios/content.jsp" />

	<form action="<%=request.getContextPath()%>/Autor">
		<h1>Testando formulário</h1>
	</form>

	<jsp:include
		page="${request.getContextPath()}/paginas/diretorios/footer.jsp" />
	<jsp:include
		page="${request.getContextPath()}/paginas/diretorios/scripts-footer.jsp" />
</body>

</html>