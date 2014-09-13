<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
</head>
<body>

<h3>Olá, [${sessionScope.get("dadosDaAutenticacao").membro.nome}]!</h3>
<h3>[${sessionScope.get("dadosDaAutenticacao").membro.nome}]!,
    parabéns pelos seus ${sessionScope.get("dadosDaAutenticacao").membro.idade}! anos de vida.'</h3>


</body>
</html>