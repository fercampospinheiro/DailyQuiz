<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">

    function show(div) {
      $('.questao').hide();
      $('#' + div).show();
    }
</script>

<form:form commandName="resposta" action="/Questionario/salvar" >

<div class="row "> 
  <div class="col-lg-12 list-group">
    ${resposta.questionario.nome}
  </div>
</div>


<!-- Coluna das questões -->

<div class="row">
<div class="col-md-2">
  <h4 class="list-group-item active">Questões</h4>
    <div class="list-group">
      <c:forEach items="${resposta.questionario.questoes}" var="questao" >
        <a href="#" onclick="show('${questao.id}')" class="list-group-item ">${questao.ordem}</a>
      </c:forEach>
    </div>
</div>

<!-- Fim da Coluna das Questões -->

<!-- Questão com alternativa-->


    <div id="questoes">
      <c:forEach items="${resposta.respostaQuestoes}" var="respostaQuestao" varStatus="vs" >

      <div class="col-md-8 questao" id="questao${respostaQue.stao.questao.id}">
        <div class="panel panel-default">

          <div class="panel-heading">${respostaQuestao.questao.pergunta}</div>
              <div class="panel-body">
                <form:radiobuttons path="respostaQuestoes[${vs.index}].alternativaSelecionada" items="${respostaQuestao.questao.alternativas}"  element="li" itemLabel="descricao" cssClass="li" />
              </div>
          </div>
        </div>

        </c:forEach>
    </div>
</div>
    <form:button class="btn btn-default">Enviar</form:button>

</form:form>