package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.Excecoes.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import br.com.sidlar.dailyquiz.domain.ValidadorMembro;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
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
        when(repository.buscaPorEmail(anyString())).thenThrow(EntidadeInexistenteException.class);
        //Exercise SUT
        autenticador.autenticaEmailESenhaDoMembro(null,null);
    }

    @Test(expected = EmailOuSenhaInexistenteException.class)
    public void senhaDoMembroNaoAuteticada_lancaEmailOuSenhaInexistenteException(){
        //Fixture
        Membro membro = mock(Membro.class);
        ValidadorMembro validador = mock(ValidadorMembro.class);
        autenticador.setValidador(validador);
        when(repository.buscaPorEmail(anyString())).thenReturn(membro);
        //Exercise Sut
        autenticador.autenticaEmailESenhaDoMembro(null, null);
    }

}