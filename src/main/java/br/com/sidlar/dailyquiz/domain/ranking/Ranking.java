package br.com.sidlar.dailyquiz.domain.ranking;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author  Fernando de Campos Pnheiro
 */
public class Ranking{
    @Autowired private ClassificacaoRanking classificador;

    private List<Posicao> posicoes = Lists.newArrayList();

    public void setPosicoes(List<Posicao> posicoes){
        this.posicoes = posicoes;
    }

    public void ordenaPosicoes(){
        this.classificador.classifica(posicoes);
    }


}


