<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">

    function show(div) {
        $('.questao').hide();
        $('.q' + div).show();
    }
</script>

<c:set var="dadosAutenticacao" value="${sessionScope.get('dadosDeAutenticacao')}"/>


<form:form modelAttribute="formulario" action="salvar" method="POST" >

    <form:hidden path="idRespostaQuestionario" value="${formulario.questionario.id}"/>

    <form:hidden path="idMembro" value="${dadosAutenticacao.membro.id}"/>

    <div class="panel panel-success col-md-10">
     <div class="row">
        <span class="label label-default col-md-12"><h4 class="pull-left" style="color: snow; font-weight:700 ">${formulario.questionario.nome}</h4> </span>
     </div>
    <!-- Coluna das questões -->
    <div class="row">
        <div class="col-md-2">
            <h4 class="list-group-item active">Questões</h4>
            <div class="list-group">
                <c:forEach items="${formulario.questionario.questoes}" var="questao" >
                    <a href="#" onclick="show('${questao.id}')" class="list-group-item ">${questao.ordem + 1}</a>
                </c:forEach>
            </div>
        </div>

        <!-- Fim da Coluna das Questões -->

        <!-- Questão com alternativa-->


        <br>
        <div id="questoes" class="col-md-10">

            <c:forEach items="${formulario.questionario.questoes}" var="questao" varStatus="vs" >

                <form:hidden path="formularioQuestoes[${vs.index}].idRepostaQuestao" value="${questao.id}" />

                <div class="panel panel-default questao q${questao.id}">
                        <div class="panel-heading"><span class="badge">${questao.ordem + 1}</span>&nbsp${questao.pergunta}</div>
                        <ol type="a">
                            <form:radiobuttons path="" items="${questao.alternativas}"  itemValue="id" element="li" itemLabel="descricao"/>
                        </ol>
                </div>

            </c:forEach>
            <ul class="pager">
                <li class="previous disabled"><a href="#">← Anterior</a></li>
                <li class="next"><a href="#">Próxima →</a></li>
            </ul>
            <br>

        </div>
    </div>

    <div class="panel-footer clearfix">
        <div class="pull-right">
            <a href="/" class="btn btn-primary">Voltar</a>&nbsp
            <form:button class="btn btn-default">Finalizar</form:button>
        </div>
    </div>
    </div>

</form:form>