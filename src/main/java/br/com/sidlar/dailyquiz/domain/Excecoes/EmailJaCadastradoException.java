package br.com.sidlar.dailyquiz.domain.Excecoes;

/**
 * Created by Fernando_2 on 12/09/2014.
 */
public class EmailJaCadastradoException extends RuntimeException {
	public EmailJaCadastradoException(String message) {
		super(message);
	}

	public EmailJaCadastradoException(String message, Throwable cause) {
		super(message, cause);
	}
}
