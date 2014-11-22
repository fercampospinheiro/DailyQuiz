package br.com.sidlar.dailyquiz.domain.formularios;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;

public class FormularioQuestionario {
	private Integer idRespostaQuestionario;
	private Questionario questionario;
	private List<FormularioQuestao> formularioQuestoes = Lists.newArrayList();
	private Integer idMembro;
	
	public FormularioQuestionario() {}
	
	public FormularioQuestionario(Questionario questionario) {
		this.questionario = questionario;
		this.adicionaQuestoes();
	}
	
	public Questionario getQuestionario() {
		return questionario;
	}
	
	public List<FormularioQuestao> getFormularioQuestoes() {
		return formularioQuestoes;
	}
	
	
	public Integer getIdRespostaQuestionario() {
		return idRespostaQuestionario;
	}

	public void setIdRespostaQuestionario(Integer idRespostaQuestionario) {
		this.idRespostaQuestionario = idRespostaQuestionario;
	}

	private void adicionaQuestoes(){
		List<Questao> questoes = this.questionario.getQuestoes();
		for (Questao questao : questoes) {
			this.formularioQuestoes.add(new FormularioQuestao(questao));
		}
	}

	public Integer getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Integer idMembro) {
		this.idMembro = idMembro;
	}

	
}
