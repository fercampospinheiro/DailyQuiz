package br.com.sidlar.dailyquiz.presentation.respostaQuestionario;

import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Fernando de Campos Pinheiro
 */
@Controller
@RequestMapping("/RespostaQuestionario")
public class RespostaQuestionarioController {

    @Autowired private RespostaQuestionarioRepository repository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String carregaResposta(@PathVariable("id") Integer id,Model model){
        RespostaQuestionario  respostaQuestionario = repository.buscaPorId(id);
        model.addAttribute("resposta",respostaQuestionario);
        return "/RespostaQuestionario/respostaQuestionario";
    }
}
