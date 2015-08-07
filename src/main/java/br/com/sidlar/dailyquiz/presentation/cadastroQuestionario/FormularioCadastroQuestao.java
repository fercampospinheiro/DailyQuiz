package br.com.sidlar.dailyquiz.presentation.cadastroQuestionario;


import java.util.List;

public class FormularioCadastroQuestao {

    private int ordem;
    private String pergunta;
    private int idAlternativaCorreta;
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

    public int getOrdem() {
        return ordem;
    }

    public String getPergunta() {
        return pergunta;
    }

    public List<FormularioCadastroAlternativa> getFormulariosCadastroAlternativa() {
        return formulariosCadastroAlternativa;
    }

    public int getIdAlternativaCorreta() {
        return idAlternativaCorreta;
    }

    public void setIdAlternativaCorreta(int idAlternativaCorreta) {
        this.idAlternativaCorreta = idAlternativaCorreta;
    }
}
