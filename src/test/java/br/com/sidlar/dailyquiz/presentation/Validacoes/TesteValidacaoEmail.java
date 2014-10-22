package br.com.sidlar.dailyquiz.presentation.Validacoes;

import br.com.sidlar.dailyquiz.presentation.Excecoes.DadosInvalidosException;
import static org.junit.Assert.*;
import br.com.sidlar.dailyquiz.presentation.Validacoes.ValidaEmail;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.springframework.validation.BindingResult;

public class TesteValidacaoEmail {

    @Test
    public void emailComPontosSequenciaisAntesDoArroba(){
        //Fixture
        try {
            BindingResult resultado = mock(BindingResult.class);
            ValidaEmail email = new ValidaEmail();
        //Exercise
            email.valida("tio..bill@microsoft.com",resultado);

        }catch (DadosInvalidosException e){
        //verify
            fail(e.getMessage());
        }

    }
    @Test
    public void emailComPontosSequenciaisAposArroba(){
        //Fixture
        try {
            BindingResult resultado = mock(BindingResult.class);
            ValidaEmail email = new ValidaEmail();
            //Exercise
            email.valida("tio.bill@microsoft..com", resultado);
        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }

    @Test
    public void emailComAnderlineAntesDoArroba(){
        //Fixture
        try {
            BindingResult resultado = mock(BindingResult.class);
            ValidaEmail email = new ValidaEmail();
            //Exercise
            email.valida("tio_bill@localserver.com",resultado);

        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }

    @Test
    public void emailSemPontoAposArroba(){
        //Fixture
        try {
            BindingResult resultado = mock(BindingResult.class);
            ValidaEmail email = new ValidaEmail();
            //Exercise
            email.valida("tio_bill@localserver",resultado);

        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }


}