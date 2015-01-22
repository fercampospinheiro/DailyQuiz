package br.com.sidlar.dailyquiz.presentation.respostaQuestionario;

import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionarioRepository;
import br.com.sidlar.dailyquiz.infrastructure.DadosDeAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Fernando de Campos Pinheiro
 */
@Controller
@RequestMapping("/RespostaQuestionario")
public class RespostaQuestionarioController {

    @Autowired private RespostaQuestionarioRepository repository;
    @Autowired private HttpSession session;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String carregaResposta(@PathVariable("id") Integer id,Model model){
        DadosDeAutenticacao dadosDeAutenticação;
        dadosDeAutenticação = (DadosDeAutenticacao) session.getAttribute("dadosDeAutenticacao");

        RespostaQuestionario  respostaQuestionario = repository.buscaPorId(id);
        model.addAttribute("resposta",respostaQuestionario);

        if (dadosDeAutenticação != null) return "/RespostaQuestionario/respostaQuestionario";
        else return "redirect:/Login";

    }
}
