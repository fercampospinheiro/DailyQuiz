<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Cadastro de Novo Membro</title>
</head>
<body>

    <h2>Informe os seus dados</h2>

    <form:form modelAttribute="formulario" method="post" >
        <label>Nome :</label>
        <form:input path="nome" /><br>
        <form:errors path="ErroNoNome"/>
        <label>E-mail :</label>
        <form:input path="email"/><br>
        <form:errors path="ErroNoEmail"/>
        <label>Senha :</label>
        <form:password path="senha"/><br
        <form:errors path="ErroNaSenha"/>>
        <label>Data de Nascimento :</label>
        <form:input type="date" path="dataNascimento" /><br>
        <form:button>Cadastrar</form:button>
    </form:form>

</body>
</html>
