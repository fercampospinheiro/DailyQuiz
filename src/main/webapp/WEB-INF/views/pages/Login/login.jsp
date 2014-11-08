<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>

    <div class="container" style="margin-top:30px">
        <div class="col-md-offset-3 col-md-4">
        <div class="panel panel-default" >
            <div class="panel-heading">
                <h3 class="panel-title">Login do Dailyquiz </h3>
            </div>

            <div class="panel-body">
                <form method="post" class="form-group">
                    <h4>Informe e-mail e senha</h4>
                    <div class="form-group">
                        <input type="text" class="form-control" name="email" placeholder="email" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password"  class="form-control" name="senha" placeholder="senha" required >
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Entrar</button>
                    </div>
                    <a href = "/CadastraMembro">Não possuo usuário</a>
                </form>
                <br>

            </div>
        </div>
        </div>
    </div>



</body>
</html>