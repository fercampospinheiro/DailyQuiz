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

	public String geraHashCodeDaSenhaDoMembro(String Senha){
		//implementação
		return "";
	}

	public Membro geraMembroComInformacaoDoformulario(FormularioCadastroMembro formulario){
		Membro membro = new Membro();
		membro.setNome(formulario.getNome());
		membro.setUserName(formulario.getUserName());
		String senhaComHashCode = geraHashCodeDaSenhaDoMembro(formulario.getSenha());
		membro.setSenha(senhaComHashCode);

		return membro;
	}

    @Transactional(readOnly = false)
    public void cadastraNovoMembro(Membro membro) {
        membroRepository.insereNovoMembro(membro);
    }

	public NivelSeguranca obtemNivelDeSegurancaDaSenhaDoMebro(String senha){

		return NivelSeguranca.MEDIO;
	}

}
