package br.com.sidlar.dailyquiz.presentation.dashboard;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.ranking.Posicao;
import br.com.sidlar.dailyquiz.domain.ranking.Ranking;
import br.com.sidlar.dailyquiz.domain.ranking.RankingRepository;
import br.com.sidlar.dailyquiz.domain.ranking.StandardCompetitionRanking;
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
import java.util.Optional;

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

        if (estaAutenticado()){
            List<Questionario> questionarios =   repository.buscaTodos();
            model.addAttribute("questionarios",questionarios);

            Membro  membro = membroAutenticado();
            List<RespostaQuestionario> repostas = respostaRepository.buscaPorMembro(membro);
            model.addAttribute("respostas",repostas);

            List<Posicao> posicoes = rankingRepository.obtemDezPrimeirasPosicoes();
            Ranking ranking = new Ranking();
            ranking.ordenaAtraves(new StandardCompetitionRanking(posicoes));
            model.addAttribute("ranking", ranking);

             return "/Home/index";
        }
        else{ return "redirect:/Login";}
    }


    private boolean estaAutenticado() {
        return getDadosDeAutenticacao().isPresent();
    }

    private Membro membroAutenticado() {
        return getDadosDeAutenticacao().get().getMembro();
    }

    private Optional<DadosDeAutenticacao> getDadosDeAutenticacao() {
        Object dadosAutenticacao = session.getAttribute("dadosDeAutenticacao");
        if (dadosAutenticacao == null) {
            return Optional.empty();
        }
        return Optional.of((DadosDeAutenticacao) dadosAutenticacao);
    }



}
