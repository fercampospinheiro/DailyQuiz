package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

/**
 * Created by fernando on 01/11/14.
 */
public class QuestaoRepetidaException extends RuntimeException{

    public QuestaoRepetidaException(String message) {
        super(message);
    }

    public QuestaoRepetidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
