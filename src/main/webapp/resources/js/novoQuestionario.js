
var i = 0;

$(

    $("#adicionaAlternativa").click(function(){


      function geraEstrutura(){
        i = i +1
        $('.alternativas').append(novaAlternativa())
      }

      function novaAlternativa(){

        return $(
            '<div class = "alternativa"+"i">'+

                '<label >'+
                  i +  'ordem:'+'<a href ="javascript:removeAlternativa('+i+');" class = "btn btn-default btn-xs">x</a>'+
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

  )

      function removeAlternativa(numero){

          $('.alternativa'+numero).hide();

            }
