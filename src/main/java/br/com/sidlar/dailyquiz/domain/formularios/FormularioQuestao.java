package br.com.sidlar.dailyquiz.domain.formularios;

/**
 * Created by fernando on 13/11/14.
 */
public class FormularioQuestao {
    private Integer idQuestao;
    private Integer idAlternativaCorreta;

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Integer getIdAlternativaCorreta() {
        return idAlternativaCorreta;
    }

    public void setIdAlternativaCorreta(Integer idAlternativaCorreta) {
        this.idAlternativaCorreta = idAlternativaCorreta;
    }
}
