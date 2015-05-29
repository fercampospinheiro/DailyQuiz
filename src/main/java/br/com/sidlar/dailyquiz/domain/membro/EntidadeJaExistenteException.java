package br.com.sidlar.dailyquiz.domain.membro;

/**
 * Created by Fernando_2 on 12/09/2014.
 */
public class EntidadeJaExistenteException extends RuntimeException {

	public EntidadeJaExistenteException(String message) {
		super(message);
	}

	public EntidadeJaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}
}
