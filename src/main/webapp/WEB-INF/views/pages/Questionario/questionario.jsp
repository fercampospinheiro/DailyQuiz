<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">

    function show(div) {
      $('.questao').hide();
      $('#' + div).show();
    }
</script>

<div class="row ">
  <div class="col-lg-12 list-group">
    ${questionario.nome}
    ${questionario.questoes.size()}
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
<div id="questoes">
  <c:forEach items="${questionario.questoes}" var="questao" >
  <div class="col-md-8 questao" id="${questao.id}">
    <div class="panel panel-default">
      <div class="panel-heading">${questao.pergunta}</div>
      <div class="panel-body">
        <c:forEach items="${questao.alternativas}" var="alternativa" >
        <div class="radio">
          <label><input type="radio" name="questao1">${alternativa.exibe()}</label>
        </div>
        </c:forEach>
      </div>
      </div>
    </div>
  </c:forEach>
</div>

</div>