package br.com.sidlar.dailyquiz.presentation.cadastroQuestionario;


import java.util.List;

public class FormularioCadastroQuestao {

    private int ordem;
    private String pergunta;
    List<FormularioCadastroAlternativa> formulariosCadastroAlternativa;

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setFormulariosCadastroAlternativa(List<FormularioCadastroAlternativa> formulariosCadastroAlternativa) {
        this.formulariosCadastroAlternativa = formulariosCadastroAlternativa;
    }
}
