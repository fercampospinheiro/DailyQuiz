package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 *@author Fernando de Campos Pinheiro
 */
@Component
public class StandardCompetitionRanking implements ClassificacaoRanking {


    private List<Posicao> posicoes;

    public StandardCompetitionRanking(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    @Override
    public List<Posicao> classifica() {
        Collections.sort(this.posicoes);
        return ordena(this.posicoes);
    }


    private List<Posicao> ordena(List<Posicao> posicoes) {

        int ordemAtual = 1;
        int numeroOrdensRepetidas = 0;
        int pontuacaoAtual = 0;
        int proximaPontuacao = 0;
        int proximoIndice = 0;
        int ultimoIndice = posicoes.size();

        for (Posicao posicao : posicoes) {

            pontuacaoAtual = posicao.getPontuacao();
            proximoIndice = posicoes.indexOf(posicao) + 1;

            if(proximoIndice < ultimoIndice) {

                proximaPontuacao = posicoes.get(proximoIndice).getPontuacao();

                if (pontuacaoAtual != proximaPontuacao) {
                    ordemAtual+= numeroOrdensRepetidas;
                    posicao.defineOrdem(ordemAtual);
                    numeroOrdensRepetidas = 0;
                    ordemAtual++;
                } else{
                    posicao.defineOrdem(ordemAtual);
                    numeroOrdensRepetidas++;
                }

            }
            else if (proximoIndice == ultimoIndice){
                ordemAtual+= numeroOrdensRepetidas;
                posicao.defineOrdem(ordemAtual);
            }
        }
        return posicoes;
    }



}
