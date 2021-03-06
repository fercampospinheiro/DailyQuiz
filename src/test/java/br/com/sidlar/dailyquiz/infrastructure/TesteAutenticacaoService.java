package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.membro.EmailCadastradoException;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;
import br.com.sidlar.dailyquiz.domain.membro.ValidadorMembro;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class TesteAutenticacaoService {

    private AutenticacaoService autenticador;
    @Mock
    private MembroRepository repository;

    @Before
    public void inicializa(){
        MockitoAnnotations.initMocks(this);
        autenticador = new AutenticacaoService();
        autenticador.setRepository(repository);
    }




    @Test(expected = EmailOuSenhaInexistenteException.class)
    public void emailDoMembroNaoAutenticado_lancaEmailOuSenhaInexistenteExcpetion(){
        //Fixture);
        when(repository.buscaPorEmail(anyString())).thenThrow(EmailCadastradoException.class);
        //Exercise SUT
        autenticador.autenticaEmailESenhaDoMembro(null,null);
    }

    @Test(expected = EmailOuSenhaInexistenteException.class)
    public void senhaDoMembroNaoAuteticada_lancaEmailOuSenhaInexistenteException(){
        //Fixture
        Membro membro = mock(Membro.class);
        ValidadorMembro validador = mock(ValidadorMembro.class);
        GeradorHash gerador = mock(HashSha1.class);

        validador.setGerador(gerador);
        autenticador.setValidador(validador);

        when(repository.buscaPorEmail(anyString())).thenReturn(membro);
        when(gerador.geraHash(anyString())).thenReturn(anyString());
        doNothing().when(membro.possuiSenhaInformada(anyString()));
        doThrow(EmailOuSenhaInexistenteException.class).when(validador).validaSenha(anyString(), anyObject());

        //Exercise Sut
        autenticador.autenticaEmailESenhaDoMembro(null, null);
    }

}