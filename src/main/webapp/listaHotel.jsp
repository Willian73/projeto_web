<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nossos Hoteis</title>
</head>
<body>
	<h3>Nossos hoteis</h3>
	<br />
	<br />
	<ul>
		<c:forEach items="${hoteis}" var="hotel">
			<li>${hotel.nome}-<a
				href="/projeto_web/listaAcomodacao?id=${hotel.id}">Ver
					Acomodações</a></li>
		</c:forEach>
	</ul>

	<br />
	<br />

	<a href="/projeto_web/formCadastraHotel">Cadastrar Hotel</a>

</body>
</html>