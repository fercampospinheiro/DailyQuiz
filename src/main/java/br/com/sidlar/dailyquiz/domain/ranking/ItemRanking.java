package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;

/**
 * @author Fernando de Campos Pinheiro
 */
public class ItemRanking {

    private int ordem;
    private int pontuacao;
    private Membro membro;


    public ItemRanking(int ordem ,int pontuacao, Membro membro) {
        this.ordem =  ordem;
        this.pontuacao = pontuacao;
        this.membro = membro;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Membro getMembro() {
        return membro;
    }

    public int getOrdem(){
        return this.ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemRanking that = (ItemRanking) o;

        if (ordem != that.ordem) return false;
        if (pontuacao != that.pontuacao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordem;
        result = 31 * result + pontuacao;
        return result;
    }
}
