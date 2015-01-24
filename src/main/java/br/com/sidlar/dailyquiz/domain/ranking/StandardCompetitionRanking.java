package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 *@author Fernando de Campos Pinheiro
 */
@Component
public class StandardCompetitionRanking implements ClassificacaoRanking {

    @Override
    public List<Posicao> classifica(List<Posicao> posicoes) {
        Collections.sort(posicoes);
        return  ordenaPorStandardCompetition(posicoes);
    }

    private List<Posicao> ordenaPorStandardCompetition(List<Posicao> posicoes){
        int indiceAtual = 0 ;
        int ordemAtual = 1;
        int qtdOrdensIguais = 0;
        int numeroPosicoes = posicoes.size() -1;

        for(Posicao posicao : posicoes) {

            if(indiceAtual < numeroPosicoes) {

                int proximoIndice = indiceAtual + 1;
                int indiceAnterior = indiceAtual - 1;

                int pontuacaoAnterior = 0;
                if(indiceAtual > 0) pontuacaoAnterior = posicoes.get(indiceAnterior).getPontuacao();

                int pontuacaoAtual = posicao.getPontuacao();
                int proximaPontuacao = posicoes.get(indiceAtual + 1).getPontuacao();

                if(proximaPontuacao < pontuacaoAtual){
                    int ordemProximoIndice = ordemAtual + qtdOrdensIguais + 1;

                    posicao.defineOrdem(ordemAtual);
                    posicoes.get(proximoIndice).defineOrdem(ordemProximoIndice);

                    qtdOrdensIguais = 0;
                    ordemAtual++;
                    indiceAtual++;
                }
                else if (pontuacaoAnterior == pontuacaoAtual || pontuacaoAtual == proximaPontuacao) {
                    posicao.defineOrdem(ordemAtual);
                    qtdOrdensIguais++;
                    indiceAtual++;
                }

            }
        }

        return posicoes;
    }

}