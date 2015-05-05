<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<script src="<c:url value="/resources/libs/handleBars/handlebars-v3.0.1.js" />"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

    <style>
        .ha {
            border: 2px dotted blue;
        }

        .lista {
            border: 1px solid;
        }

		
		.painel-questao{ 
			border:1px solid darkgray;
            box-shadow: 3px 1px 3px #696969;

		}

        .questao{
        	margin : 1% 1%;
        }

        .alternativas{
            border-left: 1px lightgrey solid ;
            border-right: 1px lightgrey solid;
            border-bottom: 1px lightgrey solid ;
            border-radius: 0px 0px 8px 8px;
            padding: 0.5% 1%;


        }
        .nova-questao{
            width: 100%;
        }
        .nova-alternativa{
        	margin : 1% 1%;
        }

    </style>

    <script>
        $(function(){

            $(".nova-alternativa").on("click", insereNovaQuestao());
            $(".nova-questao").on("click",insereNovaQuestao());
            $(".nova-questao").trigger("click");


            $( ".lista-alternativas" ).sortable();
            $( ".lista-alternativas" ).disableSelection();
            $(".lista-alternativas").resizable();

        });

        var numeroAlternativa = 0;
        var numeroQuestao = 0;


        function geraNovaAlternativa(){
            var source =  $("#alternativa-template").html();
            var template = Handlebars.compile(source);
            var context = {numero: ++numeroAlternativa};
            return template(context);
        }

        function geraNovaQuestao(){
            var source =  $("#questao-template").html();
            var template = Handlebars.compile(source);
            var context = {numero: ++numeroQuestao};
            return template(context);
        }


        function insereNovaQuestao(){
            var novaQuestao = geraNovaQuestao();
            $(".painel-questao").append(novaQuestao);
        }

        function insereNovaAlternativa(){
            var novaAlternativa = geraNovaAlternativa();
            $(".lista-alternativas").append(novaAlternativa);
        }


    </script>

</head>

<body>

<script id="questao-template" type="text/x-handlebars-template">

    <div class="questao{{numero}}">

        <div class="nova-questao form-group col-md-12">
            <h4>Elabore a primeira pergunta</h4> <a href ="#" class="btn btn-default btn-xs pull-right">nova Pergunta</a>
        </div>

        <div class="pergunta input-group">
            <div class="ordem input-group-addon">1</div>
            <label class="sr-only" for="input-pergunta">pergunta : </label>
            <input id="input-pergunta"  class="form-control" type="text" name="questao{{numero}}" placeholder="informe a pergunta"/>
            <a href="#" class="excluir-pergunta input-group-addon">
                <span class="glyphicon glyphicon-trash" ></span>
            </a>
        </div>

        <div class="alternativas col-md-offset-1">
            <h4>Elabore a primeira alternativa</h4>
            <div class="lista-alternativas ui-widget-content" >


            </div>

            <div class="nova-alternativa">
                <a href="#" class=" btn btn-default btn-xs">nova Alternativa</a>
            </div>
        </div>

    </div>


</script>


<script id="alternativa-template" type="text/x-handlebars-template">
    <div class="alternativa{{numero}} ui-state-default ui-widget-header input-group">
        <div class="ordem input-group-addon"></div>
        <input  id="input-alternativa" class = "form-control" type = "text" name="alternativa{{numero}}" placeholder="informe a alternativa"/>
        <a href="#" class="excluir-pergunta input-group-addon">
            <span class="glyphicon glyphicon-trash" ></span>
        </a>
    </div>
</script>



 <form>
    
    
    <div class="questionario col-md-12 ">
    
	    <div class="painel-questao">


		</div>
	</div>

  </form>

</body>