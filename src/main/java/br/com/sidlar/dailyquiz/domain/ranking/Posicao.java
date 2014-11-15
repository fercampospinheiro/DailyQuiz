package br.com.sidlar.dailyquiz.domain.ranking;

/**
 * @autor Fernando de Campos Pinheiro
 */
public class Posicao {
    private int ordem ;
    private ItemRanking itemRanking;

    public Posicao() {
    }

    public Posicao(int ordem, ItemRanking itemRanking) {
        this.ordem = ordem;
        this.itemRanking = itemRanking;
    }

    public int getOrdem() {
        return ordem;
    }

    public ItemRanking getItemRanking() {
        return itemRanking;
    }
}
