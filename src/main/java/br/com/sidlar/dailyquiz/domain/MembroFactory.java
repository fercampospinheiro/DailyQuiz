package br.com.sidlar.dailyquiz.domain;

import br.com.sidlar.dailyquiz.infrastructure.GeradorHascode;
import br.com.sidlar.dailyquiz.infrastructure.HashcodeSha1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Fabrica de membro com processos específicos
 * @author Fernando de Campos pinheiro
 */
@Component
public class MembroFactory {

    @Autowired private GeradorHascode geradorHascode;

	/**
	 * Cria um membro com dados oriundos do {@link br.com.sidlar.dailyquiz.domain.FormularioCadastroMembro}
	 * com processo de hascode Sha1 na Senha.
	 * @param formulario
	 * @return Membro
	 */
    public Membro geraMembroComInformacaoDoformulario(FormularioCadastroMembro formulario){
        Membro membro = new Membro();
        membro.setNome(formulario.getNome());
        membro.setEmail(formulario.getUserName());
        String senhaComHashCode = geradorHascode.geraHashcode(formulario.getSenha());
        membro.setSenha(senhaComHashCode);
        return membro;
    }
}
