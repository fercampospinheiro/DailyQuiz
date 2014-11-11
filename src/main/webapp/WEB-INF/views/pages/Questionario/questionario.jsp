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
    Dados do cliente
  </div>
</div>


<!-- Coluna das questões -->
<div class="row">
<div class="col-md-2">
  <h4 class="list-group-item active">Questões</h4>
    <div class="list-group">
      <a href="#" onclick="show('questao1')" class="list-group-item ">1</a>
      <a href="#" onclick="show('questao2')" class="list-group-item ">2</a>
      <a href="#" onclick="show('questao3')" class="list-group-item">3</a>
    </div>
</div>
<!-- Fim da Coluna das Questões -->

<!-- Questão com alternativa-->
<div id="questoes">
  <div class="col-md-8 questao" id="questao1">
    <div class="panel panel-default">
      <div class="panel-heading">Quem decobriu o Brasil</div>
      <div class="panel-body">
        <div class="radio">
          <label><input type="radio" name="questao1">Pedro Alvares Cabral</label>
        </div>
        <div class="radio">
          <label><input type="radio" name="questao1">José da Fonseca</label>
        </div>
        <div class="radio">
          <label><input type="radio" name="questao1">Marcelo </label>
        </div>
      </div>
      </div>
    </div>
  <div class="col-md-8 questao" id="questao2">
    <div class="panel panel-default">
      <div class="panel-heading">Quanto anos tem o Brasil</div>
      <div class="panel-body">
        <div class="radio">
          <label><input type="radio" name="questao2">500 anos</label>
        </div>
        <div class="radio">
          <label><input type="radio" name="questao2">20 anos</label>
        </div>
        <div class="radio">
          <label><input type="radio" name="questao2">350 anos</label>
        </div>
      </div>
    </div>
  </div>
  <div class="col-md-8 questao" id="questao3">
    <div class="panel panel-default">
      <div class="panel-heading">Qual o antigo nome do Java?</div>
        <div class="panel-body">
          <div class="radio">
            <label><input type="radio" name="questao3">Oak</label>
          </div>
          <div class="radio">
            <label><input type="radio" name="questao3">Sei lá</label>
          </div>
          <div class="radio">
            <label><input type="radio" name="questao4">Nao lembro</label>
          </div>
        </div>
      </div>
    </div>

</div>

</div>