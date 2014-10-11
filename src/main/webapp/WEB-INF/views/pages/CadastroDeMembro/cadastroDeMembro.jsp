<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
   <style type="text/css">
        .erros{
            color : #c9302c;
            font-style: normal;
        }

    </style>
    <title>Cadastro de Novo Membro</title>
</head>
<body>


    <div class="row">
        <d iv class="col-md-6 col-md-offset-2">
            <h2>Informe os seus dados</h2>
            <form:form modelAttribute="formulario" method="post" >
                <div class="input-group">
                    <span class="input-group-addon glyphicon glyphicon-user"></span>
                    <form:input path="nome" cssClass="form-control" placeholder="Nome"/>
                </div>
                <form:errors path="nome"  cssClass="erros"/>

                <br>
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <form:input path="email" cssClass="form-control" placeholder="E-Mail"/>
                </div>
                <form:errors path="email" cssClass="erros"/>

                <br>
                <div class="input-group">
                    <span class="input-group-addon glyphicon glyphicon-lock"></span>
                    <form:input type="password" path="senha"  cssClass="form-control" placeholder="Senha"/>
                </div>
                <form:errors path="senha" cssClass="erros"/><br>

                <label>Data de Nascimento :</label>
                <div class="input-group">
                    <span class="input-group-addon glyphicon glyphicon-calendar"></span>
                    <form:input type ="date" path="dataNascimento"  cssClass="form-control"/>
                </div>
                <br>
                <form:button class="btn btn-default">Cadastrar</form:button>
            </form:form>
        </div>
    </div>
    </body>
</body>
</html>
