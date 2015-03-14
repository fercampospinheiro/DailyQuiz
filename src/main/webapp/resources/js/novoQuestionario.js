    $("#ok").click(

            function (){
                var novaAlternativa,atributo,descricaoAtributo;
                atributo = "path";
                descricaoAtributo = "questoes[0].alternativas[0].descricao";

                novaAlternativa =  $(".alternativa").clone();
                novaAlternativa.attr(atributo,descricaoAtributo);
                novaAlternativa.appendTo(".alternativas");
          
            }
    )