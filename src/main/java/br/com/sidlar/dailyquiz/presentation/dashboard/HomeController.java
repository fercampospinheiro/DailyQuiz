package br.com.sidlar.dailyquiz.presentation.dashboard;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.ranking.Posicao;
import br.com.sidlar.dailyquiz.domain.ranking.Ranking;
import br.com.sidlar.dailyquiz.domain.ranking.RankingRepository;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionarioRepository;
import br.com.sidlar.dailyquiz.infrastructure.DadosDeAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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
    @Autowired private RespostaQuestionarioRepository respostaRepository;
    @Autowired private RankingRepository rankingRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(Model model) {

        DadosDeAutenticacao dadosDeAutenticação;
        dadosDeAutenticação = (DadosDeAutenticacao) session.getAttribute("dadosDeAutenticacao");
        if (dadosDeAutenticação != null){
            List<Questionario> questionarios =   repository.buscaTodos();
            model.addAttribute("questionarios",questionarios);

            Membro  membro = dadosDeAutenticação.getMembro();
            List<RespostaQuestionario> repostas = respostaRepository.buscaPorMembro(membro);
            model.addAttribute("respostas",repostas);

            List<Posicao> posicoes = rankingRepository.obtemDezPrimeirasPosicoes();
            model.addAttribute("ranking", new Ranking(posicoes));

             return "/Home/index";
        }
        else{ return "redirect:/Login";}
    }

}
