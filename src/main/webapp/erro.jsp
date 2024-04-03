<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Erro 404 - Página não encontrada</title>
</head>
<body>
	<h1>Erro 404</h1>
	<p>A página que você está procurando não foi encontrada.</p>
	<p>Verifique a URL digitada ou utilize o menu para navegar pela
		aplicação.</p>
	<p>Se o problema persistir, entre em contato com o administrador do
		sistema.</p>
	<p>Código de erro:
		${request.getAttribute("javax.servlet.error.status_code")}</p>
	<p>URL inválida:
		${request.getAttribute("javax.servlet.error.request_uri")}</p>
</body>
</html>