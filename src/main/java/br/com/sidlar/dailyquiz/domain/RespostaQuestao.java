package br.com.sidlar.dailyquiz.domain;

/**
 * Created by fernando on 30/10/14.
 */
public class RespostaQuestao {
    private Integer id;
    private Integer numero;
    private Questao questao;
    private Opcao opcaoSelecionada;

    public RespostaQuestao() {
    }

    public RespostaQuestao(Integer numero,Questao questao) {
        this.questao = questao;
    }

    public void is(Opcao opcao){
        opcaoSelecionada = opcao;
    }

    public boolean estaCorreta(){
        return questao.altertivaCorretaEhIgualOpcao(opcaoSelecionada);
    }

    public Integer getNumero() {
        return numero;
    }

    public String visualizaPergunta(){
        return questao.getPergunta();
    }
    public String visualiaResposta(){
        return questao.getAlternativa(this.opcaoSelecionada).exibe();
    }
}


