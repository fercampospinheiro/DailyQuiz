package br.com.sidlar.dailyquiz.domain;

import br.com.sidlar.dailyquiz.domain.Excecoes.EmailJaCadastradoException;
import br.com.sidlar.dailyquiz.domain.Excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.Excecoes.EntidadeInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Responsavel pelo processo de cadastramento de um novo membro
 * @author  Fernando de Campos Pinheiro
 */

@Service
public class CadastroMembroService {

    @Autowired private MembroRepository membroRepository;

    /**
     *Cadastra um novo membro se os dados deste não constarem no repositorio de membros
     * @throws EmailJaCadastradoException caso o e-mail informado como membro já exista
     */
    public void cadastraNovoMembro(Membro membro) throws EmailJaCadastradoException {
        verificaExistenciaDeEmail(membro.getEmail());
        membroRepository.adicionaNovoMembro(membro);
    }

    private void verificaExistenciaDeEmail(String email){
        if(membroRepository.existeEmail(email))
            throw new EmailJaCadastradoException(String.format("Email % já existe!", email));
    }

}