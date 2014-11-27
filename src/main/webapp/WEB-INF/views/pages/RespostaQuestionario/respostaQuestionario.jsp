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



  <div class="panel panel-success col-md-10">
    <div class="row">
      <span class="label label-default col-md-12"><h4 class="pull-left" style="color: snow; font-weight:700 ">${formulario.questionario.nome}</h4> </span>
    </div>
    <!-- Coluna das questões -->
    <div class="row">
      <div class="col-md-2">
        <h4 class="list-group-item active">Questões</h4>
        <div class="list-group">
          <c:forEach items="${resposta.questionario.questoes}" var="questao" >
            <a href="#" onclick="show('${questao.id}')" class="list-group-item ">${questao.ordem + 1}</a>
          </c:forEach>
        </div>
      </div>

      <!-- Fim da Coluna das Questões -->

      <!-- Questão com alternativa-->


      <br>
      <div id="questoes" class="col-md-10">

        <c:forEach items="${resposta.respostaQuestoes}" var="questao" varStatus="vs" >

          <div class="panel panel-default questao q${questao.questao.id}">
            <div class="panel-heading"><span class="badge">${questao.questao.ordem + 1}</span>&nbsp${questao.questao.pergunta}</div>
            <ol type="a">
              <c:forEach items="${questao.questao.alternativas}" var="alternativa">
                <c:choose >
                  <c:when test="${questao.questao.alternativaCorreta.equals(alternativa)} ">
                    <div class="radio">
                      <label><input type="radio" name="optradio" checked disabled>${alternativa.exibe()} ok</label>
                    </div>
                  </c:when>
                  <c:when test="${questao.alternativaSelecionada.equals(alternativa)}">
                    <div class="radio">
                      <label><input type="radio" name="optradio" disabled>${alternativa.exibe()} respondeu esta</label>
                    </div>
                  </c:when>
                </c:choose>
              </c:forEach>

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
      </div>
    </div>
  </div>

