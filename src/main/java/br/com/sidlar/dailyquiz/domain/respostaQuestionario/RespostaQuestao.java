package br.com.sidlar.dailyquiz.domain.respostaQuestionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;

import javax.persistence.*;

/**
 * @author Fernando de Campos Pinheiro
 */
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
public class RespostaQuestao {
    @Id @GeneratedValue
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
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

    public boolean estaCorreta(){
        return questao.ehIgualRespostaDaQuestao(alternativaSelecionada);
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

    public void referenteA(Questao questao) {
        this.questao = questao;
    }
}


