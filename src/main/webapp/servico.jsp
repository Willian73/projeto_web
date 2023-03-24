<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Serviços</title>
</head>
<body>
    <form action="/projeto_web/cadastraServico?id=${id}" method="post">
        <ul>
            <li>
                <label for="descricao">Descrição:</label>
                <input id="descricao" name="descricao" type="text">
            </li>
            <li>
                <label for="preco">Preço:</label>
                <input id="preco" name="preco" type="text">
            </li>
        </ul>
        <input type="submit" value="salvar">
    </form>
</body>
</html>