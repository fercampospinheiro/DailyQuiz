package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
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
       //fixture
        Membro  membro = mock(Membro.class);

        ItemRanking  item1PrimeiraPosicao = new ItemRanking(0,30,membro);
        ItemRanking  item2PrimeiraPosicao = new ItemRanking(0,30,membro);
        ItemRanking  item3TerceiraPosicao = new ItemRanking(0,20,membro);
        ItemRanking  item4QuartaPosicao = new ItemRanking(0,18,membro);

        List<ItemRanking> itemRankings = Lists.newArrayList();
        itemRankings.add(item1PrimeiraPosicao);
        itemRankings.add(item2PrimeiraPosicao);
        itemRankings.add(item3TerceiraPosicao);
        itemRankings.add(item4QuartaPosicao);

        //exercise Sut
        ClassificacaoRanking  classificador= new StandardCompetitionRanking();
        List<ItemRanking> itensOrdenados = classificador.classifica(itemRankings);

        ItemRanking  item1 = new ItemRanking(1,30,membro);
        ItemRanking  item2 = new ItemRanking(1,30,membro);
        ItemRanking  item3 = new ItemRanking(3,20,membro);
        ItemRanking  item4 = new ItemRanking(4,18,membro);

        //veryfy
        assertThat(itensOrdenados,hasItems(item1, item2, item3, item4));
    }

}