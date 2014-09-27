package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.FormularioCadastroMembro;
import org.joda.time.LocalDate;

/**
 * Classe utilitária que válida todos os dados vindos da JSP
 * @author Fernando de Campos Pinheiro
 */
public class ValidadorUtils {

    private static final String FORMATO_DE_EMAIL_VALIDO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static void validaFormulario(FormularioCadastroMembro formulario) throws DadosInvalidosException {
            validaNome(formulario.getNome());
            validaEmail(formulario.getEmail());
            validaSenha(formulario.getSenha());
        }

    /**
     * Se o nome for maio que 50 catcteres lança uma exceção com a descrição do erro
     */
    private static void validaNome(String nome){
        if (nome.length()>50)
            throw  new  DadosInvalidosException("Nome não pode possuir mais de 50 cacteres ");
    }

    /**
     * Se o E-mail for no formato inválido retorna uma excpetio informando da incosistencia
     */
    private static void validaEmail(String email){
        if(!email.matches(FORMATO_DE_EMAIL_VALIDO))
            throw new DadosInvalidosException("E-mail inválido");
    }
    /**
     * Valida senha menores que 6 caracteres e maiores que 10 caracteres
     */
    private static void validaSenha(String senha){
        if(senha.length() < 6 || senha.length() >10 )
            throw new DadosInvalidosException("Senha deve ter no mínimo 6 e no máximo 10 cacteres");
    }


}
