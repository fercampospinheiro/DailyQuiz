package br.com.sidlar.dailyquiz.domain.membro;

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
    public void diaEhMesAtualEhOMesmoDoNascimento_FazAniversarioHoje() throws Exception {

        //fixture

        membro.nasceuEm(new LocalDate(1985,01,14));
        membro.setDataAtual(new LocalDate(2015,01,14));
        //exercise

        boolean resultado = membro.fazAniversarioHoje();
        //verify

        assertThat(resultado,is(true));

    }
    @Test
    public void diaAtualEhMesmoDoNascimento_MasMesAtualDiferente_NaoFazAniversarioHoje() throws Exception {

        //fixture

        membro.nasceuEm(new LocalDate(1985,01,14));
        membro.setDataAtual(new LocalDate(2015,02,14));
        //exercise

        boolean resultado = membro.fazAniversarioHoje();
        //verify

        assertThat(resultado,is(false));

    }


    @Test
    public void diaEhMesAtualNaoEhMesmoDoNascimento_NaoFazAniversarioHoje() throws Exception {

        //fixture

        membro.nasceuEm(new LocalDate(1985,01,14));
        membro.setDataAtual(new LocalDate(2015,02,15));
        //exercise

        boolean resultado = membro.fazAniversarioHoje();
        //verify

        assertThat(resultado,is(false));

    }


    @Test
    public void nasceuNoAnoAtual_NaoFazAniversarioHoje() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1995));
        membro.setDataAtual(new LocalDate(1995));

        //exercise

        boolean resultado = membro.fazAniversarioHoje();
        //verify

        assertThat(resultado,is(false));

    }

    @Test
    public void membro_DeveFazerAniversario_Em13Dias_ComDiaAtualInferior() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1985,01,14));
        membro.setDataAtual(new LocalDate(2015,01,01));
        //exercise
        Days dias = membro.obtemDiasParaAniversario();
        //verify
        assertThat(dias.getDays(),is(13));

    }

    @Test
    public void membro_DeveFazerAniversario_Em44Dias_ComMesAtualInferior() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1985,02,14));
        membro.setDataAtual(new LocalDate(2015,01,01));
        //exercise
        Days dias = membro.obtemDiasParaAniversario();
        //verify
        assertThat(dias.getDays(),is(44));

    }

    @Test
    public void membro_DeveFazerAniversario_Em14Dias_ComMesEDiaAtualPosteriores() throws Exception {

        //fixture
        membro.nasceuEm(new LocalDate(1985,01,14));
        membro.setDataAtual(new LocalDate(2015,12,31));
        //exercise

        Days dias = membro.obtemDiasParaAniversario();
        //verify
        assertThat(dias.getDays(),is(14));

    }
}