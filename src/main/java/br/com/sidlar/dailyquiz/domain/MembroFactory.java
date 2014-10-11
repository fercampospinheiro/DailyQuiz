package br.com.sidlar.dailyquiz.domain;

import br.com.sidlar.dailyquiz.infrastructure.GeradorHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Responsavel pela geração de um membro com dados do formulário
 * @author Fernando de Campos pinheiro
 */
@Component
public class MembroFactory {

    @Autowired private GeradorHash geradorHascode;

	/**
	 * Cria um membro com dados do {@link FormularioMembro}
	 * @param formulario com dados do novo membro
	 * @return Membro populado com sua informações
	 */
    public Membro geraMembroPorformulario(FormularioMembro formulario){
        Membro membro = new Membro();
        membro.setNome(formulario.getNome());
        membro.setEmail(formulario.getEmail());
        String hashDaSenha = geradorHascode.geraHash(formulario.getSenha());
        membro.setSenha(hashDaSenha);
        membro.setDataNascimento(formulario.getDataNascimento());
        return membro;
    }
}
