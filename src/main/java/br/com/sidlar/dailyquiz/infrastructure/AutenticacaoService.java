package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Service
public class AutenticacaoService {

	@Autowired private HttpSession session;
	@Autowired MembroRepository membroRepository;

	public void autenticaEmailESenhaDoMembro(String email,String senha) throws EmailOuSenhaInexistenteException {


	}

	private void adicionaDadosDeAutenticacaoNaSessao(DadosDeAutenticação dadosDeAutenticação){
		this.session.setAttribute("dadosDaAutenticacao",dadosDeAutenticação);
	}

	private Membro obtemMembroPeloEmail(String email){
		try {
			return membroRepository.buscaPorEmail(email);
		} catch (EntidadeInexistenteException e) {
			throw new EmailOuSenhaInexistenteException(String.format("Não foi possivel encontra um membro com o e-mail:%",email),e);
		}

	}

	private void validaSenhaDoMembro(){
		;
	}

}

