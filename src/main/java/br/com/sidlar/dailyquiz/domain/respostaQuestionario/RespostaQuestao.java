package br.com.sidlar.dailyquiz.domain.respostaQuestionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questao;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;

import javax.persistence.*;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaQuestao {
    @Id @GeneratedValue
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "idQuestao")
    private Questao questao;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name ="IdAlternativaCorreta")
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

    public void setAlternativaSelecionada(Alternativa alternativaSelecionada) {
        this.alternativaSelecionada = alternativaSelecionada;
    }

    public Alternativa getAlternativaSelecionada() {
        return alternativaSelecionada;
    }
}


