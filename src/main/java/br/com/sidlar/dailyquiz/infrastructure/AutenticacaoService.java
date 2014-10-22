package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.Excecoes.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import br.com.sidlar.dailyquiz.domain.ValidadorMembro;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Serviço que controla o processo de autenticação
 * @author  Fernando de Campos Pinheiro
 */
@Service
public class AutenticacaoService {

	@Autowired HttpSession session;
	@Autowired private MembroRepository repository;

	public void autenticaEmailESenhaDoMembro(String email, String senha){
		try {

            Membro membro = repository.buscaPorEmail(email);
            ValidadorMembro validador = new ValidadorMembro(repository);
            validador.validaSenha(senha, membro);
            adicionaMembroNaSessao(membro);

        }
        catch (EntidadeInexistenteException | EmailOuSenhaInexistenteException e){
            throw new EmailOuSenhaInexistenteException(e.getMessage());
        }
	}

    public void autenticaMembro(Membro membro){
        adicionaMembroNaSessao(membro);
    }
	private void adicionaMembroNaSessao(Membro membro){
		DateTime momentoDaAutenticao = DateTime.now(DateTimeZone.getDefault());
		this.session.setAttribute("dadosDeAutenticacao", new DadosDeAutenticacao(membro, momentoDaAutenticao));
	}

	public DadosDeAutenticacao obtemDadosDeAutenticacao(){
			return (DadosDeAutenticacao)this.session.getAttribute("dadosDeAutenticacao");
	}


}

