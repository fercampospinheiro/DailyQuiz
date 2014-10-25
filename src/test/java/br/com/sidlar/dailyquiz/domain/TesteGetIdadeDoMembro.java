package br.com.sidlar.dailyquiz.domain;

import org.hamcrest.core.Is;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.cglib.core.Local;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TesteGetIdadeDoMembro {

    private Membro membro;

    @Before
   public void inicializa(){
       membro = new Membro();
   }

    @Test
    public void AIdadeDoMembroQueNasceuEm1985_DeveSer29(){
        //fixture
        membro.setDataNascimento(new LocalDate(1985,01,14));
        //exercise SUT
        int idadeDoMembro = membro.getIdade().getYears();
        //verify
        assertThat(idadeDoMembro, is(29));
    }
    @Test
    public void AIdadeDoMembroQueNasceuEsteAnoDeveSerZero(){
        //Fixture
        membro.setDataNascimento(new LocalDate(2014,01,14));
        //exercise SUT
        int idadeDoMembro = membro.getIdade().getYears();
        //verify
        assertThat(idadeDoMembro, is(0));
    }

    @Test
    public void dataDeAniversarioAposDiaCorrenteDeveRetornarZero(){
        //Fixture
        membro.setDataNascimento(LocalDate.now().plusDays(10));
        //exercise SUT
        int idadeDoMembro = membro.getIdade().getYears();
        //verify
        assertThat(idadeDoMembro, is(0));
    }

}