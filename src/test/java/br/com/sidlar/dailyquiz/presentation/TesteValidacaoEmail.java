package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.FormularioMembro;
import br.com.sidlar.dailyquiz.presentation.Excecoes.DadosInvalidosException;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.springframework.validation.BindingResult;

public class TesteValidacaoEmail {

    @Test
    public void bloqueiaEmailComPontosSequenciaisAntesDoArroba(){
        //Fixture
        try {
            BindingResult result = mock(BindingResult.class);
            FormularioMembro formulario = mock(FormularioMembro.class);
            ValidadorFormulario validador = new ValidadorFormulario(result);
        //Exercise
            validador.validaEmail("tio.bill@microsoft..com");

        }catch (DadosInvalidosException e){
        //verify
            fail(e.getMessage());
        }

    }
    @Test
    public void emailComPontosSequenciaisAposArroba(){
        //Fixture
        try {
            BindingResult result = mock(BindingResult.class);
            FormularioMembro formulario = mock(FormularioMembro.class);
            ValidadorFormulario validador = new ValidadorFormulario(result);
            //Exercise
            validador.validaEmail("tio..bill@microsoft.com");

        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }

    @Test
    public void emailComAnderlineAntesDoArroba(){
        //Fixture
        try {
            BindingResult result = mock(BindingResult.class);
            FormularioMembro formulario = mock(FormularioMembro.class);
            ValidadorFormulario validador = new ValidadorFormulario(result);
            //Exercise
            validador.validaEmail("tio_bill@localserver.com");

        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }

    @Test
    public void emailSemPontoAposArroba(){
        //Fixture
        try {
            BindingResult result = mock(BindingResult.class);
            FormularioMembro formulario = mock(FormularioMembro.class);
            ValidadorFormulario validador = new ValidadorFormulario(result);
            //Exercise
            validador.validaEmail("tio_bill@localserver");

        }catch (DadosInvalidosException e){
            //verify
            fail(e.getMessage());
        }

    }


}