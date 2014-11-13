package br.com.sidlar.dailyquiz.domain;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TesteObtemDiasParaProximoAniversario {

    private Membro membro;

    @Before
   public void inicializa(){
       membro = new Membro();
   }


    @Test
    public void diasParaProximoAniversario_deveSerQuantidadeDeDiasEntreHojeEhProximaDatadeAniversario(){
        //Fixture
        membro.setDataNascimento(new LocalDate(1985,01,14));
        LocalDate proximoAniversario = new LocalDate(2015,01,14);

        //Exercise
        Days diasRestantes = membro.obtemDiasParaProximoAniversario();
        Days quantidadeDeDias = Days.daysBetween(LocalDate.now(), proximoAniversario );
        //verify
        System.out.println(diasRestantes.getDays());

        assertThat(diasRestantes,is(quantidadeDeDias));
    }

}