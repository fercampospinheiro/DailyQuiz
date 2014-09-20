package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.FormularioCadastroMembro;
import org.joda.time.LocalDate;

/**
 * @author Fernando de Campos Pinheiro
 */
public class ValidadorUtils {

    public static void validaFormulario(FormularioCadastroMembro formulario) throws DadosInvalidosException {
            validaNome(formulario.getNome());
            validaEmail(formulario.getEmail());
            validaSenha(formulario.getSenha());
        }

    private static void validaNome(String nome){
        if (nome.length()>50)
            throw  new  DadosInvalidosException("Nome não pode possuir mais de 50 cacteres ");
    }
    private static void validaEmail(String email){
        if(email!= "")
            throw new DadosInvalidosException("E-mail inválido");
    }
    private static void validaSenha(String senha){
        if(senha.length() < 6 || senha.length() >10 )
            throw new DadosInvalidosException("Senha deve ter no mínimo 6 e no máximo 10 cacteres");
    }


}
