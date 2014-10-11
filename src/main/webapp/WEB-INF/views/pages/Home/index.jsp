<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
</head>
<body>

<h3>Olá, [${sessionScope.get("dadosDeAutenticacao").membro.nome}]!</h3>
    <br>

    <c:choose>
        <c:when test="${sessionScope.get('dadosDeAUtenticacao').membro.fazAniversarioHoje}">
            <p>
                ${sessionScope.get("dadosDeAutenticacao").membro.nome} parabéns pelos seus
                ${sessionScope.get("dadosDeAutenticacao").membro.idade.years} anos de vida!
            </p>
        </c:when>
        <c:when test="${sessionScope.get('dadosDeAUtenticacao').membro.obtemDiasParaProximoAniversario.days <= 5 }">
            <p>
                ${sessionScope.get("dadosDeAutenticacao").membro.nome} faltam apenas
                ${sessionScope.get("dadosDeAUtenticacao").membro.obtemDiasParaProximoAniversario.days} dias para o seu aniversário.
            </p>
        </c:when>
    </c:choose>

</body>
</html>