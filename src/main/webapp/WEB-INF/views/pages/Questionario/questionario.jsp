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

<form:form commandName="formulario" action="/Questionario/salvar" >

  <form:hidden path="idQuestionario" value="${questionario.id}"/>

<div class="row "> 
  <div class="col-lg-12 list-group">
    ${questionario.nome}
  </div>
</div>


<!-- Coluna das questões -->

<div class="row">
<div class="col-md-2">
  <h4 class="list-group-item active">Questões</h4>
    <div class="list-group">
      <c:forEach items="${questionario.questoes}" var="questao" >
        <a href="#" onclick="show('${questao.id}')" class="list-group-item ">${questao.ordem}</a>
      </c:forEach>
    </div>
</div>

<!-- Fim da Coluna das Questões -->

<!-- Questão com alternativa-->
  <c:forEach items="${formulario.formularioQuestoes}" varStatus="vs">

    ${vs.index}
  <div id="questoes">
  <c:forEach items="${questionario.questoes}" var="questao" >

  <div class="col-md-8 questao" id="questao${questao.id}">
    <div class="panel panel-default">

      <form:hidden path="formularioQuestoes[${vs.index}].idQuestao" value="${questao.id}"/>

      <div class="panel-heading">${questao.pergunta}</div>
      <div class="panel-body">
        <c:forEach items="${questao.alternativas}" var="alternativa" >
        <div class="radio">
          <label><form:radiobutton path="formularioQuestoes[${vs.index}].idAlternativa" value="${questao.id}"/>${alternativa.exibe()}
        </div>
        </c:forEach>
      </div>
      </div>
    </div>

  </c:forEach>


</div>
  </c:forEach>
</div>
  <form:button class="btn btn-default">Enviar</form:button>

</form:form>