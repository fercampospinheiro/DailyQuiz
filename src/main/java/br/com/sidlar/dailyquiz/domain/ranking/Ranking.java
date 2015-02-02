package br.com.sidlar.dailyquiz.domain.ranking;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.TreeSet;

/**
 * @author  Fernando de Campos Pnheiro
 */
public class Ranking{
    @Autowired private ClassificacaoRanking classificador;

    public Ranking(List<Posicao> posicoes) {
        this.posicoes = posicoes;
        ordenaPosicoes();
    }

    private List<Posicao> posicoes = Lists.newArrayList();

    private void ordenaPosicoes(){
        this.classificador.classifica(posicoes);
    }

    public List<Posicao> getPosicoes() {
        return posicoes;
    }
}


