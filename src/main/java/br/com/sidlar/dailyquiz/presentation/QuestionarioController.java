package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.QuestionarioRespository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private QuestionarioRespository repository;

    @RequestMapping(value = "/lista" , method = RequestMethod.GET)
    public String  listaQuestionarios(Model model){
      List<Questionario> questionarios = repository.buscaPorData(DateTime.now());
      model.addAttribute("questionarios",questionarios);
      return "/Questionario/questionario";
    }


}
