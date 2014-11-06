package br.com.sidlar.dailyquiz.domain.respostaQuestionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questao;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;

import javax.persistence.*;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaDaQuestao {
    @Id @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "idQuestao")
    private Questao questao;
    @OneToOne
    @JoinColumn(name ="IdAlternativaCorreta")
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


