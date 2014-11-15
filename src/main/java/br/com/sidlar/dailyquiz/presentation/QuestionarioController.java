package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @autor Fernando de Campos Pinheiro
 */
@Controller
@RequestMapping("/Questionario")
public class QuestionarioController {

    @Autowired
    private QuestionarioRepository repository;

    @RequestMapping(value = "/lista" , method = RequestMethod.GET)
    public String  listaQuestionarios(Model model){
      List<Questionario> questionarios = repository.buscaPorData(DateTime.now());
      model.addAttribute("questionarios",questionarios);
      return "/Questionario/questionario";
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String carregaQuestionario(@PathVariable("id") Integer id, Model model) {
        Questionario questionario = repository.buscaQuestionarioPorId(id);
        questionario.getQuestoes().size();
        RespostaQuestionario respostaQuestionario = new RespostaQuestionario(questionario);
        model.addAttribute("resposta", respostaQuestionario);
        return "/Questionario/questionario";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvaQuestionario(@ModelAttribute("resposta")RespostaQuestionario resposta ) {
        repository.salva(resposta);
        return "redirect:/";
    }






}
