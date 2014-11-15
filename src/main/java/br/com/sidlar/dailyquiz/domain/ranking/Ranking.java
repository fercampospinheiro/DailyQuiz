package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author  Fernando de Campos Pnheiro
 */
public class Ranking {

    private List<Posicao> posicoes = Lists.newArrayList();
    private List<ItemRanking> itensRanking = Lists.newArrayList();

    public void definePosicoes(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    public List<Posicao> obtemDefinicao() {
        return posicoes;
    }


}


