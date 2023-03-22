<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contato</title>
</head>
<body>
   <form action="" method="post">
        <ul>
            <li>
                <label for="telefone_principal">Telefone principal:</label>
                <input id="telefone_principal" name="telefone_principal" type="text">
            </li>
            <li>
                <label for="telefone_auxiliar">Telefone auxiliar:</label>
                <input id="telefone_auxiliar" name="telefone_auxiliar" type="text">
            </li>
            <li>
                <label for="email">Email:</label>
                <input id="email" name="email" type="text">
            </li>
            
         </ul>
        <input type="submit" value="salvar">
    </form>
</body>
</html>