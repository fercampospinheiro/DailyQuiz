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
    private  StandardCompetitionRanking classificador;

    @Before
    public void inicializa(){
        membro = new Membro();
        classificador = new StandardCompetitionRanking();
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
        List<Posicao> posicoesOrdenadasDecrescentemente = classificador.classifica(posicoesDesordenadas);

        // verify outcome
        assertThat(posicoesOrdenadasDecrescentemente, contains(
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

        List<Posicao> posicoesComPontucaoIgual =
                Lists.newArrayList(
                new Posicao(20,criaMembro("Fernando")),
               new Posicao(20,criaMembro("Antonio")),
                new Posicao(20,criaMembro("Andre")),
                new Posicao(20,criaMembro("Paulo"))
        );

        //execute SUT

        List<Posicao> posicoesComMesmaOrdem = classificador.classifica(posicoesComPontucaoIgual);

        //verify

        posicoesComMesmaOrdem.forEach(p -> System.out.println(p.getOrdem()));

        assertThat(posicoesComMesmaOrdem.get(0).getOrdem(),is(1));
        assertThat(posicoesComMesmaOrdem.get(1).getOrdem(),is(1));
        assertThat(posicoesComMesmaOrdem.get(2).getOrdem(),is(1));
        assertThat(posicoesComMesmaOrdem.get(3).getOrdem(),is(1));

    }

    @Test
    public void posicaoComPontuacaoAposSequenciaDeIguais_deveTerComoOrdem_oNumeroDaSequenciaDaPosicao() throws Exception {

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
        List<Posicao> posicoesComOrdemDaSequenciaAposIguais = classificador.classifica(posicoesIguaisESequenciaNaoIguais);


        posicoesComOrdemDaSequenciaAposIguais.forEach(o -> System.out.println(o.getOrdem()));

        //verify
        assertThat(posicoesComOrdemDaSequenciaAposIguais.get(0).getOrdem(), is(1));
        assertThat(posicoesComOrdemDaSequenciaAposIguais.get(1).getOrdem(),is(1));
        assertThat(posicoesComOrdemDaSequenciaAposIguais.get(2).getOrdem(),is(3));
        assertThat(posicoesComOrdemDaSequenciaAposIguais.get(3).getOrdem(),is(4));
        assertThat(posicoesComOrdemDaSequenciaAposIguais.get(4).getOrdem(),is(4));
        assertThat(posicoesComOrdemDaSequenciaAposIguais.get(5).getOrdem(),is(6));

    }


    private Membro criaMembro(String nome) {
        membro.setEmail(nome + "@yahoo.com");
        membro.setNome(nome);
        return membro;
    }

}