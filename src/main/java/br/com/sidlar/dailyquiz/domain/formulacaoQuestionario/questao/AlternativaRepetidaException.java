package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao;

/**
 * Created by fernando on 01/11/14.
 */
public class AlternativaRepetidaException extends RuntimeException{

    public AlternativaRepetidaException(String message) {
        super(message);
    }

    public AlternativaRepetidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
