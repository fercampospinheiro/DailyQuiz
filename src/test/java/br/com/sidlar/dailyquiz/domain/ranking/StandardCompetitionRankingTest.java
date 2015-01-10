package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import javafx.scene.media.MediaMarkerEvent;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.mock;

public class StandardCompetitionRankingTest {
    @Test
    public void esperaListaDeItensRankingClassificadoNoStandardCompetitionRanking(){
       // fixture
        Membro  membro = mock(Membro.class);

        List<ItemRanking> itemRankings =
                ImmutableList.of(
                        new ItemRanking(0, membro),
                        new ItemRanking(1,membro),
                        new ItemRanking(2,membro),
                        new ItemRanking(3,membro)
                );

        StandardCompetitionRanking classificador = new StandardCompetitionRanking();

        // exercise SUT
        List<ItemRanking> itensOrdenados = classificador.classifica(itemRankings);

        // verify outcome

//        assertThat(itensOrdenados.get(0).getOrdem(), is(1));
//        assertThat(itensOrdenados.get(1).getOrdem(), is(1));
//        assertThat(itensOrdenados.get(2).getOrdem(), is(3));
//        assertThat(itensOrdenados.get(3).getOrdem(), is(4));
    }

}