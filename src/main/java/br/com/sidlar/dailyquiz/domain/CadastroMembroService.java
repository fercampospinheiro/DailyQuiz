package br.com.sidlar.dailyquiz.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  Fernando de Campos Pinheiro
 */

@Service
public class CadastroMembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Transactional(readOnly = false)
    public void cadastraNovoMembro(Membro membro) {
        membroRepository.insereNovoMembro(membro);
    }

	public NivelSeguranca obtemNivelDeSegurancaDaSenhaDoMebro(String senha){

		return NivelSeguranca.MEDIO;
	}

}
