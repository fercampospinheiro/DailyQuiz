<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Cadastro de Novo Membro</title>
</head>
<body>
    <form:form modelAttribute="membro" method="post" >
        <form:label path="">Nome :</form:label>
        <form:input path="nome" maxlength="50"  /><br>
        <form:label path="">E-mail :</form:label>
        <form:input path="email"/><br>
        <form:label path="">${emailExistente}</form:label>
        <br>
        <form:label path="">Senha :</form:label>
        <form:password path="senha"/><br>
        <form:label path="">Data de Nascimento :</form:label>
        <form:password path="dataDeNasacimento"/><br>
        <form:button>Cadastrar</form:button>
    </form:form>
</body>
</html>
