<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Cadastro de Novo Membro</title>
</head>
<body>
    <form:form modelAttribute="formulario" method="post" action="/CadastraMembro" >
        <form:label path="">Nome :</form:label>
        <form:input path="nome" /><br>
        <form:label path="">E-mail :</form:label>
        <form:input path="email"/><br>
        <form:label path="">Senha :</form:label>
        <form:password path="senha"/><br>
        <form:label path="">Data de Nascimento :</form:label>
        <form:input type="date" path="dataNascimento" /><br>
        <form:button>Cadastrar</form:button>
    </form:form>

    <div class="alert">
        <button type="button" class="close" data-dismiss="alert">×</button>
       <c:if test="${dadosInvalidos.message != ''}">
           <strong>Erro no formulario :</strong> ${dadosInvalidos.message}
       </c:if>
    </div>
</body>
</html>
