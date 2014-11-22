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

    <div class="row ">
        <div class="col-lg-12 list-group">
                ${formulario.questionario.nome}
        </div>
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



        <div id="questoes">

            <c:forEach items="${formulario.questionario.questoes}" var="resposta" varStatus="vs" >

                <form:hidden path="formularioQuestoes[${vs.index}].idRepostaQuestao" value="${resposta.id}" />

                <div class="col-md-8 questao q${resposta.id}">
                    <div class="panel panel-default">

                        <div class="panel-heading"><span class="badge">${resposta.ordem + 1}</span>&nbsp${resposta.pergunta}</div>
                        <ol type="a">
                            <div class="panel-body">
                                <form:radiobuttons path="formularioQuestoes[${vs.index}].idAlternativa" items="${resposta.alternativas}"  itemValue="id" element="li" itemLabel="descricao" itemcssClass="li" />
                            </div>
                        </ol>
                    </div>

                </div>

            </c:forEach>
        </div>
    </div>
    <form:button class="btn btn-default">Enviar</form:button>

</form:form>