package br.com.sidlar.dailyquiz.domain.validacoes;

import br.com.sidlar.dailyquiz.domain.excecoes.EmailJaCadastradoException;
import br.com.sidlar.dailyquiz.domain.excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;
import br.com.sidlar.dailyquiz.infrastructure.GeradorHash;
import br.com.sidlar.dailyquiz.infrastructure.HashSha1;
import org.springframework.stereotype.Component;

/**
 * Valida dados do formulário com as informações do Repositório de Membro
 */
@Component
public class ValidadorMembro {

    private MembroRepository repository;
    private GeradorHash gerador = new HashSha1();

    public ValidadorMembro(MembroRepository repository) {
        this.repository = repository;
    }

    public void verificaExistenciaDeEmail(String email){
        if(repository.existeEmail(email))
            throw new EmailJaCadastradoException("Email  "+ email + "  já existe!");
    }

    public void  validaSenha(String senha,Membro membro){
        String HashDaSenha = gerador.geraHash(senha);
        if (!membro.possuiSenhaInformada(HashDaSenha)) {
            throw new EmailOuSenhaInexistenteException("Senha inválida");
        }
    }

    public void setRepository(MembroRepository repository) {
        this.repository = repository;
    }

    public void setGerador(GeradorHash gerador) {
        this.gerador = gerador;
    }
}
