package br.com.sidlar.dailyquiz.domain;

import org.springframework.stereotype.Service;

/**
 * @author  Fernando de Campos Pinheiro
 */

@Service
public class CadastroMembroService {

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

	public NivelSeguranca obtemNivelDeSegurancaDaSenhaDoMebro(String senha){

		return NivelSeguranca.MEDIO;
	}

}
