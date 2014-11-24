<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
</head>
<body>

<div class="container">
    <!--Area de login do membro -->

    <div id="areaLogin" class="row" >
        <c:set var="dadosAutenticacao" value="${sessionScope.get('dadosDeAutenticacao')}"/>

        <c:choose>
            <c:when test="${dadosAutenticacao.membro.aniversarioHoje eq true}">
                <p>
                        ${dadosAutenticacao.membro.nome} parabéns pelos seus
                        ${dadosAutenticacao.membro.idade.years} anos de vida!
                </p>
            </c:when>
            <c:when test="${dadosAutenticacao.membro.obtemDiasParaProximoAniversario().days <= 5}">
                <p>
                        ${dadosAutenticacao.membro.nome} faltam apenas
                        ${dadosAutenticacao.membro.obtemDiasParaProximoAniversario().days} dias para o seu aniversário.
                </p>
            </c:when>
        </c:choose>
    </div>

    <!--Fim da area de login -->

    <!--Corpo da página -->

    <div id="corpoPagina" class="row" >
        <!--Area do Rankin-->
        <div id="ranking" class="col-md-4">
            <div class="list-group-item">
                <h4 class="list-group-item-heading">Crie seu Questionáio</h4>
                <br>
                <p class="list-group-item-text">Fácil, simples para você criar seu questionário</p>
                <br>
                <button class="btn btn-success btn-lg small">Criar Agora</button>
            </div>
            <br>


            <h4 class="list-group-item " style="background-color: cadetblue ">Ranking Geral</h4>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge pull-left">1</span>
                            &nbsp Antonio
                        </li>
                        <li class="list-group-item">
                            <span class="badge pull-left">2</span>
                            &nbsp Marcos
                        </li>
                        <li class="list-group-item">
                            <span class="badge pull-left">3</span>
                            &nbsp Jose
                        </li>
                    </ul>

        </div>
        <!--Area das opçoes dos questionários-->
        <div id="questionarios" class="col-md-5">
            <h4>Questionários</h4>

            <h4 class="list-group-item active">Respondidos</h4>
            <div class="list-group">
                <a href="#" class="list-group-item">
                    Prova da Fuvest
                </a>
                <a href="#" class="list-group-item">
                    Prova da UFABC
                </a>
            </div>
            <h4 class="list-group-item active">Disponiveis</h4>


            <ul class="list-group">
                <c:forEach items="${questionarios}" var="questionario">
                    <a href="Questionario/${questionario.id}" class="list-group-item">
                            ${questionario.nome}
                        <span class="col-md-offset-1 label label-danger">${questionario.expiraEm()}</span>
                    </a>
                </c:forEach>

            </ul>


        </div>
    </div>
</div>
<!--Fim do corpo da página -->


</div>


</body>
</html>