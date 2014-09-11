package br.com.sidlar.dailyquiz.domain;

/**
 * Created by Fernando_2 on 10/09/2014.
 */
public class EntidadeNaoExistenteException extends RuntimeException {

	public EntidadeNaoExistenteException(String message) {
		super(message);
	}

	public EntidadeNaoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeNaoExistenteException(Throwable cause) {
		super(cause);
	}
}
