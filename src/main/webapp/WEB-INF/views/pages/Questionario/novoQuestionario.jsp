<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h2>teste</h2>

<div class='col-xs-4'>
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

            <div class='alternativas'>

            </div>

            <br>
            <a href ='#' class = 'btn btn-default btn-xs' id='adicionaAlternativa'>+</a>
            </br>

        </div>

    </form>
</div>


