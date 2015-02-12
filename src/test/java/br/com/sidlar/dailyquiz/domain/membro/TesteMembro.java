package br.com.sidlar.dailyquiz.domain.membro;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
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
    public void diaEMesAtualEhOMesmoDoNascimento_deveFazerAniversarioHoje() throws Exception {

        //fixture
        defineHojeComo(14, 1, 2015);
        membro.setDataNascimento(new LocalDate(1985, 1, 14));

        //exercise
        boolean resultado = membro.fazAniversarioHoje();

        //verify
        assertThat(resultado, is(true));

    }

    @Test
    public void diaAtualEhMesmoDoNascimento_MasMesAtualDiferente_NaoFazAniversarioHoje() throws Exception {

        //fixture
        defineHojeComo(14, 2, 2015);
        membro.setDataNascimento(new LocalDate(1985, 1, 14));

        //exercise
        boolean resultado = membro.fazAniversarioHoje();

        //verify
        assertThat(resultado, is(false));

    }

    @Test
    public void diaEhMesAtualNaoEhMesmoDoNascimento_NaoFazAniversarioHoje() throws Exception {

        //fixture
        defineHojeComo(15, 2, 2015);
        membro.setDataNascimento(new LocalDate(1985, 1, 14));

        //exercise
        boolean resultado = membro.fazAniversarioHoje();

        //verify
        assertThat(resultado,is(false));

    }


    @Test
    public void nasceuNoAnoAtual_NaoFazAniversarioHoje() throws Exception {

        //fixture
        defineHojeComo(1, 1, 1995);
        membro.setDataNascimento(new LocalDate(1995, 1, 1));

        //exercise
        boolean resultado = membro.fazAniversarioHoje();

        //verify
        assertThat(resultado,is(false));

    }


    @Test
    public void membro_DeveFazerAniversario_Em13Dias_ComDiaAtualInferior() throws Exception {

        //fixture
        defineHojeComo(1, 1, 2015);
        membro.setDataNascimento(new LocalDate(1985, 1, 14));

        //exercise
        Days dias = membro.obtemDiasParaAniversario();

        //verify
        assertThat(dias.getDays(),is(13));

    }

    @Test
    public void membro_DeveFazerAniversario_Em44Dias_ComMesAtualInferior() throws Exception {

        //fixture
        defineHojeComo(1, 1, 2015);
        membro.setDataNascimento(new LocalDate(1985, 2, 14));

        //exercise
        Days dias = membro.obtemDiasParaAniversario();

        //verify
        assertThat(dias.getDays(),is(44));

    }

    @Test
    public void membro_DeveFazerAniversario_Em14Dias_ComMesEDiaAtualPosteriores() throws Exception {

        //fixture
        defineHojeComo(31, 12, 2015);
        membro.setDataNascimento(new LocalDate(1985,1,14));

        //exercise
        Days dias = membro.obtemDiasParaAniversario();

        //verify
        assertThat(dias.getDays(),is(14));

    }

    private void defineHojeComo(int dia, int mes, int ano) {
        DateTimeUtils.setCurrentMillisFixed(new DateTime(ano, mes, dia, 0, 0, 0).getMillis());
    }

}