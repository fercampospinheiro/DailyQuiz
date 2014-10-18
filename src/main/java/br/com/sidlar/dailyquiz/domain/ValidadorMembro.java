package br.com.sidlar.dailyquiz.domain;

import br.com.sidlar.dailyquiz.domain.Excecoes.EmailJaCadastradoException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Valida dados do formulário com as informações do Repositório de Membro
 */
@Component
public class ValidadorMembro{

    private MembroRepository repository;


    public ValidadorMembro(MembroRepository repository) {
        this.repository = repository;
    }

    public void verificaExistenciaDeEmail(String email){
        if(repository.existeEmail(email))
            throw new EmailJaCadastradoException("Email  "+ email + "  já existe!");
    }
}
