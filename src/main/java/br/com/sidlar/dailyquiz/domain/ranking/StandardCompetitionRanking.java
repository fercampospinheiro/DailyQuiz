package br.com.sidlar.dailyquiz.domain.ranking;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by fernando on 15/11/14.
 */
@Component
public class StandardCompetitionRanking implements ClassificacaoRanking {

    private List<Posicao> posicoes = Lists.newArrayList();

    @Override
    public List<Posicao> classifica(List<ItemRanking> itensRanking) {

        int pontuacaoInicial = 0;
        int ordem = 1;

        for (ItemRanking item : itensRanking) {
            if (item.getPontuacao() > pontuacaoInicial) {
                pontuacaoInicial = item.getPontuacao();
                Posicao posicao = new Posicao(ordem, item);
                posicoes.add(posicao);
                ordem = +1;
            } else if (item.getPontuacao() == pontuacaoInicial) {
                Posicao posicao = new Posicao(ordem, item);
                ordem = +2;
            }
        }
        return posicoes;
    }

}
