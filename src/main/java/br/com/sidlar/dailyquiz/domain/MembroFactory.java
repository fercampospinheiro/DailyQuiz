package br.com.sidlar.dailyquiz.domain;

import org.springframework.stereotype.Component;

/**
 * @author Fernando de Campos pinheiro
 */
@Component
public class MembroFactory {

    private GeradorHashcode hashcode = new GeradorHashcode();

    public Membro geraMembroComInformacaoDoformulario(FormularioCadastroMembro formulario){
        Membro membro = new Membro();
        membro.setNome(formulario.getNome());
        membro.setUserName(formulario.getUserName());
        String senhaComHashCode = hashcode.geraHashCodeDeString(formulario.getSenha());
        membro.setSenha(senhaComHashCode);
        return membro;
    }
}
