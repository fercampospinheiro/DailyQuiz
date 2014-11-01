package br.com.sidlar.dailyquiz.presentation.validacoes;
import br.com.sidlar.dailyquiz.presentation.excecoes.DadosInvalidosException;
import org.springframework.validation.BindingResult;

/**
 * @author Fernando de Campos Pinheiro
 */
public class ValidaSenha {
    private static final String CAMPO_SENHA = "senha";

    /**
     * Valida se a senha é menor que 6 caracteres e maior que 10 caracteres
     */
    public void valida(String senha,BindingResult resultado) {
        if (senha.length() < 6 || senha.length() > 10) {
            resultado.rejectValue(CAMPO_SENHA, "resultado", "Senha menor de 6 caracteres !");
            throw new DadosInvalidosException("Senha tem menos de 6 caracteres.");
        } else if (senha.length() > 10) {
            resultado.rejectValue(CAMPO_SENHA, "resultado", "Senha maior que 10 caracteres !");
            throw new DadosInvalidosException("Senha tem mais de 10 caracteres.");
        }
    }
}
