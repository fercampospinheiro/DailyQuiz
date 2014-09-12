package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Service
public class AutenticacaoService {

	@Autowired private HttpSession session;
	@Autowired private MembroRepository membroRepository;
	@Autowired private GeradorHascode geradorHascode;

	public void autenticaEmailESenhaDoMembro(String email,String senha) throws EmailOuSenhaInexistenteException {
		Membro membro =  obtemMembroPeloEmail(email);
		validaSenhaDoMembro(senha, membro);
		adicionaDadosDeAutenticacaoNaSessao(new DadosDeAutenticação(membro,new DateTime()));
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

	private void validaSenhaDoMembro(String senha, Membro membro){

		String HascodeDaSenha = geradorHascode.geraHashcode(senha);
		if (!membro.validaSenha(HascodeDaSenha)){
			throw new EmailOuSenhaInexistenteException("Senha inválida");
		}
	}

}

