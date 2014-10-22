package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Membro;
import static org.hamcrest.core.Is.*;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TesteDeLogicaAutenticacao {

    @Test
    public void autenticacaoDoMembro() {
        //fixture
        AutenticacaoService  autentica = new AutenticacaoService();
        Membro membro = new Membro();

        //exercise
        autentica.autenticaMembro(membro);
        Membro membroAutenticado = autentica.obtemDadosDeAutenticacao().getMembro();
        //verify
        assertThat(membroAutenticado, is(membro));
    }

}