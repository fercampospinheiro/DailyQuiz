package br.com.sidlar.dailyquiz.presentation;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.infrastructure.DadosDeAutenticacao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author  Fernando de Campos Pinheiro
 *
 * Reponsável pelas chamadas relacionadas a página principal da Aplicação , a Home.
 *
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired private HttpSession session;
    @Autowired private QuestionarioRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(Model model) {

        DadosDeAutenticacao dadosDeAutenticação;
        dadosDeAutenticação = (DadosDeAutenticacao) session.getAttribute("dadosDeAutenticacao");
        List<Questionario> questionarios =   repository.buscaTodos();
        model.addAttribute("questionarios",questionarios);
        if (dadosDeAutenticação != null) return "/Home/index";
        else return "redirect:/Login";
    }
    @RequestMapping(value = "q",method = RequestMethod.GET)
    public String carregaQuestionario(){
        return "/Questionario/questionario";
    }

}
