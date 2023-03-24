<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nossos serviços</title>
</head>
<body>

	<h3>Nossos Serviços</h3>

	<br />
	<br />
	<br />

	<ul>
		<c:forEach items="${lista}" var="servico">
			<li>${servico.id} - ${servico.descricao} <a
				href="/projeto_web/servicoAlterar?id=${servico.id}">Alterar</a> 
				<a href="/projeto_web/excluirServico?id=${servico.id}">Excluir</a></li>
		</c:forEach>
	</ul>

</body>
</html>