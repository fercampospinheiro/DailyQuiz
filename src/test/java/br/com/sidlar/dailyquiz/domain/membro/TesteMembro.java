package br.com.sidlar.dailyquiz.domain.membro;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.joda.time.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TesteMembro {

    private Membro membro;

    @Before
    public void inicializa(){
        membro = new Membro();
    }


    @Test
    public void membroNasceuNoDiaEstipulado_DeveFazerAniversario() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1985,01,14));

        LocalDate diaEstipulado = new LocalDate(2015,01,14);
        //exercise

        boolean resultado = membro.fazAniversarioHoje(diaEstipulado);
        //verify

        assertThat(resultado,is(true));

    }

    @Test
    public void membroNasceuNoDiaEstipulado_ComMesDiferente_NaoDeveFazerAniversario() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(000,01,02));

        LocalDate diaEstipulado = new LocalDate(000,01,04);
        //exercise

        boolean resultado = membro.fazAniversarioHoje(diaEstipulado);
        //verify

        assertThat(resultado,is(false));

    }
    @Test
    public void membroNasceuNoMesmoAnoEstipulado_NaoDeveFazerAniversario() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1995));

        LocalDate anoEstipulado = new LocalDate(1995);
        //exercise

        boolean resultado = membro.fazAniversarioHoje(anoEstipulado);
        //verify

        assertThat(resultado,is(false));

    }

    @Test
    public void membro_DeveFazerAniversario_Em365Dias() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1985,01,14));

        //exercise
        LocalDate proximoAniversario = new LocalDate(2016,01,14);

        Days dias = membro.faraAniversarioEm(proximoAniversario);
        //verify
        assertThat(dias.getDays(),is(365));

    }
}