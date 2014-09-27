package br.com.sidlar.dailyquiz.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviço de suporte ao cadastro de um membro
 * @author  Fernando de Campos Pinheiro
 */

@Service
public class CadastroMembroService {

    @Autowired private MembroRepository membroRepository;

    public void cadastraNovoMembro(Membro membro) throws EmailOuSenhaJaExistenteException{
        verificaExistenciaDeEmail(membro.getEmail());
        membroRepository.adicionaNovoMembro(membro);
    }

    private void verificaExistenciaDeEmail(String email){

        try {
            Membro membroRecuperadoDoBanco = membroRepository.buscaPorEmail(email);
            throw new EmailOuSenhaJaExistenteException(String.format("Email % já existe!",email));
        }
        catch (EntidadeInexistenteException e){
            throw  new EmailOuSenhaInexistenteException("Email não existe!");
        }



    }


}