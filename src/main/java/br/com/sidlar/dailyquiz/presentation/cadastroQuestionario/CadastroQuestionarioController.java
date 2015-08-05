package br.com.sidlar.dailyquiz.presentation.cadastroQuestionario;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.QuestionarioFactory;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CadastroQuestionario")
public class CadastroQuestionarioController {

    @Autowired private QuestionarioFactory factory;
    @Autowired private QuestionarioRepository repository;


	@RequestMapping(value ="/novo",method = RequestMethod.GET)
	public String carregaCadastro(Model model){
		FormularioCadastroQuestionario formulario =  new FormularioCadastroQuestionario();
		model.addAttribute("formulario", formulario);
		return "/CadastroQuestionario/novoCadastroQuestionario";
	}
	
	@RequestMapping(value ="/novo",method = RequestMethod.POST)
	public String cadastraQuestionario(@ModelAttribute("formulario")FormularioCadastroQuestionario formulario, Model model){

        try {
            Questionario novoQuestionario = factory.porQuestionario(formulario);
            repository.salva(novoQuestionario);
            model.addAttribute("formulario",formulario);
            return "/CadastroQuestionario/novoCadastroQuestionario";
        }
        catch (Exception e ){
            return  "";
        }

	}


}
