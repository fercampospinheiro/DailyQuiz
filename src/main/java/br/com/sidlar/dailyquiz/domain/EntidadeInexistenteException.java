package br.com.sidlar.dailyquiz.domain;

/**
 * Created by Fernando_2 on 10/09/2014.
 */
public class EntidadeInexistenteException extends RuntimeException {

	public EntidadeInexistenteException(String message) {
		super(message);
	}

	public EntidadeInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeInexistenteException(Throwable cause) {
		super(cause);
	}
}
