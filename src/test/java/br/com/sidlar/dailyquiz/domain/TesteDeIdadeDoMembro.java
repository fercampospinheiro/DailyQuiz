package br.com.sidlar.dailyquiz.domain;

import org.hamcrest.core.Is;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TesteDeIdadeDoMembro {

    @Test
    public void idadeDoMembroQueNasceuEm1985(){

        //fixture
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(1985,01,14));

        //exercise SUT
        int idadeDoMembro = membro.getIdade().getYears();

        //verify
        assertThat(idadeDoMembro, is(29));

    }
    @Test
    public void idadeDoMembroQueNasceuEsteAno(){

        //fixture
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(2014,01,14));

        //exercise SUT
        int idadeDoMembro = membro.getIdade().getYears();

        //verify
        assertThat(idadeDoMembro, is(0));

    }

}