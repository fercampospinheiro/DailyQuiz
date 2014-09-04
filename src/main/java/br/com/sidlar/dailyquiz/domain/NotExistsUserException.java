package br.com.sidlar.dailyquiz.domain;

/**
 * Exceção por inexistencia de usuário
 *@author Fernando de Campos Pinheiro
 */
public class NotExistsUserException extends RuntimeException {

	public NotExistsUserException(Throwable cause) {
		super(cause);
	}

	public NotExistsUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotExistsUserException(String message) {
		super(message);
	}

	public NotExistsUserException() {
	}
}
