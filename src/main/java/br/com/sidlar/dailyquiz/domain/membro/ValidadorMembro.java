package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.domain.excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.infrastructure.GeradorHash;
import br.com.sidlar.dailyquiz.infrastructure.HashSha1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Valida dados do formulário com as informações do Repositório de Membro
 */
@Component
public class ValidadorMembro {

    @Autowired private MembroRepository repository;
    @Autowired private GeradorHash gerador = new HashSha1();

    public ValidadorMembro() {
    }

    public ValidadorMembro(MembroRepository repository) {
        this.repository = repository;
    }

    public void verificaEmailCadastrado(String email){
        if(repository.existeEmail(email)) {
            throw new EmailCadastradoException("Email  " + email + "  já possui cadastrado! Informe outro e-mail.");
        }
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
