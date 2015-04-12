
var numeroAlternativa = 0;

$(

    $("#adicionaAlternativa").click(function(){


      function geraEstrutura(){
        novaAlternativa(obtemNumeroALternativa());
      }

      function obtemNumeroALternativa(){
        numeroAlternativa = numeroAlternativa + 1;
        return numeroAlternativa;
      }



      function novaAlternativa(numero){

       var novaAlternativa = "alternativa" + numero;
       var classNovaALternativa = ".alternativa" + numero

       var div = $("<div>");
       var label = $("<label>") ;
       var input = $("<input>");

       div.attr({
         class: novaAlternativa
       });
       input.attr({
         type:"text",
         name: novaAlternativa
       });
       

       $(".alternativas").append(div);

       //campo ordem
       $(classNovaALternativa).append(label).text("ordem");
       $(classNovaALternativa).append(input)
       //campo descricao
       $(classNovaALternativa).append(label).text("descricao");
       $(classNovaALternativa).append(input)

      }

      geraEstrutura();

      }

        )

  )

      function removeAlternativa(numero){

          $('.alternativa'+numero).hide();


            }
