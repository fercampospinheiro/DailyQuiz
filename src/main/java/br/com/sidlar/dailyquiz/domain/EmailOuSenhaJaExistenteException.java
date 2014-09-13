package br.com.sidlar.dailyquiz.domain;

/**
 * Created by Fernando_2 on 12/09/2014.
 */
public class EmailOuSenhaJaExistenteException extends RuntimeException {
	public EmailOuSenhaJaExistenteException(String message) {
		super(message);
	}

	public EmailOuSenhaJaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}
}
