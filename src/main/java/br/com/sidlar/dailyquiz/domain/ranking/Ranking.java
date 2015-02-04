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
    private List<Posicao> posicoes;
    public Ranking() {
    }

    public void ordenaAtraves(ClassificacaoRanking classificador){
        this.posicoes = classificador.classifica();
    }

    public List<Posicao> getPosicoes() {
        return this.posicoes;
    }


}


