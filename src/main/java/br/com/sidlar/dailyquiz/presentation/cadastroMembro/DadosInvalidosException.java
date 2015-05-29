package br.com.sidlar.dailyquiz.presentation.cadastroMembro;

/**
 * Classe que representa uma excessão por dados inconsistentes vindo de um formulário na camada de apresentação
 * @author Fernando de Campos Pinheiro.
 */
public class DadosInvalidosException extends RuntimeException{

    public DadosInvalidosException(String message) {
        super(message);
    }

    public DadosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
}
