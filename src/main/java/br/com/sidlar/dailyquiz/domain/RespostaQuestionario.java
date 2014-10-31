package br.com.sidlar.dailyquiz.domain;

import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fernando de Campos Pinheiro
 */
public class RespostaQuestionario {
    private Integer id;
    private Questionario questionario;
    private Map<Integer,RespostaQuestao> respostas = new HashMap<>();
    private Membro membro;
    private LocalDate dataReposta;

    public RespostaQuestionario() {
    }

    public void adicionaRespostaDaQuestao(RespostaQuestao respostaQuestao){
         respostas.put(respostaQuestao.getNumero(),respostaQuestao);
    }

    public RespostaQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public void respondidoPor(Membro membro){
        this.membro =  membro;
    }

    public void adicionaQuestionario(Questionario questionario){
        questionario = questionario;
    }



}
