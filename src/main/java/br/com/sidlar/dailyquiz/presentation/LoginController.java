package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * @author  Fernando de Campos Pinheiro
 *
 * Delega solicitações da view <b>login</b> aos serviços e repositorios do dominio do Membro
 * referentes ao processo de Login e Autenticação
 *
 */
@Controller
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private MembroRepository membroRepository;

	/**
	 * @return String : view do login
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String carregaLogin(){
		return "/Login/login";
	}

	/**
	 * Verifica se o username e senha pertence a alguma crendecial no {@link br.com.sidlar.dailyquiz.domain.MembroRepository}
	 * e efetua autenticação
	 * @param username
	 * @param senha
	 * @param request
	 * @return String : view Home  ou Login
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String efetuaLogin(String username, String senha,HttpServletRequest request){

		Membro membro = membroRepository.buscaMembroPorCredencial(username, senha);

		if(membro != null){
			request.getSession().setAttribute("membroAutenticado", membro);
			return "/Home/index";
		}
		else{
			return "/Login/login";
		}


	}


}
