<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<script src="<c:url value="/resources/libs/handleBars/handlebars-v3.0.1.js" />"></script>


<%--<script type="text/javascript">--%>


    <%--var i = 0;--%>



    <%--$(function(){--%>




        <%--$("#adicionaAlternativa").click(function(){--%>
                    <%--function geraEstrutura(){--%>
                        <%--i++;--%>
                        <%--$('.alternativas').append(novaAlternativa())--%>
                    <%--}--%>

                    <%--function novaAlternativa(){--%>

                        <%--$("<div>").html("ashfjkasgjksjk");--%>
                        <%--$("<ul>").html("ashfjkasgjksjk");--%>

<%--//                    <div> <li></li> <li></li> </div>--%>
                        <%--return $(--%>
                                        <%--'<div class = "alternativa' + i + '">'+--%>

                                        <%--'<label >'+--%>
                                        <%--i +  'ordem:'+'<a class="remove-alternativo" href ="#" onclick="removeAlternativa(' + i + ');" class = "btn btn-default btn-xs">x</a>'+--%>
                                        <%--'</label>'+--%>
                                        <%--'<input path="questoes[0].alternativas['+i+'].ordem" class= "form-control"/>'+--%>

                                        <%--'<label>'+--%>
                                        <%--'descricao:'+--%>
                                        <%--'</label>'+--%>
                                        <%--'<input path="questoes[0].alternativas['+i+'].descricao" class="form-control"/>'+--%>
                                        <%--'</div>'--%>
                        <%--);--%>
                    <%--}--%>

                    <%--geraEstrutura();--%>

                <%--}--%>
        <%--);--%>

       <%--var remove =  function removeAlternativa(numero){--%>

            <%--$('.alternativa'+numero).hide();--%>

        <%--}--%>


    <%--});--%>



<%--</script>--%>
<%--<script id="entry-template" type="text/x-handlebars-template">--%>
    <%--<div class="entry{{title}}">--%>
        <%--<h1></h1>--%>
        <%--<div class="body">--%>
            <%--{{body}}--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</script>--%>


    <style>
        .ha {
            border: 2px dotted blue;
        }

        .lista {
            border: 1px solid;
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

<h2>Novo Questionário</h2>

<div id="aqui"></div>

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

</body>