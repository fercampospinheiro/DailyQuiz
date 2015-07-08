package br.com.sidlar.dailyquiz.presentation.cadastroQuestionario;


import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public class FormularioCadastroQuestionario {

    private String nome;
    private List<FormularioCadastroQuestao> formulariosCadastroQuestao = new ArrayList<>();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private DateTime dataDisponivel;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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

    public DateTime getDataDisponivel() {
        return dataDisponivel;
    }

    public DateTime getDataLimite() {
        return dataLimite;
    }
}
