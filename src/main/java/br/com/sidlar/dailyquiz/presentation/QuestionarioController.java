package br.com.sidlar.dailyquiz.presentation;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.domain.formularios.FormularioQuestionario;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionarioFactory;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionarioService;

/**
 * @author Fernando de Campos Pinheiro
 */
@Controller
@RequestMapping("/Questionario")
public class QuestionarioController {

    @Autowired
    private QuestionarioRepository repository;
    @Autowired
    private RespostaQuestionarioService service;
    @Autowired
    private RespostaQuestionarioFactory factory;
    
    
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
        FormularioQuestionario formulario = new FormularioQuestionario(questionario); 
        model.addAttribute("formulario", formulario);
        return "/Questionario/questionario";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvaQuestionario(@ModelAttribute("formulario") FormularioQuestionario formulario ) {
        RespostaQuestionario resposta = factory.criaPorFormulario(formulario);
    	service.respondeQuestionario(resposta);
        return "redirect:/";
    }


}
