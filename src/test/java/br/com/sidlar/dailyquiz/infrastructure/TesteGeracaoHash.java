package br.com.sidlar.dailyquiz.infrastructure;

import org.apache.commons.codec.digest.DigestUtils;
import static org.hamcrest.core.Is.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteGeracaoHash {

    @Test
    public void hashGeradoEhIgualHashSha1(){
        //Fixture
        GeradorHash gerador = new HashSha1();
        //exercise SUT
        String hashDoTexto = gerador.geraHash("olá");

        //verify
        assertThat(hashDoTexto, is(DigestUtils.sha1Hex("olá")));

    }
}