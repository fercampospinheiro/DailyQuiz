package br.com.sidlar.dailyquiz.presentation.questionario;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;

public class FormularioQuestao {
	private Integer idRepostaQuestao;
	private Questao questao;
	private Integer idAlternativa;
	
	public FormularioQuestao() {}
	
	public FormularioQuestao(Questao questao){
		this.questao = questao;
	}
	
	public Questao getQuestao() {
		return questao;
	}

	public void setIdAlternativa(Integer idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public Integer getIdAlternativa() {
		return idAlternativa;
	}

	public Integer getIdRepostaQuestao() {
		return idRepostaQuestao;
	}

	public void setIdRepostaQuestao(Integer idRepostaQuestao) {
		this.idRepostaQuestao = idRepostaQuestao;
	}
	
	
	
	
	
}
