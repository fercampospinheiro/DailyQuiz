package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.FormularioMembro;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteGeracaoHashDaSenhaDoMembro {

    @Test
    public void senhaDoMembroGeradoPelaFactoryIgualSenhaDigestUtil(){
       //Fixture
        FormularioMembro formulario = new FormularioMembro();
        formulario.setSenha("teste");
        MembroFactory factory = new MembroFactory();

       //Exercise
        String senhaDoDigest = DigestUtils.sha1Hex(formulario.getSenha());
        Membro membro = factory.fabricaPorformulario(formulario);

       //verify
        assertEquals(membro.getSenha(),senhaDoDigest);

    }
}