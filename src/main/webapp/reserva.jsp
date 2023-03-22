<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserva</title>
</head>
<body>
    <form action="/projeto_web/reservar?id=${idQuarto}" method="post">
        <ul>
            <li>
                <label for="dataCheckin">Data do Checkin:</label>
                <input id="dataCheckin" name="dataCheckin" type="date">
            </li>
            <li>
                <label for="dataCheckout">Data do Checkout:</label>
                <input id="dataCheckout" name="dataCheckout" type="date">
            </li>
            <li>
                <label for="quantidadeAdulto">Quantidade do Adultos:</label>
                <input id="quantidadeAdulto" name="quantidadeAdulto" type="text">
            </li>
            <li>
                <label for="quantidadeCrianca">Quantidade do Crianças:</label>
                <input id="quantidadeCrianca" name="quantidadeCrianca" type="text">
            </li>
        </ul>
        <input type="submit" value="salvar">
    </form>
</body>
</html>