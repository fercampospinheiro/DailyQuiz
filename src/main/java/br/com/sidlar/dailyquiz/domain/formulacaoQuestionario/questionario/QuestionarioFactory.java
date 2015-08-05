package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.presentation.cadastroQuestionario.FormularioCadastroAlternativa;
import br.com.sidlar.dailyquiz.presentation.cadastroQuestionario.FormularioCadastroQuestao;
import br.com.sidlar.dailyquiz.presentation.cadastroQuestionario.FormularioCadastroQuestionario;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.List;

@Component
public class QuestionarioFactory {

    public Questionario porQuestionario(FormularioCadastroQuestionario formulario) {
        Questionario novoQuestionario = obtemQuestionarioPorFormulario(formulario);
        return novoQuestionario;
    }

    private Questionario obtemQuestionarioPorFormulario(FormularioCadastroQuestionario formulario) {

        Questionario questionario = new Questionario();

        questionario.setDataDisponivel(formulario.getDataDisponivel());
        questionario.setDataLimite(formulario.getDataLimite());
        questionario.setMembroCriador(null);
        questionario.setNome(formulario.getNome());

        List<Questao> questoes = obtemQuestoesPorFormulario(formulario.getFormulariosCadastroQuestao());
        questionario.setQuestoes(questoes);

        return questionario;
    }

    private List<Questao> obtemQuestoesPorFormulario(List<FormularioCadastroQuestao> formulariosCadastroQuestao) {

        Questao novaQuestao = new Questao();
        List<Questao> questoes = Lists.newArrayList();

        for (FormularioCadastroQuestao form : formulariosCadastroQuestao) {


            novaQuestao.setOrdem(form.getOrdem());
            novaQuestao.setPergunta(form.getPergunta());

            List<Alternativa> alternativas = obtemAlternativasPorFormulario(form.getFormulariosCadastroAlternativa());

            novaQuestao.setAlternativas(alternativas);

            questoes.add(novaQuestao);

        }

        return  questoes;
    }

    private List<Alternativa> obtemAlternativasPorFormulario(List<FormularioCadastroAlternativa> formulariosCadastroAlternativa) {

        Alternativa novaAlternativa = new Alternativa();
        List<Alternativa> alternativas = Lists.newArrayList();

        for(FormularioCadastroAlternativa form : formulariosCadastroAlternativa){

            novaAlternativa.setOrdem(form.getOrdem());
            novaAlternativa.setDescricao(form.getDescricao());

            alternativas.add(novaAlternativa);

        }

        return alternativas;
    }
}
