package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StandardCompetitionRankingTest {

    private Membro membro ;
    private StandardCompetitionRanking2 classificador;

    @Before
    public void inicializa(){
        membro = new Membro();
        classificador = new StandardCompetitionRanking2();
    }


    @Test
    public void posicoesDesordenadas_devemSerOrdenadasDecrescentemente() throws Exception {

        // setup fixture

        List<Posicao> posicoesDesordenadas =
                Lists.newArrayList(
                        new Posicao(10, criaMembro("José")),
                        new Posicao(5, criaMembro("Maria")),
                        new Posicao(8, criaMembro("Moises")),
                        new Posicao(1, criaMembro("Cobra")),
                        new Posicao(2, criaMembro("Andre"))
                );

        // execute SUT
        classificador.setPosicoes(posicoesDesordenadas);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        // verify outcome
        assertThat(posicoesComOrdemEsperada, contains(
                new Posicao(10, criaMembro("José")),
                new Posicao(8, criaMembro("Moises")),
                new Posicao(5, criaMembro("Maria")),
                new Posicao(2, criaMembro("Andre")),
                new Posicao(1, criaMembro("Cobra"))
        ));

    }

    @Test
    public void posicoesComPotuacaoIgual_devemSerOrdenadasComMesmaOrdem() throws Exception {

        //setup fixture

        List<Posicao> posicoesComPontuacaoIgual =
                Lists.newArrayList(
                new Posicao(20,criaMembro("Fernando")),
               new Posicao(20,criaMembro("Antonio")),
                new Posicao(20,criaMembro("Andre")),
                new Posicao(20,criaMembro("Paulo"))
        );

        //execute SUT
        classificador.setPosicoes(posicoesComPontuacaoIgual);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        //verify

        assertThat(posicoesComOrdemEsperada.get(0).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(2).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(3).getOrdem(),is(1));

    }

    @Test
    public void posicoesComPotuacaoIgualComGap_devemSerOrdenadasComMesmaOrdem() throws Exception {

        //setup fixture

        List<Posicao> posicoesComPontuacaoIgual =
                Lists.newArrayList(
                        new Posicao(20,criaMembro("Fernando")),
                        new Posicao(20,criaMembro("Antonio")),
                        new Posicao(20,criaMembro("Andre")),
                        new Posicao(19,criaMembro("Andre")),
                        new Posicao(18,criaMembro("Andre")),
                        new Posicao(18,criaMembro("Paulo")),
                        new Posicao(18,criaMembro("Paulo"))
                );

        //execute SUT

        classificador.setPosicoes(posicoesComPontuacaoIgual);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        //verify

        assertThat(posicoesComOrdemEsperada.get(0).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(2).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(3).getOrdem(),is(4));
        assertThat(posicoesComOrdemEsperada.get(4).getOrdem(),is(5));
        assertThat(posicoesComOrdemEsperada.get(5).getOrdem(),is(5));
        assertThat(posicoesComOrdemEsperada.get(6).getOrdem(),is(5));

    }

    @Test
    public void posicoesOrdenadas_devemSerOrdenadasRespeitandoUnicoGap() throws Exception {

        //Setup fixture
        List<Posicao> posicoesIguaisESequenciaNaoIguais =
                Lists.newArrayList(
                    new Posicao(20,criaMembro("Fernando")),
                    new Posicao(20,criaMembro("Marcio")),
                    new Posicao(19,criaMembro("Gerson"))

                );
        //execute SUT
        classificador.setPosicoes(posicoesIguaisESequenciaNaoIguais);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        //verify
        assertThat(posicoesComOrdemEsperada.get(0).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(2).getOrdem(),is(3));

    }

    @Test
    public void posicoesOrdenadas_devemSerOrdenadasRespeitandoMaisDeUmGap() throws Exception {

        //Setup fixture
        List<Posicao> posicoesIguaisESequenciaNaoIguais =
                Lists.newArrayList(
                        new Posicao(20,criaMembro("Fernando")),
                        new Posicao(20,criaMembro("Marcio")),
                        new Posicao(19,criaMembro("Gerson")),
                        new Posicao(18,criaMembro("Andre")),
                        new Posicao(18,criaMembro("João")),
                        new Posicao(17,criaMembro("Paulo"))

                );
        //execute SUT
        classificador.setPosicoes(posicoesIguaisESequenciaNaoIguais);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        //verify
        assertThat(posicoesComOrdemEsperada.get(0).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(2).getOrdem(),is(3));
        assertThat(posicoesComOrdemEsperada.get(3).getOrdem(),is(4));
        assertThat(posicoesComOrdemEsperada.get(4).getOrdem(),is(4));
        assertThat(posicoesComOrdemEsperada.get(5).getOrdem(),is(6));

    }

    @Test
    public void posicoesDesordenadas_devemSerOrdenadasRespeitandoUnicoGap() throws Exception {

        //Setup fixture
        List<Posicao> posicoesIguaisESequenciaNaoIguais =
                Lists.newArrayList(
                        new Posicao(20,criaMembro("Fernando")),
                        new Posicao(19,criaMembro("Marcio")),
                        new Posicao(20,criaMembro("Gerson"))

                );
        //execute SUT
        classificador.setPosicoes(posicoesIguaisESequenciaNaoIguais);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        //verify
        assertThat(posicoesComOrdemEsperada.get(0).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(2).getOrdem(),is(3));

    }

    @Test
    public void posicoesDesordenadas_devemSerOrdenadasRespeitandoMaisDeUmGap() throws Exception {

        //Setup fixture
        List<Posicao> posicoesIguaisESequenciaNaoIguais =
                Lists.newArrayList(
                        new Posicao(20,criaMembro("Fernando")),//1
                        new Posicao(19,criaMembro("Marcio")),//3
                        new Posicao(20,criaMembro("Gerson")),//1
                        new Posicao(18,criaMembro("Gerson")),//4
                        new Posicao(16,criaMembro("Gerson")),//6
                        new Posicao(18,criaMembro("Gerson"))//4

                );
        //execute SUT
        classificador.setPosicoes(posicoesIguaisESequenciaNaoIguais);
        List<Posicao> posicoesComOrdemEsperada = classificador.classifica();

        //verify
        assertThat(posicoesComOrdemEsperada.get(0).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemEsperada.get(2).getOrdem(),is(3));
        assertThat(posicoesComOrdemEsperada.get(3).getOrdem(),is(4));
        assertThat(posicoesComOrdemEsperada.get(4).getOrdem(),is(4));
        assertThat(posicoesComOrdemEsperada.get(5).getOrdem(),is(6));

    }

    private Membro criaMembro(String nome) {
        membro.setEmail(nome + "@yahoo.com");
        membro.setNome(nome);
        return membro;
    }

}