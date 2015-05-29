package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.membro.Membro;

/**
 * @author Fernando de Campos Pinheiro
 */
public class Posicao implements Comparable<Posicao>{

    private int ordem;

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    private int pontuacao;
    private Membro membro;

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Posicao(){

    }

    public Posicao(int pontuacao, Membro membro) {
        this.pontuacao = pontuacao;
        this.membro = membro;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Membro getMembro() {
        return membro;
    }

    public void defineOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getOrdem() {
        return ordem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicao)) return false;

        Posicao posicao = (Posicao) o;

        if (pontuacao != posicao.pontuacao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordem;
        result = 31 * result + (int) (pontuacao ^ (pontuacao >>> 32));
        return result;
    }

    @Override
    public int compareTo(Posicao o) {
        if(this.getPontuacao() > o.getPontuacao() ){return  -1;}
        else if(this.getPontuacao() == o.getPontuacao()){return 0;}
        else return 1;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "ordem=" + ordem +
                ", pontuacao=" + pontuacao +
                ", cadastroMembro=" + membro +
                '}';
    }
}
