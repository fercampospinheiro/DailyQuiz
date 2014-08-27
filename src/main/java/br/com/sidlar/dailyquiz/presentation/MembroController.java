package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MembroController {

	@Autowired
	private MembroRepository membroRepository;

	@RequestMapping(value="/CadastraNovoMembro", method = RequestMethod.GET)
	public String carregaCadastroMembro(Membro membro,Model model){
		model.addAttribute(membro);
		return "/CadastroDeMembro/cadastroDeMembro";
	}


	@RequestMapping(value="/CadastraNovoMembro", method = RequestMethod.POST)
	public String cadastraNovoMembro(Membro membro, HttpServletRequest request){
		membro.geraHashCodeDaSenhaDoMembro();
		membroRepository.insereNovoMembro(membro);
		request.getSession().setAttribute("membroAutenticado",membro);
		return "/Home/index";
	}
}
