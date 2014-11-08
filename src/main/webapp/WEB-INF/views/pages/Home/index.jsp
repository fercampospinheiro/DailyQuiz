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

        <h3>Olá, [${dadosAutenticacao.membro.nome}]!</h3><br>

        <c:choose>
            <c:when test="${dadosAutenticacao.membro.aniversarioHoje eq true}">
                <p>
                    ${dadosAutenticacao.membro.nome} parabéns pelos seus
                    ${dadosAutenticacao.membro.idade.years} anos de vida!
                </p>
            </c:when>
            <c:when test="${dadosAutenticacao.membro.diasParaProximoAniversario.days <= 5}">
                <p>
                    ${dadosAutenticacao.membro.nome} faltam apenas
                    ${dadosAutenticacao.membro.diasParaProximoAniversario.days} dias para o seu aniversário.
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

               <div class="panel panel-default">
                   <div class="page-header">
                           <h3 class="col-md-offset-2">Ranking Geral</h3>
                   </div>
                   <div class="panel-body">
                       <ul class="list-group">
                           <li class="list-group-item">
                               <span class="badge">1</span>
                               Antonio
                           </li>
                           <li class="list-group-item">
                               <span class="badge">2</span>
                               Marcos
                           </li>
                           <li class="list-group-item">
                               <span class="badge">3</span>
                               Jose
                           </li>
                       </ul>
                   </div>
                </div>
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
                    <a href="#" class="list-group-item">
                        Questao sobre Solid
                        <span class="col-md-offset-1 label label-danger">Expira em : 10 horas</span>
                    </a>
                    <a  href="#" class="list-group-item">
                        Teste de lógica
                        <span class="col-md-offset-1 label label-danger">Expira em : 3 dias</span>
                    </a>
                </ul>

                </div>
            </div>
            <!--Outros dados : descrição do membro, dados estatísticos -->
            <div id="outrosDados" class="col-md-2 panel">
                Aqui outros dados

            </div>
        </div>
    <!--Fim do corpo da página -->


    </div>


    </body>
    </html>