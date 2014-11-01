package br.com.sidlar.dailyquiz.domain.respostaQuestionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questao;

import javax.persistence.*;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaDaQuestao {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Questao questao;
    @OneToOne
    private Alternativa alternativaSelecionada;

    public RespostaDaQuestao() {
    }
    public RespostaDaQuestao(Questao questao) {
        this.questao = questao;
    }

    public void is(Alternativa alternativa){
        this.alternativaSelecionada= alternativa;
    }

    public boolean estaCorreta(){
        return questao.ehIgualRespostaDaQuestao(alternativaSelecionada);
    }

    public String exibe(){
        return alternativaSelecionada.exibe();
    }
}


