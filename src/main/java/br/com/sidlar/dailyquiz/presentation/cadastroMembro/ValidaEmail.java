package br.com.sidlar.dailyquiz.presentation.cadastroMembro;

import org.springframework.validation.BindingResult;

/**
 * @author Fernando de Campos Pinheiro
 */
public class ValidaEmail {
    private static final String CAMPO_EMAIL = "email";
    private static final String FORMATO_DE_EMAIL_VALIDO = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*$";

    /**
     * Se o E-mail for um formato inválido retorna uma exceção informando da incosistência
     */
    public void valida(String email, BindingResult resultado) {
        if (!email.matches(FORMATO_DE_EMAIL_VALIDO)) {
            resultado.rejectValue(CAMPO_EMAIL, "resultado", "Email inválido !");
            throw new DadosInvalidosException("O e-mail é inválido !");
        }

    }

}
