package br.com.sidlar.dailyquiz.presentation.login;

import br.com.sidlar.dailyquiz.domain.excecoes.EmailOuSenhaInexistenteException;
import br.com.sidlar.dailyquiz.infrastructure.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author  Fernando de Campos Pinheiro
 *Responsável pelas solicitações de login
 */
@Controller
@RequestMapping("/Login")
public class LoginController {

	@Autowired private AutenticacaoService autenticacaoService;

	/**
	 * Prepara a tela de login para o usuario do site
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String carregaLogin(){
		return "/Login/login";
	}

	/**
	 * Efetua o processo de autenticão de um possivel membro através do e-mail e senha.
	 * @param email do  membro da aplicação
	 * @param senha do membro da aplicação
	 * @return String : view Home  ou Login
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String efetuaLogin(@RequestParam("email")String email,@RequestParam("senha")String senha, HttpServletRequest req){

		try {
			autenticacaoService.autenticaEmailESenhaDoMembro(email, senha);
			return "redirect:/";
		}
		catch (EmailOuSenhaInexistenteException e){
			return "/Login/login";
		}

	}


}
