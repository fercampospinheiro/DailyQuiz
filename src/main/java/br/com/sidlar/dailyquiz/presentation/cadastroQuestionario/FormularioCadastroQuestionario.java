package br.com.sidlar.dailyquiz.presentation.cadastroQuestionario;


import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class FormularioCadastroQuestionario {

    private String nome;
    private List<FormularioCadastroQuestao> formulariosCadastroQuestao;
    private DateTime dataDisponivel;
    private DateTime dataLimite;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<FormularioCadastroQuestao> getFormulariosCadastroQuestao() {
        return formulariosCadastroQuestao;
    }

    public void setFormulariosCadastroQuestao(List<FormularioCadastroQuestao> formulariosCadastroQuestao) {
        this.formulariosCadastroQuestao = formulariosCadastroQuestao;
    }

    public void setDataDisponivel(DateTime dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public void setDataLimite(DateTime dataLimite) {
        this.dataLimite = dataLimite;
    }
}
