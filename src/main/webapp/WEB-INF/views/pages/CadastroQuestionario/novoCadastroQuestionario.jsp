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

		.questionario{
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

            insereNovaQuestao({exibeBotao: true});
            insereNovaAlternativa(document);

            $(".botao-nova-questao").on("click", function(){
				var self = this;
                insereNovaQuestao({exibeBotao: false}, self);
                $(".lista-alternativas").sortable();
                $(".lista-alternativas").disableSelection();
            });

            $(".painel-questao").on("click",".nova-alternativa", function(){
                var self = this;
                insereNovaAlternativa(self);
            });

            $(".painel-questao").on("click",".exclui-alternativa",function(){
                var self = this;
                excluiAlternativa(self);
            });

            $(".painel-questao").on("click",".exclui-questao",function(){
                var self = this;
                excluiQuestao(self)
            });


            $(".painel-questao").on("keydown",".input-pergunta", function () {
                var self = this;
                ocultaOrientacaoQuestao(self);
            })


            $(".painel-questao").sortable({
                stop: function( event, ui ) {
                    moveBotaoNovaPerguntaParaUltimaQuestao(event);
                }
            }).disableSelection();

            $(".lista-alternativas").sortable().disableSelection();

        });

        var numeroAlternativa = 0;
        var numeroQuestao = 0;

        function insereNovaQuestao(conf,context){
            var $novaQuestao = $(geraNovaQuestao(conf));
            $(".painel-questao").append($novaQuestao);
            moveBotaoNovaPerguntaParaUltimaQuestao();
            preparaAtributoNameQuestao($novaQuestao);
        }

        function geraNovaQuestao(conf){
            var source =  $("#questao-template").html();
            var template = Handlebars.compile(source);
            var context = {numero: ++numeroQuestao, exibeBotao: conf.exibeBotao};

            return template(context);
        }

        function insereNovaAlternativa(context){
            var $novaAlternativa = $(geraNovaAlternativa());
            $listaAlternativas =  $(context).closest(".alternativas").find(".lista-alternativas");
            $listaAlternativas.append($novaAlternativa);
            preparaAtributoNameAlternativa($novaAlternativa)
        }

        function geraNovaAlternativa(){
            var source = $("#alternativa-template").html();
            var template = Handlebars.compile(source);
            var context = {numero: ++numeroAlternativa};
            return template(context);
        }

        function excluiAlternativa(context){
            $(context).parent(".alternativa").hide("slow",function(){
               $(this).remove();
            });
        }

        function excluiQuestao(context){
            $(context).closest(".questao").hide("slow",function(){
                $(this).remove();
            });


        }

        function moveBotaoNovaPerguntaParaUltimaQuestao() {
            var $botaoNovaQuestao = $(".botao-nova-questao");
            $(".painel-questao .questao:last-child .nova-questao").prepend($botaoNovaQuestao);
        }

        function ocultaOrientacaoQuestao(context){
            $(context).closest(".questao").find(".nova-questao h4").hide();
        }

		function preparaAtributoNameQuestao($novaQuestao){
			geraNamePerguntaQuestao($novaQuestao);
			geraNameOrdemQuestao($novaQuestao);
		}

		function geraNamePerguntaQuestao($novaQuestao){
			var inputPergunta = $novaQuestao.find(".input-pergunta");

			var indice = $(".pergunta").length;		
			inputPergunta.prop("name","formulariosCadastroQuestao["+ indice + "].pergunta");
		}

		function geraNameOrdemQuestao($novaQuestao){
			var inputOrdem = $novaQuestao.find(".input-pergunta");

			var indice = $(".ordem-questao").length;
			inputOrdem.attr("name","formulariosCadastroQuestao["+ indice + "].ordem");
			
		}

        function preparaAtributoNameAlternativa($novaAlternativa){
            geraNameOrdemAlternativa($novaAlternativa);
            geraNameDescricaoAlternativa($novaAlternativa);
        }

        function geraNameOrdemAlternativa($novaAlternativa){
            var inputOrdem = $novaAlternativa.find(".input-alternativa");

            var indiceQuestao = $(".pergunta").length;
            var indiceAlternativa = $(".input-ordem-alternativa").length;
            inputOrdem.prop("name","formulariosCadastroQuestao["+ indiceQuestao + "].formulariosCadastroAlternativa["+ indiceAlternativa + "].descricao");
        }

        function geraNameDescricaoAlternativa($novaAlternativa){
            var inputDescricao = $novaAlternativa.find(".input-alternativa");

            var indiceQuestao = $(".pergunta").length;
            var indiceAlternativa = $(".input-alternativa").length;
            inputDescricao.prop("name","formulariosCadastroQuestao["+ indiceQuestao + "].formulariosCadastroAlternativa["+ indiceAlternativa + "].descricao");

        }

        
    </script>

</head>

<body>
<!-- Template de questoes -->
<script id="questao-template" type="text/x-handlebars-template">

    <div class="questao ui-state-default">

        <div class="nova-questao form-group col-md-12">
            <h4>Elabore a primeira pergunta</h4>
            {{#if exibeBotao}}
            <a href ='javascript:void(0)' class='botao-nova-questao btn btn-default btn-xs pull-right'>nova Pergunta</a>
            {{/if}}
        </div>

        <div class="pergunta input-group">
            <!-- Ordem da questao-->
			<input type="hidden" class="ordem-questao" />
            
			<!-- Pergunta da questão-->
			<label class="sr-only" for="input-pergunta">pergunta : </label>
            <input id="input-pergunta"  class="input-pergunta form-control" type="text" placeholder="informe a pergunta"/>
            
			<a href="javascript:void(0)" class=" input-group-addon">
                <span class="exclui-questao glyphicon glyphicon-trash" ></span>
            </a>
        </div>

		<!-- Alternativas da questão -->
        <div class="alternativas col-md-offset-1">
            <h4>Elabore a primeira alternativa</h4>
            <div class="lista-alternativas ui-sortable" >

            </div>

            <div class="nova-alternativa">
                <a href="javascript:void(0)" class="botao-alternativa btn btn-default btn-xs">nova Alternativa</a>
            </div>
        </div>

    </div>


</script>


<script id="alternativa-template" type="text/x-handlebars-template">
    <div class="alternativa ui-state-default input-group">
        <div class="ordem input-group-addon">
            <input type="hidden" class="input-ordem-alternativa" value="">

        </div>
            <input  id="input-alternativa" class= "form-control input-alternativa" name="formulariosCadastroAlternativa[0].descricao" placeholder="informe a alternativa"/>
            <a href="#" class="exclui-alternativa input-group-addon">
            <span class="glyphicon glyphicon-trash" ></span>
        </a>
    </div>
</script>



 <form action="" method="post">
    
    
    <div class="questionario col-md-12 ">
		<!-- Nome do questionario -->
        <div class="nome-questionario col-md-12">
            <label for="input-nome" class="label-nome sr-only">Nome do Questionário : </label>
            <input name="nome" id ="input-pergunta" class="input-pergunta form-control" placeholder="informe o nome "></input>
        </div>
		<!-- Questoes -->
	    <div class="painel-questao ui-sortable">


		</div>
        <div class="form-group col-md-12">
            <button class="btn btn-success pull-right">Salvar</button>
        </div>
	</div>

 </form>

</body>