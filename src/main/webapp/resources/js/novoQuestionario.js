
var i = 0;

$(

    $("#adicionaAlternativa").click(function(){


      function geraEstrutura(){
        i = i +1
        novaAlternativa();
      }

      function novaAlternativa(){

       var htmlAlternativa = $(".alternativas").html();
    	 var divALternativa = "<div>";
    	 var labelOrdem = "<label>" ;

    	 htmlAlternativa.html(divALternativa).Attr("class","alternativa");
    	 htmlAlternativa.children(".alternativa").html(labelOrdem + labelOrdem);

      }

      geraEstrutura();

      }

        )

  )

      function removeAlternativa(numero){

          $('.alternativa'+numero).hide();


            }
