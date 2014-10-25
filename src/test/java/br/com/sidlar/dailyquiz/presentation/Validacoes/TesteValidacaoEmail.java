package br.com.sidlar.dailyquiz.presentation.Validacoes;

import br.com.sidlar.dailyquiz.presentation.Excecoes.DadosInvalidosException;
import static org.junit.Assert.*;
import br.com.sidlar.dailyquiz.presentation.Validacoes.ValidaEmail;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.springframework.validation.BindingResult;

public class TesteValidacaoEmail {

    private ValidaEmail email;

    @org.junit.Before
    public void inicialiaza(){
        email = new ValidaEmail();
    }


    @Test(expected = DadosInvalidosException.class)
    public void emailComFormatoInvalido_lancaDadosInvalidosException(){
        //Fixture
            BindingResult resultado = mock(BindingResult.class);
        //Exercise
            email.valida("tio..bill@microsoft.com",resultado);
    }


    @Test
    public void oFormatoDoEmailDeveSerValido(){

        try {
            //Fixture
            BindingResult resultado = mock(BindingResult.class);
            //Exercise
            email.valida("tio_bill@localserver",resultado);

        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }


}