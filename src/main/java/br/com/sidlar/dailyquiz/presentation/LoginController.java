package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


/**
 * Created by Fernando_2 on 25/08/14.
 */
@Controller
public class LoginController {

	@Autowired
	private MembroRepository membroRepository;


	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String carregaLogin(){
		return "/Login/login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String efetuaLogin(String username, String senha, HttpSession sessao){

		Membro membro = membroRepository.contemUsuarioNosMembros(username,senha);

		if(existeMembro(membro)){
            sessao.setAttribute("membroAutenticado",membro);
			return "/Home/index";
		}else{
			return "/Login/login";
		}


	}


	public boolean existeMembro(Membro membro){
		return membro.equals(null)? false : true;
	}



}
