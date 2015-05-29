package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.presentation.cadastroMembro.FormularioMembro;
import br.com.sidlar.dailyquiz.infrastructure.GeradorHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Responsavel pela geração de um cadastroMembro com dados do formulário
 * @author Fernando de Campos pinheiro
 */
@Component
public class MembroFactory {

    @Autowired private GeradorHash gerador;
    @Autowired private ValidadorMembro validadorMembro;
	/**
	 * Cria um cadastroMembro com dados do {@link br.com.sidlar.dailyquiz.presentation.cadastroMembro.FormularioMembro}
     * Valida os dados para geração do cadastroMembro
	 * @param formulario com dados do novo cadastroMembro
	 * @return Membro populado com sua informações
	 */
    public Membro comDadosFormulario(FormularioMembro formulario) throws EmailCadastradoException {

        validadorMembro.verificaEmailCadastrado(formulario.getEmail());

        String hashDaSenha = gerador.geraHash(formulario.getSenha());

        Membro membro = new Membro();
        membro.setNome(formulario.getNome());
        membro.setEmail(formulario.getEmail());
        membro.setSenha(hashDaSenha);
        membro.setDataNascimento(formulario.getDataNascimento());

        return membro;
     }


}
