package br.com.sidlar.dailyquiz.presentation.cadastroQuestionario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CadastroQuestionario")
public class CadastroQuestionarioController {

	@RequestMapping(value ="/novo",method = RequestMethod.GET)
	public String carregaCadastro(Model model){
		FormularioCadastroQuestionario formulario =  new FormularioCadastroQuestionario();
		model.addAttribute("formulario", formulario);
		return "/CadastroQuestionario/novoCadastroQuestionario";
	}
	
	
}
