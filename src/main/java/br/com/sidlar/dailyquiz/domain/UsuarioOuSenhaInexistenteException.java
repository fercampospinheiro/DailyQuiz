package br.com.sidlar.dailyquiz.domain;

/**
 * Exceção por inexistencia de usuário
 *@author Fernando de Campos Pinheiro
 */
public class UsuarioOuSenhaInexistenteException extends RuntimeException {

	public UsuarioOuSenhaInexistenteException(Throwable cause) {
		super(cause);
	}

	public UsuarioOuSenhaInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioOuSenhaInexistenteException(String message) {
		super(message);
	}

}
