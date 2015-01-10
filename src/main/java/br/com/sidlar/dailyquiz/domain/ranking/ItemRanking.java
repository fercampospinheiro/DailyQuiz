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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemRanking that = (ItemRanking) o;

        if (pontuacao != that.pontuacao) return false;

        return true;
    }


}
