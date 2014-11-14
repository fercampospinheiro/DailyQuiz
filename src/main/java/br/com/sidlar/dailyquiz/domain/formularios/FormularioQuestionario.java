package br.com.sidlar.dailyquiz.domain.formularios;

import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaDaQuestao;

import java.util.List;

/**
 * @author Fernando de Campos Pinheiro
 */
public class FormularioQuestionario {

    private Integer idQuestionario;
    private List<FormularioQuestao> formularioQuestoes;

    public Integer getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public List<FormularioQuestao> getFormularioQuestoes() {
        return formularioQuestoes;
    }

    public void setFormularioQuestoes(List<FormularioQuestao> formularioQuestoes) {
        this.formularioQuestoes = formularioQuestoes;
    }
}
