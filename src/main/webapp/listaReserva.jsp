<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${lista}" var="reserva">
			<li>${reserva.id}-${reserva.quarto.nomeAcomodacao}<a
				href="/projeto_web/formServico?id=${reserva.id}">Cadastrar
					Servico</a>
			</li>
		</c:forEach>
	</ul>

	<br />
	<br />

	<a href="/projeto_web/listaServico">Lista de Servicos</a>

</body>
</html>