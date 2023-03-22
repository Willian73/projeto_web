<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acomodação</title>
</head>
<body>
    <form action="/projeto_web/cadastraAcomodacao?id=${idHotel}" method="post">
        <ul>
            <li>
                <label for="nome">Nome:</label>
                <input id="nome" name="nome" type="text">
            </li>
            <li>
                <label for="precoAdulto">Preço por Adulto:</label>
                <input id="precoAdulto" name="precoAdulto" type="text">
            </li>
            <li>
                <label for="precoCrianca">Preço por Criança:</label>
                <input id="precoCrianca" name="precoCrianca" type="text">
            </li>
            <li>
                <label for="tamanho">Tamanho:</label>
                <input id="tamanho" name="tamanho" type="text">
            </li>
        </ul>
        <input type="submit" value="salvar">
    </form>
</body>
</html>