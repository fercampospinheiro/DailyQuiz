
var numeroAlternativa = 0;

$(function(){

    $("#adicionaAlternativa").click(function(){


      function geraEstrutura(){
        novaAlternativa(obtemNumeroALternativa());
      }

      function obtemNumeroALternativa(){
        numeroAlternativa = numeroAlternativa + 1;
        return numeroAlternativa;
      }



      function novaAlternativa(numero){

       var classNovaALternativa = ".alternativa" + numero

       var divAlternativa = $("<div>");
       var labelOrdem = $("<label>ordem</label>") ;
       var inputOrdem = $("<input type:'text'>descrição</input>");

       divAlternativa.addClass("alternativa"+numero);

       input.prop("name","alternativa"+numero);
       

       $(".alternativas").append(divAlternativa);

       //campo ordem
       divAlternativa.append(label).text("ordem");
       divAlternativa.append(input);
       //campo descricao
       divAlternativa.append(label).text("descricao");
       divAlternativa.append(input);

      }

      geraEstrutura();

      });

  });

      function removeAlternativa(numero){

          $('.alternativa'+numero).hide();


            };
