package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;

/**
 * @author Fernando de Campos Pinheiro
 */
public class ItemRanking {

    private int pontuacao;
    private Membro membro;

    public ItemRanking(int pontuacao, Membro membro) {
        this.pontuacao = pontuacao;
        this.membro = membro;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Membro getMembro() {
        return membro;
    }
}
