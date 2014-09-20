package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.domain.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Service
public class AutenticacaoService {

	@Autowired HttpSession session;
	@Autowired private MembroRepository membroRepository;
	@Autowired private GeradorHascode geradorHascode;

	public void autenticaEmailESenhaDoMembro(String email,String senha) throws EmailOuSenhaInexistenteException {
		Membro membro =  obtemMembroPeloEmail(email);
		validaSenhaDoMembro(senha, membro);
		adicionaMembroNaSessao(membro);
	}


	public void autenticaMembro(Membro membro){
		adicionaMembroNaSessao(membro);
	}

	private void adicionaMembroNaSessao(Membro membro){
		DateTime instanteDaAutenticao = DateTime.now(DateTimeZone.getDefault());
		this.session.setAttribute("dadosDaAutenticacao",new DadosDeAutenticação(membro,instanteDaAutenticao));
	}

	private Membro obtemMembroPeloEmail(String email){
		try {
			return membroRepository.buscaPorEmail(email);
		} catch (EntidadeInexistenteException e) {
			throw new EmailOuSenhaInexistenteException(String.format("Não foi possivel encontra um membro com o e-mail:%",email),e);
		}

	}

	private void validaSenhaDoMembro(String senha, Membro membro) {

		String HascodeDaSenha = geradorHascode.geraHashcode(senha);
		if (!membro.validaSenha(HascodeDaSenha)) {
			throw new EmailOuSenhaInexistenteException("Senha inválida");
		}

	}

	public DadosDeAutenticação obtemDadosDeAutenticacao(){
			return (DadosDeAutenticação)this.session.getAttribute("dadosDaAutenticacao");
	}


}

