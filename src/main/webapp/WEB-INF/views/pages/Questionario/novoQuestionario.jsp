<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>

    function duplicarCampos(campo){
        var clone = document.getElementById(campo).cloneNode(true);
        var destino = document.getElementById(campo);
        destino.appendChild (clone);

        var camposClonados = clone.getElementsByClassName('input');

        for(i=0; i<camposClonados.length;i++){
            camposClonados[i].value = '';
        }



    }

    function removerCampos(campo){
        var node1 = document.getElementById(campo);
        node1.removeChild(node1.childNodes[0]);
    }

</script>

<h2>teste</h2>

<form:form modelAttribute="questionario" action="novo">
    Titulo do Questionario:<form:input path="nome"/>

        <div id ="perguntaAtual">
            Pergunta :<form:input path="questoes[0].pergunta" cssClass="input"/>
                <div class = "novaAlternativa">
                    ordem:<form:input path="questoes[0].alternativas[0].ordem" cssClass="input"/>
                    descricao:<form:input path="questoes[0].alternativas[0].descricao" cssClass="input"/>
                </div>
            <a href="javascript:duplicarCampos('perguntaAtual');">+</a>
            <a href="javascript:removerCampos('novaPergunta');">-</a>
        </div>
        <div id ="novaPergunta">

        </div>

    <button>Adicionar</button>
</form:form>

