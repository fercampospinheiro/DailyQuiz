package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

public class StandardCompetitionRankingTest {

    @Test
    public void test1() throws Exception {

        // setup fixture
        StandardCompetitionRanking classificador = new StandardCompetitionRanking();

        List<Posicao> posicoes =
                Lists.newArrayList(
                        new Posicao(10, criaMembro("José")),
                        new Posicao(5, criaMembro("Maria")),
                        new Posicao(8, criaMembro("Moises")),
                        new Posicao(1, criaMembro("Cobra")),
                        new Posicao(2, criaMembro("Andre"))
                );

        // execute SUT
        List<Posicao> posicoesOrdenadas = classificador.classifica(posicoes);

        // verify outcome
        assertThat(posicoesOrdenadas, contains(
                new Posicao(10, criaMembro("José")),
                new Posicao(8, criaMembro("Moises")),
                new Posicao(5, criaMembro("Maria")),
                new Posicao(2, criaMembro("Andre")),
                new Posicao(1, criaMembro("Cobra"))
        ));

    }

    private Membro criaMembro(String nome) {
        return new Membro(nome + "@yahoo.com", nome);
    }

}