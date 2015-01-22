package br.com.sidlar.dailyquiz.domain.respostaQuestionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;

import javax.persistence.*;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaQuestao {
    @Id @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idQuestao")
    private Questao questao;

    @OneToOne
    @JoinColumn(name ="idAlternativa")
    private Alternativa alternativaSelecionada;

    public RespostaQuestao() {
    }
    public RespostaQuestao(Questao questao) {
        this.questao = questao;
    }


    public String exibe(){
        return alternativaSelecionada.exibe();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void comAlternativaSelecionada(Alternativa alternativaSelecionada) {
        this.alternativaSelecionada = alternativaSelecionada;
    }

    public Alternativa getAlternativaSelecionada() {
        return alternativaSelecionada;
    }

    public boolean possuiComoRespostaCorreta(Alternativa alternativa){
        return this.questao.getAlternativaCorreta().equals(alternativa);
    }


    public boolean possuiComoRespostaSelecionada(Alternativa alternativa){
        return this.alternativaSelecionada.equals(alternativa);
    }

    public Alternativa getAlternativaCorreta(){
        return this.questao.getAlternativaCorreta();
    }

    public void referenteA(Questao questao) {
        this.questao = questao;
    }
}


