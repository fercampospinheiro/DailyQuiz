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

    private static final String FORMATO_DE_EMAIL_VALIDO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String ERRO_NO_NOME = "ErroNoNome";
    private static final String ERRO_NO_EMAIL = "ErroNoEmail";
    private static final String ERRO_NA_SENHA = "ErroNaSenha";

    private BindingResult resultado;

    public ValidadorFormulario(FormularioMembro formulario, BindingResult resultado) throws DadosInvalidosException {
        validaNome(formulario.getNome());
        validaEmail(formulario.getEmail());
        validaSenha(formulario.getSenha());
        this.resultado = resultado;
    }

    /**
     * Se o nome for maior que 50 caracteres ou não informado lança uma execeção com a descrição do erro
     */
    private void validaNome(String nome) {
        if (nome.length() > 50){
            resultado.rejectValue(ERRO_NO_NOME,"resultado", "Nome com mais 50 caracteres !");
            throw new DadosInvalidosException("Nome possui mais de 50 cacteres !");
        }
        else if(nome.isEmpty()){
            resultado.rejectValue(ERRO_NO_NOME,"resultado", "O nome não foi informado!");
            throw new DadosInvalidosException("Nome não informado !");
        }
    }

    /**
     * Se o E-mail for um formato inválido retorna uma exceção informando da incosistência
     */
    private void validaEmail(String email){
        if(!email.matches(FORMATO_DE_EMAIL_VALIDO))
            resultado.rejectValue(ERRO_NO_EMAIL,"resultado","Email inválido !");
            throw new DadosInvalidosException("O e-mail é inválido !");
    }
    /**
     * Valida se a senha é menor que 6 caracteres e maior que 10 caracteres
     */
    private void validaSenha(String senha){
        if(senha.length() < 6 || senha.length() >10 ) {
            resultado.rejectValue(ERRO_NA_SENHA,"resultado", "Senha menor de 6 caracteres !");
            throw new DadosInvalidosException("Senha tem mais de 6.");
        }
        else if(senha.length()> 10)
            resultado.rejectValue(ERRO_NA_SENHA,"resultado", "Senha maior que 10 caracteres !");
            throw new DadosInvalidosException("Senha tem mais de 10 cacteres.");
        }


}
