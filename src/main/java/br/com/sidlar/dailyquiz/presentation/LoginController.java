package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Fernando_2 on 25/08/14.
 */
@Controller
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private MembroRepository membroRepository;


	@RequestMapping(method = RequestMethod.GET)
	public String carregaLogin(){
		return "/Login/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String efetuaLogin(String username, String senha,HttpServletRequest request){

		Membro membro = membroRepository.buscaMembroComUserName(username, senha);

		if(membro != null){
			request.getSession().setAttribute("membroAutenticado",membro);
			return "/Home/index";
		}else{
			return "/Login/login";
		}


	}





}
