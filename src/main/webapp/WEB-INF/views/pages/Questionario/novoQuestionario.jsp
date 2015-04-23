<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<script src="<c:url value="/resources/libs/handleBars/handlebars-v3.0.1.js" />"></script>

    <style>
        .ha {
            border: 2px dotted blue;
        }

        .lista {
            border: 1px solid;
        }

		
		.painel-questao{ 
			border:1px solid blue;
        	border-radius: 10px;
		}

        .questao{
        	margin : 1% 1%;
        }
        .nova-alternativa{
        	margin : 1% 1%;
        }

    </style>

    <script>
        $(function(){
            var source   = $("#entry-template").html();
            var template = Handlebars.compile(source);

            var context = {
                nome: "João",
                enderecos: [
                    {
                        bairro: "baaaa",
                        cidade: "São Paulo"
                    },
                    {
                        bairro: "asdasdas",
                        cidade: "Rio de Janeiro"
                    },
                    {
                        bairro: "ggggg",
                        cidade: "jjajajajajaja"
                    }
                ]
            };
            var html    = template(context);

            $("#aqui").append(html);
        });
    </script>

</head>

<body>

<script id="entry-template" type="text/x-handlebars-template">
    <div class="ha">
        <h1>{{nome}}</h1>
        <ul class="lista">
        {{#each enderecos}}
        <li>{{bairro}}</li>
        <li>{{cidade}}</li>
        {{/each}}
        </ul>
    </div>
</script>

 <form>
    
    
    <div class="questionario col-md-12 ">
    
	    <div class="painel-questao">
		    <div class="questao">
		
		      <h3>Elabore a primeira pergunta</h3>
		
				<div class="pergunta input-group">
					<div class="ordem input-group-addon">1</div>
				  	<label class="sr-only" for="pergunta">pergunta : </label>
				  	<input id="pergunta"  class="form-control" type="text" name="" placeholder="informe a pergunta"/>	     
					<a href="#" class="excluir-pergunta input-group-addon">
				  		<span class="glyphicon glyphicon-trash" ></span>
				  	</a>	     
				</div>
		
				<div class="alternativas col-md-offset-1">
		        	<h3>Elabore a primeira alternativa</h3>
		        	<div class="alternativa input-group">
		          		<div class="ordem input-group-addon">A</div>
		          		<label class="sr-only" for="alternativa" >Alternativa :</label>
		          		<input  id="alternativa" class = "form-control" type = "text" name="" placeholder="informe a alternativa"/>
		            	<a href="#" class="excluir-pergunta input-group-addon">
		        			<span class="glyphicon glyphicon-trash" ></span>		
		        		</a>
		        	</div>
		       		<div class="nova-alternativa">
		       			<a href="#" class="btn btn-default btn-xs">nova Alternativa</a>
		       		</div>
				</div>
				
			</div>
		
		    <div class="nova-questao btn btn-default btn-xs">nova Pergunta</div>
		</div>
	</div>

  </form>

</body>