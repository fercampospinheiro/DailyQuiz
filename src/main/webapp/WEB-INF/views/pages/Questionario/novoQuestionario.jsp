<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script type="text/javascript">
    var i = 0;




    $(function(){




        $("#adicionaAlternativa").click(function(){


                    function geraEstrutura(){
                        i++;
                        $('.alternativas').append(novaAlternativa())
                    }

                    function novaAlternativa(){

                        $("<div>").html("ashfjkasgjksjk");
                        $("<ul>").html("ashfjkasgjksjk");


                        return $(
                                        '<div class = "alternativa' + i + '">'+

                                        '<label >'+
                                        i +  'ordem:'+'<a class="remove-alternativo" href ="#" onclick="removeAlternativa(' + i + ');" class = "btn btn-default btn-xs">x</a>'+
                                        '</label>'+
                                        '<input path="questoes[0].alternativas['+i+'].ordem" class= "form-control"/>'+

                                        '<label>'+
                                        'descricao:'+
                                        '</label>'+
                                        '<input path="questoes[0].alternativas['+i+'].descricao" class="form-control"/>'+
                                        '</div>'
                        );
                    }

                    geraEstrutura();

                }

        )

    });

    function removeAlternativa(numero){

        $('.alternativa'+numero).hide();

    }

</script>

</head>

<body>

<h2>Novo Questionário</h2>

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