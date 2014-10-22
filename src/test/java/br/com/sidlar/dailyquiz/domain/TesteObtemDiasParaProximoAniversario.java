package br.com.sidlar.dailyquiz.domain;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteObtemDiasParaProximoAniversario {

    @Test
    public void comDataAniversarioAnteriorDataAtual(){

        //Fixture
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(1985,01,14));

        //Exercise
        int diasRestantes = membro.obtemDiasParaProximoAniversario().getDays();

        //verify
        assertEquals(diasRestantes, 88);//  data usada 18/10/201
    }

    @Test
    public void comDataAniversarioPosteriorDataAtual(){

        //Fixture
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(1985,12,14));
        //Exercise
        int diasRestantes = membro.obtemDiasParaProximoAniversario().getDays();
        //verify
        assertEquals(diasRestantes, 57);//  data usada 18/10/2014
    }
}