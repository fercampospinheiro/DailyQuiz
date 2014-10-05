package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.Excecoes.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
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
	@Autowired private MembroRepository membroRepository;
	@Autowired private GeradorHash geradorHascode;

	public void autenticaEmailESenhaDoMembro(String email, String senha) throws EmailOuSenhaInexistenteException {
		Membro membro =  obtemMembroPeloEmail(email);
		validaSenhaDoMembro(senha, membro);
		adicionaMembroNaSessao(membro);
	}


	public void autenticaMembro(Membro membro){
		adicionaMembroNaSessao(membro);
	}

	private void adicionaMembroNaSessao(Membro membro){
		DateTime momentoDaAutenticao = DateTime.now(DateTimeZone.getDefault());
		this.session.setAttribute("dadosDeAutenticacao", new DadosDeAutenticacao(membro, momentoDaAutenticao));
	}

	private Membro obtemMembroPeloEmail(String email){
		try {
			return membroRepository.buscaPorEmail(email);
		} catch (EntidadeInexistenteException e) {
			throw new EmailOuSenhaInexistenteException(String.format("Não foi possivel encontra um membro com o e-mail:%",email),e);
		}

	}

	private void validaSenhaDoMembro(String senha, Membro membro) {

		String HascodeDaSenha = geradorHascode.geraHash(senha);
		if (!membro.possuiSenhaInformada(HascodeDaSenha)) {
			throw new EmailOuSenhaInexistenteException("Senha inválida");
		}

	}

	public DadosDeAutenticacao obtemDadosDeAutenticacao(){
			return (DadosDeAutenticacao)this.session.getAttribute("dadosDeAutenticacao");
	}


}

