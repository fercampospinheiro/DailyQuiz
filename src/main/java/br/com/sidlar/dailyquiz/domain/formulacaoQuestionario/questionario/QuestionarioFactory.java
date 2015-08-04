package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.presentation.cadastroQuestionario.FormularioCadastroQuestao;
import br.com.sidlar.dailyquiz.presentation.cadastroQuestionario.FormularioCadastroQuestionario;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionarioFactory {

    public Questionario porQuestionario(FormularioCadastroQuestionario formulario){
       Questionario  novoQuestionario =  obtemQuestionarioPorFormulario(formulario);
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
        SS
    }

}
