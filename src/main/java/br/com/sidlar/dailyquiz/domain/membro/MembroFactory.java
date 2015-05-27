package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.domain.excecoes.EmailJaCadastradoException;
import br.com.sidlar.dailyquiz.presentation.formularios.FormularioMembro;
import br.com.sidlar.dailyquiz.domain.validacoes.ValidadorMembro;
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
    @Autowired private ValidadorMembro validadorMembro;
	/**
	 * Cria um membro com dados do {@link br.com.sidlar.dailyquiz.presentation.formularios.FormularioMembro}
     * Valida os dados para geração do membro
	 * @param formulario com dados do novo membro
	 * @return Membro populado com sua informações
	 */
    public Membro fabricaPorformulario(FormularioMembro formulario) throws EmailJaCadastradoException{

        validadorMembro.verificaExistenciaDeEmail(formulario.getEmail());

        String hashDaSenha = geradorHascode.geraHash(formulario.getSenha());

        Membro membro = new Membro();
        membro.setNome(formulario.getNome());
        membro.setEmail(formulario.getEmail());
        membro.setSenha(hashDaSenha);
        membro.setDataNascimento(formulario.getDataNascimento());

        return membro;
     }


}
