package br.com.sidlar.dailyquiz.domain.excecoes;

/**
 * Exceção por inexistencia de usuário
 *@author Fernando de Campos Pinheiro
 */
public class EmailOuSenhaInexistenteException extends RuntimeException {

	public EmailOuSenhaInexistenteException(Throwable cause) {
		super(cause);
	}

	public EmailOuSenhaInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailOuSenhaInexistenteException(String message) {
		super(message);
	}

}
