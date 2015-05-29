package br.com.sidlar.dailyquiz.domain.membro;

/**
 * Created by Fernando_2 on 12/09/2014.
 */
public class EmailCadastradoException extends RuntimeException {
	public EmailCadastradoException(String message) {
		super(message);
	}

	public EmailCadastradoException(String message, Throwable cause) {
		super(message, cause);
	}
}
