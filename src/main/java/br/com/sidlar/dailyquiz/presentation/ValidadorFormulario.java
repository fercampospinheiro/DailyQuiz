package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.FormularioMembro;
import br.com.sidlar.dailyquiz.presentation.Excecoes.DadosInvalidosException;
import org.springframework.validation.BindingResult;

/**
 * Responśavel pela pré-validação dos dados do formulario com propósito
 * de cadastro de um novo membro
 * @author Fernando de Campos Pinheiro
 */
public class ValidadorFormulario {

    private static final String FORMATO_DE_EMAIL_VALIDO = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*$";
    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_SENHA = "senha";

    private BindingResult resultado;

    public ValidadorFormulario( BindingResult resultado){
        this.resultado = resultado;
    }

    public void validaCampos(String nome,String email,String senha ) throws DadosInvalidosException{
        validaNome(nome);
        validaEmail(email);
        validaSenha(senha);
    }

    /**
     * Se o nome for maior que 50 caracteres ou não informado lança uma execeção com a descrição do erro
     */
    private void validaNome(String nome) {
        if (nome.length() > 50){
            resultado.rejectValue(CAMPO_NOME,"resultado", "Nome com mais 50 caracteres !");
            throw new DadosInvalidosException("Nome possui mais de 50 cacteres !");
        }
        else if(nome.isEmpty()){
            resultado.rejectValue(CAMPO_NOME,"resultado", "O nome não foi informado!");
            throw new DadosInvalidosException("Nome não informado !");
        }
    }

    /**
     * Se o E-mail for um formato inválido retorna uma exceção informando da incosistência
     */
    public void validaEmail(String email) {
        if (!email.matches(FORMATO_DE_EMAIL_VALIDO)) {
            resultado.rejectValue(CAMPO_EMAIL, "resultado", "Email inválido !");
            throw new DadosInvalidosException("O e-mail é inválido !");
        }
    }
    /**
     * Valida se a senha é menor que 6 caracteres e maior que 10 caracteres
     */
    private void validaSenha(String senha) {
        if (senha.length() < 6 || senha.length() > 10) {
            resultado.rejectValue(CAMPO_SENHA, "resultado", "Senha menor de 6 caracteres !");
            throw new DadosInvalidosException("Senha tem menos de 6 caracteres.");
        } else if (senha.length() > 10) {
            resultado.rejectValue(CAMPO_SENHA, "resultado", "Senha maior que 10 caracteres !");
            throw new DadosInvalidosException("Senha tem mais de 10 caracteres.");
        }

    }
}
