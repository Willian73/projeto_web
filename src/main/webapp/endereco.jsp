<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Endereço</title>
</head>
<body>
   <form action="" method="GET">
        <ul>
            <li>
                <label for="tipo_logradouro">Tipo logradouro:</label>
                <input id="tipo_logradouro" name="tipo_logradouro" type="text">
            </li>
            <li>
                <label for="logradouro">Logradouro:</label>
                <input id="logradouro" name="logradouro" type="text">
            </li>
            <li>
                <label for="numero_residencia">Numero residência:</label>
                <input id="numero_residencia" name="numero_residencia" type="text">
            </li>
            <li>
                <label for="complemento">Complemento:</label>
                <input id="complemento" name="complemento" type="text">
            </li>
            <li>
                <label for="cep">CEP:</label>
                <input id="cep" name="cep" type="text">
            </li>
             <li>
                <label for="bairro">Bairro:</label>
                <input id="bairro" name="bairro" type="text">
            </li>
            <li>
                <label for="cidade">Cidade:</label>
                <input id="cidade" name="cidade" type="text">
            </li>
            <li>
                <label for="estado">Estado:</label>
                <input id="estado" name="estado" type="text">
            </li>
            <li>
                <label for="pais">País:</label>
                <input id="pais" name="pais" type="text">
            </li>
         </ul>
        <input type="submit" value="salvar">
    </form>
</body>
</html>