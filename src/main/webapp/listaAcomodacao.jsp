<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nossas Acomodações</title>
</head>
<body>

	<h3>Nossas Acomodações</h3>

	<br />
	<br />



	<ul>
		<c:forEach items="${lista}" var="quarto">
			<li>${quarto.nomeAcomodacao}-<a href="/projeto_web/formReserva?id=${quarto.id}">Reservar Quarto</a></li>
		</c:forEach>
	</ul>

	<br />
	<br />


	<a href="/projeto_web/formAcomodacao?id=${idHotel}">Cadastrar Nova Acomodação</a> |
	<a href="/projeto_web/listaHotel">Voltar</a>
</body>
</html>