package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author Fernando de Campos Pinheiro
 */
@Component
public class StandardCompetitionRanking2 implements ClassificacaoRanking {


    private List<Posicao> posicoes;

    public StandardCompetitionRanking2() {

    }

    public StandardCompetitionRanking2(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    @Override
    public List<Posicao> classifica() {
        Collections.sort(this.posicoes);
        return ordena(this.posicoes);
    }


    private List<Posicao> ordena(List<Posicao> posicoes) {

        int ordem = 1;
        int qtdEmpate = 0;

        for (int i = 0, posicoesSize = posicoes.size(); i < posicoesSize; i++) {
            Posicao posicaoAtual = posicoes.get(i);

            boolean ultimaPosicao = i == posicoesSize - 1;
            if (ultimaPosicao) {
                if (qtdEmpate == 0) {
                    /* não empatou */
                posicaoAtual.defineOrdem(ordem + qtdEmpate);
            } else {
                posicaoAtual.defineOrdem(ordem);
            }
            break;
        }

            Posicao proxPosicao = posicoes.get(i + 1);
            if (posicaoAtual.getPontuacao() != proxPosicao.getPontuacao()) {
                /* não houve empate */
                posicaoAtual.defineOrdem(ordem++);
                qtdEmpate = 0;
            } else {
                /* houve empate */
                posicaoAtual.defineOrdem(ordem);
                qtdEmpate++;
            }
        }


        return posicoes;
    }

    public void setPosicoes(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

}
