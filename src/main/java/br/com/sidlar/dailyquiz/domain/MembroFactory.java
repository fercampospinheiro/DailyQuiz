package br.com.sidlar.dailyquiz.domain;

import br.com.sidlar.dailyquiz.infrastructure.GeradorHashcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Fabrica de membro com processos específicos
 * @author Fernando de Campos pinheiro
 */
@Component
public class MembroFactory {

    @Autowired private GeradorHashcode geradorHascode;

	/**
	 * Cria um membro com dados do {@link FormularioMembro}
	 * @param formulario com dados do novo membro
	 * @return Membro populado com sua informações
	 */
    public Membro geraMembroComInformacaoDoformulario(FormularioMembro formulario){
        Membro membro = new Membro();
        membro.setNome(formulario.getNome());
        membro.setEmail(formulario.getEmail());
        String hashCodeDaSenha = geradorHascode.geraHashcode(formulario.getSenha());
        membro.setSenha(hashCodeDaSenha);
        membro.setDataNascimento(formulario.getDataNascimento());
        return membro;
    }
}
