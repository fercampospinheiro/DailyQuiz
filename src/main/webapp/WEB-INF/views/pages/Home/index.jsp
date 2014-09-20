<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
</head>
<body>

<h3>Olá, [${sessionScope.get("dadosDaAutenticacao").membro.nome}]!</h3>
    <c:choose>
        <br>
        <c:when test="${sessionScope.get('dadosDaAUtenticacao').diaDeAniversario}">
            <p>
                ${sessionScope.get("dadosDaAutenticacao").membro.nome} parabéns pelos seus
                ${sessionScope.get("dadosDaAutenticacao").membro.idade.years} anos de vida!
            </p>
        </c:when>
        <br>
        <c:when test="${sessionScope.get('dadosDaAUtenticacao').diasParaProximoAniversario.days <= 5 }">
            <p>
                ${sessionScope.get("dadosDaAutenticacao").membro.nome} faltam apenas
                ${sessionScope.get("dadosDaAUtenticacao").diasParaProximoAniversario.days} dias para o seu aniversário.
            </p>
        </c:when>
    </c:choose>

</body>
</html>