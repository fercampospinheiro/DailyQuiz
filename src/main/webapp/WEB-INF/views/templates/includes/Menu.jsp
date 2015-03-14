<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="dadosAutenticacao" value="${sessionScope.get('dadosDeAutenticacao')}"/>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-default navbar-fixed-top" role="navigation">
    <div class="container">

        <div class="col-md-3">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">DailyQuiz</a>
        </div>

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="../">Home</a></li>
            </ul>
        </div>

        </div>
        <div class="col-md-offset-5 col-md-3 panel-default">
            <div class="panel-body">
                <form method="post" action="../Logout">
                    Olá, ${dadosAutenticacao.membro.nome}!
                    <button class="btn-xs">sair</button>
                </form>
            </div>
        </div>

    </div>
</nav>
