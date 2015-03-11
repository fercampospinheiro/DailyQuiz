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

<form >
    <div class= 'form-group'>
        <label>
            Titulo do Questionario:
        </label>
        <input path="nome" class = 'form-control'/>
    </div>
    <div class= 'form-goup'>
        <label>
            Pergunta :
        </label>
        <input path="questoes[0].pergunta" class= 'form-control'/>
    </div>
    <div class = 'form-group'>
        <div class = "novaAlternativa">
            <label >
                ordem:
            </label>
            <input path="questoes[0].alternativas[0].ordem" class= 'form-control'/>

            <label>
                descricao:
            </label>
            <input path="questoes[0].alternativas[0].descricao" class='form-control'/>
        </div>

        <div id ="novaPergunta">

        </div>
    </div>


    <a href ='#' class = 'btn' id='ok'>Adicionar</a>
</form>

